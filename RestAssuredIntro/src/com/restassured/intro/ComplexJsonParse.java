package com.restassured.intro;

import com.restassured.files.Payload;
import com.restassured.files.ReusablesMethods;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {

		// JsonPath jPath = ReusablesMethods.stringToJson(Payload.dummyResponse());
		JsonPath jPath = new JsonPath(Payload.dummyResponse());

		// Print No of courses returned by API
		int noOfCourses = jPath.getInt("courses.size()");
		System.out.println(noOfCourses);

		// Print Purchase Amount
		int purchaseAmount = jPath.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);

		// Print Title of the first course
		String firstCourseTitle = jPath.get("courses[0].title");
		System.out.println(firstCourseTitle);

		// Print All course titles and their respective Prices

		for (int i = 0; i < noOfCourses; i++) {
			// String courseTitle = jPath.getString("courses[" + i + "].title");
			// int coursePrice = jPath.getInt("courses[" + i + "].price");
			// System.out.println("Course title is " + courseTitle + " and their respective
			// price is " + coursePrice);

			String courseTitle = jPath.get("courses[" + i + "].title");
			System.out.println(courseTitle);
			System.out.println(jPath.get("courses[" + i + "].price").toString());
		}

		for (int i = 0; i < noOfCourses; i++) {

			// Print no of copies sold by RPA Course

			//if (jPath.get("courses[" + i + "].title").toString().equalsIgnoreCase("RPA")) {
			if (jPath.getString("courses[" + i + "].title").equalsIgnoreCase("RPA")) {
				System.out.println("Number of RPA course copies sold are " + jPath.get("courses[" + i + "].copies").toString());
				break;
			}
		}
	}

}
