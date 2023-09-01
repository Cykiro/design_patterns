package org.example.exercises.design_patterns.singleton.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.exercises.design_patterns.singleton.model.Client;

import java.util.List;

public class JacksonHelper {
    private static ObjectMapper mapper = new ObjectMapper();

    public static String convertObjectToString(Object object) throws JsonProcessingException {
        String jsonString = mapper.writeValueAsString(object);
        return jsonString;
    }

    public static List<Client> convertStringToObject(String json) throws JsonProcessingException {
        List<Client> o = mapper.readValue(json, new TypeReference<List<Client>>() {});
        return o;
    }
}
