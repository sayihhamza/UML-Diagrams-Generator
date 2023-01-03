package org.mql.java.application.parsers;

import java.util.Set;

import org.mql.java.application.types.FilesType;
import org.mql.java.application.utils.FileUtils;

public class ProjectParser {

	private final String targetProject;
	private final String path;

	public ProjectParser(String path) {
		this.targetProject = path.substring(path.lastIndexOf("\\") + 1);
		this.path = path;
	}

	public Set<String> getAllPackages() {
		return FileUtils.findFiles(path, FilesType.ALL_PACKAGES, "");
	}

	public String getTargetProject() {
		return targetProject;
	}

	public String getPath() {
		return path;
	}
}
