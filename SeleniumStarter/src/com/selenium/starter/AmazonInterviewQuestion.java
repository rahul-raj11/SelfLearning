package com.selenium.starter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonInterviewQuestion {

	static WebDriver driver = null;

	public static void main(String[] args) {

		// WebDriver driver = null;

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\browserDrivers\\chromedriver.exe");

		driver = new ChromeDriver();

		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/");

		String[] listOfProducts = { "Cauliflower", "Cucumber", "Beetroot", "Brocolli" };

		// String genericStringXpath =
		// "//*[contains(text(),'%s')]//parent::div//div//button[contains(text(),'ADD TO CART')]";

		addItems(listOfProducts);
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		waitUntilVisible(By.xpath("//input[@class='promoCode']"));
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		
		waitUntilVisible(By.xpath("//div[@class='promoWrapper']//span[contains(text(),'Code applied')]"));
		System.out.println(driver.findElement(By.xpath("//div[@class='promoWrapper']//span[contains(text(),'Code applied')]")).getText());
	}

	public static void addIteamToCart(String genaricStringXpath, String iteam) {
		String finalXpathString = genaricStringXpath.replace("%s", iteam);
		driver.findElement(By.xpath(finalXpathString)).click();
	}
	
	public static void addItems(String[] listOfProducts) {
		
		int listSize = listOfProducts.length;
		
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));

		for (int i = 0; i < products.size(); i++) {

			String[] productName = products.get(i).getText().split("-");
			String product = productName[0].trim();

			List<String> list = Arrays.asList(listOfProducts);

			while (listSize > 0) {
				if (list.contains(product)) {
					driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
					// addIteamToCart(genericStringXpath, productName);
					// break;
					listSize--;
				}
			}
		}
	}
	
	public static void waitUntilVisible(By locator) {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
