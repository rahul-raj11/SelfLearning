package com.selenium.starter;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxAssignment {

	public static void main(String[] args) {

		WebDriver driver = null;

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\browserDrivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");

		// Check the first Checkbox and verify if it is successfully checked and Uncheck
		// it again to verify if it is successfully Unchecked
		driver.findElement(
				By.xpath("//legend[text()='Checkbox Example']/following-sibling::label//input[@id='checkBoxOption1']"))
				.click();
		System.out.println(driver
				.findElement(By.xpath(
						"//legend[text()='Checkbox Example']/following-sibling::label//input[@id='checkBoxOption1']"))
				.isSelected());

		Assert.assertTrue(driver
				.findElement(By.xpath(
						"//legend[text()='Checkbox Example']/following-sibling::label//input[@id='checkBoxOption1']"))
				.isSelected());

		driver.findElement(
				By.xpath("//legend[text()='Checkbox Example']/following-sibling::label//input[@id='checkBoxOption1']"))
				.click();
		System.out.println(driver
				.findElement(By.xpath(
						"//legend[text()='Checkbox Example']/following-sibling::label//input[@id='checkBoxOption1']"))
				.isSelected());

		Assert.assertFalse(driver
				.findElement(By.xpath(
						"//legend[text()='Checkbox Example']/following-sibling::label//input[@id='checkBoxOption1']"))
				.isSelected());

		// How to get the Count of number of check boxes present in the page
		List<WebElement> countCheckbox = driver.findElements(
				By.xpath("//legend[text()='Checkbox Example']/following-sibling::label//input[@type='checkbox']"));
		System.out.println("Count of checkbox is " + countCheckbox.size());
	}

}
