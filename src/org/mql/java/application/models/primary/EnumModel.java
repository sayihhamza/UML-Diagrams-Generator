package org.mql.java.application.models.primary;

import java.util.List;

import org.mql.java.application.models.secondary.ConstantModel;

public class EnumModel extends ClassModel {

	private List<ConstantModel> constants;
	
	public EnumModel(String name, List<ConstantModel> constants) {
		super(name,null,null);
		this.constants = constants;
	}

	public List<ConstantModel> getConstants() {
		return constants;
	}

	@Override
	public String toString() {
		return "EnumModel [constants=" + constants + "]";
	}
	
}
