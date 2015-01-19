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

import java.util.Arrays;
import java.util.List;

import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metric.ValueType;
import org.sonar.api.measures.Metrics;

/**
 * Metrics for the SonarQube Logo Plugin
 * 
 * @author jbadenas
 */
public class LogoMetrics implements Metrics {

  /**
   * Binary data is stored in this metric
   */
  public static final Metric LOGO_DATA = new Metric.Builder("logo_data", "Logo binary image data", ValueType.DATA)
      .setDescription("Logo binary image data").setDirection(Metric.DIRECTION_NONE).setQualitative(false)
      .setDomain(CoreMetrics.DOMAIN_GENERAL).create();

  /**
   * File extension for the image
   */
  public static final Metric LOGO_EXT = new Metric.Builder("logo_ext", "Logo image file extension", Metric.ValueType.STRING)
      .setDescription("Logo image file extension").setDirection(Metric.DIRECTION_NONE).setQualitative(false)
      .setDomain(CoreMetrics.DOMAIN_GENERAL).create();

  /**
   * Gets the plugin metrics
   */
  public final List<Metric> getMetrics() {
    return Arrays.asList(LOGO_DATA, LOGO_EXT);
  }
}