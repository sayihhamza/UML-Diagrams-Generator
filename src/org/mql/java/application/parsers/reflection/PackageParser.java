package org.mql.java.application.parsers.reflection;

import java.io.File;
import java.util.List;
import java.util.Vector;

import org.mql.java.application.models.primary.ClassModel;
import org.mql.java.application.models.primary.PackageModel;
import org.mql.java.application.parsers.Parser;
import org.mql.java.application.utils.FileUtils;
import org.mql.java.application.utils.StringUtils;

public class PackageParser implements Parser {

	private File targetPackage;
	private String name;

	public String getName() {
		return name;
	}

	public File getTargetPackage() {
		return targetPackage;
	}

	public void setTargetPackage(File targetPackage) {
		this.targetPackage = targetPackage;
		this.name = StringUtils.toPackageName(targetPackage.getAbsolutePath());
	}

	public Object parse() {
		if (FileUtils.isPackageDirectory(targetPackage)) {
			PackageModel packageModel = new PackageModel(name);
			parseClasses(packageModel);
			return packageModel;
		}
		return null;
	}

	private void parseClasses(PackageModel packageModel) {
		List<ClassModel> classModels = new Vector<>();
		for (File classFile : targetPackage.listFiles()) {
			if (FileUtils.isClassFile(classFile)) {
				ClassParser classParser = new ClassParser();
				classParser.setTargetClass(classFile);
				classModels.add((ClassModel) classParser.parse());
			}
		}
		packageModel.setClasses(classModels);
	}
}
