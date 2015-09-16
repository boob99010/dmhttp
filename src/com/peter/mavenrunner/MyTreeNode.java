/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peter.mavenrunner;

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

	public MyTreeNode(Object userObject, String type, Project project, ProjectInformation projectInformation) {
		super(userObject);
		this.type = type;
		this.project = project;
		this.projectInformation = projectInformation;
	}

}
