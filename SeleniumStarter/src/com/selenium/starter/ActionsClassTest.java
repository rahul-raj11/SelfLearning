package com.selenium.starter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassTest {

	public static void main(String[] args) {

		WebDriver driver = null;

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\browserDrivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.amazon.com/");
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.chord(Keys.CONTROL, "a"));

		// moveToElement(driver, driver.findElement(By.id("twotabsearchtextbox"))).c
		Actions action = new Actions(driver);
		// sometimes doubleClick() also selects all the text available in text box
		action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.chord(Keys.SHIFT, "a"))
				.sendKeys("hello").doubleClick().build().perform();

		// Selecting all entered text by Keys.chord() by using sendKeys()
//		String selectAll = Keys.chord(Keys.CONTROL, "a");
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(selectAll);

		// moveToElement(driver,
		// driver.findElement(By.xpath("//a[@id='nav-link-accountList']")));
		// contextClick() is used to perform right click action
		action.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).contextClick().build()
				.perform();
	}

	// Move to element
	public static void moveToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

}
