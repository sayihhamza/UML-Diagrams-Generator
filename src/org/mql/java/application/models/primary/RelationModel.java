package org.mql.java.application.models.primary;

import org.mql.java.application.models.Model;
import org.mql.java.application.models.secondary.FieldModel;
import org.mql.java.application.types.RelationType;

public class RelationModel implements Model {

	private RelationType relationType;
	private String name;

	private ClassModel relationParent;
	private ClassModel relationChild;

	private String relationParentName;
	private String relationChildName;

	private FieldModel relationField;

	public RelationModel(String name) {
		this.name = name;
	}

	public RelationModel(RelationType realtionType) {
		this.relationType = realtionType;
		this.name = relationType.name();
	}

	public String getName() {
		return this.name;
	}

	public RelationType getRelationType() {
		return relationType;
	}

	public ClassModel getRelationParent() {
		return relationParent;
	}

	public void setRelationParent(ClassModel relationParent) {
		this.relationParent = relationParent;
	}

	public ClassModel getRelationChild() {
		return relationChild;
	}

	public void setRelationChild(ClassModel relationChild) {
		this.relationChild = relationChild;
	}

	public FieldModel getRelationField() {
		return relationField;
	}

	public void setRelationField(FieldModel relationField) {
		this.relationField = relationField;
	}

	public String getRelationParentName() {
		return relationParentName;
	}

	public void setRelationParentName(String relationParentName) {
		this.relationParentName = relationParentName;
	}

	public String getRelationChildName() {
		return relationChildName;
	}

	public void setRelationChildName(String relationChildName) {
		this.relationChildName = relationChildName;
	}

}
