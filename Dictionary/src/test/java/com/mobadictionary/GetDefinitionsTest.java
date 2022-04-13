package com.mobadictionary;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * The GetDefinitions tests.
 */
public class GetDefinitionsTest {

    /**
     * The Wilson.
     */
    GetDefinitions wilson;
    /**
     * The Request.
     */
    Request request;
    /**
     * The Response.
     */
    Response response;

    /**
     * Reinitializes the handler, request and response objects.
     */
    @BeforeEach
    public void setUp() {
        wilson = new GetDefinitions();
        request = new Request();
        response = null;
    }

    /**
     * Gets all definitions.
     */
    @Test
    public void getAllDefinitionsSuccess() {
        request.setResource("definitions");

        response = wilson.handleRequest(request, null);

        assertEquals(21, response.getDefinitions().size());
    }

    /**
     * Handle title request.
     */
    @Test
    public void handleTitleRequestSuccess() {
        request.setResource("title");
        request.setValue("LeagueOfLegends");

        response = wilson.handleRequest(request, null);

        assertEquals(3, response.getDefinitions().size());
    }

    /**
     * Catch bad title.
     */
    @Test
    public void catchBadTitleSuccess() {
        request.setResource("title");
        request.setValue("nope");

        response = wilson.handleRequest(request, null);

        assertNotNull(response.getError());
    }

    /**
     * Handle keyword request.
     */
    @Test
    public void handleKeywordRequestSuccess() {
        request.setResource("keyword");
        request.setValue("Bot");

        response = wilson.handleRequest(request, null);

        assertEquals("LeagueOfLegends", response.getDefinitions().get(0).getGame());
        assertEquals("Bot", response.getDefinitions().get(0).getKeyword());
        assertEquals("The duo lane", response.getDefinitions().get(0).getDefinition());
    }

    /**
     * Catch bad keyword.
     */
    @Test
    public void catchBadKeywordSuccess() {
        request.setResource("keyword");
        request.setValue("nope");

        response = wilson.handleRequest(request, null);

        assertNotNull(response.getError());
    }

    /**
     * Catch bad request.
     */
    @Test
    public void catchBadRequestSuccess() {
        request.setResource("bad-request");

        response = wilson.handleRequest(request, null);

        assertNotNull(response.getError());
    }
}
