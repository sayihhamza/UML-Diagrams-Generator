package org.mql.java.application.models.primary;

import java.util.List;

public class PackageModel {

	private final String name;
	private final List<ClassModel> innerClasses;
	private final List<PackageModel> innerPackages;
	
	public PackageModel(String name,List<ClassModel> innerClasses,List<PackageModel> innerPackages) {
		this.name = name;
		this.innerClasses = innerClasses;
		this.innerPackages = innerPackages;
	}

	public String getName() {
		return name;
	}
	
	public List<ClassModel> getInnerClasses() {
		return innerClasses;
	}

	public List<PackageModel> getInnerPackages() {
		return innerPackages;
	}
}
