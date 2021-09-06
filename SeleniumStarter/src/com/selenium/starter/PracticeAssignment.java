package com.selenium.starter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PracticeAssignment {

	public static void main(String[] args) {
		WebDriver driver = null;

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\browserDrivers\\chromedriver.exe");

		driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");

		String checkBox = "//legend[text()='Checkbox Example']/following-sibling::label//input[@id='checkBoxOption2']";
		String checkBoxLabel = "//legend[text()='Checkbox Example']/following-sibling::label[@for='benz']";
		String dropdownByID = "dropdown-class-example";
		String textBoxId = "name";
		String alertButton = "alertbtn";

		clickElement(getElementByXpath(driver, checkBox));

		String textOption = getText(getElementByXpath(driver, checkBoxLabel));

		selectOptionByValue(getElementById(driver, dropdownByID), textOption);

		enterText(getElementById(driver, textBoxId), textOption);

		clickElement(getElementById(driver, alertButton));

		swithchToJavaAlert(driver);

		if (getJavaAlertText(driver).contains(textOption)) {
			System.out.println("Alert message contains text: " + textOption);
			acceptJavaAlert(driver);
		} else {
			System.out.println("Alert message does not contains text: " + textOption);
		}
	}

	public static WebElement getElementById(WebDriver driver, String id) {
		return driver.findElement(By.id(id));
	}

	public static WebElement getElementByXpath(WebDriver driver, String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public static void clickElement(WebElement element) {
		element.click();
	}

	public static String getText(WebElement element) {
		return element.getText();
	}

	public static void selectOptionByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public static void enterText(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static Alert swithchToJavaAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}

	public static String getJavaAlertText(WebDriver driver) {
		return swithchToJavaAlert(driver).getText();
	}

	public static void acceptJavaAlert(WebDriver driver) {
		swithchToJavaAlert(driver).accept();
		
	}

}
