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
 * @version 1.0
 * @author Patroklos PAPAPETROU
 */
import org.sonar.api.web.*;

@UserRole(UserRole.USER)
@WidgetCategory({"Documentation"})
public class DocumentationWidget extends AbstractRubyTemplate implements RubyRailsWidget {

  public String getId() {
    return "documentation";
  }

  public String getTitle() {
    return "Documentation Metrics";
  }

  @Override
  protected String getTemplatePath() {
    return "/documentation_widget.html.erb";
  }

}
