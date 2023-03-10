package org.mql.java.application.ui.swing.uml;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.mql.java.application.models.primary.RelationModel;

public class JRelation extends JPanel implements Draggable {
	private static final long serialVersionUID = 1L;
	
	private RelationModel relationModel;
	private JProject jProject;
	
	private Point p1, p2;
	
	public JRelation(RelationModel umlRelation, JProject jProject) {
		this.relationModel = umlRelation;
		this.jProject = jProject;
		
		// setOpaque(false);
		// setBackground(Color.red);
		setSize(500, 500);
		drawRelation();
	}
	
	private void drawRelation() {
		JClass childJumlClassifier = jProject.getJumlClassifier(relationModel.getRelationChild());
		JClass parentJumlClassifier = jProject.getJumlClassifier(relationModel.getRelationParent());
				
		p1 = new Point(childJumlClassifier.getX(), childJumlClassifier.getY());
		p2 = new Point(parentJumlClassifier.getX(), parentJumlClassifier.getY());
		
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		

		g.setColor(Color.black);
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
	}

	@Override
	public void move(MouseEvent e) {
		
	}

}
