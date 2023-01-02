package org.mql.java.application.models.primary;

import java.util.List;

import org.mql.java.application.models.secondary.ConstantModel;
import org.mql.java.application.models.secondary.FieldModel;
import org.mql.java.application.models.secondary.MethodModel;
import org.mql.java.application.models.secondary.ValueModel;

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
	
	public ClassModel(String name, List<FieldModel> fields,List<MethodModel> classMethods) {
		this.name = name;
		this.fields = fields;
		this.classMethods = classMethods;
	}
	
	
	
	
}
