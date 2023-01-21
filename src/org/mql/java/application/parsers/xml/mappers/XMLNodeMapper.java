package org.mql.java.application.parsers.xml.mappers;

import java.lang.reflect.Type;

import org.mql.java.application.models.primary.ClassModel;
import org.mql.java.application.models.primary.EnumModel;
import org.mql.java.application.models.primary.InterfaceModel;
import org.mql.java.application.models.primary.PackageModel;
import org.mql.java.application.models.primary.ProjectModel;
import org.mql.java.application.models.primary.RelationModel;
import org.mql.java.application.models.secondary.ConstantModel;
import org.mql.java.application.models.secondary.FieldModel;
import org.mql.java.application.models.secondary.MethodModel;
import org.mql.java.application.parsers.xml.XMLNode;

public class XMLNodeMapper implements Mapper {

	@Override
	public XMLNode objectToXMLNode(Object obj) {
		XMLNode node = null;
		if (obj != null) {
			if (obj instanceof ProjectModel) {
				ProjectModel actualObj = (ProjectModel) obj;
				node = new XMLNode("project", 1);
				node.setAttribute("name", actualObj.getName());

				if (actualObj.getPackages().size() > 0) {
					XMLNode packagesNode = new XMLNode("packages", 1);
					XMLNode packageNode;
					for (PackageModel aPackage : actualObj.getPackages()) {
						packageNode = objectToXMLNode(aPackage);
						packagesNode.appendChild(packageNode);
					}
					node.appendChild(packagesNode);
				}

				if (actualObj.getClassRelations().size() > 0) {
					XMLNode relationsNode = new XMLNode("relations", 1);
					XMLNode relationNode;
					for (RelationModel aRelation : actualObj.getClassRelations()) {
						relationNode = new XMLNode("relation", 1);
						relationNode.setAttribute("type", aRelation.getName());
						relationNode.setAttribute("parent", aRelation.getRelationParent().getName());
						relationNode.setAttribute("child", aRelation.getRelationChild().getName());
						relationsNode.appendChild(relationNode);
					}
					node.appendChild(relationsNode);
				}

				return node;
			} else if (obj instanceof PackageModel) {
				PackageModel actualObj = (PackageModel) obj;
				node = new XMLNode("package", 1);
				node.setAttribute("name", actualObj.getName());
				XMLNode classesNode = new XMLNode("classes", 1);
				XMLNode classNode;
				for (ClassModel aClass : actualObj.getClasses()) {
					classNode = objectToXMLNode(aClass);
					classesNode.appendChild(classNode);
				}
				node.appendChild(classesNode);
				return node;
			} else if (obj instanceof ClassModel) {
				ClassModel actualObj = (ClassModel) obj;

				if (actualObj instanceof EnumModel) {
					node = new XMLNode("enumeration", 1);
					XMLNode constantsNode = new XMLNode("constants", 1);
					XMLNode constantNode;
					for (ConstantModel aConsant : ((EnumModel) actualObj).getConstants()) {
						constantNode = new XMLNode("constant", 1);
						constantNode.setAttribute("value", aConsant.getName());
						constantsNode.appendChild(constantNode);
					}
					node.appendChild(constantsNode);

				} else {
					if (actualObj instanceof InterfaceModel) {
						node = new XMLNode("interface", 1);
					} else {
						node = new XMLNode("class", 1);
					}

					if (actualObj.getFields().size() > 1
							|| (!actualObj.getName().contains("$") && actualObj.getFields().size() > 0)) {
						XMLNode fieldsNode = new XMLNode("fields", 1);
						XMLNode fieldNode;
						for (FieldModel aField : actualObj.getFields()) {
							if (!aField.getName().contains("this$")) {
								fieldNode = new XMLNode("field", 1);
								fieldNode.setAttribute("name", aField.getName());
								fieldNode.setAttribute("type", aField.getGenericType().getTypeName());
								fieldNode.setAttribute("visibility", aField.getModifierString());
								fieldsNode.appendChild(fieldNode);
							}
						}
						node.appendChild(fieldsNode);
					}

					if (actualObj.getMethods().size() > 0) {
						XMLNode methodsNode = new XMLNode("methods", 1);
						XMLNode methodNode;
						for (MethodModel aMethod : actualObj.getMethods()) {
							methodNode = new XMLNode("method", 1);
							methodNode.setAttribute("name", aMethod.getName());
							methodNode.setAttribute("visibility", aMethod.getModifierString());

							if (aMethod.getReturnType() != null) {
								methodNode.setAttribute("returnType", aMethod.getReturnType().getTypeName());
							} else if (aMethod.isConstructor()) {
								methodNode.setAttribute("returnType", "");
							} else {
								methodNode.setAttribute("returnType", "void");
							}

							if (aMethod.getParameterTypes().size() > 0) {
								XMLNode parameterTypes = new XMLNode("parameterTypes", 1);
								XMLNode parameterType;
								for (Type aType : aMethod.getParameterTypes()) {
									parameterType = new XMLNode("parameterType", 1);
									parameterType.setAttribute("type", aType.getTypeName());
									parameterTypes.appendChild(parameterType);
								}
								methodNode.appendChild(parameterTypes);
							}

							methodsNode.appendChild(methodNode);
						}
						node.appendChild(methodsNode);
					}
				}
				node.setAttribute("name", actualObj.getName());
				return node;
			}
		}
		return node;
	}
}
