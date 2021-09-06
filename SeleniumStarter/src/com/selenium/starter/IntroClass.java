package com.selenium.starter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IntroClass {

	public static void main(String[] args) {
		// Best practice to declare WebDriver as null
		WebDriver driver = null;
		
		// Before defining driver object first need to set property which will point to the driver files
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\browserDrivers\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\browserDrivers\\geckodriver.exe");
		//System.setProperty("webdriver.ie.driver", "D:\\Selenium\\browserDrivers\\IEDriverServer.exe");
		
		// Create Driver Object for Chrome browser(Since ChromeDriver implements WebDriver interface so it is best to use WebDriver)
		driver = new ChromeDriver();
		
		// For Firefox browser
		//driver = new FirefoxDriver();
		
		// For InternetExplorer browser
		//driver = new InternetExplorerDriver();
		
		// before launching browser it's always advised to maximize the window
		driver.manage().window().maximize();
		
		// get() method is used to navigate to the provided valid url
		//driver.get("https://www.google.com/");
		// we can also use navigate to the provided valid url, move forward, backward etc.
		driver.navigate().to("https://www.facebook.com/");
		
		// get the title of the page which is open
		System.out.println(driver.getTitle());
		
		// get current url
		System.out.println(driver.getCurrentUrl());
		
		// gets the page source code
		//System.out.println(driver.getPageSource());
		
		// interact with browser elements
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("abc@demo.com");
		driver.findElement(By.name("pass")).clear();
		driver.findElement(By.name("pass")).sendKeys("abc@demo.com");
		//driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();
		driver.findElement(By.linkText("Forgotten password?")).click();
		driver.navigate().back();
		
		driver.findElement(By.cssSelector("#email")).clear();
		driver.findElement(By.cssSelector("#email")).sendKeys("abc123@demo.com");
		driver.findElement(By.xpath("//input[@id='pass']")).clear();
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("abc123@demo.com");
		
		// Close the current browser instance
		//driver.close();
		
		// Closes all the open browser instance
		//driver.quit();
	}

}
