package com.selenium.starter;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//TestNG(NG stands New Generation) is one of the testing framework

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = null;
		WebElement element1;

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\browserDrivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		// driver.navigate().to("https://www.spicejet.com/");
		driver.get("https://www.spicejet.com/");

		Thread.sleep(10000);

		// Check Box
		Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'Senior Citizen')]/parent::div//input"))
				.isSelected());

		System.out.println(driver.findElement(By.xpath("//label[contains(text(),'Senior Citizen')]/parent::div//input"))
				.isSelected());
		driver.findElement(By.xpath("//label[contains(text(),'Senior Citizen')]/parent::div//input")).click();
		System.out.println(driver.findElement(By.xpath("//label[contains(text(),'Senior Citizen')]/parent::div//input"))
				.isSelected());

		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Senior Citizen')]/parent::div//input"))
				.isSelected());

		List<WebElement> chekboxes = driver.findElements(By.xpath("//div[@id='discount-checkbox']//div//input"));
		System.out.println(chekboxes.size());

		// Assert.assertEquals(chekboxes.size(), 5);

		// System.out.println(driver.findElement(By.xpath("//div[contains(@style,'display:
		// block; opacity: 0.5;')]")).isEnabled());

		driver.findElement(By.xpath("//label[text()='Round Trip']/parent::td//input[@value='RoundTrip']")).click();
		System.out.println(
				driver.findElement(By.xpath("//label[text()='Round Trip']/parent::td//input[@value='RoundTrip']"))
						.isSelected());

		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("Is enabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		// System.out.println(driver.findElement(By.xpath("//div[contains(@style,'display:
		// block; opacity: 1;')]")).isEnabled());

		element1 = driver.findElement(By.id("divpaxinfo"));
		// driver.findElement(By.xpath("//label[contains(text(),'PASSENGERS')]/following-sibling::div[@id='divpaxinfo']"));
		// element1.click();
		Thread.sleep(5000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element1);
		// driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(4000);

	}

}
