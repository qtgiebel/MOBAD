package com.mobadictionary;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ResponseTest {

    @Test
    public void insertDefinitionEntrySuccess() {
        DefinitionEntry entry = new DefinitionEntry();
        Response response = new Response();
        response.insert(entry);

        assertEquals(1, response.getDefinitions().size());
    }

    @Test
    public void catchErrorSuccess() {
        Response response = new Response();
        Map<String, String> error = new HashMap<String, String>();
        response.setError(error);

        assertNotNull(response.getError());
    }

}
