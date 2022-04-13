package com.mobadictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Response {

    private Map<String,String> error;
    private List<DefinitionEntry> definitions;

    public Response() {
        definitions = new ArrayList<>();
    }

    public void insert(DefinitionEntry entry) {
        definitions.add(entry);
    }

    public void error(Map<String, String> error) {
        this.error = error;
        definitions = null;
    }

    public Map<String, String> getError() {
        return error;
    }

    public void setError(Map<String, String> error) {
        this.error = error;
    }

    public List<DefinitionEntry> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<DefinitionEntry> definitions) {
        this.definitions = definitions;
    }
}
