package com.restassuredapi.basic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.restassuredapi.payload.Payloads;
import com.restassuredapi.utility.StringToJsonParser;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers;

public class LibraryApi {
	
	
	
	@Test(dataProvider = "BooksData", priority = 1)
	public void addBook(String isbn, String aisle) {
		
		RestAssured.baseURI = "http://216.10.245.166";
		
		String postResponse = given().log().all().header("Content-Type", "application/json").body(Payloads.addBookPayload(isbn, aisle))
		.when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).body("Msg", Matchers.equalTo("successfully added")).extract().response().asString();
		
		JsonPath jsonPath = StringToJsonParser.parseStringToJson(postResponse);
		String id = jsonPath.get("ID");
		System.out.println("ID: " + id);
	}
	
	@Test(dataProvider = "BooksData", priority = 2)
	public void deleteBook(String isbn, String aisle) {
		
		RestAssured.baseURI = "http://216.10.245.166";
		
		given().log().all().header("Content-Type", "application/json").body(Payloads.deleteBookPayload(isbn + "" + aisle))
		.when().post("Library/DeleteBook.php")
		.then().log().all().assertThat().statusCode(200).body("msg", Matchers.equalTo("book is successfully deleted"));
		
	}
	
	
	@DataProvider(name = "BooksData")
	public Object[][] getData() {
		return new Object[][] {{"kslasx", "4646"},{"jgddls","48741"},{"hehieuwjd","75412"}};
	}

}
