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

/**
 *
 * @author gcampb2
 */
import org.sonar.api.web.*;

@UserRole(UserRole.USER)
@Description("Shows reviews with a manual severity")
@WidgetCategory({"Reviews"})
public class ManualSeverityWidget extends AbstractRubyTemplate implements RubyRailsWidget {

  public String getId() {
    return "manual_severity_reviews";
  }

  public String getTitle() {
    return "Manual Severity Reviews";
  }

  @Override
  protected String getTemplatePath() {
    return "/manual_severity_reviews_widget.html.erb";
  }

}
