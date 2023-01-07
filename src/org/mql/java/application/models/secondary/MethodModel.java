package org.mql.java.application.models.secondary;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import org.mql.java.application.models.Model;

public class MethodModel implements Model {

	private final String name;
	
	private final List<Type> parameterTypes;
	private final int modifier;
	private final boolean isConstructor;
	private final Type returnType;

	public MethodModel(Method method) {
		name = method.getName();
		parameterTypes = Arrays.asList(method.getParameterTypes());
		modifier = method.getModifiers();
		isConstructor = false;
		returnType= method.getReturnType();
	}
	
	public MethodModel(Constructor<?> constructor) {
		name = constructor.getName();
		parameterTypes = Arrays.asList(constructor.getParameterTypes());
		modifier = constructor.getModifiers();
		isConstructor = true;
		returnType = null;
	}

	public String getName() {
		return name;
	}

	public List<Type> getParameterTypes() {
		return parameterTypes;
	}

	public int getModifier() {
		return modifier;
	}

	public boolean isConstructor() {
		return isConstructor;
	}

	public Type getReturnType() {
		return returnType;
	}
}
