package com.selenium.starter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class E2ESpicejetTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = null;

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\browserDrivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.navigate().to("https://www.spicejet.com/");

		Thread.sleep(10000);

		driver.findElement(By.xpath("//label[contains(text(),'Family and Friends')]/parent::div//input")).click();

		driver.findElement(By.xpath("//label[text()='Round Trip']/parent::td//input[@value='RoundTrip']")).click();

		Thread.sleep(7000);
		driver.findElement(By.xpath("//label[contains(text(),'FROM')]/parent::div/following-sibling::input")).click();

		Thread.sleep(7000);
		driver.findElement(By.xpath(
				"//label[contains(text(),'FROM')]/parent::div//following-sibling::div//table//td[@class='mapbg']//ul//a[contains(text(),'Bengaluru (BLR)')]"))
				.click();

		Thread.sleep(7000);
		driver.findElement(By.xpath(
				"//label[contains(text(),'TO')]/parent::div//following-sibling::div//table//td[@class='mapbg']//ul//a[contains(text(),'Chennai (MAA)')]"))
				.click();

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

		Thread.sleep(7000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.id("divpaxinfo")));
		Thread.sleep(7000);

		Select numberOfAdults = new Select(driver.findElement(By.xpath(
				"//label[contains(text(),'Adult')]/ancestor::div/following-sibling::div//select[contains(@id,'Adult')]")));

		numberOfAdults.selectByValue("5");

		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

	}

}
