package org.mql.java.application.ui.swing.uml;
import java.util.List;
import java.util.Vector;


import javax.swing.JPanel;

import org.mql.java.application.models.Model;
import org.mql.java.application.models.primary.PackageModel;
import org.mql.java.application.models.primary.ProjectModel;
import org.mql.java.application.models.primary.RelationModel;

@SuppressWarnings("unused")
public class JProject extends JPanel {
	private static final long serialVersionUID = 1L;

	private ProjectModel projectModel;
	private List<JPackage> jPackages;
	private List<JRelation> jRelations;

	public JProject(ProjectModel projectModel) {
		this.projectModel = projectModel;
		jPackages = new Vector<>();
		jRelations = new Vector<>();
		drawPackages();
//		drawRelations();
	}

	public JClass getJumlClassifier(Model umlClassifier) {
		for (JPackage jumlPackage : jPackages) {
			for (JClass jumlClassifier : jumlPackage.getJumlClassifiers()) {
				if (jumlClassifier.getName() == umlClassifier.getName()) {
					return jumlClassifier;
				}
			}
		}
		return null;
	}
	
	private void drawPackages() {
		JPackage jumlPackage;
		for (PackageModel umlPackage : projectModel.getPackages()) {
			int x = 1, y = 1;

			jumlPackage = new JPackage(umlPackage);
			jumlPackage.setLocation(x, y);
			add(jumlPackage);

			jPackages.add(jumlPackage);
		}
	}

//	private void drawRelations() {
//		JUMLRelation jumlRelation;
//		for (RelationModel umlRelation : projectModel.getClassRelations()) {
//			jumlRelation = new JUMLRelation(umlRelation, this);
//
//			add(jumlRelation);
//			jumlRelations.add(jumlRelation);
//		}
//	}
}
