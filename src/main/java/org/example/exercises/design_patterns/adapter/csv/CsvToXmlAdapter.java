package org.example.exercises.design_patterns.adapter.csv;

import org.example.exercises.design_patterns.adapter.xml.XmlParserHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;

public class CsvToXmlAdapter extends XmlParserHelper {
    CsvParserHelper csvParserHelper;

    List<String> headers;
    List<List<String>> data;
    Document newDoc;

    public CsvToXmlAdapter(CsvParserHelper csvParserHelper) {
        super(null);
        this.csvParserHelper = csvParserHelper;
        headers = csvParserHelper.getHeaders();
        data = csvParserHelper.getData();
        newDoc = getNewDoc();
    }

    private static Document getNewDoc() {
        DocumentBuilder builder = getDocumentBuilder();
        return builder.newDocument();
    }

    private static DocumentBuilder getDocumentBuilder() {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            return builder;
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Document parse() {
        try {
            csvParserHelper.readCSV();
            Element rootElement = getRootElement();
            newDoc.appendChild(rootElement);

            return newDoc;
        } catch (Exception exp) {
           throw new RuntimeException(exp);
        }
    }

    private Element getRootElement() {
        Element rootElement = createInvoiceElement();
        fillLineElements(rootElement);
        return rootElement;
    }

    private Element createInvoiceElement() {
        Element invoice = newDoc.createElement("invoice");
        Element invoiceNumber = getInvoiceNumber(newDoc);
        invoice.appendChild(invoiceNumber);
        return invoice;
    }

    private void fillLineElements(Element rootElement) {
        List<Element> listLineElement = getListLineElement();
        listLineElement.forEach(rootElement::appendChild);
    }

    private List<Element> getListLineElement() {
        List<Element> result = new ArrayList<>();
        for (List<String> rowData : data) {
            Element lineElement = getLineElement(rowData);
            result.add(lineElement);
        }
        return result;
    }

    private Element getLineElement(List<String> rowData) {
        Element lineElement = newDoc.createElement("line");

        for (int i = 1; i < headers.size(); i++) {
            String header = getHeader(i);
            String value = rowData.get(i);
            Element curElement = getChildLineElement(header, value);
            lineElement.appendChild(curElement);
        }

        return lineElement;
    }

    private Element getChildLineElement(String header, String value) {
        Element curElement = newDoc.createElement(header);
        curElement.appendChild(newDoc.createTextNode(value));
        return curElement;
    }

    private String getHeader(int i) {
        return headers.get(i).replaceAll("[\\t\\p{Zs}\\u0020]", "_");
    }

    private Element getInvoiceNumber(Document newDoc) {
        Element invoiceNumber = newDoc.createElement("invoice_number");
        invoiceNumber.appendChild(newDoc.createTextNode(data.get(0).get(0)));
        return invoiceNumber;
    }
}
