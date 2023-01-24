package org.mql.java.application.ui.swing.uml;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import org.mql.java.application.models.secondary.FieldModel;
import org.mql.java.application.ui.swing.Label;
import org.mql.java.application.utils.StringUtils;

public class JField extends JPanel{
	private static final long serialVersionUID = 1L;

	protected FieldModel umlCharacteristic;

	protected Label signatureLabel;
	public JField(FieldModel fieldModel) {
		this.umlCharacteristic = fieldModel;
		setOpaque(false);
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		signatureLabel = new Label();
		FieldModel property = umlCharacteristic;
		
		signatureLabel.addText(property.getModifierString());
		signatureLabel.addText(StringUtils.toSimpleName(property.getName()));
		signatureLabel.addText(": " + StringUtils.toSimpleName(property.getGenericType().getTypeName()));
		add(signatureLabel);
	}
}
