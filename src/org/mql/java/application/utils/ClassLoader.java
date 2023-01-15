package org.mql.java.application.utils;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoader {
	public static Class<?> loadClass(File file) {
		try {
			URLClassLoader classLoader;
			String className = StringUtils.toPackageName(file.getAbsolutePath());
			String uri = file.toURI().toString();
			classLoader = URLClassLoader.newInstance(new URL[] { new URL(uri) });
			return classLoader.loadClass(className);
		} catch (Exception e) {
			System.out.println("CLASS LOADER EXCEPTION " + e.getMessage());
		}
		return null;
	}
}
