package com.mobadictionary;

import java.util.ArrayList;
import java.util.List;

public class GoodResponse implements Response<DefinitionEntry> {

    private String status;
    private List<DefinitionEntry> definitions;

    public GoodResponse() {
        definitions = new ArrayList<>();
    }

    @Override
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
