package com.restassuredapi.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.path.json.JsonPath;

public class StringToJsonParser {

	
	// for parsing string to json
	
		public static JsonPath parseStringToJson(String response) {
			
			JsonPath jsonPath = new JsonPath(response);
			
			return jsonPath;
		}
		
		
		public static String generateStringFromExternalJson(String path) throws IOException {
			
			return new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + path)));
		}
}
