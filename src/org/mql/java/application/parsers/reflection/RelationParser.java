package org.mql.java.application.parsers.reflection;

import org.mql.java.application.models.primary.ClassModel;
import org.mql.java.application.models.primary.RelationModel;
import org.mql.java.application.models.secondary.FieldModel;
import org.mql.java.application.types.RelationType;
import org.mql.java.application.utils.ReflectionUtils;

public class RelationParser {

	private ClassModel firstClass;
	private ClassModel secondClass;

	private RelationModel relationModel;

	public RelationParser(ClassModel firstClass, ClassModel secondClass) {
		this.firstClass = firstClass;
		this.secondClass = secondClass;
		this.relationModel = null;
	}

	public void setRelationModel(RelationModel relationModel) {
		this.relationModel = relationModel;
	}

	public RelationModel getRelationModel() {
		return relationModel;
	}

	public RelationModel parse() {
		if (!firstClass.equals(secondClass)) {
			parseDependency();
			parseAssociation();
			parseAggregation();
			parseCompostion();
			parseRealisation();
			parseGeneralization();
			return relationModel;
		}
		return null;
	}

	public void parseDependency() {
		if (ReflectionUtils.isClassInMethodParameterOf(firstClass, secondClass.getMethods())) {
			RelationModel dependencyRelation = new RelationModel(RelationType.DEPENDENCY);
			dependencyRelation.setRelationChild(firstClass);
			dependencyRelation.setRelationParent(secondClass);
			setRelationModel(dependencyRelation);
		}
	}

	public void parseAssociation() {
		FieldModel associationField = null;
		if ((associationField = ReflectionUtils.checkIfClassTypeInFieldsOf(firstClass,
				secondClass.getFields())) != null) {
			RelationModel associationRelation = new RelationModel(RelationType.ASSOCIATION);
			associationRelation.setRelationChild(firstClass);
			associationRelation.setRelationParent(secondClass);
			associationRelation.setRelationField(associationField);
			setRelationModel(associationRelation);
		}
	}

	public void parseAggregation() {
		if (ReflectionUtils.isClassInMethodParameterOf(firstClass, secondClass.getConstructors())) {
			RelationModel aggregationRelation = new RelationModel(RelationType.AGGREGATION);
			aggregationRelation.setRelationChild(firstClass);
			aggregationRelation.setRelationParent(secondClass);
			aggregationRelation.setRelationField(getRelationModel().getRelationField());
			setRelationModel(aggregationRelation);
		}
	}

	public void parseCompostion() {
		if (ReflectionUtils.isRelationCompositeOf(firstClass, secondClass, getRelationModel())) {
			RelationModel compositionRelation = new RelationModel(RelationType.COMPOSITION);
			compositionRelation.setRelationChild(firstClass);
			compositionRelation.setRelationParent(secondClass);
			if (getRelationModel() != null)
				compositionRelation.setRelationField(getRelationModel().getRelationField());
			setRelationModel(compositionRelation);
		}
	}

	public void parseRealisation() {
		if (ReflectionUtils.isClassImplements(firstClass, secondClass)) {
			RelationModel realizationRelation = new RelationModel(RelationType.REALISATION);
			realizationRelation.setRelationChild(firstClass);
			realizationRelation.setRelationParent(secondClass);
			setRelationModel(realizationRelation);
		}
	}

	public void parseGeneralization() {
		if (ReflectionUtils.isClassExtends(firstClass, secondClass)) {
			RelationModel generalizationRelation = new RelationModel(RelationType.GENERALIZATION);
			generalizationRelation.setRelationChild(firstClass);
			generalizationRelation.setRelationParent(secondClass);
			setRelationModel(generalizationRelation);
		}
	}
}