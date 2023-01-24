package org.mql.java.application.parsers.xml.mappers;

import org.mql.java.application.parsers.xml.XMLNode;

public interface Mapper {
	XMLNode objectToXMLNode(Object obj);
	Object xmlNodeToObject(XMLNode projectNode);
}
