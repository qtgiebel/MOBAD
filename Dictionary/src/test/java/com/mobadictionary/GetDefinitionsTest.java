package com.mobadictionary;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class GetDefinitionsTest {

    GetDefinitions wilson;
    Request request;
    Response response;

    @BeforeEach
    public void setUp() {
        wilson = new GetDefinitions();
        request = new Request();
        response = null;
    }

    @Test
    public void handleKeywordRequestSuccess() {
        request.setResource("keyword");
        request.setValue("Bot");

        response = wilson.handleRequest(request, null);

        assertEquals("LeagueOfLegends", response.getDefinitions().get(0).getGame());
        assertEquals("Bot", response.getDefinitions().get(0).getKeyword());
        assertEquals("The duo lane", response.getDefinitions().get(0).getDefinition());
    }

    @Test
    public void handleTitleRequestSuccess() {
        request.setResource("title");
        request.setValue("LeagueOfLegends");

        response = wilson.handleRequest(request, null);

        assertEquals(3, response.getDefinitions().size());
    }

    @Test
    public void getAllDefinitionsSuccess() {
        request.setResource("definitions");

        response = wilson.handleRequest(request, null);

        assertEquals(21, response.getDefinitions().size());
    }

    @Test
    public void catchBadRequestSuccess() {
        request.setResource("bad-request");

        response = wilson.handleRequest(request, null);

        assertNotNull(response.getError());
    }
}
