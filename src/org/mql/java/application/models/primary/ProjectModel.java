package org.mql.java.application.models.primary;

import java.util.List;

public class ProjectModel {

	private final String name;
	private final String path;
	private final List<PackageModel> allPackages;
	
	public ProjectModel(String name,String path,List<PackageModel> allPackages) {
		this.name = name;
		this.path = path;
		this.allPackages = allPackages;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public List<PackageModel> getAllPackages() {
		return allPackages;
	}
}
