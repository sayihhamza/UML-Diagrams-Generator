package org.mql.java.application.types;

public enum ModifierTypes {
	PRIVATE(2, "-"), PRIVATE_STATIC(10, "- {static}"), PRIVATE_FINAL_STATIC(26, ""),

	PROTECTED(4, "#"), PROTECTED_STATIC(12, "{static}"), PROTECTED_ABSTRACT(1028, "# {abstract}"),
	PROTECTED_FINAL_STATIC(28, ""),

	PUBLIC(1, "+"), PUBLIC_STATIC(9, "+ {static}"), PUBLIC_ABSTRACT(1025, "+ {abstract}"), PUBLIC_FINAL_STATIC(25, ""),

	PACKAGE(0, "~"), PACKAGE_STATIC(8, "~ {static}"), PACKAGE_ABSTRACT(1024, "~ {abstract}"),
	PACKAGE_FINAL_STATIC(24, "");

	public int modifier;
	public String symbol;

	private ModifierTypes(int modifier, String symbol) {
		this.modifier = modifier;
		this.symbol = symbol;
	}

	public static String valueOf(int modifier) {
		for (ModifierTypes mod : ModifierTypes.values()) {
			if (mod.modifier == modifier) {
				return mod.symbol;
			}
		}
		return "";
	}
}
