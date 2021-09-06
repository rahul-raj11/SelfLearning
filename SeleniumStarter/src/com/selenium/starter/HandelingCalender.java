package com.selenium.starter;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandelingCalender {

	static WebDriver driver = null;
	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.path2usa.com/travel-companions");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='travel_date']")).click();
		String date = "//*[@class='day' and contains(text(),'%s')]";
		//String month = "//div[@class='datepicker-days']//th[@class='datepicker-switch' and contains(text(), '%s')";
		
		// Select the month from calendar
		while (!driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']")).getText().contains("June")) {
			driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next']")).click();
		}
		
		convertStringToXpath(date, driver, "17").click();
		
		// Select the date from calendar
//		List<WebElement> dates = driver.findElements(By.xpath("//*[@class='day']"));
//		
//		for (int i = 0; i < dates.size(); i++) {
//			String text = driver.findElements(By.xpath("//*[@class='day']")).get(i).getText();
//			if (text.equalsIgnoreCase("23")) {
//				driver.findElements(By.xpath("//*[@class='day']")).get(i).click();
//				break;
//			}
//		}
	}
	
	
	public static WebElement convertStringToXpath(String s, WebDriver driver, String dateValue) {
		String replacedString = s.replace("%s", dateValue);
		
		return driver.findElement(By.xpath(replacedString));
	}

}
