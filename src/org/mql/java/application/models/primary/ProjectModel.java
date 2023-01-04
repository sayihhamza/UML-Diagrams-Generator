package org.mql.java.application.models.primary;

import java.util.Set;

public class ProjectModel {

	private final String name;
	private final String path;
	private final Set<PackageModel> allPackages;

	public ProjectModel(String name, String path, Set<PackageModel> allPackages) {
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

	public Set<PackageModel> getAllPackages() {
		return allPackages;
	}

	@Override
	public String toString() {
		return "ProjectModel [name=" + name + ", path=" + path + ", allPackages=" + allPackages + "]";
	}
}
