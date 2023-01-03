package org.mql.java.example;

import java.util.Set;
import java.util.stream.Collectors;

import org.mql.java.application.parsers.ClassParser;
import org.mql.java.application.parsers.PackageParser;
import org.mql.java.application.parsers.ProjectParser;
import org.mql.java.application.utils.ReflectionUtils;

public class Example {

	public Example() {
		test();
	}

	public void test() {
		ProjectParser projectParser = new ProjectParser(
				"C:\\Users\\esayi\\eclipse-workspace\\UML Diagrams Generator\\bin\\");
		Set<String> projectPackages = projectParser.getAllPackages();

		projectPackages = projectPackages.stream().filter(packageName -> packageName.contains("org.mql.java.example"))
				.collect(Collectors.toSet());

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
		new Example();
	}
}
