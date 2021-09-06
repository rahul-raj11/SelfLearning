package com.selenium.starter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLCertificates {

	public static void main(String[] args) {

		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +  "\\browserDrivers\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//capabilities.setAcceptInsecureCerts(true);
		capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		//capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		//capabilities.acceptInsecureCerts();
		options.merge(capabilities);
		
		driver = new ChromeDriver(options);
		driver.get("https://self-signed.badssl.com/");
	}

}
