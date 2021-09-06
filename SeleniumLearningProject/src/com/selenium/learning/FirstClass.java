package com.selenium.learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirstClass {

	public static void main(String[] args) {

		//To launch chrome browser
//		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\browserDrivers\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		//driver.get("https://www.google.com/");
//		driver.navigate().to("https://www.google.com/");
//		System.out.println(driver.getTitle());
//		if (!driver.equals(null)) {
//			driver.quit();
//		}
		//To launch chrome browser in incognito mode
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito");
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		options.merge(capabilities);
//		ChromeDriver driver = new ChromeDriver(options);		
//		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
//		driver.manage().window().maximize();
		
		//To launch firefox browser
//		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\browserDrivers\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
//		driver.manage().window().maximize();
//		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		
		//To launch firefox broser in private mode
//		FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("-private");
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("moz:firefoxOptions",options);
//        options.merge(capabilities);
//        WebDriver driver = new FirefoxDriver(options);
//        driver.manage().window().maximize();
//		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		
		
	}

}
