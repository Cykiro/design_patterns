package org.example.exercises.design_patterns.adapter;

import org.example.exercises.design_patterns.adapter.csv.CsvParserHelper;
import org.example.exercises.design_patterns.adapter.csv.CsvToXmlAdapter;
import org.example.exercises.design_patterns.adapter.json.JsonParserHelper;
import org.example.exercises.design_patterns.adapter.json.XmlToJsonAdapterHelper;
import org.example.exercises.design_patterns.adapter.util.Pair;
import org.example.exercises.design_patterns.adapter.xml.XMLProcessor;
import org.example.exercises.design_patterns.adapter.xml.XmlParserHelper;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class XMLProcessorTest {


    @Test
    public void parseXML() throws IOException, ParserConfigurationException, SAXException {

        XMLProcessor XMLProcessor = new XMLProcessor();
        XmlParserHelper xmlParserHelper = new XmlParserHelper("example_jdom.xml");

        Pair pair = XMLProcessor.countMoney(xmlParserHelper.parse());

        assertThat("993123").isEqualTo(pair.getNumber());
        assertThat(BigDecimal.valueOf(34.30).setScale(2)).isEqualTo(pair.getPrice());
    }

    @Test
    public void parseJson() throws IOException, ParserConfigurationException, SAXException {
        XMLProcessor XMLProcessor = new XMLProcessor();
        JsonParserHelper jsonParser = new JsonParserHelper("example2.json");
        XmlToJsonAdapterHelper xmlToJsonAdapterHelper = new XmlToJsonAdapterHelper(jsonParser);

        Pair pair = XMLProcessor.countMoney(xmlToJsonAdapterHelper.parse());

        assertThat("993123").isEqualTo(pair.getNumber());
        assertThat(BigDecimal.valueOf(34.30).setScale(2)).isEqualTo(pair.getPrice());
    }
    @Test
    public void parseCsv(){
        XMLProcessor xmlProcessor = new XMLProcessor();
        CsvParserHelper csvParserHelper = new CsvParserHelper("example3.csv");
        CsvToXmlAdapter csvToXmlAdapter = new CsvToXmlAdapter(csvParserHelper);

        Pair pair = xmlProcessor.countMoney(csvToXmlAdapter.parse());

        assertThat("993123").isEqualTo(pair.getNumber());
        assertThat(BigDecimal.valueOf(34.30).setScale(2)).isEqualTo(pair.getPrice());
    }

    public void compareDocs(){
        CsvParserHelper csvParserHelper = new CsvParserHelper("example3.csv");
        CsvToXmlAdapter csvToXmlAdapter = new CsvToXmlAdapter(csvParserHelper);
        System.out.println(convertDocumentToString(csvToXmlAdapter.parse()));
    }
    public static String convertDocumentToString(Document doc) {
        try {
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            return sw.toString();
        } catch (Exception ex) {
            throw new RuntimeException("Error converting to String", ex);
        }
    }
}