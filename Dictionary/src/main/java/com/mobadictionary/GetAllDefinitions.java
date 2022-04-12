package com.mobadictionary;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;

public class GetAllDefinitions implements RequestHandler<Request,Response> {

    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
    DynamoDBMapper mapper = new DynamoDBMapper(client);

    @Override
    public Response handleRequest(Request request, Context context) {
        DefinitionEntry entry;
        Response response = new Response();

        switch (request.getResource()) {
            case "definitions":
                ScanRequest scanRequest = new ScanRequest()
                        .withTableName("Reply");

                ScanResult result = client.scan(scanRequest);
                for (Map<String, AttributeValue> item : result.getItems()){
                    entry = new DefinitionEntry(item);
                    response.insert(entry);
                }
            case "title":

            case "keyword":
                response.insert(
                        mapper.load(
                                DefinitionEntry.class,
                                request.getValue()));
                return response;
            default:
                break;
        }

        return null;
    }
}
