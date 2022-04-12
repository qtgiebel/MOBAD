package com.mobadictionary;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "test")
public class DefinitionEntry {

    @DynamoDBHashKey
    private String game;

    @DynamoDBRangeKey
    private String keyword;

    @DynamoDBAttribute
    private String definition;

    public DefinitionEntry() {}

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
