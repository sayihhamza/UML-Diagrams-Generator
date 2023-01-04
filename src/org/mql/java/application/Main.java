package org.mql.java.application;

import java.util.Set;

import org.mql.java.application.reflection.parsers.ClassParser;
import org.mql.java.application.reflection.parsers.PackageParser;
import org.mql.java.application.reflection.parsers.ProjectParser;
import org.mql.java.application.utils.ReflectionUtils;

public class Main {

	public Main() {
		test();
	}

	public void test() {
		ProjectParser projectParser = new ProjectParser("C:\\Users\\esayi\\eclipse-workspace\\UML Diagrams Generator\\bin\\");
		Set<String> projectPackages = projectParser.getAllPackages();
		for (String packageName : projectPackages) {
			PackageParser packageParser = new PackageParser(packageName, projectParser.getPath());
			Set<String> classes = packageParser.getInnerClasses();
			for (String className : classes) {
				Class<?> cls = ReflectionUtils.loadClass(className, projectParser.getPath());
				ClassParser classParser = new ClassParser(cls);
				System.out.println(classParser.getHeritageChaine());
			}
		}
	}

	public static void main(String[] args) {
		new Main();
	}
}
