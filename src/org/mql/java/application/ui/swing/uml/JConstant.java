package org.mql.java.application.ui.swing.uml;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import org.mql.java.application.models.secondary.ConstantModel;
import org.mql.java.application.ui.swing.Label;

public class JConstant extends JPanel{

	private static final long serialVersionUID = 1L;

	protected ConstantModel umlCharacteristic;

	protected Label signatureLabel;
	
	public JConstant(ConstantModel constantModel) {
		this.umlCharacteristic = constantModel;

		setOpaque(false);
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		signatureLabel = new Label();
		signatureLabel.addText(umlCharacteristic.getName());
		add(signatureLabel);

	}

}
