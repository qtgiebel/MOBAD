package com.mobadictionary;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import java.util.Map;

@DynamoDBTable(tableName = "DICTIONARY")
public class DefinitionEntry {

    @DynamoDBAttribute
    private String game;

    @DynamoDBHashKey
    private String keyword;

    @DynamoDBAttribute
    private String definition;

    public DefinitionEntry() {}

    public DefinitionEntry(Map<String, AttributeValue> input) {
        this.keyword = input.get("Keyword").getS();
        this.game = input.get("Game").getS();
        this.definition = input.get("Description").getS();
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

    @Override
    public String toString() {
        return "DefinitionEntry{" +
                "game='" + game + '\'' +
                ", keyword='" + keyword + '\'' +
                ", definition='" + definition + '\'' +
                '}';
    }
}
