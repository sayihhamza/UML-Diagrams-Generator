package org.mql.java.application.models.secondary;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.mql.java.application.models.Model;
import org.mql.java.application.utils.ModifierUtils;

public class MethodModel implements Model {

	private String name;

	private String modifierString;
	private String typeName;

	private List<String> parameterTypeNames;
	private List<Parameter> parameters;
	private List<Type> parameterTypes;
	private int modifier;
	private boolean isConstructor;
	private Type returnType;

	public MethodModel(String name) {
		this.name = name;
	}
	
	public MethodModel(Method method) {
		this.name = method.getName();
		this.parameters = Arrays.asList(method.getParameters());
		this.parameterTypes = Arrays.asList(method.getGenericParameterTypes());
		this.modifier = method.getModifiers();
		this.modifierString = ModifierUtils.resolveModifier(modifier);
		this.isConstructor = false;
		this.returnType = method.getGenericReturnType();
		this.typeName = returnType.getTypeName();
		this.parameterTypeNames = parameterTypes.stream().map(type -> type.getTypeName()).collect(Collectors.toList());
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

	public String getTypeName() {
		return typeName;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public List<String> getParameterTypeNames() {
		return parameterTypeNames;
	}
	
	public void setParameterTypeNames(List<String> parameterTypeNames) {
		this.parameterTypeNames = parameterTypeNames;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setModifierString(String modifierString) {
		this.modifierString = modifierString;
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
