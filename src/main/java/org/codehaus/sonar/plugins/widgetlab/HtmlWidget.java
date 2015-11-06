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

import org.sonar.api.web.*;

@UserRole(UserRole.USER)
@Description("Displays the configured text. Intended to enable dashboard description.")
@WidgetCategory({"Global"})
@WidgetScope("GLOBAL")
@WidgetProperties({
  @WidgetProperty(key = "userText",
    description = "Text to display in widget",
    type = WidgetPropertyType.TEXT
  ),
  @WidgetProperty(key = "widgetTitle",
    description = "Widget title. Will be displayed in a bar across the top."
  ),
  @WidgetProperty(
    key = "isMarkdown",
    description = "Check to have text rendered as markdown. (<a href='#' onclick=\"window.open(baseUrl + '/markdown/help','markdown','height=300,width=600,scrollbars=1,resizable=1');return false;\">Markdown help</a>)",
    type = WidgetPropertyType.BOOLEAN
  )
})
public class HtmlWidget extends AbstractRubyTemplate implements RubyRailsWidget {

  @Override
  public String getId() {
    return "user-text";
  }

  @Override
  public String getTitle() {
    return "User Text Display";
  }

  @Override
  protected String getTemplatePath() {
    return "/html_widget.html.erb";
  }

}
