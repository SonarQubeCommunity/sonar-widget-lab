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

/**
 * Alerts
 * 
 * @version 1.0
 * @author Patroklos PAPAPETROU
 */
@UserRole(UserRole.USER)
@WidgetCategory({ "Alerts" })
@Description("Shows Alerts in a fine way.")
public class AlertsWidget extends AbstractRubyTemplate implements RubyRailsWidget {

  /**
   * Get Widget Id
   */
  public final String getId() {
    return "alt_alerts";
  }

  /**
   * Get widget title
   */
  public final String getTitle() {
    return "Alerts (advanced version)";
  }

  /**
   * Get widget template path
   */
  @Override
  protected final String getTemplatePath() {
    return "/alt_alerts_widget.html.erb";
  }
}