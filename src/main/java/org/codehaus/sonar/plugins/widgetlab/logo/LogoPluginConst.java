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

/**
 * Constant attributes
 * 
 * @author jbadenas
 */
public final class LogoPluginConst {

  /**
   * Private constructor
   */
  private LogoPluginConst() {
  }

  /**
   * Location for the image, it can be an URL or a path to a file in the source code
   */
  public static final String CONFKEY_IMG_LOCATION = "logo.imglocation";

  /**
   * Set the image style with this property, ex: width:200px;
   */
  public static final String CONFKEY_IMG_STYLE = "logo.style";

  /**
   * Set a link in the image to redirect to.
   */
  public static final String CONFKEY_LINK = "logo.link";

  /**
   * Alternative text for the image
   */
  public static final String CONFKEY_ALT_TEXT = "logo.alttext";

  /**
   * Internal prefix to specify a image in the sources directory
   */
  public static final String IMGPATH_PREFIX_SOURCES = "sources:";
}