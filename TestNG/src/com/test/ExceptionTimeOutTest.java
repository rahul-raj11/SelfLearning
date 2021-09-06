package com.test;

import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

public class ExceptionTimeOutTest {
	
	@Test(timeOut = 5000, expectedExceptions = ThreadTimeoutException.class)
	public void infiniteLoopTest() {
		int i = 1;
		while(i < 10) {
			System.out.println(i);
		}
	}

}
