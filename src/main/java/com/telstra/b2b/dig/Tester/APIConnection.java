package com.telstra.b2b.dig.Tester;


import com.telstra.b2b.dig.Tester.utils.JsonSearchUtilities;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class APIConnection {


    //TODO: Question 1: Complete the following Request
    //create a method that consumes the twitter API and retrieves the timeline for a given usertag, and returns the value
    //We are trying to get the recent tweets from a particular user on twitter.
    //in it's native json format.
    //api doc: https://developer.twitter.com/en/docs/twitter-api/v1/tweets/timelines/api-reference/get-statuses-user_timeline
    //API URL: https://api.twitter.com/1.1/statuses/user_timeline.json
    //Parameters: user_id (String)
    //Authentication: bearer Token (getToken() method already implemented



    //TODO: Question 2:
    //create a method that gets the current global trends data
    //then search the results to find if any of the trends are sponsored.
    //if any trends are sponsered, print the trend name and sponsor to the screen
    //API doc: https://developer.twitter.com/en/docs/twitter-api/v1/trends/trends-for-location/api-reference/get-trends-place
    //API url: https://api.twitter.com/1.1/trends/place.json
    //Authentication: bearer token
    //parameters: id: - id of the location to get trending results from. 1 for global results
    //Response will come in the response body as a jsonArray.
    //Response format: "promoted_content": null = not sponsord.
    //Response format: Trend name found under "name":"[...name...]"


    private static String getAuthToken(String username, String password) {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header(username,password);




        request.body("grant_type=client_credentials");

        Response response = request.post("https://api.twitter.com/oauth2/token");

        String token = JsonSearchUtilities.getFirstValueFromJSON(response.getBody().print(), "access_token");
        return token;
    }




}
