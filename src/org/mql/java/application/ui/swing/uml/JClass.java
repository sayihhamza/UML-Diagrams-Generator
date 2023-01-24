package org.mql.java.application.ui.swing.uml;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;

import org.mql.java.application.models.primary.ClassModel;
import org.mql.java.application.models.primary.EnumModel;
import org.mql.java.application.models.primary.InterfaceModel;
import org.mql.java.application.models.secondary.ConstantModel;
import org.mql.java.application.models.secondary.FieldModel;
import org.mql.java.application.models.secondary.MethodModel;
import org.mql.java.application.ui.swing.BoxPanel;
import org.mql.java.application.ui.swing.Label;

public class JClass extends BoxPanel implements Draggable {
	private static final long serialVersionUID = 1L;

	private Color color;

	private ClassModel classModel;

	private TitlePanel titlePanel;
	private SectionPanel attributesPanel;
	private SectionPanel operationsPanel;

	private int eX, eY;

	public JClass(ClassModel classModel) {
		this(classModel, Color.BLACK);

		drawTitlePanel();

		if (classModel instanceof EnumModel) {
			drawConstantsPanel();
		} else {
			drawAttributesPanel();
			drawOperationsPanel();
		}

		if (classModel instanceof InterfaceModel) {
			setBackground(new Color(251, 235, 255));
		} else if (classModel instanceof EnumModel) {
			setBackground(new Color(255, 255, 195));
		} else {
			setBackground(Color.white);
		}

		setSize(getPreferredSize());
	}

	private class CustomMouseListener implements MouseListener {

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {
			eX = e.getX();
			eY = e.getY();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			setCursor(new Cursor(Cursor.MOVE_CURSOR));
		}

		@Override
		public void mouseClicked(MouseEvent e) {

		}
	}

	private class CustomMouseMotionListener implements MouseMotionListener {
		@Override
		public void mouseMoved(MouseEvent e) {
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			move(e);
		}
	}

	public JClass(ClassModel classifier, Color color) {
		this.classModel = classifier;
		this.color = color;

		addMouseListener(new CustomMouseListener());
		addMouseMotionListener(new CustomMouseMotionListener());
	}

	private void drawTitlePanel() {
		titlePanel = new TitlePanel();
		add(titlePanel);
	}

	private void drawAttributesPanel() {
		attributesPanel = new SectionPanel();

		for (FieldModel umlMember : classModel.getFields()) {
			if (!umlMember.getName().contains("$"))
				attributesPanel.add(new JField(umlMember));
		}

		add(attributesPanel);
	}

	private void drawOperationsPanel() {
		operationsPanel = new SectionPanel();

		for (MethodModel umlMember : classModel.getMethods()) {
			operationsPanel.add(new JMethod(umlMember));
		}

		add(operationsPanel);
	}

	private void drawConstantsPanel() {
		attributesPanel = new SectionPanel();

		for (ConstantModel umlMember : ((EnumModel) classModel).getConstants()) {
			attributesPanel.add(new JConstant(umlMember));
		}

		add(attributesPanel);
	}

	private class TitlePanel extends BoxPanel {
		private static final long serialVersionUID = 1L;

		public TitlePanel() {
			setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, color));

			if (classModel instanceof InterfaceModel) {
				add(new Label("<<interface>>"));
			} else if (classModel instanceof EnumModel) {
				Label titleLabel = new Label("<<enum>>");
				add(titleLabel);
			}

			add(new Label(classModel.getName().replace("..", "::")));

			setOpaque(false);
		}
	}

	private class SectionPanel extends BoxPanel {
		private static final long serialVersionUID = 1L;

		public SectionPanel() {
			setBorder(1);
			setBorderTop(0);
			setOpaque(false);
		}
	}

	public ClassModel getClassifier() {
		return classModel;
	}

	@Override
	public void move(MouseEvent e) {
		setLocation((getX() + e.getX() - eX), (getY() + e.getY() - eY));

		// TODO : notify associated relations
	}
}
