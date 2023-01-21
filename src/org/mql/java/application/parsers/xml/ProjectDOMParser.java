package org.mql.java.application.parsers.xml;

import java.io.File;

import org.mql.java.application.models.primary.ProjectModel;
import org.mql.java.application.parsers.Parser;
import org.mql.java.application.parsers.xml.mappers.Mapper;
import org.mql.java.application.parsers.xml.mappers.XMLNodeMapper;


public class ProjectDOMParser implements Parser {
	private XMLNode root;
	
	public ProjectDOMParser() {
		Mapper mapper = new XMLNodeMapper();
		root = mapper.objectToXMLNode(ProjectModel.getInstance(null));
	}
	public void generate() {
		root.generate();
	}
	
	public XMLNode getRoot() {
		return root;
	}

	@Override
	public Object parse(File file) {
		// TODO : load the project from an XML Tree
		return null;
	}

}
