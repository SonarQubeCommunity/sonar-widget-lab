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
package org.codehaus.sonar.plugins.widgetlab;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.codehaus.sonar.plugins.widgetlab.logo.LogoDashboardWidget;
import org.codehaus.sonar.plugins.widgetlab.logo.LogoMetrics;
import org.codehaus.sonar.plugins.widgetlab.logo.LogoPostJob;
import org.codehaus.sonar.plugins.widgetlab.logo.LogoWebService;
import org.junit.Before;
import org.junit.Test;

public class WidgetLabPluginTest {

  private WidgetLabPlugin plugin;

  @Before
  public void setUp() {
    plugin = new WidgetLabPlugin();
  }

  @Test
  public void testPluginDefinition() {
    assertThat(plugin.getExtensions().size(), equalTo(9));
    assertEquals("Plugin extensions must contain all extensions created", plugin.getExtensions(), Arrays.asList(AlertsWidget.class,
        AltRulesComplianceWidget.class, DifferentialDropdownWidget.class, HtmlWidget.class, ManualSeverityWidget.class,
        LogoDashboardWidget.class, LogoMetrics.class, LogoPostJob.class, LogoWebService.class));
  }
}