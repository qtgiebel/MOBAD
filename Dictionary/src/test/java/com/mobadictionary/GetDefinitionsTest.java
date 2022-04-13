package com.mobadictionary;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
}
