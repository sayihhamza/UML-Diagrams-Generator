package org.mql.java.application.ui.swing.uml;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.mql.java.application.models.primary.ClassModel;
import org.mql.java.application.models.primary.PackageModel;
import org.mql.java.application.ui.swing.BoxPanel;
import org.mql.java.application.ui.swing.Label;
import org.mql.java.application.ui.swing.WrapLayout;
import org.mql.java.application.utils.StringUtils;

public class JPackage extends BoxPanel implements Draggable {
	private static final long serialVersionUID = 1L;

	private PackageModel packageModel;
	private List<JClass> jClasses;

	private JPanel namePanel;
	private JPanel classesPanel;

	public JPanel getClassifiersPanel() {
		return classesPanel;
	}

	public void setClassifiersPanel(JPanel classifiersPanel) {
		this.classesPanel = classifiersPanel;
	}

	private int eX, eY;

	private class CustomMouseListener implements MouseListener {

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

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
			// TODO Auto-generated method stub

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

	public JPackage(PackageModel umlPackage) {
		this.packageModel = umlPackage;
		jClasses = new Vector<>();

		setOpaque(false);
		drawClassifiers(15);
		drawTitle(5);

		setSize(getPreferredSize());

		addMouseListener(new CustomMouseListener());
		addMouseMotionListener(new CustomMouseMotionListener());
	}

	private void drawClassifiers(int padding) {
		classesPanel = new JPanel(null);

		classesPanel.setLayout(new WrapLayout(FlowLayout.LEFT, padding, padding));
		classesPanel.setBorder(new LineBorder(Color.black, 1));
		classesPanel.setBackground(Color.white);

		for (ClassModel classifier : packageModel.getClasses()) {
			JClass jumlClassifier = new JClass(classifier);
//			jumlClassifier.setLocation(10, 10);
			classesPanel.add(jumlClassifier);

			jClasses.add(jumlClassifier);
		}

		classesPanel.setSize(600, 200);
	}

	private void drawTitle(int padding) {
		namePanel = new JPanel();
		namePanel.setOpaque(false);
		namePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		Label titleLabel = new Label(StringUtils.toPackageName(packageModel.getName()));

		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.CENTER, getClassifiersPanel().getPreferredSize().width / 2, padding));
		p.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.black));
		p.setBackground(Color.white);
		p.add(titleLabel);

		namePanel.add(p);

		add(namePanel);
		add(classesPanel);
	}

	public List<JClass> getJumlClassifiers() {
		return jClasses;
	}

	@Override
	public void move(MouseEvent e) {
		setLocation(getX() + e.getX() - eX, getY() + e.getY() - eY);
	}

}
