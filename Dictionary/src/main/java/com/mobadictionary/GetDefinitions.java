package com.mobadictionary;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.HashMap;
import java.util.Map;

public class GetDefinitions implements RequestHandler<Request,Response> {

    //AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();

    @Override
    public Response handleRequest(Request request, Context context) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
        DefinitionEntry entry;
        Response response = new Response();

        switch (request.getResource()) {
            case "definitions":
                ScanRequest scanRequest = new ScanRequest()
                        .withTableName("DICTIONARY");

                ScanResult result = client.scan(scanRequest);
                for (Map<String, AttributeValue> item : result.getItems()){
                    entry = new DefinitionEntry(item);
                    response.insert(entry);
                }
                return response;
            case "title":
                Map<String, AttributeValue> titleExpressionAttributes = new HashMap<>();
                titleExpressionAttributes.put(":val", new AttributeValue().withS(request.getValue()));

                ScanRequest titleRequest = new ScanRequest()
                        .withTableName("DICTIONARY")
                        .withFilterExpression("Game = :val")
                        .withExpressionAttributeValues(titleExpressionAttributes);

                ScanResult titleResult = client.scan(titleRequest);

                for (Map<String, AttributeValue> item : titleResult.getItems()) {
                    entry = new DefinitionEntry(item);
                    response.insert(entry);
                }

                return response;
            case "keyword":
                Map<String, AttributeValue> keywordExpressionAttributes = new HashMap<>();
                keywordExpressionAttributes.put(":val", new AttributeValue().withS(request.getValue()));

                ScanRequest keywordRequest = new ScanRequest()
                        .withTableName("DICTIONARY")
                        .withFilterExpression("Keyword = :val")
                        .withExpressionAttributeValues(keywordExpressionAttributes);

                ScanResult keywordResult = client.scan(keywordRequest);

                for (Map<String, AttributeValue> item : keywordResult.getItems()) {
                    entry = new DefinitionEntry(item);
                    response.insert(entry);
                }

                return response;
            default:
                break;
        }

        return null;
    }
}
