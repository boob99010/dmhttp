/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.peter.mavenrunner;

import java.util.List;

/**
 *
 * @author peter
 */
public class PersistData {

	public String type;
	String projectName;
	public String name;
	public String goals;
	public String profile;
	public List<String> properties;
	public boolean skipTests;

	public PersistData(String type, String projectName, String name, String goals, String profile, List<String> properties, boolean skipTests) {
		this.type = type;
		this.projectName = projectName;
		this.name = name;
		this.goals = goals;
		this.profile = profile;
		this.properties = properties;
		this.skipTests = skipTests;
	}
}
