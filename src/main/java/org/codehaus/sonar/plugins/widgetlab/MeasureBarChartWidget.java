/*
 * Widget Lab
 * Copyright (C) 2012 Shaw Industries
 * sonarqube@googlegroups.com
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

@UserRole(UserRole.USER)
@Description("Display a measure history in a bar chart")
@WidgetCategory({"Measures"})
@WidgetProperties({
  @WidgetProperty(key = MeasureBarChartWidget.MEASURE_PROPERTY,
    description = "Measure",
    defaultValue = "sqale_index",
    type = WidgetPropertyType.METRIC),
  @WidgetProperty(key = MeasureBarChartWidget.PERIOD_PROPERTY,
    description = "Period",
    type = WidgetPropertyType.SINGLE_SELECT_LIST,
    defaultValue = "Y",
    options = {"Y", "S", "Q", "M", "W"}),
})
public class MeasureBarChartWidget extends AbstractRubyTemplate implements RubyRailsWidget {

  public static final String MEASURE_PROPERTY = "metric";
  public static final String PERIOD_PROPERTY = "period";

  @Override
  public String getId() {
    return "measure_bar_chart";
  }

  @Override
  public String getTitle() {
    return "Measure History as Bar Chart";
  }

  @Override
  protected String getTemplatePath() {
    return "/measure_bar_chart_widget.html.erb";
  }
}
