/*
License
	Copyright (C) 2016 Peter Cheung (mcheung63@hotmail.com)

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.peter.mavenrunner;

import java.util.List;
import javax.swing.Icon;
import javax.swing.tree.DefaultMutableTreeNode;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectInformation;

/**
 *
 * @author peter
 */
public class MyTreeNode extends DefaultMutableTreeNode {

	public String type;
	public Icon icon;
	Project project;
	ProjectInformation projectInformation;
	public String name;
	public String goals;
	public String profile;
	public List<String> properties;
	public boolean skipTests;

	public MyTreeNode(String name, String goals, String profile, List<String> properties, boolean skipTests, String type, Project project, ProjectInformation projectInformation) {
		this.name = name;
		this.goals = goals;
		this.profile = profile;
		this.properties = properties;
		this.skipTests = skipTests;
		this.type = type;
		this.project = project;
		this.projectInformation = projectInformation;
	}

	public String toString() {
		return name + " - " + goals;
	}

}
