package org.mql.java.application.reflection.parsers;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ClassParser {

	private final Class<?> targetClass;

	public ClassParser(Class<?> targetClass) {
		this.targetClass = targetClass;
	}

	public Class<?> getTargetClass() {
		return targetClass;
	}

	public Class<?> getParentClass() {
		return targetClass.getSuperclass();
	}

	public List<Constructor<?>> getConstructors() {
		return Arrays.asList(targetClass.getDeclaredConstructors());
	}

	public List<Class<?>> getIntefaces() {
		return Arrays.asList(targetClass.getInterfaces());
	}

	public List<Field> getFields() {
		return Arrays.asList(targetClass.getDeclaredFields());
	}

	public List<Method> getMethods() {
		return Arrays.asList(targetClass.getDeclaredMethods());
	}

	public List<Object> getConstatns() {
		return Arrays.asList(targetClass.getEnumConstants());
	}

	public List<Class<?>> getInnerClasses() {
		return Arrays.asList(targetClass.getDeclaredClasses());
	}

	public List<Class<?>> getHeritageChaine() {
		Class<?> classTmp = targetClass;
		List<Class<?>> classes = new LinkedList<Class<?>>();
		while (classTmp != null) {
			classes.add(classTmp);
			classTmp = classTmp.getSuperclass();
		}
		return classes;
	}
}
