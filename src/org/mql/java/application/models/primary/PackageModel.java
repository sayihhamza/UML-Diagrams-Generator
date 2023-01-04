package org.mql.java.application.models.primary;

import java.util.List;

public class PackageModel {

	private final String name;
	private final List<ClassModel> innerClasses;

	public PackageModel(String name, List<ClassModel> innerClasses) {
		this.name = name;
		this.innerClasses = innerClasses;
	}

	public String getName() {
		return name;
	}

	public List<ClassModel> getInnerClasses() {
		return innerClasses;
	}

	@Override
	public String toString() {
		return "PackageModel [name=" + name + ", innerClasses=" + innerClasses + "]";
	}
}
