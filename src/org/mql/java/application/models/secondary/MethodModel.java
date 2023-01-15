package org.mql.java.application.models.secondary;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import org.mql.java.application.models.Model;
import org.mql.java.application.types.ModifierTypes;

public class MethodModel implements Model {

	private final String name;
	
	private final List<Parameter> parameters;
	private final int modifier;
	private final String modifierString;
	private final boolean isConstructor;
	private final Type returnType;

	public MethodModel(Method method) {
		this.name = method.getName();
		this.parameters = Arrays.asList(method.getParameters());
		this.modifier = method.getModifiers();
		this.modifierString = ModifierTypes.valueOf(method.getModifiers());
		this.isConstructor = false;
		this.returnType= method.getReturnType();
	}
	
	public MethodModel(Constructor<?> constructor) {
		this.name = constructor.getName();
		this.parameters = Arrays.asList(constructor.getParameters());
		this.modifier = constructor.getModifiers();
		this.modifierString =  ModifierTypes.valueOf(constructor.getModifiers());
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

	@Override
	public String toString() {
		return "MethodModel [name=" + name + ", parameters=" + parameters + ", modifier=" + modifier
				+ ", modifierString=" + modifierString + ", isConstructor=" + isConstructor + ", returnType="
				+ returnType + "]";
	}
}
