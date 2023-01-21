package org.mql.java.application;

import java.io.File;

import org.mql.java.application.parsers.Parser;
import org.mql.java.application.parsers.reflection.ProjectParser;
import org.mql.java.application.parsers.xml.ProjectDOMParser;
import org.mql.java.application.utils.FileUtils;

public class Main {
	private static void parseProject(File file){
		Parser parser = new ProjectParser();
		parser.parse(file);
	}
	private static void generateXMLTree(){
		ProjectDOMParser domParser = new ProjectDOMParser();
		domParser.generate();
	}

	private static void startProcessing(File file) {
		parseProject(file);
		generateXMLTree();
	}

	public static void main(String[] args) {
		if(args.length == 1) {
			File file = new File(args[0]);
			if(FileUtils.isProjectDirectory(file)) {
				startProcessing(file);
			}
		}
	}
}
