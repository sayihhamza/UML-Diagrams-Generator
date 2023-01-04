package org.mql.java.application.models.secondary;

import java.lang.reflect.Type;
import java.util.List;


public class MethodModel {

	private String name;
	private List<Type> parameterTypes;
	private int modifier;
	private boolean isConstructor;
	private Type type;

	public MethodModel(String name, List<Type> parameterTypes, int modifier, boolean isConstructor, Type type) {
		this.name = name;
		this.parameterTypes = parameterTypes;
		this.modifier = modifier;
		this.isConstructor = isConstructor;
		this.type = type;
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

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "MethodModel [name=" + name + ", parameterTypes=" + parameterTypes + ", modifier=" + modifier
				+ ", isConstructor=" + isConstructor + ", type=" + type + "]";
	}
	
}
