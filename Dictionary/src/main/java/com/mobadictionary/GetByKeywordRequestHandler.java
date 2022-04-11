package com.mobadictionary;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 *
 */
public class GetByKeywordRequestHandler implements RequestStreamHandler {

    private static final String DYNAMODB_TABLE_NAME = "dictionary"/*System.getenv("dictionary")*/;

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {

        JSONParser parser = new JSONParser();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        JSONObject responseJson = new JSONObject();

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
        DynamoDB dynamoDB = new DynamoDB(client);

        Item result = null;
        JSONObject responseBody = new JSONObject();

        try {
            JSONObject event = (JSONObject) parser.parse(reader);

            if (event.get("keyword") == null) {
                throw new Exception("No keyword included");
            }

            System.out.println("Keyword: " + event.get("keyword"));
            result = dynamoDB.getTable(DYNAMODB_TABLE_NAME).getItem("Keyword", "Generic", "Game", event.get("keyword"));
            System.out.println(dynamoDB.getTable(DYNAMODB_TABLE_NAME));

            if (result == null) {
                throw new Exception(("Keyword not found"));
            }


            DefinitionEntry definition = new DefinitionEntry((JSONObject) parser.parse(result.toJSON()));
            responseBody.put("Definition", definition);
            responseJson.put("statusCode", 200);
        } catch (ParseException e) {
            responseJson.put("statusCode", 400);
            responseJson.put("exception", e);
        } catch (Exception e) {
            responseBody.put("message", e.getMessage());
            responseJson.put("statusCode", 400);
        }

        responseJson.put("body", responseBody.toString());

        OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
        writer.write(responseJson.toString());
        writer.close();
    }
}


