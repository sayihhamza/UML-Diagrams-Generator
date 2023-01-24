package org.mql.java.application;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import org.mql.java.application.models.primary.ProjectModel;
import org.mql.java.application.parsers.Parser;
import org.mql.java.application.parsers.reflection.ProjectParser;
import org.mql.java.application.parsers.xml.ProjectDOMParser;
import org.mql.java.application.ui.swing.uml.JProject;
import org.mql.java.application.utils.FileUtils;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	private ProjectModel projectModel;

	private void parseProject(File file) {
		Parser parser = new ProjectParser();
		projectModel = (ProjectModel) parser.parse(file);
		
//		File xmlFile = new File(
//				"C:\\Users\\esayi\\eclipse-workspace\\UML Diagrams Generator\\resources\\projectModel.xml");
//		XMLNode projectNode = new XMLNode(xmlFile);
//		XMLNodeMapper nodeMapper = new XMLNodeMapper();
//		projectModel = (ProjectModel) nodeMapper.xmlNodeToObject(projectNode);
	}

	private void generateXMLTree() {
		ProjectDOMParser domParser = new ProjectDOMParser();
		domParser.generate();
	}

	private void startProcessing(File file) {
		parseProject(file);
		generateXMLTree();
		drawProject();
		config();
	}

	private void config() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}

	private void drawProject() {
		if (projectModel != null) {
			JScrollPane panelPane = new JScrollPane(new JProject(projectModel));
			setContentPane(panelPane);
		}
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

			File file = new File(
					"C:\\Users\\esayi\\eclipse-workspace\\UML Diagrams Generator\\bin\\org\\mql\\java\\example");
			if (FileUtils.isProjectDirectory(file)) {
				Main main = new Main();
				main.startProcessing(file);
			}

		} catch (Exception e) {
			System.out.println("EXCEPTION : " + e.getMessage());
		}
	}
}
