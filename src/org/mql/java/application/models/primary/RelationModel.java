package org.mql.java.application.models.primary;

import org.mql.java.application.models.Model;
import org.mql.java.application.models.secondary.FieldModel;
import org.mql.java.application.types.RelationType;

public class RelationModel implements Model {

	private final RelationType relationType;

	private ClassModel relationParent;
	private ClassModel relationChild;
	
	private FieldModel relationField;

	public RelationModel(RelationType realtionType) {
		this.relationType = realtionType;
	}

	public String getName() {
		return relationType.name();
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
}
