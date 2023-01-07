package org.mql.java.application.models.primary;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Vector;

import org.mql.java.application.models.Model;
import org.mql.java.application.models.secondary.FieldModel;
import org.mql.java.application.models.secondary.MethodModel;

public class ClassModel implements Model {

	private final String name;

	private List<FieldModel> fields;
	private List<MethodModel> methods;

	public ClassModel(String name) {
		this.name = name;
		this.fields = new Vector<>();
		this.methods = new Vector<>();
	}

	public String getName() {
		return name;
	}

	public List<FieldModel> getFields() {
		return fields;
	}

	public void setFields(List<FieldModel> fields) {
		this.fields = fields;
	}

	public List<MethodModel> getMethods() {
		return methods;
	}

	public void setMethods(List<MethodModel> methods) {
		this.methods = methods;
	}

	public List<MethodModel> getConstructors() {
		List<MethodModel> constructors = new Vector<>();
		for (MethodModel method : methods)
			if (method.isConstructor())
				constructors.add(method);
		return constructors;
	}

	public void addConstructor(Constructor<?> constructor) {
		if (this.getClass() != EnumModel.class && this.getClass() != InterfaceModel.class)
			methods.add(new MethodModel(constructor));
	}
}
