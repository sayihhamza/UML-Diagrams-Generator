package org.mql.java.application;

import java.io.File;

import org.mql.java.application.models.primary.ProjectModel;
import org.mql.java.application.parsers.reflection.ProjectParser;

public class Main {

	public Main() {
		exploreProject();
	}

	private void exploreProject() {
		File projectFile = new File(
				"C:\\Users\\esayi\\eclipse-workspace\\UML Diagrams Generator\\bin\\");
		ProjectParser projectParser = new ProjectParser();
		projectParser.setTargetProject(projectFile);
		ProjectModel projectModel = (ProjectModel) projectParser.parse();
		System.out.println(projectModel);
	}

	public static void main(String[] args) {
		new Main();
	}
}
