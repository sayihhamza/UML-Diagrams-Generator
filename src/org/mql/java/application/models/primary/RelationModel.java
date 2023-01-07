package org.mql.java.application.models.primary;

import org.mql.java.application.models.Model;
import org.mql.java.application.types.RelationType;

public class RelationModel implements Model {

	private final String name;
	private final RelationType realtionType;

	private ClassModel relationParent;
	private ClassModel realtionChild;

	public RelationModel(RelationType realtionType) {
		this.realtionType = realtionType;
		name = realtionType.toString();
	}

	public String getName() {
		return name;
	}

	public RelationType getRealtionType() {
		return realtionType;
	}

	public ClassModel getRelationParent() {
		return relationParent;
	}

	public void setRelationParent(ClassModel relationParent) {
		this.relationParent = relationParent;
	}

	public ClassModel getRealtionChild() {
		return realtionChild;
	}

	public void setRealtionChild(ClassModel realtionChild) {
		this.realtionChild = realtionChild;
	}
}
