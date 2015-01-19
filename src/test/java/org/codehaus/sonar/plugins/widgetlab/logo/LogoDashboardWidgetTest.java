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
 * Tests that the resource for the widget exists
 * 
 * @author jbadenas
 */
public class LogoDashboardWidgetTest {

  private LogoDashboardWidget widget = new LogoDashboardWidget();

  @Test
  public void testWidgetId() {
    assertEquals(widget.getId(), "logo");
  }

  @Test
  public void testWidgetTitle() {
    assertEquals(widget.getTitle(), "Logo");
  }

  @Test
  public void testWidgetTemplatePath() {
    assertEquals(widget.getTemplatePath(), "/logo/logo_dashboard_widget.html.erb");
  }
}