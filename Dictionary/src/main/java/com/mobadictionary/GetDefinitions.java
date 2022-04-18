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

/**
 * This class gets definition entries from a DynamoDB database and returns them to the user as JSON objects.
 */
public class GetDefinitions implements RequestHandler<Request,Object> {

    /**
     * The Client for accessing the database.
     */
    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
            .withRegion("us-east-2")
            .build();

    /**
     * Message data to return in case of an error.
     */
    Map<String,String> error;

    /**
     * Receives a request object with the search terms for the API,
     * and returns a response with the requested data.
     * @param request The API Request.
     * @param context The context provided by Lambda.
     * @return The API Response.
     */
    @Override
    public Response handleRequest(Request request, Context context) {
        DefinitionEntry entry;
        Response response = new Response();
        error = new HashMap<>();

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

                if (titleResult.getCount() < 1) {
                    error.put("errorMessage", "No records could be found for that game");
                    response.error(error);
                    return response;
                }

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

                if (keywordResult.getCount() != 1) {
                    error.put("errorMessage", "No records could be found for that keyword");
                    response.error(error);
                    return response;
                }

                for (Map<String, AttributeValue> item : keywordResult.getItems()) {
                    entry = new DefinitionEntry(item);
                    response.insert(entry);
                }

                return response;
            default:
                error.put("errorMessage", "No resource/operation could be found");
                response.error(error);
                return response;
        }
    }
}
