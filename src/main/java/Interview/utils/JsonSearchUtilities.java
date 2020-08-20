package Interview.utils;

import lombok.extern.log4j.Log4j2;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * Taken and modified from Stack overflow - User Mr. Polywhirl
 * https://stackoverflow.com/questions/32459776/how-to-retrieve-particular-jsonobject-irrespective-of-its-depth-in-json
 * */
@Log4j2
public class JsonSearchUtilities {


    // ========================================================================
    // Main Routines
    // ========================================================================

    public static List<String> searchJson(String json, String key){
        return searchJson(json, key,false);
    }

    public static List<String> searchJsonArray(String json, String key){
        List<String> valList = new ArrayList<>();
        JsonArray jsonArray = readJsonArray(json);

        return recurseJsonArray(jsonArray,key,valList, false);
    }

    public static List<String> searchJson(String json, String key, Boolean cleanResult){
        List<String> valList = new ArrayList<>();
        JsonObject jsonObject = readJsonStringToObject(json);

        return recurseJsonObject(jsonObject, key, valList, cleanResult);
    }


    public static List<String> getOrderLineAndItmems(String json){
        List<String> orderitems = new ArrayList<>();
        List<String> orderlines = new ArrayList<>();
        JsonObject jsonObject =readJsonStringToObject(json);
        orderitems = recurseJsonObject(jsonObject, "orderItems", orderitems, false);
        orderlines = recurseJsonObject(jsonObject, "Order Lines", orderlines, false);
        JsonArray oiArray = readJsonArray(orderitems.get(0));
        JsonArray olArray = readJsonArray(orderlines.get(0));
        List<String> values = new ArrayList<>();
        if(olArray.size() > 0) {
            for (JsonValue jo : olArray) {
                if (jo instanceof JsonObject) {
                    values.add(jo.toString());
                }
            }
        }
        if(oiArray.size() > 0) {
            for (JsonValue jo : oiArray) {
                if (jo instanceof JsonObject) {
                    values.add(jo.toString());
                }
            }
        }

        return values;
    }

    public static String getFirstValueFromJSON(String json, String key){
        List<String> values = searchJson(json, key);
        if (values.size()> 0) return values.get(0);
        return "";
    }



    public static List<String> recurseJsonObject(JsonObject jsonObject, String identifier, List<String> valList, boolean clean){
        if(jsonObject.containsKey(identifier)){
            String result = jsonObject.get(identifier).toString();
            if(clean) result= result.replaceAll("\"", "");
            valList.add(result);
        }


        if (jsonObject != null) {
            for (String key : jsonObject.keySet()) {
                Object child = jsonObject.get(key);
                if(child instanceof JsonObject){
                    valList=recurseJsonObject((JsonObject) child, identifier, valList, clean);
                }
                else if(child instanceof JsonArray){
                    valList = recurseJsonArray((JsonArray) child, identifier, valList, clean);
                }
                else if(child.toString().equals("\"" + identifier + "\"") || child.toString().equals(identifier) ){
                    String value = (String)jsonObject.keySet().toArray()[1]; //gets the key for the value field (sometimes its not value)
                    //sometimes the name/value order is reversed : check and correct for that:
                    if(value.equals("\"" + identifier + "\"")) value = ((String)jsonObject.keySet().toArray()[0]);
                    String result = jsonObject.get(value).toString();
                    result= result.replaceAll("\"", "");
                    valList.add(result);
                }
            }
        }
        return valList;

    }

    public static String sanitizeMalformedJson(String json){
        return json.replaceAll("(?<!\\\\)\"", "").replaceAll("\\\\", "");
    }

    public static List<String> recurseJsonArray(JsonArray jsonArray, String Identifier, List<String> valList, boolean clean){
        for(Object child : jsonArray){
            if(child instanceof JsonObject){
                valList= recurseJsonObject((JsonObject) child, Identifier, valList, clean);
            }
            else if (child instanceof JsonArray){
                valList= recurseJsonArray((JsonArray) child, Identifier, valList, clean);
            }
        }


        return valList;
    }



    public static JsonArray readJsonArray(String json) {
        InputStream stream = null;

        try {
            JsonReader reader = Json.createReader(new StringReader(json));
            return reader.readArray();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.getMessage();
                }
            }
        }
        return null;
    }


    public static JsonObject readJsonStringToObject(String json) {
        InputStream stream = null;

        try {
            JsonReader reader = Json.createReader(new StringReader(json));
            return reader.readObject();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.getMessage();
                }
            }
        }

        return null;
    }

    public static String prettyPrint(String json) {
        JsonStructure structure = readJsonStringToObject(json);
        return jsonFormat(structure, JsonGenerator.PRETTY_PRINTING);
    }

    public static String prettyPrint(JsonStructure json) {
        return jsonFormat(json, JsonGenerator.PRETTY_PRINTING);
    }

    public static String jsonFormat(JsonStructure json, String... options) {
        StringWriter stringWriter = new StringWriter();
        Map<String, Boolean> config = new HashMap<String, Boolean>();

        if (options != null) {
            for (String option : options) {
                config.put(option, true);
            }
        }

        JsonWriterFactory writerFactory = Json.createWriterFactory(config);
        JsonWriter jsonWriter = writerFactory.createWriter(stringWriter);

        jsonWriter.write(json);
        jsonWriter.close();

        return stringWriter.toString();
    }
}

