package com.mobadictionary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResponseTest {

    @Test
    public void insertDefinitionEntrySuccess() {
        DefinitionEntry entry = new DefinitionEntry();
        Response response = new Response();
        response.insert(entry);

        assertEquals(1, response.getDefinitions().size());
    }

}
