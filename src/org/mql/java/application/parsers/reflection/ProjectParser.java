package org.mql.java.application.parsers.reflection;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.mql.java.application.models.primary.PackageModel;
import org.mql.java.application.models.primary.ProjectModel;
import org.mql.java.application.parsers.Parser;
import org.mql.java.application.utils.FileUtils;

public class ProjectParser implements Parser {

	private final File targetProject;
	private final String name;

	public ProjectParser(File projectFile) {
		name = "UML Diagrams Generator";
		this.targetProject = projectFile;
	}

	public Object parse() {
		if (FileUtils.isProjectDirectory(targetProject)) {
			ProjectModel projectModel = new ProjectModel(targetProject,name);
			List<PackageModel> packageModels = new Vector<>();
			Set<File> allPackages = new HashSet<>();
			FileUtils.getAllPackages(targetProject, allPackages);
			for (File packageFile : allPackages) {
				PackageParser packageParser = new PackageParser(packageFile);
				PackageModel packageModel = (PackageModel) packageParser.parse();
				packageModels.add(packageModel);
			}
			projectModel.setPackages(packageModels);
			return projectModel;
		}
		return null;
	}
}
