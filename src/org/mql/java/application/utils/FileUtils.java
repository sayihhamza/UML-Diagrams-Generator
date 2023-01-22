package org.mql.java.application.utils;

import java.io.File;
import java.util.List;

public class FileUtils {

	public static void getAllPackages(File dirctory, List<File> allPackages) {
		if (dirctory.exists() && dirctory.isDirectory()) {
			for (File childDirectory : dirctory.listFiles()) {
				if (childDirectory.isDirectory()) {
					if (isPackageDirectory(childDirectory)) {
						allPackages.add(childDirectory);						
					}
					getAllPackages(childDirectory, allPackages);
				}
			}
		}
	}

	public static void getClasses(File packageDirectory, List<File> classes) {
		if (isPackageDirectory(packageDirectory)) {
			for (File classFile : packageDirectory.listFiles()) {
				if (classFile.getAbsolutePath().endsWith(".class"))
					classes.add(classFile);
			}
		}
	}

	public static boolean isProjectDirectory(File projectDirectory) {
		if (isPackageDirectory(projectDirectory)) {
			return true;
		} else if (projectDirectory.isDirectory()) {
			for (File childDirectory : projectDirectory.listFiles())
				if (isPackageDirectory(childDirectory)) {
					return true;
				} else {
					isPackageDirectory(childDirectory);
				}
		}
		return false;
	}

	public static boolean isPackageDirectory(File packageDirectory) {
		if (packageDirectory.isDirectory()) {
			for (File childFile : packageDirectory.listFiles()) {
				if (isClassFile(childFile)) {
					return true;
				}
			}
		}
		return true;
	}

	public static boolean isClassFile(File classFile) {
		if (classFile.getAbsolutePath().endsWith(".class")) {
			return true;			
		}
		return false;
	}
}
