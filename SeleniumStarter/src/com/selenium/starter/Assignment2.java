package com.selenium.starter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) {

		WebDriver driver = null;

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\browserDrivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.navigate().to("https://www.cleartrip.com/");

		selectDropdownValue(driver.findElement(By.id("Adults")), "4");

		selectDropdownValue(driver.findElement(By.id("Childrens")), "3");

		driver.findElement(By.xpath("//input[@id='DepartDate']")).click();

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active ")).click();

		driver.findElement(By.linkText("More options: Class of travel, Airline preference")).click();

		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("indigo");

		driver.findElement(By.id("SearchBtn")).click();

		System.out.println(driver.findElement(By.xpath("//div[@id='homeErrorMessage']")).getText());

	}

	public static void selectDropdownValue(WebElement element, String value) {
		Select adults = new Select(element);
		adults.selectByVisibleText(value);
	}

}
