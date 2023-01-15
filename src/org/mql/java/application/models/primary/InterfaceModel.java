package org.mql.java.application.models.primary;

public class InterfaceModel extends ClassModel {

	public InterfaceModel(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "InterfaceModel [name=" + super.getName() + ", parentClass=" + super.getParentClass() + ", fields=" + super.getFields() + ", methods="
				+ super.getMethods() + ", interfaces=" + super.getInterfaces() + "]";
	}
}
