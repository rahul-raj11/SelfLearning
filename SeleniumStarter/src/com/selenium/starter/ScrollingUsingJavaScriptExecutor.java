package com.selenium.starter;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollingUsingJavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +  "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(5000);
		
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=500");
		
		List<WebElement> values = driver.findElements(By.xpath("//th[contains(text(),'Amount')]/ancestor::table[@id='product']//td[4]"));
		int sum = 0;
		
		for (int i = 0; i < values.size(); i++) {
			
			sum += Integer.parseInt(values.get(i).getText());
		}
		
		System.out.println("Sum of values: " + sum);
		
		int totalAmount = Integer.parseInt(driver.findElement(By.xpath("//*[@class='totalAmount']")).getText().split(":")[1].trim());
		
		Assert.assertEquals(sum, totalAmount);
		
//		if (sum == totalAmount) {
//			System.out.println("Summed total is equal to total amount...");
//		}
	}

}
