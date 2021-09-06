package com.selenium.starter;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {

		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +  "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String rowsXpath = "//legend[text()='Web Table Example']/following-sibling::table//tr";
		String columnsXpath = "//legend[text()='Web Table Example']/following-sibling::table//tr[1]/th";
		
		int numberOfRows = getCount(rowsXpath, driver);
		int numberOfColumns = getCount(columnsXpath, driver);
		
		System.out.println("Number of rows in table: " + numberOfRows);
		
		System.out.println("Number of columns in table: " + numberOfColumns);
		
		List<WebElement> secondRowValues = driver.findElements(By.xpath("//legend[text()='Web Table Example']/following-sibling::table//tr[3]/td"));
		for (int i = 0; i < secondRowValues.size(); i++) {
			System.out.println(secondRowValues.get(i).getText());
		}
	}
	
	public static int getCount(String xpath, WebDriver driver) {
		List<WebElement> rows = driver.findElements(By.xpath(xpath));
		return rows.size();
	}

}
