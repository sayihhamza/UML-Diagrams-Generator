package org.mql.java.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;

import org.mql.java.application.models.primary.ClassModel;
import org.mql.java.application.models.primary.EnumModel;
import org.mql.java.application.models.primary.InterfaceModel;
import org.mql.java.application.models.primary.PackageModel;
import org.mql.java.application.models.primary.ProjectModel;
import org.mql.java.application.models.secondary.ConstantModel;
import org.mql.java.application.models.secondary.FieldModel;
import org.mql.java.application.models.secondary.MethodModel;
import org.mql.java.application.reflection.parsers.ClassParser;
import org.mql.java.application.reflection.parsers.PackageParser;
import org.mql.java.application.reflection.parsers.ProjectParser;
import org.mql.java.application.utils.ReflectionUtils;

public class Example {

	public Example() {
		test();
	}

	public void test() {
		ProjectParser projectParser = new ProjectParser("C:\\Users\\esayi\\eclipse-workspace\\UML Diagrams Generator");
		Set<PackageModel> packageModels = new HashSet<>();

		Set<String> projectPackages = projectParser.getAllPackages();
		projectPackages = projectPackages.stream().filter(packageName -> packageName.contains("org.mql.java.example"))
				.collect(Collectors.toSet());

		for (String packageName : projectPackages) {
			PackageParser packageParser = new PackageParser(packageName, projectParser.getPath());
			Set<String> classes = packageParser.getInnerClasses();
			List<ClassModel> classModels = new Vector<>();
			for (String className : classes) {
				Class<?> cls = ReflectionUtils.loadClass(className, projectParser.getPath());
				ClassParser classParser = new ClassParser(cls);
				List<FieldModel> fieldModels = new Vector<>();
				List<MethodModel> methodModels = new Vector<>();
				List<ConstantModel> constantModels = new Vector<>();
				for (Field field : classParser.getFields()) {
					FieldModel fieldModel = new FieldModel(field.getName(), field.getModifiers(),
							classes.contains(field.getType().getName()), field.getType());
					fieldModels.add(fieldModel);
				}
				for (Method method : classParser.getMethods()) {
					MethodModel methodModel = new MethodModel(method.getName(),
							Arrays.asList(method.getParameterTypes()), method.getModifiers(),
							Constructor.class.isAssignableFrom(method.getClass()), method.getReturnType());
					methodModels.add(methodModel);
				}
				if (cls.isEnum()) {
					for (Object constant : classParser.getConstatns()) {
						ConstantModel constantModel = new ConstantModel(constant);
						constantModels.add(constantModel);
					}
				}
				if (cls.isEnum()) {
					EnumModel enumModel = new EnumModel(classParser.getTargetClass().getName(), constantModels);
					classModels.add(enumModel);
				} else if (cls.isInterface()) {
					InterfaceModel interfaceModel = new InterfaceModel(classParser.getTargetClass().getName(),
							fieldModels, methodModels);
					classModels.add(interfaceModel);
				} else {
					ClassModel classModel = new ClassModel(classParser.getTargetClass().getName(), fieldModels,
							methodModels);
					classModels.add(classModel);
				}
			}
			PackageModel packageModel = new PackageModel(packageName, classModels);
			packageModels.add(packageModel);
		}
		ProjectModel projectModel = new ProjectModel(projectParser.getTargetProject(), projectParser.getPath(),
				packageModels);
		System.out.println(projectModel);
	}

	public static void main(String[] args) {
		new Example();
	}
}
