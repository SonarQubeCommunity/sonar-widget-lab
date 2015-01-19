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

import java.util.ArrayList;
import java.util.List;

import org.codehaus.sonar.plugins.widgetlab.logo.LogoDashboardWidget;
import org.codehaus.sonar.plugins.widgetlab.logo.LogoMetrics;
import org.codehaus.sonar.plugins.widgetlab.logo.LogoPluginConst;
import org.codehaus.sonar.plugins.widgetlab.logo.LogoPostJob;
import org.codehaus.sonar.plugins.widgetlab.logo.LogoWebService;
import org.sonar.api.Extension;
import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.api.SonarPlugin;

/**
 * Widget Lab plugin
 * 
 * @author gcampb2
 * @author Patroklos Papapetrou
 * @author jbadenas
 */
@Properties({
  @Property(key = LogoPluginConst.CONFKEY_IMG_LOCATION, name = "Image location", description = "Image location inside the sources or via URL (ex: sources:/src/main/site/logo.png or http://www.myproj.org/img/logo.png)", project = true, global = true),
  @Property(key = LogoPluginConst.CONFKEY_IMG_STYLE, name = "Image css style", description = "Image css style (ex: width:200px; display: block; margin: auto;)", project = true, global = true),
  @Property(key = LogoPluginConst.CONFKEY_LINK, name = "Project url", description = "Project url", project = true, global = true),
  @Property(key = LogoPluginConst.CONFKEY_ALT_TEXT, name = "Alternative text", description = "Alternative text", project = true,
      global = true) })
public class WidgetLabPlugin extends SonarPlugin {

  /**
   * @return classes to include in the plugin
   */
  public final List<Class<? extends Extension>> getExtensions() {
    List<Class<? extends Extension>> extensions = new ArrayList<Class<? extends Extension>>();

    // Widget Lab
    extensions.add(AlertsWidget.class);
    extensions.add(AltRulesComplianceWidget.class);
    extensions.add(DifferentialDropdownWidget.class);
    extensions.add(HtmlWidget.class);
    extensions.add(ManualSeverityWidget.class);
    
    // Logo
    extensions.add(LogoDashboardWidget.class);
    extensions.add(LogoMetrics.class);
    extensions.add(LogoPostJob.class);
    extensions.add(LogoWebService.class);

    return extensions;
  }
}