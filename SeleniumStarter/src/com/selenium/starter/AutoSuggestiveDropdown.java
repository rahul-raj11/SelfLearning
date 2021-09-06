package com.selenium.starter;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = null;

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\browserDrivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.xpath("//b[text()='Country']/parent::legend/following-sibling::input[@id='autosuggest']"))
				.sendKeys("CA");
		// //b[text()='Country']/ancestor::form/following-sibling::ul//li//a[text()='%s']

		Thread.sleep(4000);

		List<WebElement> countries = driver
				.findElements(By.xpath("//b[text()='Country']/ancestor::form/following-sibling::ul//li//a"));

//		for(int i = 0; i < countries.size(); i++) {
//			
//			if(countries.get(i).getText().equalsIgnoreCase("CANADA")) {
//				countries.get(i).click();
//				break;
//			}
//		}

		for (WebElement country : countries) {

			if (country.getText().equalsIgnoreCase("CANADA")) {
				country.click();
				break;
			}
		}

	}

}
