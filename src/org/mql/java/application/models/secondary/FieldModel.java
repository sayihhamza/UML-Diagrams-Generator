package org.mql.java.application.models.secondary;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import org.mql.java.application.models.Model;

public class FieldModel implements Model {

	private final String name;

	private final int modifier;
	private final Type type;

	public FieldModel(Field field) {
		name = field.getName();
		modifier = field.getModifiers();
		type = field.getType();
	}

	public String getName() {
		return name;
	}

	public int getModifier() {
		return modifier;
	}

	public Type getType() {
		return type;
	}
}
