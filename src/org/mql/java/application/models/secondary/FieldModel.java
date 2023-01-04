package org.mql.java.application.models.secondary;

import java.lang.reflect.Type;

public class FieldModel {

	private String name;
	private int modifier;
	private boolean isClassModelType;
	private Type type;

	public FieldModel(String name, int modifier, boolean isClassModelType, Type type) {
		this.name = name;
		this.modifier = modifier;
		this.isClassModelType = isClassModelType;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public int getModifier() {
		return modifier;
	}

	public boolean isClassModelType() {
		return isClassModelType;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "FieldModel [name=" + name + ", modifier=" + modifier + ", isClassModelType=" + isClassModelType
				+ ", type=" + type + "]";
	}
}
