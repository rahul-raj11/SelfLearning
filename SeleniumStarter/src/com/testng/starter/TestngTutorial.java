package com.testng.starter;

import org.testng.annotations.*;

public class TestngTutorial {
	
	@BeforeSuite
	public void demoBeforeSuite () {
		System.out.println("I will execute before suite...");
	}
	
	@BeforeTest
	public void demoBeforeTest () {
		System.out.println("I will execute before tests...");
	}
	
	@BeforeClass
	public void demoBeforeClass () {
		System.out.println("I will execute before class execution...");
	}
	
	@BeforeMethod
	public void demoBeforeMethod () {
		System.out.println("I will execute before all test execution...");
	}
	
	@Test(groups= {"smoke"})
	public void demoMethod () {
		System.out.println("Hello TestNg...");
	}
	
	@Test(timeOut = 4000)
	public void demoMethod1 () {
		System.out.println("Bye TestNg...");
	}
	
	@Test(dependsOnMethods = {"demoMethod5"})
	public void demoMethod2 () {
		System.out.println("Bye TestNg2...");
	}
	
	@Test(groups= {"smoke"})
	public void demoMethod3 () {
		System.out.println("Bye TestNg3...");
	}
	
	@Test(groups= {"smoke"}, enabled = false)
	public void demoMethod4 () {
		System.out.println("Bye TestNg4...");
	}
	
	@Test(dataProvider = "getData")
	public void demoMethod5 (String userName, String password) {
		System.out.println("Bye TestNg5...");
		System.out.println(userName + " " + password);
	}
	
	@Parameters({"URL"})
	@Test
	public void demoParamitarized (String urlName) {
		System.out.println("Demo parametarized method getting value from testng.xml for URL variable as " + urlName);
	}
	
	@AfterMethod
	public void demoAftereMethod () {
		System.out.println("I will execute after all test execution...");
	}
	
	@AfterTest
	public void demoAfterTest () {
		System.out.println("I will execute after tests...");
	}
	
	@AfterClass
	public void demoAfterClass () {
		System.out.println("I will execute after class execution...");
	}
	
	@AfterSuite
	public void demoAfterSuite () {
		System.out.println("I will execute after suite...");
	}
	
	@DataProvider
	public Object[][] getData () {
		Object[][] obj = new Object[3][2];
		obj[0][0] = "user1";
		obj[0][1] = "password1";
		obj[1][0] = "user2";
		obj[1][1] = "password2";
		obj[2][0] = "user3";
		obj[2][1] = "password3";
		return obj;
	}

}
