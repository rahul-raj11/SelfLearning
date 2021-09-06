package com.test;

import org.testng.annotations.Test;

public class TestNgFeature {
	
	@Test
	public void loginTest() {
		System.out.println("login test");
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void homePageTest() {
		System.out.println("home page test");
	}
	
//	@Test
//	public void searchPageTest() {
//		System.out.println("search page test");
//	}

}
