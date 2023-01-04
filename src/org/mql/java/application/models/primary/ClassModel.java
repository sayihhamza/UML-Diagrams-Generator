package org.mql.java.application.models.primary;

import java.util.List;

import org.mql.java.application.models.secondary.FieldModel;
import org.mql.java.application.models.secondary.MethodModel;

public class ClassModel {

	private final String name;

	private List<FieldModel> fields;
	private List<MethodModel> methods;

	public ClassModel(String name, List<FieldModel> fields, List<MethodModel> methods) {
		this.name = name;
		this.fields = fields;
		this.methods = methods;
	}

	public String getName() {
		return name;
	}

	public List<FieldModel> getFields() {
		return fields;
	}

	public List<MethodModel> getClassMethods() {
		return methods;
	}

	@Override
	public String toString() {
		return "ClassModel [name=" + name + ", classFields=" + fields + ", classMethods=" + methods + "]";
	}
}
