package com.mobadictionary;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
        request.setResource("Keyword");
        request.setValue("Bot");

        response = wilson.handleRequest(request, null);

        System.out.println(response);
    }
}
