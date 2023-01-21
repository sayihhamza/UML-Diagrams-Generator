package org.mql.java.application.models.secondary;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import org.mql.java.application.models.Model;
import org.mql.java.application.utils.ModifierUtils;

public class MethodModel implements Model {

	private final String name;

	private final List<Parameter> parameters;
	private final List<Type> parameterTypes;
	private final int modifier;
	private final String modifierString;
	private final boolean isConstructor;
	private final Type returnType;

	public MethodModel(Method method) {
		this.name = method.getName();
		this.parameters = Arrays.asList(method.getParameters());
		this.parameterTypes = Arrays.asList(method.getGenericParameterTypes());
		this.modifier = method.getModifiers();
		this.modifierString = ModifierUtils.resolveModifier(modifier);
		this.isConstructor = false;
		this.returnType = method.getGenericReturnType();
	}

	public MethodModel(Constructor<?> constructor) {
		this.name = constructor.getName();
		this.parameters = Arrays.asList(constructor.getParameters());
		this.parameterTypes = Arrays.asList(constructor.getGenericParameterTypes());
		this.modifier = constructor.getModifiers();
		this.modifierString = ModifierUtils.resolveModifier(modifier);
		this.isConstructor = true;
		this.returnType = null;
	}

	public String getName() {
		return name;
	}

	public String getModifierString() {
		return modifierString;
	}

	public boolean isConstructor() {
		return isConstructor;
	}

	public Type getReturnType() {
		return returnType;
	}

	public int getModifier() {
		return modifier;
	}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public List<Type> getParameterTypes() {
		return parameterTypes;
	}
}
