package com.mobadictionary;

import org.json.simple.*;

public class DefinitionEntry {

    private String keyword;
    private String definition;
    private String game;

    public DefinitionEntry(JSONObject json) {
        this.keyword = (String) json.get("keyword");
        this.definition = (String) json.get("definition");
        this.game = (String) json.get("game");
    }

    @Override
    public String toString() {
        return "{\"keyword\":\"" + this.keyword
                + "\",\"definition\":\"" + this.definition
                + "\",\"game\":\"" + this.game + "\"}";
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
