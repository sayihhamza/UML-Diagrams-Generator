package org.mql.java.application.models.primary;

import java.io.File;
import java.util.List;

import org.mql.java.application.models.Model;

public class ProjectModel implements Model {

	private final String name;

	private String path;
	private List<PackageModel> packages;


	public ProjectModel(File projectDirectory,String projectName) {
		path = projectDirectory.getAbsolutePath();
		name = projectName;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public List<PackageModel> getPackages() {
		return packages;
	}

	public void setPackages(List<PackageModel> packages) {
		this.packages = packages;
	}
}
