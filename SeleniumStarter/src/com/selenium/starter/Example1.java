package com.selenium.starter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;

public class Example1 {

	public static void main(String[] args) {

		WebDriver driver = null;
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\browserDrivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//driver.get("https://login.salesforce.com/?locale=in");
		driver.navigate().to("https://login.salesforce.com/?locale=in");
		
		// If we use class name with space then we will not able to identify the element
		//driver.findElement(By.className("input r4 wide mb16 mt8 username")).sendKeys("username1");
		driver.findElement(By.id("username")).sendKeys("username1");
		driver.findElement(By.name("pw")).sendKeys("password1");
		driver.findElement(By.xpath("//input[@id=\"Login\"]")).click();
		String errorMessage = driver.findElement(By.xpath("//div[@id='error']")).getText();
		System.out.println(errorMessage);
		
	}

}
