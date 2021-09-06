package com.restassuredapi.basic;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.Assert;

import com.restassuredapi.payload.Payloads;
import com.restassuredapi.utility.StringToJsonParser;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Basics {
	
	static JsonPath jsonPath;

	public static void main(String[] args) throws IOException {
		
		
		
		// Three main methods:
		// given(): accept all input details
		// when(): Submit the APT
		// then(): validate the response
		
		
		// Add place --> Update place with new address --> Get place to validate if new address is present in response or not
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		// Validate if Add place(POST API) is working as expected
		//.body(Payloads.postAction()).when().post("/maps/api/place/add/json")
		String postResponse = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(StringToJsonParser.generateStringFromExternalJson("\\src\\main\\java\\com\\restassuredapi\\resources\\postPayload.json")).when().post("/maps/api/place/add/json")		
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		
		System.out.println("POST Response: " + postResponse);
		
//		JsonPath jsonPath = new JsonPath(postResponse); // for parsing string to json
//		String placeID = jsonPath.get("place_id");
		jsonPath = StringToJsonParser.parseStringToJson(postResponse);
		String placeID = jsonPath.getString("place_id");
		
		System.out.println("Place ID: " + placeID);
		
		System.out.println("==========================================================================");
		
		
		// Validate if Update place(PUT API) is working as expected
		
		String newAddress = "70 Summer walk, USA";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n" + 
				"\"place_id\":\"" + placeID + "\",\r\n" + 
				"\"address\":\"" + newAddress + "\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}\r\n" + 
				"")
		.when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		System.out.println("==========================================================================");
		
		
		
		// Validate if we can get details(GET API) is working as expected
		// .body("address", equalTo(newAddress));
		
		String getResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID)
		.when().get("/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("GET Response: " + getResponse);
		jsonPath = StringToJsonParser.parseStringToJson(getResponse);
		String actualAddress = jsonPath.get("address");
		
		System.out.println(actualAddress);
		
		Assert.assertEquals(actualAddress, newAddress);
		
	}
	
}
