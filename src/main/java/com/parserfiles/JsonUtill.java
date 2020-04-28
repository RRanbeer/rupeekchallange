package com.parserfiles;

import java.util.List;

import io.restassured.response.Response;

public class JsonUtill {
	/**
	 *getJsonString returns the json value from the specified jsonPath
	 *@param reponnse
	 *@param jsonPath
	 *@return 
	 */
public static String getJsonString(Response response, String jsonPath)
{
return response.getBody().jsonPath().get(jsonPath).toString();	
}

/**
 *getJsonString returns the json array from the specified jsonPath
 *@param reponnse
 *@param jsonPath
 *@return 
 */
public static List<String> getJsonList(Response response, String jsonPath)
{
return response.getBody().jsonPath().getList(jsonPath);	
}

}
