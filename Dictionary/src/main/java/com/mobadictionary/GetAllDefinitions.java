package com.mobadictionary;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.amazonaws.services.lambda.runtime.*;

public class GetAllDefinitions {

    public static Object handleRequest(Request request, Context context) throws ResourceNotFoundException {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
        DynamoDBMapper mapper = new DynamoDBMapper(client);
        DefinitionEntry entry = null;

        switch (request.getResource()) {
            case "definitions" :

                break;
            case "title" :

                break;
            case "keyword" :

                break;
            default:
                break;
        }


        return null;
    }

}
