package com.restassured.intro;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

import org.testng.Assert;

public class BasicIntro {

	public static void main(String[] args) {
		
		// Add place -> Update Place with New Address -> Get place to validate if New Address is present in response or not.

		// Validate if Add place api is working as expected or not
		// RestAssured works on 3 principle given(all input details), when(submit the api), then(validate the response)
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String postResponse = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(com.restassured.files.Payload.addPlace()).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		
		System.out.println("=====================================================================");
		System.out.println(postResponse);
		
		//JsonPath jp = new JsonPath(postResponse); // for parsing json
		JsonPath jp = com.restassured.files.ReusablesMethods.stringToJson(postResponse);
		String placeId = jp.getString("place_id");
		
		System.out.println(placeId);
		
		// Update place i.e. PUT
		
		String updatedAddress = "70 nature walk, USA";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n" + 
				"\"place_id\":\"" + placeId + "\",\r\n" + 
				"\"address\":\"" + updatedAddress + "\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}\r\n" + 
				"").when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		// Get updated place i.e. GET
		
		String getResponse = given().log().all().queryParams("key", "qaclick123", "place_id", placeId)
		.when().get("maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).body("address", equalTo(updatedAddress)).extract().response().asString();
		
		JsonPath jPath = com.restassured.files.ReusablesMethods.stringToJson(getResponse);
		//JsonPath jp1 = new JsonPath(getResponse);
		String address = jPath.getString("address");
		System.out.println(address);
		Assert.assertEquals(address, updatedAddress);
		
	}

}
