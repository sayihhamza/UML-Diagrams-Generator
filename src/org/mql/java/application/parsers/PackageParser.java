package org.mql.java.application.parsers;

import java.util.Set;

import org.mql.java.application.types.FilesType;
import org.mql.java.application.utils.FileUtils;

public class PackageParser {

	private final String targetPackage;
	private final String path;

	public PackageParser(String targetPackage, String path) {
		this.targetPackage = targetPackage;
		this.path = path;
	}

	public Set<String> getInnerPackages() {
		return FileUtils.findFiles(path, FilesType.INNER_PACKAGES, targetPackage);
	}

	public Set<String> getInnerClasses() {
		return FileUtils.findFiles(path, FilesType.INNER_CLASSES, targetPackage);
	}
}
