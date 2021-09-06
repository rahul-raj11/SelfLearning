package com.selenium.starter;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsOrTabs {

	public static void main(String[] args) {
		
		WebDriver driver = null;

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\browserDrivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/intl/en-GB/gmail/about/");
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Privacy")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> window = windows.iterator();
		String parentWindow = window.next();
//		String childWindow = null;
//		for(int i = 0; i < windows.size(); i++) {
		String childWindow = window.next();
		//}
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Visit your Google Account")).click();
		driver.close();
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());

	}
	
	public static void switchToWindows(WebDriver driver) {
		String parent = driver.getWindowHandle();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		while(itr.hasNext()) {
			String childWindow = itr.next();
			
			if(!parent.equals(childWindow)) {
				driver.switchTo().window(childWindow);
			}
		}
	}

}
