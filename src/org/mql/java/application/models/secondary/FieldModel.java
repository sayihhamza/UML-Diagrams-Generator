package org.mql.java.application.models.secondary;

import java.lang.reflect.Type;

public class FieldModel {

	private String name;
	private int modifier;
	private String initialValue;
	private boolean isClassModelType;
	private Type type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getModifier() {
		return modifier;
	}

	public void setModifier(int modifier) {
		this.modifier = modifier;
	}

	public String getInitialValue() {
		return initialValue;
	}

	public void setInitialValue(String initialValue) {
		this.initialValue = initialValue;
	}

	public boolean isClassModelType() {
		return isClassModelType;
	}

	public void setClassModelType(boolean isClassModelType) {
		this.isClassModelType = isClassModelType;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
