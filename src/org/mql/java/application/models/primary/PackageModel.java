package org.mql.java.application.models.primary;

import java.util.List;
import java.util.Vector;

import org.mql.java.application.models.Model;
import org.mql.java.application.utils.StringUtils;

public class PackageModel implements Model {

	private String name;
	private List<ClassModel> classes;

	public PackageModel(String name) {
		this.classes = new Vector<>();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String fileName) {
		this.name = StringUtils.toPackageName(fileName);
	}

	public List<ClassModel> getClasses() {
		return classes;
	}

	public void setClasses(List<ClassModel> classes) {
		this.classes = classes;
	}
//	@Override
//	public String toString() {
//		StringBuffer temp = new StringBuffer("Package : " + getName());
//		for(ClassModel clazz : classes) {
//			temp.append("\n\t" + clazz);
//		}
//		return temp.toString();
//	}
}
