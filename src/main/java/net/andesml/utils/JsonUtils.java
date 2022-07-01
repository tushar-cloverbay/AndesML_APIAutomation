package net.andesml.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.andesml.base.Constants;

public class JsonUtils {
	public static String payloadGenerator(String fileName) throws IOException
	{
	String filepath = System.getProperty("user.dir")+"\\Resources\\"+fileName;
	return new String(Files.readAllBytes(Paths.get(filepath)));
	}
	
	
	public static String getKeyValue(Response response,String key)
	{
		String strResponse = response.getBody().asString();
		JsonPath responseObj = new JsonPath(strResponse);
		return responseObj.getString(key);
	}
	
	public static JSONObject updateJson(JSONObject obj, String keyString, String newValue) throws Exception {
        JSONObject json = new JSONObject();
        // get the keys of json object
        Iterator iterator = obj.keys();
        String key = null;
        while (iterator.hasNext()) {
            key = (String) iterator.next();
            // if the key is a string, then update the value
            if ((obj.optJSONArray(key) == null) && (obj.optJSONObject(key) == null)) {
                if ((key.equals(keyString))) {
                    // put new value
                    obj.put(key, newValue);
                    return obj;
                }
            }

            // if it's jsonobject
            if (obj.optJSONObject(key) != null) {
                updateJson(obj.getJSONObject(key), keyString, newValue);
            }

            // if it's jsonarray
            if (obj.optJSONArray(key) != null) {
                JSONArray jArray = obj.getJSONArray(key);
                for (int i = 0; i < jArray.length(); i++) {
                    updateJson(jArray.getJSONObject(i), keyString, newValue);
                }
            }
        }
        System.out.println("Request Updated.....");
        return obj;
    }
	
	public static List<String> getAllKeys(String jsonString) {
		List<String> list = new ArrayList<String>();
		
		JSONObject json = new JSONObject(jsonString);
        // get the keys of json object
        Iterator iterator = json.keys();
        String key = null;
        while (iterator.hasNext()) {
            key = (String) iterator.next();
            // if the key is a string, then update the value
            list.add(key);
                

            // if it's jsonobject
            if (json.optJSONObject(key) != null) {
            	List<String> listinner = getAllKeys(json.getJSONObject(key).toString());
            	list.addAll(listinner);
            }

            // if it's jsonarray
            if (json.optJSONArray(key) != null) {
                JSONArray jArray = json.getJSONArray(key);
                for (int i = 0; i < jArray.length(); i++) {
                	List<String> listinner = getAllKeys(jArray.getJSONObject(i).toString());
                	list.addAll(listinner);
                }
            }
        }
	        return list;
	}
	

}
