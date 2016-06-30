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

import org.sonar.api.web.*;

@UserRole(UserRole.USER)
@Description("Issues tags for security-related issues global counts")
@WidgetCategory({"Technical Debt"})
@WidgetScope("GLOBAL")
@WidgetProperties({
  @WidgetProperty(
    key = "tagsOfInterest",
    type = WidgetPropertyType.TEXT,
    description = "Which tags should be included in this display",
    defaultValue = "owasp-top10, sans-top25, owasp-a1, owasp-a2, owasp-a3, owasp-a4, owasp-a5, owasp-a6, owasp-a7, " +
            "owasp-a8, owasp-a9, owasp-a10, sans-top25-insecure, sans-top25-porous, sans-top25-risky, error-handling, " +
            "multi-threading,injection, denial-of-service"
  )
})
public class SecurityIssuesTagGlobalWidget extends AbstractRubyTemplate implements RubyRailsWidget {

  @Override
  public String getId() {
    return "security_issues_tag_global";
  }

  @Override
  public String getTitle() {
    return "Global Security Issues Tags";
  }

  @Override
  protected String getTemplatePath() {
    return "/security_issues_tag_global_widget.html.erb";
  }
}
