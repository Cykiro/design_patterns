package org.example.exercises.design_patterns.adapter.util;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

public class DocumentCreator {
    public static Document create(String input) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.newDocument();
        File file = new File("src/test/resources/" + input);
        if (file.exists()) {
            doc = builder.parse(file);
        } else {
            doc = builder.parse(new InputSource(new StringReader(input)));
        }

        doc.getDocumentElement().normalize();

        return doc;
    }
}
