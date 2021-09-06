package com.restassured.files;

import io.restassured.path.json.JsonPath;

public class ReusablesMethods {
	
	public static JsonPath stringToJson (String response) {
		JsonPath jPath = new JsonPath(response);
		return jPath;
	}

}
