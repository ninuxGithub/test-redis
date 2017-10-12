package com.vic.service.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



public class JsonUtil2 {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static Map<String, TreeMap<String, Double>> readStringToMap(String content) {
        try {
            Map<String, TreeMap<String, Double>> result = mapper.readValue(content, new TypeReference<Map<String, TreeMap<String, Double>>>() {
            });
            return result;
        } catch (IOException e) {
        	throw new RuntimeException(e.getMessage());
        }
    }

    public static <S, T> Map<S, T> readStringToMap(String content, Class<S> key, Class<T> value) {
        try {
            Map<S, T> result = mapper.readValue(content, mapper.getTypeFactory().constructMapLikeType(HashMap.class, key, value));
            return result;
        } catch (IOException e) {
        	throw new RuntimeException(e.getMessage());
        }
    }

    public static <S, T> TreeMap<S, T> readStringToTreeMap(String content, Class<S> key, Class<T> value) {
        try {
            TreeMap<S, T> result = mapper.readValue(content, mapper.getTypeFactory().constructMapLikeType(TreeMap.class, key, value));
            return result;
        } catch (IOException e) {
        	throw new RuntimeException(e.getMessage());
        }
    }

    public static <T> List<T> readStringToList(String content, Class<T> clazz) {
        try {
            List<T> result = mapper.readValue(content, mapper.getTypeFactory().constructParametricType(ArrayList.class, clazz));
            return result;
        } catch (IOException e) {
        	throw new RuntimeException(e.getMessage());
        }
    }

    public static String writeValueAsString(Object content) {
        try {
            return mapper.writeValueAsString(content);
        } catch (JsonProcessingException e) {
        	throw new RuntimeException(e.getMessage());
        }
    }

    public static Map<String, Double[]> readStringToMapVArray(String content) {
        try {
            Map<String, Double[]> result = mapper.readValue(content, new TypeReference<Map<String, Double[]>>() {
            });
            return result;
        } catch (IOException e) {
        	throw new RuntimeException(e.getMessage());
        }
    }

    public static <T> T readStringToJavaBean(String content, Class<T> clazz) {
        try {
            return mapper.readValue(content, clazz);
        } catch (IOException e) {
        	throw new RuntimeException(e.getMessage());
        }
    }
}

