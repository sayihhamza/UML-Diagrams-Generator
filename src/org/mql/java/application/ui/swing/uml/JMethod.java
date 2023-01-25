package org.mql.java.application.ui.swing.uml;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import org.mql.java.application.models.secondary.MethodModel;
import org.mql.java.application.ui.swing.Label;
import org.mql.java.application.utils.StringUtils;

public class JMethod extends JPanel {

	private static final long serialVersionUID = 1L;

	protected MethodModel methodModel;

	protected Label signatureLabel;

	public JMethod(MethodModel methodModel) {
		this.methodModel = methodModel;
		setOpaque(false);
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		signatureLabel = new Label();
		MethodModel operation = methodModel;
		signatureLabel.addText((operation).getModifierString());
		signatureLabel.addText(StringUtils.toSimpleName(operation.getName()));
		signatureLabel.addText("(");

		for (int i = 0; i < operation.getParameters().size(); i++) {
			signatureLabel.addText(StringUtils.toSimpleName(operation.getParameters().get(i).getType().getTypeName()));
			if (i < operation.getParameters().size() - 1) {
				signatureLabel.addText(", ");
			}
		}
		signatureLabel.addText(")");
		signatureLabel.addText(": " + ((operation.getReturnType() != null
				? StringUtils.toSimpleName(operation.getReturnType().getTypeName())
				: "void")));
		add(signatureLabel);

	}
}
