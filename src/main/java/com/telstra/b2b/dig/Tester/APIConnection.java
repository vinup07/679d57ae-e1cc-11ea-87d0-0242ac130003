package com.telstra.b2b.dig.Tester;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class APIConnection {


    //TODO: Question 1: Complete the following Request
    //This Method must talk to a set API and retrieve it's bearer token, using the supplied parameters.
    //the URL of the API is: https://b2bdigitization-testservices.apps.np.sdppcf.com/auth/signin
    //it both sends and receives information in a JSON format.
    //It accepts the Parameters in the following JSON format:
    /*
    {
        "usernameOrEmail"="[username]"
        "password"="[password]"
    }
    */

    private static String getToken(String username, String password) {
        //TODO: Code HERE
        return null;
    }
























//DO NOT EXPAND UNTIL ASKED
    public String APIPostRequestWithBody(String path, HashMap<String,String> body, String bearerToken){
        RequestSpecification request = RestAssured.given();
        request.headers(
                "Authorization",
                "Bearer " + bearerToken,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON);

        JSONObject jsonBody = new JSONObject();
        for (Map.Entry<String, String> entry : body.entrySet()) {
            jsonBody.put(entry.getKey(), entry.getValue());
        }
        request.body(jsonBody.toJSONString());

        Response response= request.post(path);

        if(response.statusCode() != 200) return "Failed: " + response.statusLine();
        return response.getBody().print();
    }






}
