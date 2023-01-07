package org.mql.java.application.parsers.reflection;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Vector;

import org.mql.java.application.models.primary.ClassModel;
import org.mql.java.application.models.primary.EnumModel;
import org.mql.java.application.models.primary.InterfaceModel;
import org.mql.java.application.models.secondary.ConstantModel;
import org.mql.java.application.models.secondary.FieldModel;
import org.mql.java.application.models.secondary.MethodModel;
import org.mql.java.application.parsers.Parser;
import org.mql.java.application.utils.ReflectionUtils;

public class ClassParser implements Parser {

	private final Class<?> targetClass;
	private final String name;

	public ClassParser(File classFile) {
		targetClass = ReflectionUtils.loadClass(classFile);
		name = targetClass.getName();
	}

	public Object parse() {
		if (targetClass != null) {
			if (targetClass.isEnum()) {
				EnumModel enumModel = new EnumModel(name);
				parseConstants(enumModel);
				return enumModel;
			} else if (targetClass.isInterface()) {
				InterfaceModel interfaceModel = new InterfaceModel(name);
				parseFields(interfaceModel);
				parseMethods(interfaceModel);
				return interfaceModel;
			} else {
				ClassModel classModel = new ClassModel(name);
				parseFields(classModel);
				parseMethods(classModel);
				parseConstructors(classModel);
				return classModel;
			}
		}
		return null;
	}

	private void parseConstants(EnumModel enumModel) {
		List<ConstantModel> constantModels = new Vector<>();
		for (Object constant : targetClass.getEnumConstants()) {
			constantModels.add(new ConstantModel(constant));
		}
		enumModel.setConstants(constantModels);
	}

	private void parseFields(ClassModel classModel) {
		List<FieldModel> fieldModels = new Vector<>();
		for (Field field : targetClass.getDeclaredFields()) {
			fieldModels.add(new FieldModel(field));
		}
		classModel.setFields(fieldModels);
	}

	private void parseMethods(ClassModel classModel) {
		List<MethodModel> methodModels = new Vector<>();
		for (Method method : targetClass.getDeclaredMethods()) {
			methodModels.add(new MethodModel(method));
		}
		classModel.setMethods(methodModels);
	}

	private void parseConstructors(ClassModel classModel) {
		for (Constructor<?> constructor : targetClass.getDeclaredConstructors()) {
			classModel.addConstructor(constructor);
		}
	}
}
