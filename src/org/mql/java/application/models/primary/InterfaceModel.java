package org.mql.java.application.models.primary;

import java.util.List;

import org.mql.java.application.models.secondary.FieldModel;
import org.mql.java.application.models.secondary.MethodModel;

public class InterfaceModel extends ClassModel {

	public InterfaceModel(String name, List<FieldModel> fields, List<MethodModel> methods) {
		super(name,fields,methods);
	}

}
