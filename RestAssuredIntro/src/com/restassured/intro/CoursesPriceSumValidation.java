package com.restassured.intro;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restassured.files.Payload;
import com.restassured.files.ReusablesMethods;

import io.restassured.path.json.JsonPath;

public class CoursesPriceSumValidation {
	
	@Test
	public void sumOfCourses() {
		
		// Verify if Sum of all Course prices matches with Purchase Amount
		
		JsonPath jsonPath = ReusablesMethods.stringToJson(Payload.dummyResponse());
		//JsonPath jsonPath = new JsonPath(Payload.dummyResponse()); // Another way of writing
		int purchasedAmount = jsonPath.getInt("dashboard.purchaseAmount");
		System.out.println("Total purchased amount is " + purchasedAmount);
		
		int numOfCourses = jsonPath.getInt("courses.size()");
		System.out.println("Total number of courses available are " + numOfCourses);
		
		int totalAmount = 0;
		for(int i = 0; i < numOfCourses; i++) {
			
			int priceOfCourse = jsonPath.getInt("courses[" + i + "].price");
			int numOfCopies = jsonPath.getInt("courses[" + i + "].copies");
			
			totalAmount += priceOfCourse * numOfCopies;
		}
		
		System.out.println("Sum of all course price is " + totalAmount);
		
		Assert.assertEquals(totalAmount, purchasedAmount);
	}

}
