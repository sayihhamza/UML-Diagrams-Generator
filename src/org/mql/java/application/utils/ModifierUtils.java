package org.mql.java.application.utils;

import java.lang.reflect.Modifier;

public class ModifierUtils {

	public static String resolveModifier(int mod) {
		if (Modifier.isPrivate(mod)) {
			return "-";
		} else if (Modifier.isPublic(mod)) {
			return "+";
		} else if (Modifier.isProtected(mod)) {
			return "#";
		} else {
			return "~";
		}
	}

}
