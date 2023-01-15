package org.mql.java.application.utils;

public class StringUtils {

	public static String toClassName(String classNameInput) {
		return classNameInput.substring(classNameInput.lastIndexOf(".") + 1);
	}
	
	public static String toPackageName(String absolutePath) {
		return absolutePath.substring(absolutePath.lastIndexOf("\\bin\\") + 5).replace(".class", "").replace("\\", ".");
	}

	public static String toProjectName(String absolutePath) {
		return absolutePath.replace("\\bin", "").substring(absolutePath.replace("\\bin", "").lastIndexOf("\\") + 1);
	}
}
