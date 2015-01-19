/*
 * Widget Lab
 * Copyright (C) 2012 Shaw Industries
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.codehaus.sonar.plugins.widgetlab.logo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.CheckProject;
import org.sonar.api.batch.PostJob;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.config.Settings;
import org.sonar.api.measures.Measure;
import org.sonar.api.measures.PersistenceMode;
import org.sonar.api.resources.Project;

/**
 * Stores the image as a metric
 * 
 * @author jbadenas
 */
public class LogoPostJob implements PostJob, CheckProject {

  private static final Logger LOG = LoggerFactory.getLogger(LogoPostJob.class);
  private static final Integer SIZE = 1024;

  private final FileSystem fileSystem;
  private final String imgLocation;

  /**
   * Constructor
   * 
   * @param settings
   * @param fileSystem
   */
  public LogoPostJob(Settings settings, FileSystem fileSystem) {
    this.fileSystem = fileSystem;

    // Logo path
    this.imgLocation = settings.getString(LogoPluginConst.CONFKEY_IMG_LOCATION);
  }

  /**
   * Enable execution on project
   */
  @Override
  public final boolean shouldExecuteOnProject(Project project) {
    return true;
  }

  /**
   * @return image extension
   */
  protected final String getImgExt() {
    String imgExt = null;

    if ( !StringUtils.isBlank(imgLocation)) {
      int dotPos = imgLocation.lastIndexOf('.');
      int len = imgLocation.length();

      if (dotPos >= 0 && len > dotPos + 1) {
        imgExt = imgLocation.substring(dotPos + 1, len);
      }
    }

    return imgExt;
  }

  /**
   * Gets all the properties and stores the image in the metric
   */
  @Override
  public final void executeOn(Project project, SensorContext context) {
    String data = null;
    String imgExt = getImgExt();

    if ( !StringUtils.isBlank(imgLocation)) {
      // Extension not defined
      if (imgExt == null) {
        LOG.error("Logo image file must have an extension: " + imgLocation);
      } else {
        try {
          // load image data into an String because we need to save a measure
          data = new String(loadFile(imgLocation));

          // Save measure
          Measure<String> measureData = new Measure<String>(LogoMetrics.LOGO_DATA);
          measureData.setPersistenceMode(PersistenceMode.DATABASE);
          measureData.setData(data);
          context.saveMeasure(measureData);

          // Save measure
          Measure<String> measureExt = new Measure<String>(LogoMetrics.LOGO_EXT);
          measureExt.setData(imgExt);
          context.saveMeasure(measureExt);

        } catch (FileNotFoundException exception) {
          LOG.error("Couldn't find image: " + imgLocation, exception);
        } catch (Exception exception) {
          LOG.error("Couldn't load image: " + imgLocation, exception);
        }
      }
    }
  }

  /**
   * Copy bytes from input stream to output stream
   * 
   * @param inputStream
   * @param outputStream
   * @throws IOException
   */
  protected final void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
    byte[] barr = new byte[SIZE];

    while (true) {
      int bytesRead = inputStream.read(barr);

      // No more bytes to read
      if (bytesRead <= 0) {
        break;
      }

      // Write output
      outputStream.write(barr, 0, bytesRead);
    }
  }

  /**
   * Loads file into a byte an encoded base64 byte array
   * 
   * @param imgLocation
   * @return file
   * @throws IOException
   */
  protected final byte[] loadFile(String imgLocation) throws IOException {
    byte[] logoByteArray = new byte[0];

    // We will load the image only if it is in the sources
    if (imgLocation.startsWith(LogoPluginConst.IMGPATH_PREFIX_SOURCES)) {
      String baseDirPath = fileSystem.baseDir().getAbsolutePath();
      String relativePath = imgLocation.substring(LogoPluginConst.IMGPATH_PREFIX_SOURCES.length());

      if (relativePath.charAt(0) != '/') {
        relativePath = "/".concat(relativePath);
      }

      // Image path
      String logoPath = baseDirPath + relativePath;

      File logo = new File(logoPath);
      InputStream inputStream = new FileInputStream(logo);

      try {
        // Copy image
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        copy(inputStream, buffer);
        logoByteArray = buffer.toByteArray();

      } finally {
        inputStream.close();
      }
    }

    return Base64.encodeBase64(logoByteArray);
  }
}