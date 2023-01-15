package org.mql.java.application.parsers.reflection;

import java.io.File;
import java.util.List;
import java.util.Vector;

import org.mql.java.application.models.primary.ClassModel;
import org.mql.java.application.models.primary.PackageModel;
import org.mql.java.application.models.primary.ProjectModel;
import org.mql.java.application.models.primary.RelationModel;
import org.mql.java.application.parsers.Parser;
import org.mql.java.application.utils.FileUtils;
import org.mql.java.application.utils.ReflectionUtils;
import org.mql.java.application.utils.StringUtils;

public class ProjectParser implements Parser {

	private File targetProject;
	private String name;

	public String getName() {
		return name;
	}
	
	public File getTargetProject() {
		return targetProject;
	}

	public void setTargetProject(File targetProject) {
		this.targetProject = targetProject;
		this.name = StringUtils.toProjectName(targetProject.getAbsolutePath());
	}

	public Object parse() {
		if (FileUtils.isProjectDirectory(targetProject)) {
			ProjectModel projectModel = new ProjectModel(targetProject, name);
			parsePackages(projectModel);
			parseRelations(projectModel);
			return projectModel;
		}
		return null;
	}
	
	private void parsePackages(ProjectModel projectModel) {
		List<PackageModel> packageModels = new Vector<>();
		List<File> projectPackages = new Vector<>();
		
		FileUtils.getAllPackages(targetProject, projectPackages);
		for (File packageFile : projectPackages) {
			PackageParser packageParser = new PackageParser();
			packageParser.setTargetPackage(packageFile);
			packageModels.add((PackageModel) packageParser.parse());
		}
		projectModel.setPackages(packageModels);
	}
	
	private void parseRelations(ProjectModel projectModel) {
		List<RelationModel> relationModels = new Vector<>();
		List<ClassModel> projectClasses = ReflectionUtils.extractAllClasses(projectModel.getPackages());
		
		for (ClassModel firstClass : projectClasses) {
			for (ClassModel secondClass : projectClasses) {
				RelationParser relationParser = new RelationParser(firstClass, secondClass);
				relationModels.add(relationParser.parse());
			}
		}
		relationModels.remove(null);
		projectModel.setClassRelations(relationModels);
	}
}
