package org.mql.java.application.utils;

import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

import org.mql.java.application.models.primary.ClassModel;
import org.mql.java.application.models.primary.PackageModel;
import org.mql.java.application.models.primary.RelationModel;
import org.mql.java.application.models.secondary.FieldModel;
import org.mql.java.application.models.secondary.MethodModel;
import org.mql.java.application.types.RelationType;

public class ReflectionUtils {

	public static List<MethodModel> filterConstructors(List<MethodModel> methods) {
		return methods.stream().filter(method -> method.isConstructor()).collect(Collectors.toList());
	}

	public static FieldModel checkIfClassTypeInFieldsOf(ClassModel firstClass, List<FieldModel> secondClassFields) {
		for (FieldModel fieldModel : secondClassFields) {
			boolean isFieldType = fieldModel.getType().getTypeName().equals(firstClass.getName());

			boolean isFieldGenericType = false;
			if (isIterable((Class<?>) fieldModel.getType())) {
				isFieldGenericType = getGenericType(fieldModel.getGenericType()).getName().equals(firstClass.getName());
			}
			if (isFieldType || isFieldGenericType) {
				return fieldModel;
			}
		}
		return null;
	}

	public static boolean isClassInMethodParameterOf(ClassModel firstClass, List<MethodModel> secondClassMethods) {
		for (MethodModel methodModel : secondClassMethods) {
			for (Parameter parameter : methodModel.getParameters()) {
				boolean isParameterType = parameter.getType().getName().equals(firstClass.getName());

				boolean isParameterGenericType = false;
				if (isIterable(parameter.getType())) {
					isParameterGenericType = getGenericType(parameter.getParameterizedType()).getName()
							.equals(firstClass.getName());
				}
				if (isParameterType || isParameterGenericType)
					return true;
			}
		}
		return false;
	}

	public static boolean isRelationCompositeOf(ClassModel firstClass, ClassModel secondClass,
			RelationModel relationModel) {
		boolean isInnerClass = isInnerClassOf(firstClass, secondClass);
		boolean isFinalField = false;
		if (relationModel != null) {
			if (relationModel.getRelationType() != null) {
				if (relationModel.getRelationType().equals(RelationType.AGGREGATION)) {
					if (!relationModel.getRelationField().getName().contains("this$")) {
						isFinalField = isFinal(relationModel.getRelationField());
					}
				}
			}
		}
		if (isInnerClass || isFinalField)
			return true;
		return false;
	}

	public static boolean isClassImplements(ClassModel firstClass, ClassModel secondClass) {
		if (firstClass.getInterfaces() != null) {
			for (ClassModel implementedInterface : firstClass.getInterfaces()) {
				if (implementedInterface.getName().equals(secondClass.getName())) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isClassExtends(ClassModel firstClass, ClassModel secondClass) {
		if (firstClass.getParentClass() != null) {
			if (secondClass.getName().equals(firstClass.getParentClass().getName()))
				return true;
		}
		return false;
	}

	public static boolean isInnerClassOf(ClassModel firstClass, ClassModel secondClass) {
		return StringUtils.toClassName(firstClass.getName()).contains(StringUtils.toClassName(secondClass.getName()));
	}

	public static boolean isFinal(FieldModel fieldModel) {
		return Modifier.isFinal(fieldModel.getModifier());
	}

	public static boolean isIterable(Class<?> inputClass) {
		return Iterable.class.isAssignableFrom(inputClass);
	}

	public static Class<?> getGenericType(Type inputType) {
		return ReflectionUtils.genericTypeCastableToClass(((ParameterizedType) inputType).getActualTypeArguments()[0]);
	}

	public static Class<?> genericTypeCastableToClass(Type type) {
		if (type instanceof Class<?>) {
			return (Class<?>) type;
		} else if (type instanceof ParameterizedType) {
			return genericTypeCastableToClass(((ParameterizedType) type).getActualTypeArguments()[0]);
		}
		return Class.class;
	}

	public static List<ClassModel> extractAllClasses(List<PackageModel> packages) {
		List<ClassModel> classModels = new Vector<>();
		for (PackageModel packageModel : packages) {
			classModels.addAll(packageModel.getClasses());
		}
		return classModels;
	}
}
