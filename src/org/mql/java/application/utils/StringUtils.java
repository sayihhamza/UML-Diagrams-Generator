package org.mql.java.application.utils;

public class StringUtils {

	public static final String trimPath(String absolutePath) {
		if (absolutePath != null) {
			String path = absolutePath.substring(absolutePath.lastIndexOf("\\bin\\") + 5);
			path = path.replace(".class", "");
			path = path.replace("\\", ".");
			return path;
		}
		return "";
	}
}
