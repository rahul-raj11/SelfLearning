package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {
	
	//Pre-conditions annotation --- starting with @Before
	@BeforeSuite  //1
	public void setup() {
		System.out.println("setup system property for chrome");
	}
	
	@BeforeTest //2
	public void launchBrowser() {
		System.out.println("launch chrome browser");
	}
	
	@BeforeClass //3
	public void enterURL() {
		System.out.println("enter URL");
	}
	
	@BeforeMethod //4
	public void login( ) {
		System.out.println("login to app");
	}
	
	//test cases --- starting with @Test
	@Test //5
	public void googleTitleTest() {
		System.out.println("Google Title Test");
	}
	
	@Test //5
	public void searchTest() {
		System.out.println("Search Test");
	}

	//post conditions --- starting with @After
	@AfterMethod //6
	public void logOut() {
		System.out.println("logout from app");
	}
	
	@AfterClass //7
	public void closeBrowser() {
		System.out.println("Close browser");
	}
	
	@AfterTest //8
	public void deleteAllCookies() {
		System.out.println("deleteAllCookies");
	}
	
	@AfterSuite //9
	public void generateTestReport() {
		System.out.println("generate test report");
	}
}
