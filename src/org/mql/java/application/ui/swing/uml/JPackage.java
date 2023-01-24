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

	private PackageModel umlPackage;
	private List<JClass> jumlClassifiers;

	private JPanel titlePanel;
	private JPanel classifiersPanel;

	public JPanel getClassifiersPanel() {
		return classifiersPanel;
	}

	public void setClassifiersPanel(JPanel classifiersPanel) {
		this.classifiersPanel = classifiersPanel;
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
		this.umlPackage = umlPackage;
		jumlClassifiers = new Vector<>();

		setOpaque(false);
		drawClassifiers(15);
		drawTitle(5);

		setSize(getPreferredSize());

		addMouseListener(new CustomMouseListener());
		addMouseMotionListener(new CustomMouseMotionListener());
	}

	private void drawClassifiers(int padding) {
		classifiersPanel = new JPanel(null);

		classifiersPanel.setLayout(new WrapLayout(FlowLayout.LEFT, padding, padding));
		classifiersPanel.setBorder(new LineBorder(Color.black, 1));
		classifiersPanel.setBackground(Color.white);

		for (ClassModel classifier : umlPackage.getClasses()) {
			JClass jumlClassifier = new JClass(classifier);
//			jumlClassifier.setLocation(10, 10);
			classifiersPanel.add(jumlClassifier);

			jumlClassifiers.add(jumlClassifier);
		}

		classifiersPanel.setSize(600, 200);
	}

	private void drawTitle(int padding) {
		titlePanel = new JPanel();
		titlePanel.setOpaque(false);
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		Label titleLabel = new Label(StringUtils.toPackageName(umlPackage.getName()));

		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.CENTER, getClassifiersPanel().getPreferredSize().width / 2, padding));
		p.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.black));
		p.setBackground(Color.white);
		p.add(titleLabel);

		titlePanel.add(p);

		add(titlePanel);
		add(classifiersPanel);
	}

	public List<JClass> getJumlClassifiers() {
		return jumlClassifiers;
	}

	@Override
	public void move(MouseEvent e) {
		setLocation(getX() + e.getX() - eX, getY() + e.getY() - eY);
	}

}
