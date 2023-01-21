package org.mql.java.application.models.secondary;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import org.mql.java.application.models.Model;
import org.mql.java.application.utils.ModifierUtils;

public class FieldModel implements Model {

	private final String name;

	private final int modifier;
	private final String modifierString;
	private final Type type;
	private final Type genericType;

	public FieldModel(Field field) {
		this.name = field.getName();
		this.modifier = field.getModifiers();
		this.modifierString = ModifierUtils.resolveModifier(modifier);
		this.type = field.getType();
		this.genericType = field.getGenericType();
	}

	public String getName() {
		return name;
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
