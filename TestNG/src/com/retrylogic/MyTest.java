package com.retrylogic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest {
	
	//@Test(retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	@Test
	public void test1() {
		Assert.assertEquals(false, true);
	}
	
	//@Test(retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	@Test
	public void test2() {
		Assert.assertEquals(false, true);
	}

}
