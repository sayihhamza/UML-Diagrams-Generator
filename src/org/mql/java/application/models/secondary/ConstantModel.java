package org.mql.java.application.models.secondary;

import org.mql.java.application.models.Model;

public class ConstantModel implements Model {

	private final Object name;

	public ConstantModel(Object constant) {
		this.name = constant;
	}

	public Object getName() {
		return name;
	}
}
