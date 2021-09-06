//package stepDefinations;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import junit.framework.Assert;
//
//public class CreateContactStepDefination {
//	
//	WebDriver driver;
//	
//	
//	@SuppressWarnings("deprecation")
//	@Given("^user is already on home page$")
//	public void user_is_already_on_home_page() {
//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir") + "\\browserDrivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.get("https://ui.cogmento.com/");
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("sikriwal.rahulraj@gmail.com");
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123Admin");
//		driver.findElement(By.xpath("(//div[contains(text(),'Login')])[1]")).click();
//		String title = driver.getTitle();
//		System.out.println("Home Page: " + title);
//		Assert.assertEquals("Cogmento CRM", title);
//	}
//
//	@When("^user mouse hover on user icon$")
//	public void user_mouse_hover_on_user_icon() {
//		Actions actions = new Actions(driver);
//		actions.moveToElement(driver.findElement(By.xpath("//*[@class='users icon']"))).build().perform();
//	}
//
//	@Then("^user clicks on contacts link$")
//	public void user_clicks_on_contacts_link() {
//		driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
//		
//	}	@Then("^user enters firstname and lastname$")
//	public void user_enters_firstname_and_lastname() {
//		driver.findElement(By.xpath("//label[contains(text(),'First Name')]//following-sibling::div//input[@name='first_name']")).sendKeys("Rahul");
//		driver.findElement(By.xpath("//label[contains(text(),'Last Name')]//following-sibling::div//input[@name='last_name']")).sendKeys("Raj");
//	}
//
//	@Then("^user clicks on save button$")
//	public void user_clicks_on_save_button() {
//		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
//	}
//
//	@Then("^verify new contact created$")
//	public void verify_new_contact_created() {
//		Actions actions = new Actions(driver);
//		actions.moveToElement(driver.findElement(By.xpath("//*[@class='users icon']"))).build().perform();
//		driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
//		List<WebElement> ele = driver.findElements(By.xpath("//th[contains(text(),'Name')]//ancestor::table//tbody//tr//td//a"));
//		int size = ele.size();
//		
//		for(int i = 0; i < size; i++) {
//			String name = ele.get(i).getText();
//			if(name.equals("Rahul Raj")) {
//				System.out.println("Contact created successfully");
//				break;
//			}
//		}
//		driver.quit();
//		
//	}
//
//	@Then("^user clicks on create button on contact page$")
//	public void user_clicks_on_create_button_on_contact_page() throws InterruptedException {
//		driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
//		Thread.sleep(10000);
//	}
//
//
//
//}
