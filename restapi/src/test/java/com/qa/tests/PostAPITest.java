package com.qa.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.Users;

public class PostAPITest extends TestBase {
	
	TestBase testBase;
	String serviceUrl;
	String apiUrl;
	String url;
	RestClient restClient;
	CloseableHttpResponse closeableHttpResponse;

	@BeforeMethod
	public void setup() {
		testBase = new TestBase();
		serviceUrl = properties.getProperty("URL");
		apiUrl = properties.getProperty("serviceURL");

		url = serviceUrl + apiUrl;
	}
	
	@Test
	public void postAPITest() throws ClientProtocolException, IOException {
		restClient = new RestClient();
		
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");

		//jackson API:
		ObjectMapper mapper = new ObjectMapper();
		Users users = new Users("devil", "angel");
		
		// object to json file:
		mapper.writeValue(new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\data\\users.json"), users);
		
		// object to json in String:
		String usersJsonString = mapper.writeValueAsString(users);
		System.out.println("Entity-----> " + usersJsonString);
		
		closeableHttpResponse = restClient.post(url, usersJsonString, headerMap);
		
		//1. status code:
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code----> " + statusCode);
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_201);
		
		//2. JsonString
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("Response from API---->" + responseJson);
		
		// json to java object:
		Users usersResObj = mapper.readValue(responseString, Users.class);
		System.out.println(users.getName().equals(usersResObj.getName()));
		System.out.println(users.getJob().equals(usersResObj.getJob()));
	}

}
