package org.example.exercises.design_patterns.adapter.xml;

import org.example.exercises.design_patterns.adapter.util.Pair;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.math.BigDecimal;

public class XMLProcessor {
    public Pair countMoney(Document doc) {

        BigDecimal price = sumPrice(doc);
        String number = doc.getElementsByTagName("invoice_number").item(0).getTextContent();
        Pair pair = new Pair(number, price);

        return pair;
    }

    private static BigDecimal sumPrice(Document doc) {
        BigDecimal priceResult = new BigDecimal(0);
        NodeList nodeList = doc.getElementsByTagName("line");

        priceResult = getDecimal(priceResult, nodeList);

        return priceResult.setScale(2);
    }

    private static BigDecimal getDecimal(BigDecimal priceResult, NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nodeLine = nodeList.item(i);
            NodeList lineTags = nodeLine.getChildNodes();
            priceResult = getBigDecimal(priceResult, lineTags);
        }
        return priceResult;
    }

    private static BigDecimal getBigDecimal(BigDecimal priceResult, NodeList lineTags) {
        Node currentNode;
        for (int j = 0; j < lineTags.getLength(); j++) {
            currentNode= lineTags.item(j);
            if(currentNode.getNodeName().equals("price")){
                Node priceTag = currentNode;
                if (priceTag.getNodeType() == Node.ELEMENT_NODE) {
                    priceResult = priceResult.add(new BigDecimal(priceTag.getTextContent()));
                }
            }
        }
        return priceResult;
    }

}
