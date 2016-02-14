/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
