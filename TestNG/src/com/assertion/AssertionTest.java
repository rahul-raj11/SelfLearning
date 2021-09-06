package com.assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTest {

	SoftAssert softAssert = new SoftAssert ();
	
	@Test
	public void test1() {
		//SoftAssert softAssert = new SoftAssert ();
		
		System.out.println("Open Browser");
		Assert.assertEquals(true, true); // Hard assertion- next corresponding after the assert condition won't be executed and testcase will be marked as failed.
		
		System.out.println("enter username");
		System.out.println("enter password");
		
		System.out.println("click on sign-in button");
		Assert.assertEquals(true, true); // Hard assertion
		
		System.out.println("Validate Home Page");
		softAssert.assertEquals(false, true); // Soft assertion
		
		System.out.println("go to deal page");
		System.out.println("create a deal");
		
		softAssert.assertAll();
	}
	
}
