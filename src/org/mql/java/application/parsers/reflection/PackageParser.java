package org.mql.java.application.parsers.reflection;

import java.io.File;
import java.util.List;
import java.util.Vector;

import org.mql.java.application.models.primary.ClassModel;
import org.mql.java.application.models.primary.PackageModel;
import org.mql.java.application.parsers.Parser;
import org.mql.java.application.utils.FileUtils;

public class PackageParser implements Parser {
	private String name;

	public String getName() {
		return name;
	}

	public Object parse(File file) {
		if (FileUtils.isPackageDirectory(file)) {
			PackageModel packageModel = new PackageModel(file.getAbsolutePath());
			List<ClassModel> classModels = new Vector<>();
			for (File classFile : file.listFiles()) {
				if (FileUtils.isClassFile(classFile)) {
					ClassParser classParser = new ClassParser();
					classModels.add((ClassModel) classParser.parse(classFile));
				}
			}
			packageModel.setClasses(classModels);
			return packageModel;
		}
		return null;
	}
}
