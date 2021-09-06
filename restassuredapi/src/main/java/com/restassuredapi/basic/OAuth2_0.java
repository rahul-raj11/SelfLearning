package com.restassuredapi.basic;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class OAuth2_0 {

	public static void main(String[] args) {

		//RestAssured.baseURI = "";
		
		String code ="4%2FqgGx5G4YMKAQOJ0OouBdEG0salosXGjkl2bVNkSMV1HFvE-bmQtjf3dAxESn4t2Z23hDdVf4EszLhhOshf_6oag";
		
		String accessTokenResponse = given().urlEncodingEnabled(false).
		queryParam("code", code).
		queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
		queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").
		queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php").
		queryParam("grant_type", "authorization_code").
		when().log().all().post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		JsonPath path = new JsonPath(accessTokenResponse);
		String accessToken = path.getString("access_token");
		
		String getResponse = given().queryParam("access_token", accessToken).
		when().log().all().get("https://rahulshettyacademy.com/getCourse.php").asString();
		
		System.out.println(getResponse);
		
	}

}
