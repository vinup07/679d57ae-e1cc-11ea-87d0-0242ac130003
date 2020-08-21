package Interview;


import Interview.utils.JsonSearchUtilities;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIConnection {


    //TODO: Question 1: Complete the following Request
    //create a method that consumes the twitter API and retrieves the timeline for a given usertag, and returns the value

    //We are trying to get the recent tweets from a particular user on twitter.

    //in it's native json format.

    //api doc: https://developer.twitter.com/en/docs/twitter-api/v1/tweets/timelines/api-reference/get-statuses-user_timeline

    //API URL: https://api.twitter.com/1.1/statuses/user_timeline.json

    //Parameters: user_id (String)

    //Authentication: bearer Token (getAuthToken() method already implemented






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





    //TODO:Question 3
    //create an Endpoint in a new class (and file) that calls the getAuthToken method and returns the result.

    //The API Contract is as follows:

    //The endpoint will be found at the URL extension /Twitter/getToken

    //it will accept username and password as parameters.

    //it will return the Token in a String format.




    private static String getAuthToken(String username, String password) {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header(username,password);

        request.body("grant_type=client_credentials");

        Response response = request.post("https://api.twitter.com/oauth2/token");

        String token = JsonSearchUtilities.getFirstValueFromJSON(response.getBody().print(), "access_token");
        return token;
    }

    //RestTemplate Example.
    /*
    * public List<String> getNewOrders(){
        String Query = "https://telstrab2b--tb2bqa2.cs116.my.salesforce.com/services/data/v41.0/query?q=SELECT++Id,CreatedDate,Request_Message__c+FROM+ApplicationLog__c";

        OAuthToken token = this.getSalesforceToken();

        // Build headers
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", "Bearer " + token.getToken());
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(headers); //HttpEntity<>(headers);
        try {
            ResponseEntity<SFHVQueryResponce> response = this.restTemplate.exchange(Query, HttpMethod.GET, request, SFHVQueryResponce.class);
            List<String> records = response.getBody();
            return records;

        } catch (RestClientException e) {
            throw new RuntimeException("Could not execute query", e);
        }

    }
    * */


}
