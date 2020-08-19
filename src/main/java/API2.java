package com.telstra.b2b.dig.Tester;


public class API2 {

    //TODO: Implement the following
    //connect to a SalesForce API and retrieve a list of phone numbers associated with a given order
    //The method must take in the Order Id as a string value, and output a List of numbers as a List
    //assume the getToken() method is implemented and returns a valid bearer token.
    //A data class has already been defined (SFImport in utils) for the response.
    //API Details:
    // URL: https://telstrab2b--tb2bqa2.my.salesforce.com/services/data/v48.0/query
    // Parameter name = q value = select+csord__Order_Number__c,Id+FROM+csord__Order__c+where+csord__Order_Number__c='[order number]'
    // HTTPMethod = GET
    // Authentication = bearer Token
    // Response as json, example
    /* mopoi b
    * {
    *   "Order_Id"="ON14569459",
    *   "Order_Type"="NEW",
    *   "Attached_Mobile_Numbers"= [
    *       "61424856697",
    *       "61424856699",
    *       "61424856704",
    *   ]
    * }
    *
    * Important Considerations!
    * The api is not reliably available, and may sometimes return a 404 or 501 error
    * Sometimes the order has Bad data, and the phone numbers are not valid, these need to be removed from the response.
    * */





    public String getToken(){
        return "token";
    }

}
