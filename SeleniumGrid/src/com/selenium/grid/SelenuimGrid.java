package com.selenium.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SelenuimGrid {
	
	public static void main(String[] args) throws MalformedURLException {
		
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +  "\\browserDrivers\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setBrowserName("Chrome");
		//capabilities.setCapability(ChromeDriver.builder(),System.getProperty("user.dir") +  "\\browserDrivers\\chromedriver.exe");
		capabilities.setPlatform(Platform.WINDOWS);
		
		URL url = new URL("http://10.115.160.154:4444/wd/hub");
		WebDriver driver = new RemoteWebDriver(url, capabilities);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	}

}
