package org.example.exercises.design_patterns.adapter.csv;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvParserHelper {

    private String xmlName;
    private List<String> headers;
    private List<List<String>> data;

    public CsvParserHelper(String xmlName) {
        this.xmlName = xmlName;
        headers = new ArrayList<>();
        data = new ArrayList<>();
    }

    public void readCSV() throws IOException, CsvValidationException {
        File file = new File("src\\test\\resources\\"+xmlName);
        try (BufferedReader csvReader = new BufferedReader(new FileReader(file))) {
            CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
            CSVReader reader = new CSVReaderBuilder(csvReader).withCSVParser(parser).build();

            readCSV(reader);
        }
    }

    private void readCSV(CSVReader reader) throws IOException, CsvValidationException {
        String[] nextLine;
        int line = 0;
        while ((nextLine = reader.readNext()) != null) {
            readLine(nextLine, line);
            line++;
        }
    }

    private void readLine(String[] nextLine, int line) {
        if (line == 0) { // Header row
            for (String col : nextLine) {
                headers.add(col);
            }
        } else { // Data row
            List<String> rowData = new ArrayList<>();
            for (String value : nextLine) {
                rowData.add(value.trim());
            }
            data.add(rowData);
        }
    }

    public List<String> getHeaders() {
        return headers;
    }

    public List<List<String>> getData() {
        return data;
    }
}