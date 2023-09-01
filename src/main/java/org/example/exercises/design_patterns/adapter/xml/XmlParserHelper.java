package org.example.exercises.design_patterns.adapter.xml;

import org.example.exercises.design_patterns.adapter.util.DocumentCreator;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlParserHelper {
    private String xmlName;

    public XmlParserHelper(String xmlName) {
        this.xmlName = xmlName;
    }


    public Document parse() throws IOException, SAXException, ParserConfigurationException {
        Document doc = DocumentCreator.create(xmlName);
        return doc;
    }
}
