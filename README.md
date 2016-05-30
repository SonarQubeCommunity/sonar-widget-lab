# Widget Lab SonarQube Plugin
[![Build Status](https://api.travis-ci.org/SonarQubeCommunity/sonar-widget-lab.svg)](https://travis-ci.org/SonarQubeCommunity/sonar-widget-lab) [![Nemo Quality Gate status](https://nemo.sonarqube.org/api/badges/gate?key=org.sonarsource.widget-lab%3Asonar-widget-lab-plugin)](https://nemo.sonarqube.org/overview?id=org.sonarsource.widget-lab%3Asonar-widget-lab-plugin)

## Description
Widget Lab plugin offers new widgets:
* WRV Rules Compliance - a Rules Compliance clone, with the Weighted Rule Violations score in the upper-left corner and the violations count moved under the Severities counts. Additionally, if a variation period is chosen, the widget does some simple math to display both violations cleared and violations added - both numerically and as colored "ears" - versus the net change displayed by the default widget. Since version 1.4, you have the option of showing Rules Compliance and/or Technical Debt in the lower-left corner.
From SonarQube version 4.5, the use of this widget requires the [Issues Density Plugin](http://docs.sonarqube.org/display/PLUG/Issues+Density+Plugin).

* User Text Display - A global widget that displays your text / HTML / Markdown. Optionally includes a title. For supported markdown, see http://[your server]/markdown/help.

* Global Differential DropDown - A global widget that allows you to put a differential dropdown on a global dashboard. This odd-looking little widget contains only a dropdown, but it allows you to apply a differential period to every widget on a global dashboard (including filters!) at once. It provides the same functionality as the built-in differential dropdown you get on project-level dashboards. Note that since SonarQube version 3.4, this widget won't effect filters, but it will still be honored by metric-specific widgets, such as the Violations widgets - as shown in the screenshot below. (since version 1.3)

* Security Issue Tags - Shows a project-level list of security-related issue tags with issue counts. (since version 1.7)

* Global Security Issue Tags - Shows a global list of security-related issue tags with issue counts. (since version 1.7)

* Bar Chart Widget - A project widget showing history of a measure as Bar Chart.  The period of time can be configured in the widget or changed directly while viewing the dashboard. The measure value is the last one of the displayed period. Ex: while showing a full year of history, each bar represents the value of the measure as it was during the last analysis of the month.

## Usage
Just add the new widgets to your dashboards.


