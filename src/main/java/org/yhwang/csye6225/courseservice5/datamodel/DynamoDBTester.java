package org.yhwang.csye6225.courseservice5.datamodel;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.amazonaws.services.dynamodbv2.document.Table;

import java.util.HashMap;
import java.util.Map;

public class DynamoDBTester {
    static AmazonDynamoDB dynamoDB;
    /*
    Init function to make the client availabe
    setup the resouces
    resources include credentials
    aws region
    build the client
    * */
    public static void init() throws Exception {
        ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
        credentialsProvider.getCredentials();
        System.out.println(credentialsProvider);
        dynamoDB = AmazonDynamoDBClientBuilder.standard().withCredentials(credentialsProvider)
                .withRegion("us-east-2").build();


    }

    public static void main(String[] args) throws Exception{
        init();
        String tableName = "students-test";

        GetItemRequest getItemRequest = new GetItemRequest();
        ///Users/mana/.aws/credentials
        //aws_access_key_id=
        //aws_secret_access_key=
        //key that you looking for dtudentId whith value 123
        Map<String, AttributeValue> itemToFetch = new HashMap<>();
        itemToFetch.put("studentId", new AttributeValue().withS("123"));

        getItemRequest.setKey(itemToFetch);
        getItemRequest.setTableName("students-test");
        GetItemResult getItemResult = dynamoDB.getItem(getItemRequest);
       // Table table = dynamoDB.get;
        System.out.println("GetItemResult: " + getItemResult);
    }
}
