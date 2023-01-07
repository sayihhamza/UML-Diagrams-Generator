package org.mql.java.application.models.primary;

import java.util.List;
import java.util.Vector;

import org.mql.java.application.models.secondary.ConstantModel;

public class EnumModel extends ClassModel {

	private List<ConstantModel> constants;
	
	public EnumModel(String name) {
		super(name);
		constants = new Vector<>();
	}

	public List<ConstantModel> getConstants() {
		return constants;
	}

	public void setConstants(List<ConstantModel> constants) {
		this.constants = constants;
	}
}
