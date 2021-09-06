package com.restassuredapi.basic;

import com.restassuredapi.payload.Payloads;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {

		JsonPath jsonPath = new JsonPath(Payloads.mockedResponse());
		
		// 1. Print No of courses returned by API
		int noOfCourses = jsonPath.getInt("courses.size()");
		System.out.println("Number Of Courses: " + noOfCourses);
		
		// 2.Print Purchase Amount
		int purchasedAmount = jsonPath.getInt("dashboard.purchaseAmount");
		System.out.println("Purchased Amount: " + purchasedAmount);
		
		// 3. Print Title of the first course
		String titleOfFirstCourse = jsonPath.getString("courses[0].title");
		System.out.println("Title Of First Course: " + titleOfFirstCourse);
		
		// 4. Print All course titles and their respective Prices
		for(int i = 0; i < noOfCourses; i++) {
			String titleOfCourse = jsonPath.getString("courses["+i+"].title");
			int priceOfCourse = jsonPath.getInt("courses["+i+"].price");
			
			System.out.println("Title of Course: " + titleOfCourse + " and price of course: " + priceOfCourse);
		}
		
		for (int i = 0; i < noOfCourses; i++) {

			// Print no of copies sold by RPA Course

			//if (jPath.get("courses[" + i + "].title").toString().equalsIgnoreCase("RPA")) {
			if (jsonPath.getString("courses[" + i + "].title").equalsIgnoreCase("RPA")) {
				System.out.println("Number of RPA course copies sold are " + jsonPath.get("courses[" + i + "].copies").toString());
				break;
			}
		}
	}

}
