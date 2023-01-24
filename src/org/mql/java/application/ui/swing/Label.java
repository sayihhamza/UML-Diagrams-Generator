package org.mql.java.application.ui.swing;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Label extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel label;

	public Label() {
		this("");
	}

	public Label(String title) {
		setOpaque(false);
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		label = new JLabel(title);
		add(label);
	}

	public void addText(String text) {
		label.setText(label.getText() + text);
	}

	public String getText() {
		return label.getText();
	}
}
