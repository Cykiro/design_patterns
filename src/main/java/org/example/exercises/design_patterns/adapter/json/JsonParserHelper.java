package org.example.exercises.design_patterns.adapter.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class JsonParserHelper {
    private String xmlName;
    ObjectMapper mapper = new ObjectMapper();
    public JsonParserHelper(String xmlName) {
        this.xmlName = xmlName;
    }


    public JSONObject parse() throws IOException {
        File file = new File("src/test/resources/" + xmlName);
        String jsonString  = Files.readString(Paths.get(file.getAbsolutePath()));
        JSONObject jsonObject = new JSONObject(jsonString);
        return jsonObject;
    }
}
