package org.mql.java.application.utils;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class ReflectionUtils {

	public static Class<?> loadClass(String className, String path) {
		try {
			File file = new File(path);
			URL[] classPath = { file.toURI().toURL() };
			try (URLClassLoader urlcl = new URLClassLoader(classPath)) {
				return urlcl.loadClass(className);
			}
		} catch (Exception E) {
			System.out.println("Class not found");
		}
		return null;
	}

}
