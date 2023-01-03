package org.mql.java.application.utils;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.mql.java.application.types.FilesType;

public class FileUtils {

	public static Set<String> findFiles(String path, FilesType fileType, String packageName) {
		Set<String> items = new HashSet<>();
		File directory = new File(path + packageName.replace(".", "/"));
		File[] files = directory.listFiles();

		if (FilesType.ALL_PACKAGES.equals(fileType)) {
			getAllPackages(path, files, items);
		} else if (FilesType.INNER_PACKAGES.equals(fileType)) {
			for (File file : files) {
				if (file.isDirectory())
					items.add(packageName + "." + file.getName());
			}
		} else if (FilesType.INNER_CLASSES.equals(fileType)) {
			for (File file : files) {
				if (file.isFile() && file.getName().endsWith(".class"))
					items.add(packageName + "." + file.getName().replace(".class", ""));
			}
		}
		return items;
	}

	private static void getAllPackages(String path, File[] files, Set<String> items) {
		for (File file : files) {
			if (file.isFile()) {
				String tmpPath = file.getPath();
				String packName = tmpPath.substring(tmpPath.indexOf("bin") + 4, tmpPath.lastIndexOf('\\'));
				items.add(packName.replace('\\', '.'));
			} else if (file.isDirectory()) {
				getAllPackages(file.getAbsolutePath(), file.listFiles(), items);
			}
		}
	}
}
