package com.selenium.starter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = null;
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\browserDrivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to("https://www.spicejet.com/");
		
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
		
	}

}
