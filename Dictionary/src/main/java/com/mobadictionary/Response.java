package com.mobadictionary;

import java.util.ArrayList;
import java.util.List;

public class Response {

    private String status;
    private List<DefinitionEntry> definitions;

    public Response() {
        definitions = new ArrayList<>();
    }

    public void insert(DefinitionEntry entry) {
        definitions.add(entry);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DefinitionEntry> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<DefinitionEntry> definitions) {
        this.definitions = definitions;
    }
}
