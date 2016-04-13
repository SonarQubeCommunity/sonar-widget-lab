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
@Description("Shows weighted issues, in addition to Rules Compliance Index.")
@WidgetCategory({"Technical Debt"})
@WidgetProperties({
  @WidgetProperty(key = "showCompliance",
    type = WidgetPropertyType.BOOLEAN,
    defaultValue = "true",
    description = "Show Rules Compliance"
  ),
  @WidgetProperty(key = "showTechDebt",
    type = WidgetPropertyType.BOOLEAN,
    defaultValue = "true",
    description = "Show Technical Debt"
  )
})
public class AltRulesComplianceWidget extends AbstractRubyTemplate implements RubyRailsWidget {

  @Override
  public String getId() {
    return "rules-alt";
  }

  @Override
  public String getTitle() {
    return "Alt Rules Compliance";
  }

  @Override
  protected String getTemplatePath() {
    return "/alt_rules_compliance_widget.html.erb";
  }

}
