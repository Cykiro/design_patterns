package org.example.exercises.design_patterns.adapter.json;

import org.example.exercises.design_patterns.adapter.xml.XmlParserHelper;
import org.example.exercises.design_patterns.adapter.util.DocumentCreator;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XmlToJsonAdapterHelper extends XmlParserHelper {
    JsonParserHelper jsonParserHelper;
    public XmlToJsonAdapterHelper(JsonParserHelper jsonParserHelper) {
        super(null);
        this.jsonParserHelper = jsonParserHelper;
    }

    @Override
    public Document parse() throws IOException, ParserConfigurationException, SAXException {
        JSONObject jsonObject = jsonParserHelper.parse();
        String xmlString = XML.toString(jsonObject);
        Document doc = DocumentCreator.create(xmlString);
        return doc;
    }

}
