package org.mql.java.example;

import java.io.File;

import org.mql.java.application.models.primary.ProjectModel;
import org.mql.java.application.parsers.reflection.ProjectParser;

@SuppressWarnings("unused")
public class Example {

	public Example() {
		exploreProject();
	}

	private void exploreProject() {
		File projectFile = new File(
				"C:\\Users\\esayi\\eclipse-workspace\\UML Diagrams Generator\\bin\\org\\mql\\java\\example");
		ProjectParser projectParser = new ProjectParser();
		projectParser.setTargetProject(projectFile);
		ProjectModel projectModel= (ProjectModel) projectParser.parse();
	}

	public static void main(String[] args) {
		new Example();
	}
}
