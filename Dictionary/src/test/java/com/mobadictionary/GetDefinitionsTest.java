package com.mobadictionary;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.lambda.runtime.Context;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetDefinitionsTest {

    DefinitionEntry definitionEntry;
    GetDefinitions getDefinitions;
    GoodResponse response;
    Request request;

    @BeforeEach
    void setUp() {
        definitionEntry = new DefinitionEntry();

        //request = new Request();
    }

    @Test
    public void getAllDefinitionsSuccess() {
        Context context = null;
        request = new Request();
        GoodResponse response = new GoodResponse();
        getDefinitions = new GetDefinitions();

        request.setResource("definitions");

        response = (GoodResponse) getDefinitions.handleRequest(request, context);

        assertEquals(21, GoodResponse.getDefinitions().size());
    }


}
