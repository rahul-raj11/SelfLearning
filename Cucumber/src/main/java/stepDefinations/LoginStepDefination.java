package stepDefinations;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import junit.framework.Assert;

public class LoginStepDefination {
	
	WebDriver driver;
	
	@Given("^user is already on login page$")
	public void user_already_on_login_page() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://ui.cogmento.com/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@SuppressWarnings("deprecation")
	@When("^title of login page is Cogmento CRM$")
	public void title_of_login_page_is_cogmento_CRM() {
		String title = driver.getTitle();
		System.out.println(title);
		//Assert.assertEquals("Cogmento CRM", title);
		org.testng.Assert.assertEquals("Cogmento CRM", title);
	}
	
	// Regular Expression
	//1. \"([^\"]*)\"
	//2. \"(.*)\"
	
	//@Then("^user enters \"(.*)\" and \"(.*)\"$")
	@Then("^user enters username and password$")
	public void user_enters_username_and_password(DataTable credentials) {
		//List<List<String>> data = credentials.raw();
		for(Map<String, String> data : credentials.asMaps(String.class, String.class)) {
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(data.get("username"));
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(data.get("password"));
		}
		//driver.findElement(By.xpath("//input[@name='email']")).clear();
		//driver.findElement(By.xpath("//input[@name='email']")).sendKeys(data.get(0).get(0));
		
		//driver.findElement(By.xpath("//input[@name='password']")).clear();
		//driver.findElement(By.xpath("//input[@name='password']")).sendKeys(data.get(0).get(1));
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		//WebElement loginBtn = By.xpath("(//div[contains(text(),'Login')])[1]";
		driver.findElement(By.xpath("(//div[contains(text(),'Login')])[1]")).click();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("argument[0].click()", loginBtn);
	}

	@SuppressWarnings("deprecation")
	@Then("^user is on home page$")
	public void user_is_on_home_page() {
		String user = driver.findElement(By.xpath("//span[@class='user-display']")).getText();
		//Assert.assertEquals("rahul raj", user);
		org.testng.Assert.assertEquals("rahul raj", user);
		driver.quit();
	}

}
