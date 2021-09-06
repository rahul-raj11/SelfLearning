package com.parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	
	WebDriver driver;
	
	@Test
	@Parameters({"url", "uname", "pascode"})
	public void yohooLoginTest(String url, String uname, String pascode) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\browserDrivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("login-username")).clear();
		driver.findElement(By.id("login-username")).sendKeys(uname);
		driver.findElement(By.id("login-signin")).click();
		driver.findElement(By.xpath("//input[contains(@id,'verification-code')]")).clear();
		driver.findElement(By.xpath("//input[contains(@id,'verification-code')]")).sendKeys(pascode);
		driver.findElement(By.id("verify-code-button")).click();
	}

}
