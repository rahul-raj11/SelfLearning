package com.selenium.starter;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeSample {

	public static void main(String[] args) {
		WebDriver driver = null;

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\browserDrivers\\chromedriver.exe");

		driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");

		// Get the count of links present in a webpage
		System.out.println("Count of links present in webpage: " + driver.findElements(By.tagName("a")).size());

		// Get the count of links present in a webpage for footer section
		System.out.println("Count of links present in webpage footer section: "
				+ driver.findElements(By.xpath("//div[@id='gf-BIG']//a")).size());

		// Get the count of links present in a webpage for one part of the footer
		// section
		System.out.println("Count of links present in webpage for one of the part of footer section: "
				+ driver.findElements(By.xpath("//div[@id='gf-BIG']//table//td[1]//a")).size());

		String parent = driver.getWindowHandle();

		for (int i = 1; i < driver.findElements(By.xpath("//div[@id='gf-BIG']//table//td[1]//a")).size(); i++) {
//			driver.findElements(By.xpath("//div[@id='gf-BIG']//table//td[1]//a")).get(i).click();
//			System.out.println(driver.getTitle());
//			driver.navigate().back();

			// Improvised way of clicking on multiple links
			String clickOnLinks = Keys.chord(Keys.CONTROL, Keys.ENTER);
			driver.findElements(By.xpath("//div[@id='gf-BIG']//table//td[1]//a")).get(i).sendKeys(clickOnLinks);
			windowHandels(driver, parent);
		}
	}

	public static void windowHandels(WebDriver driver, String parent) {
		// Window handling
		// String parent = driver.getWindowHandle();
		Set<String> childWindows = driver.getWindowHandles();
		Iterator<String> itr = childWindows.iterator();
		while (itr.hasNext()) {
			String child = itr.next();
			driver.switchTo().window(child);
			System.out.println("Title of webpage: " + driver.getTitle());
			// driver.close();
		}
		driver.switchTo().window(parent);
//					System.out.println("Title of webpage: " + driver.getTitle());
	}

}
