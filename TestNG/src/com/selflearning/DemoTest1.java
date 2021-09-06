package com.selflearning;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoTest1 {
	
	@BeforeSuite
	public void beforeSuite1() {
		System.out.println("Before Suite1");
	}
	
	@BeforeClass
	public void beforeClass1() {
		System.out.println("Before Class1");
	}
	
	@BeforeTest
	public void beforeTest1() {
		System.out.println("Before Test1");
	}
	
	@BeforeMethod
	public void beforeMethod1() {
		System.out.println("Before Method1");
	}
	
	@Test
	public void test1DemoTest1() {
		System.out.println("@Test-- test1-----DemoTest1");
	}
	
	@Test
	public void test2DemoTest1() {
		System.out.println("@Test-- test2-----DemoTest1");
	}
	
	@Test
	public void test3DemoTest1() {
		System.out.println("@Test-- test3-----DemoTest1");
	}
	
	@AfterMethod
	public void afterMethod1() {
		System.out.println("After Method1");
	}
	
	@AfterTest
	public void afterTest1() {
		System.out.println("After Test1");
	}
	
	@AfterClass
	public void afterClass1() {
		System.out.println("After Class1");
	}
	
	@AfterSuite
	public void afterSuite1() {
		System.out.println("After Suite1");
	}

}
