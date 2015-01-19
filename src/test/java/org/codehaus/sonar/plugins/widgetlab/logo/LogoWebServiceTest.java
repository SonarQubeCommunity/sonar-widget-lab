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

import org.junit.Test;

/**
 * Tests LogoWebService class. Just check that template path is not null.
 * 
 * @author jbadenas
 */
public class LogoWebServiceTest {

  private LogoWebService service = new LogoWebService();

  @Test
  public void testServiceId() {
    assertEquals(service.getId(), "logo");
  }

  @Test
  public void testServiceTemplatePath() {
    assertEquals(service.getTemplatePath(), "/logo/LogoController.rb");
  }
}