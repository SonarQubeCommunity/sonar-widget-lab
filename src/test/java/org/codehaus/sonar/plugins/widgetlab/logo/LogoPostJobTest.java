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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.config.Settings;
import org.sonar.api.resources.Project;

/**
 * @author jbadenas
 */
public class LogoPostJobTest {

  private Settings settings;
  private FileSystem fileSystem;
  private Project project;
  private LogoPostJob postJob;
  private ByteArrayInputStream inputStream;
  private ByteArrayOutputStream outputStream;

  private byte[] byteArrayInput = new byte[] { 0, 1, 2, 3, 4, 5, 6, 7 };

  /**
   * Setting up the test
   */
  @Before
  public void setUp() {
    settings = new Settings();

    fileSystem = Mockito.mock(FileSystem.class);
    project = Mockito.mock(Project.class);

    postJob = new LogoPostJob(settings, fileSystem);

    inputStream = new ByteArrayInputStream(byteArrayInput);
    outputStream = new ByteArrayOutputStream(byteArrayInput.length);
  }

  @Test
  public void testShouldExecuteOnProject() throws Exception {
    assertTrue("Always true", postJob.shouldExecuteOnProject(project));
  }

  @Test
  public void testCopy() {
    try {
      postJob.copy(inputStream, outputStream);
    } catch (Exception exception) {
      assertTrue(exception instanceof IOException);
    }

    byte[] byteArrayOutput = outputStream.toByteArray();
    assertTrue(Arrays.equals(byteArrayInput, byteArrayOutput));
  }

  @Test(expected = IOException.class)
  public void testLoadFile() throws IOException {
    File baseDir = new File(".");

    Mockito.when(fileSystem.baseDir()).thenReturn(baseDir);

    byte[] imageByteArray = null;

    // test real image
    imageByteArray = postJob.loadFile("sources:/src/main/site/logo.png");
    assertTrue(imageByteArray.length > 0);

    // fake image to check that if we use URL the metric will be null
    imageByteArray = postJob.loadFile("http://mytest/test.png");
    assertSame(imageByteArray.length, 0);

    // test image that doesn't exists
    imageByteArray = postJob.loadFile("sources:/src/image/not/found.png");
  }

  @Test
  public void testGetImgExtEmpty() {
    settings.setProperty(LogoPluginConst.CONFKEY_IMG_LOCATION, "");

    LogoPostJob newPostJob = new LogoPostJob(settings, fileSystem);

    String fileExtension = newPostJob.getImgExt();
    assertNull("No extension", fileExtension);
  }

  @Test
  public void testGetImgExtSuccess() {
    settings.setProperty(LogoPluginConst.CONFKEY_IMG_LOCATION, "http://mytest/test.png");

    LogoPostJob newPostJob = new LogoPostJob(settings, fileSystem);

    String fileExtension = newPostJob.getImgExt();
    assertEquals("PNG extension", fileExtension, "png");
  }
}