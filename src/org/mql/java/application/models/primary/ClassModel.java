package org.mql.java.application.models.primary;

import java.util.List;
import java.util.Vector;

import org.mql.java.application.models.Model;
import org.mql.java.application.models.secondary.FieldModel;
import org.mql.java.application.models.secondary.MethodModel;
import org.mql.java.application.utils.ReflectionUtils;

public class ClassModel implements Model {

	private final String name;

	private ClassModel parentClass;
	private List<FieldModel> fields;
	private List<MethodModel> methods;
	private List<ClassModel> interfaces;

	public ClassModel(String name) {
		this.name = name;
		this.parentClass = null;
		this.fields = new Vector<>();
		this.methods = new Vector<>();
		this.interfaces = new Vector<>();
	}

	public String getName() {
		return name;
	}

	public ClassModel getParentClass() {
		return parentClass;
	}
	
	public void setParentClass(ClassModel parentClass) {
		this.parentClass = parentClass;
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
		return ReflectionUtils.filterConstructors(methods);
	}

	public List<ClassModel> getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(List<ClassModel> interfaces) {
		this.interfaces = interfaces;
	}
}
