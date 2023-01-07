package org.mql.java.application.utils;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class ReflectionUtils {

	public static Class<?> loadClass(File file) {
		try {
			URLClassLoader classLoader;
			String className = "org.mql.java.example.classes.Bike";
			className = StringUtils.trimPath(file.getAbsolutePath());
			String uri = file.toURI().toString();
			classLoader = URLClassLoader.newInstance(new URL[] { new URL(uri) });
			return classLoader.loadClass(className);
		} catch (Exception e) {
			System.out.println("EXCEPTION " + e.getMessage());
		}
		return null;
	}
}
