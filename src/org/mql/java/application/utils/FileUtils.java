package org.mql.java.application.utils;

import java.io.File;
import java.util.Set;

public class FileUtils {

	public static void getAllPackages(File dirctory, Set<File> allPackages) {
		if (dirctory.exists() && dirctory.isDirectory()) {
			for (File childDirectory : dirctory.listFiles()) {
				if (childDirectory.isDirectory()) {
					if (isPackageDirectory(childDirectory))
						allPackages.add(childDirectory);
					getAllPackages(childDirectory, allPackages);
				}
			}
		}
	}

	public static void getClasses(File packageDirectory, Set<File> classes) {
		if (isPackageDirectory(packageDirectory)) {
			for (File classFile : packageDirectory.listFiles()) {
				if (classFile.getAbsolutePath().endsWith(".class"))
					classes.add(classFile);
			}
		}
	}

	public static boolean isProjectDirectory(File projectDirectory) {
		if (projectDirectory.isDirectory()) {
			if (isPackageDirectory(projectDirectory)) {
				return true;
			} else {
				for (File childDirectory : projectDirectory.listFiles())
					isProjectDirectory(childDirectory);
			}
		}
		return false;
	}

	public static boolean isPackageDirectory(File packageDirectory) {
		if (packageDirectory.exists() && packageDirectory.isDirectory()) {
			for (File childFile : packageDirectory.listFiles()) {
				if (isClassFile(childFile))
					return true;
			}
		}
		return false;
	}

	public static boolean isClassFile(File classFile) {
		if (classFile.exists() && classFile.getAbsolutePath().endsWith(".class"))
			return true;
		return false;
	}
}
