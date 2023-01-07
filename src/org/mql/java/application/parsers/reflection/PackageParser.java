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

	private final File targetPackage;
	private final String name;

	public PackageParser(File packageFile) {
		name = StringUtils.trimPath(packageFile.getAbsolutePath());
		targetPackage = packageFile;
	}

	public Object parse() {
		if (FileUtils.isPackageDirectory(targetPackage)) {
			PackageModel packageModel = new PackageModel(name);
			List<ClassModel> classModels = new Vector<>();
			for (File classFile : targetPackage.listFiles()) {
				if (FileUtils.isClassFile(classFile)) {
					ClassParser classParser = new ClassParser(classFile);
					ClassModel classModel = (ClassModel) classParser.parse();
					classModels.add(classModel);
				}
			}
			packageModel.setClasses(classModels);
			return packageModel;
		}
		return null;
	}
}