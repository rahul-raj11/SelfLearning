package com.selenium.starter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = null;
		WebElement element1;

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\browserDrivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.navigate().to("https://www.spicejet.com/");

		element1 = driver.findElement(By.xpath(
				"//label[contains(text(),'Currency')]/parent::span/following-sibling::select[contains(@id,'DropDownListCurrency')]"));

		Select select = new Select(element1);
		select.selectByValue("AED");
		Thread.sleep(5000);
		select.selectByIndex(4);
		Thread.sleep(5000);
		select.selectByVisibleText("Select");
		Thread.sleep(5000);
	}

}
