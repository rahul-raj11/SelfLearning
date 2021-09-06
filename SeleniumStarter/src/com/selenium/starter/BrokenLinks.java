package com.selenium.starter;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
//import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {

		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +  "\\browserDrivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String url = null;
		List<WebElement> footerLinks = driver.findElements(By.xpath("//div[@id='gf-BIG']//a"));
		SoftAssert softAssert = new SoftAssert();
		for (WebElement links: footerLinks) {
			url = links.getAttribute("href");
			System.out.println(url);
			HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int respCode = connection.getResponseCode();
			System.out.println(respCode);
			// Hard assert -- terminates the execution when condition fails
			//Assert.assertTrue(respCode < 400, "The broken link with link name " + links.getText() + " has response code " + respCode);
			// Soft assert -- does not terminates the execution when condition fails
			softAssert.assertTrue(respCode < 400, "The broken link with link name " + links.getText() + " has response code " + respCode);
//			if (respCode > 400) {
//				System.out.println("The broken link with link name " + links.getText() + " has response code " + respCode);
//				Assert.assertTrue(false);
//			}
		}
		softAssert.assertAll();
//		for (int i = 0; i < footerLinks.size(); i++) {
//			url = footerLinks.get(i).getAttribute("href");
//			System.out.println(url);
//			URL linkUrl = new URL(url);			
//			HttpURLConnection connection = (HttpURLConnection)linkUrl.openConnection();
//			connection.setRequestMethod("HEAD");
//			connection.connect();
//			int respCode = connection.getResponseCode();
//			System.out.println(respCode);
		
		HttpURLConnection con = (HttpURLConnection)new URL("").openConnection();
		con.setRequestMethod("HEAD");
		con.connect();
		int res = con.getResponseCode();
//		}
	}
}
