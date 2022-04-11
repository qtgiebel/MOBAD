package com.mobadictionary;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;

public class GetAllDefinitions implements RequestHandler<Request,DefinitionEntry> {

    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
    DynamoDBMapper mapper = new DynamoDBMapper(client);

    @Override
    public DefinitionEntry handleRequest(Request request, Context context) {
        DefinitionEntry entry = null;

        switch (request.getResource()) {
            case "keyword":
                entry = mapper.load(DefinitionEntry.class, "Generic", request.getValue());
                return entry;
            default:
                break;
        }

        return null;
    }
}
