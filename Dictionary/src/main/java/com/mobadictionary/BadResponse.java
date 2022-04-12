package com.mobadictionary;

import java.util.HashMap;
import java.util.Map;

public class BadResponse implements Response<Map<String,String>> {
    Map<String,String> error;

    public BadResponse() {
        error = new HashMap<>();
    }

    @Override
    public void insert(Map<String,String> entry) {
        error = entry;
    }
}
