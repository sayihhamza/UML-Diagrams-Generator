package org.mql.java.application.models.primary;

import org.mql.java.application.types.RelationType;

public class RelationModel {

	private RelationType realtionType;
	private ClassModel parentClass;
	private ClassModel childClass;
	private String parentCardinality;
	private String childCardinality;
	
	public RelationModel() {
		this.parentCardinality = null;
		this.childCardinality = null;
	}

	public RelationType getType() {
		return realtionType;
	}

	public void setType(RelationType type) {
		this.realtionType = type;
	}

	public ClassModel getParent() {
		return parentClass;
	}

	public void setParent(ClassModel parent) {
		this.parentClass = parent;
	}

	public ClassModel getChild() {
		return childClass;
	}

	public void setChild(ClassModel child) {
		this.childClass = child;
	}

	public String getParentCardinality() {
		return parentCardinality;
	}

	public void setParentCardinality(String parentCardinality) {
		this.parentCardinality = parentCardinality;
	}

	public String getChildCardinality() {
		return childCardinality;
	}

	public void setChildCardinality(String childCardinality) {
		this.childCardinality = childCardinality;
	}
}
