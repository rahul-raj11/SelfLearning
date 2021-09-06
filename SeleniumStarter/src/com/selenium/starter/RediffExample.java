package com.selenium.starter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RediffExample {

	public static void main(String[] args) {

		WebDriver driver = null;
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\browserDrivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to("https://www.rediff.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		driver.findElement(By.cssSelector("input[id*='login']")).sendKeys("abcdefghi");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	}

}
