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

public class ProjectParser implements Parser {

	public Object parse(File file) {
		if (FileUtils.isProjectDirectory(file)) {
			ProjectModel theReference = ProjectModel.getInstance(file);
			exctractPackages(file, theReference);
			exctractRelations(theReference);
			return theReference;
		}
		return null;
	}

	private void exctractPackages(File projectFile, ProjectModel projectModel) {
		List<PackageModel> packageModels = new Vector<>();
		List<File> projectPackages = new Vector<>();

		FileUtils.getAllPackages(projectFile, projectPackages);
		for (File packageFile : projectPackages) {
			Parser packageParser = new PackageParser();
			PackageModel packageModel = (PackageModel) packageParser.parse(packageFile);
			if (packageModel.getClasses().size() > 0) {
				packageModels.add(packageModel);
			}
		}
		projectModel.setPackages(packageModels);
	}

	private void exctractRelations(ProjectModel projectModel) {
		List<RelationModel> relationModels = new Vector<>();
		List<ClassModel> projectClasses = ReflectionUtils.extractAllClasses(projectModel.getPackages());
		for (ClassModel firstClass : projectClasses) {
			for (ClassModel secondClass : projectClasses) {
				RelationParser relationParser = new RelationParser(firstClass, secondClass);
				if (relationParser.parse() != null)
					relationModels.add(relationParser.parse());
			}
		}
		projectModel.setClassRelations(relationModels);
	}
}
