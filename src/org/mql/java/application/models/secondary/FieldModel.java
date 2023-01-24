package org.mql.java.application.models.secondary;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import org.mql.java.application.models.Model;
import org.mql.java.application.utils.ModifierUtils;

public class FieldModel implements Model {

	private String name;

	private int modifier;
	private String modifierString;
	private String typeName;

	private Type type;
	private Type genericType;

	public FieldModel(String name) {
		this.name = name;
	}

	public FieldModel(Field field) {
		this.name = field.getName();
		this.modifier = field.getModifiers();
		this.modifierString = ModifierUtils.resolveModifier(modifier);
		this.type = field.getType();
		this.genericType = field.getGenericType();
		this.typeName = genericType.getTypeName();
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

	public void setName(String name) {
		this.name = name;
	}

	public void setModifierString(String modifierString) {
		this.modifierString = modifierString;
	}

	public String getModifierString() {
		return modifierString;
	}

	public Type getType() {
		return type;
	}

	public int getModifier() {
		return modifier;
	}

	public Type getGenericType() {
		return genericType;
	}
}
