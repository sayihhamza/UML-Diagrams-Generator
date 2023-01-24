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

	public static String toSimpleName(String iterableTypeName) {
		if (!iterableTypeName.contains(">"))
			return toClassName(iterableTypeName);
		String iterableName = iterableTypeName.substring(0, iterableTypeName.lastIndexOf("<"));
		iterableName = toClassName(iterableName);
		String genericName = iterableTypeName.substring(iterableTypeName.lastIndexOf("<") + 1,
				iterableTypeName.length() - 1);
		genericName = toClassName(genericName);
		return iterableName + "<" + genericName + ">";
	}
}
