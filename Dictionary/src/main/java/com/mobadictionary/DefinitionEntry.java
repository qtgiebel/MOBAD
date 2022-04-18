package com.mobadictionary;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import java.util.Map;

/**
 * The model class for the attributes being mapped from the DICTIONARY table.
 */
public class DefinitionEntry {

    private String game;

    private String keyword;

    private String definition;

    /**
     * Instantiates a new Definition entry.
     */
    public DefinitionEntry() {}

    /**
     * Instantiates a new Definition entry.
     *
     * @param input the input
     */
    public DefinitionEntry(Map<String, AttributeValue> input) {
        this.keyword = input.get("Keyword").getS();
        this.game = input.get("Game").getS();
        this.definition = input.get("Description").getS();
    }

    /**
     * Gets definition.
     *
     * @return the definition
     */
    public String getDefinition() {
        return definition;
    }

    /**
     * Sets definition.
     *
     * @param definition the definition
     */
    public void setDefinition(String definition) {
        this.definition = definition;
    }

    /**
     * Gets game.
     *
     * @return the game
     */
    public String getGame() {
        return game;
    }

    /**
     * Sets game.
     *
     * @param game the game
     */
    public void setGame(String game) {
        this.game = game;
    }

    /**
     * Gets keyword.
     *
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * Sets keyword.
     *
     * @param keyword the keyword
     */
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
