package org.mql.java.application;

import java.io.File;

import org.mql.java.application.models.primary.ClassModel;
import org.mql.java.application.models.primary.PackageModel;
import org.mql.java.application.models.primary.ProjectModel;
import org.mql.java.application.parsers.reflection.ProjectParser;

public class Main {

	public Main() {
		exploreProject();
	}

	private void exploreProject() {
		File tmp = new File(
				"C:\\Users\\esayi\\eclipse-workspace\\UML Diagrams Generator\\bin\\org\\mql\\java\\example");
		ProjectParser pp = new ProjectParser(tmp);

		ProjectModel pm = (ProjectModel) pp.parse();
		System.out.println(pm.getName());
		for (PackageModel string : pm.getPackages()) {
			System.out.println(string.getName());
			for (ClassModel string2 : string.getClasses()) {
				System.out.println(string2.getName());
			}
		}
	}

	public static void main(String[] args) {
		new Main();
	}
}
