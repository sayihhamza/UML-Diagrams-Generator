package org.mql.java.application.models.secondary;

public class ConstantModel {

	private Object constantValue;

	public ConstantModel(Object constantValue) {
		this.constantValue = constantValue;
	}

	public Object getConstantValue() {
		return constantValue;
	}

	@Override
	public String toString() {
		return "ConstantModel [constantValue=" + constantValue + "]";
	}
}
