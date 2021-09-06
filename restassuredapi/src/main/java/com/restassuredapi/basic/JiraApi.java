package com.restassuredapi.basic;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.Assert;

import com.restassuredapi.utility.StringToJsonParser;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class JiraApi {

	public static void main(String[] args) {

		RestAssured.baseURI = "http://localhost:8080";
		
		SessionFilter filter = new SessionFilter();
		
		// Login Scenario
		String logingResponse = given().relaxedHTTPSValidation().log().all().header("Content-Type", "application/json").
		body("{\r\n" + 
				"    \"username\": \"fred\",\r\n" + 
				"    \"password\": \"freds_password\"\r\n" + 
				"}").filter(filter).
		when().post("/rest/auth/1/session").
		then().log().all().extract().response().asString();
		
		// Add comment to existing bug
		String expectedCommentMessage = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
		String addCommentResponse = given().log().all().pathParam("issueId", "10101").header("Content-Type", "application/json")
		.body("{\r\n" + 
				"    \"body\": \"" + expectedCommentMessage + "\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}").filter(filter).
		when().post("/rest/api/2/issue/{issueId}/comment").
		then().log().all().assertThat().statusCode(201).extract().response().asString();
		String commentId = StringToJsonParser.parseStringToJson(addCommentResponse).getString("id");
		
		// Add Attachment
		given().log().all().pathParam("issueId", "10101").header("X-Atlassian-Token", "no-check").filter(filter).
		header("Content-Type", "multipart/form-data").
		multiPart("file", new File(System.getProperty("user.dir") + "\\restassuredapi\\src\\main\\java\\com\\restassuredapi\\resources\\jira.txt")).
		when().post("/rest/api/2/issue/{issueId}/attachments").
		then().log().all().assertThat().statusCode(200);
		
		// Get issue
		String getIssueDetails = given().log().all().pathParam("issueId", "10101").
		queryParam("fields", "comment").filter(filter).
		when().get("/rest/api/2/issue/{issueId}").
		then().log().all().extract().response().asString();
		
		System.out.println("Issue Details: " + getIssueDetails);
		
		int numOfComments = StringToJsonParser.parseStringToJson(getIssueDetails).getInt("fields.comment.comments.size()");
		
		for(int i = 0; i < numOfComments; i++) {
			
			String issueCommentId = StringToJsonParser.parseStringToJson(getIssueDetails).get("fields.comment.comments[" + i + "].id").toString();
			
			if(commentId.equals(issueCommentId)) {
				String commentMessage = StringToJsonParser.parseStringToJson(getIssueDetails).get("fields.comment.comments[" + i + "].body").toString();
				System.out.println(commentMessage);
				Assert.assertEquals(commentMessage, expectedCommentMessage);
			}
			
		}
		
	}

}
