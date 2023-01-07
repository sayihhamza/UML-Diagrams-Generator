package org.mql.java.application.models.primary;

import java.util.List;

import org.mql.java.application.models.Model;

public class PackageModel implements Model{

	private final String name;
	private List<ClassModel> classes;

	public PackageModel(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<ClassModel> getClasses() {
		return classes;
	}
	
	public void setClasses(List<ClassModel> classes) {
		this.classes = classes;
	}
}
