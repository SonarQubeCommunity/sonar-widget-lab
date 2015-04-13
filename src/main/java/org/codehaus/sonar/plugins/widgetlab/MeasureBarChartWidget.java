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

import org.sonar.api.web.AbstractRubyTemplate;
import org.sonar.api.web.Description;
import org.sonar.api.web.RubyRailsWidget;
import org.sonar.api.web.UserRole;
import org.sonar.api.web.WidgetCategory;
import org.sonar.api.web.WidgetProperties;
import org.sonar.api.web.WidgetProperty;
import org.sonar.api.web.WidgetPropertyType;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@UserRole(UserRole.USER)
@Description("Display a measure history in a bar chart (1 year of data)")
@WidgetCategory({"Measures"})
@WidgetProperties({
  @WidgetProperty(key = "metric",
    description = "Measure",
    type = WidgetPropertyType.METRIC),
  @WidgetProperty(key = "period",
    description = "Period",
    type = WidgetPropertyType.SINGLE_SELECT_LIST)
})
public class MeasureBarChartWidget extends AbstractRubyTemplate implements RubyRailsWidget {

  @Override
  protected String getTemplatePath() {
    // return "/measure_bar_chart_widget.html.erb";
    return "/Users/alexandregigleux/Repos/sonar-widget-lab/src/main/resources/measure_bar_chart_widget.html.erb";
  }

  @Override
  public String getId() {
    return "measure_bar_chart";
  }

  public String intToEnglishValue(int i) {
    if (i == 1) {
      return "One";
    }
    if (i == 2) {
      return "Two";
    }
    if (i == 3) {
      return "Three";
    }
    if (i == 4) {
      return "Four";
    }
    if (i == 5) {
      return "Five";
    }
    if (i == 6) {
      return "Six";
    }
    if (i > 6) {
      throw new NotImplementedException();
    }
    return null;
  }

  @Override
  public String getTitle() {
    return "Measure History as Bar Chart";
  }
}
