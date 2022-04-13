package com.mobadictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Response.
 */
public class Response {

    private Map<String,String> error;
    private List<DefinitionEntry> definitions;

    /**
     * Instantiates a new Response.
     */
    public Response() {
        definitions = new ArrayList<>();
    }

    /**
     * Insert.
     *
     * @param entry the entry
     */
    public void insert(DefinitionEntry entry) {
        definitions.add(entry);
    }

    /**
     * Error.
     *
     * @param error the error
     */
    public void error(Map<String, String> error) {
        this.error = error;
        definitions = null;
    }

    /**
     * Gets error.
     *
     * @return the error
     */
    public Map<String, String> getError() {
        return error;
    }

    /**
     * Sets error.
     *
     * @param error the error
     */
    public void setError(Map<String, String> error) {
        this.error = error;
    }

    /**
     * Gets definitions.
     *
     * @return the definitions
     */
    public List<DefinitionEntry> getDefinitions() {
        return definitions;
    }

    /**
     * Sets definitions.
     *
     * @param definitions the definitions
     */
    public void setDefinitions(List<DefinitionEntry> definitions) {
        this.definitions = definitions;
    }

    @Override
    public String toString() {
        return "Response{" +
                "error=" + error +
                ", definitions=" + definitions +
                '}';
    }
}
