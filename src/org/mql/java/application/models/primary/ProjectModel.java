package org.mql.java.application.models.primary;

import java.io.File;
import java.util.List;

import org.mql.java.application.models.Model;
import org.mql.java.application.utils.StringUtils;

public class ProjectModel implements Model {

	private static ProjectModel project;
	private String path;
	
	public void setPath(String path) {
		this.path = path;
	}

	private List<PackageModel> packages;
	private List<RelationModel> classRelations;
	
	public static ProjectModel getInstance(File file) {
		if(project == null) {
			project = new ProjectModel(file);
		}
		return project;
	}
	
	private ProjectModel(File file) {
		this.path = file.getAbsolutePath();
	}

	public String getName() {
		return StringUtils.toProjectName(path);
	}

	public void setName(String path) {
		this.path = path;
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

	public List<RelationModel> getClassRelations() {
		return classRelations;
	}

	public void setClassRelations(List<RelationModel> classRelations) {
		this.classRelations = classRelations;
	}
	
//	@Override
//	public String toString() {
//		StringBuffer temp = new StringBuffer("Project : " + getName());
//		for(PackageModel item : packages) {
//			temp.append("\n\t" + item);
//		}
//		return temp.toString();
//	}
}
