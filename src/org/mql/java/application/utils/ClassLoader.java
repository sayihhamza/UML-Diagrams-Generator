package org.mql.java.application.utils;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

@SuppressWarnings("resource")
public class ClassLoader {

	public static Class<?> loadClass(File file) {
		try {
			File fileTmp = new File(
					file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf("\\bin\\") + 5));
			URL[] url = { fileTmp.toURI().toURL() };
			URLClassLoader urlcl = new URLClassLoader(url);
			return urlcl.loadClass(StringUtils.toPackageName(file.getAbsolutePath()));
		} catch (Exception ex) {
			System.out.println("Class Inexisstante");
			ex.printStackTrace();
		}
		return null;
	}
}
