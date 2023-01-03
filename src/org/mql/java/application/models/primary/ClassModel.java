package org.mql.java.application.models.primary;

import java.util.List;

import org.mql.java.application.models.secondary.ConstantModel;
import org.mql.java.application.models.secondary.FieldModel;
import org.mql.java.application.models.secondary.MethodModel;
import org.mql.java.application.models.secondary.ValueModel;
import org.mql.java.application.types.ClassType;

public class ClassModel {

	private final String name;

	private List<FieldModel> fields;
	private List<MethodModel> classMethods;

	private boolean isInterface;
	private List<MethodModel> interfaceMethods;

	private boolean isAnnotation;
	private List<ValueModel> values;

	private boolean isEnum;
	private List<ConstantModel> constantss;

	public ClassModel(String name,List<FieldModel> fields,List<MethodModel> classMethods) {
		this.name = name;
		this.fields = fields;
		this.classMethods = classMethods;
	}
	
	@SuppressWarnings({ "unchecked", "incomplete-switch" })
	public ClassModel(String name, ClassType classType,List<?> items) {
		this.name = name;
		switch (classType) {
		case INTETFACE:
			this.isInterface = true;
			this.interfaceMethods = (List<MethodModel>) items;
			break;
		case ANNOTATION:
			this.isAnnotation = true;
			this.values = (List<ValueModel>) items;
			break;
		case ENUM:
			this.isEnum = true;
			this.constantss = (List<ConstantModel>) items;
			break;
		}
	}

	public String getName() {
		return name;
	}
	
	public List<FieldModel> getFields() {
		return fields;
	}


	public List<MethodModel> getClassMethods() {
		return classMethods;
	}

	public boolean isInterface() {
		return isInterface;
	}


	public List<MethodModel> getInterfaceMethods() {
		return interfaceMethods;
	}

	public boolean isAnnotation() {
		return isAnnotation;
	}
	
	public List<ValueModel> getValues() {
		return values;
	}

	public boolean isEnum() {
		return isEnum;
	}

	public List<ConstantModel> getConstantss() {
		return constantss;
	}
}
