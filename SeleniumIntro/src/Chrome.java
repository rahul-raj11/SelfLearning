import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome {

	public static void main(String[] args) {

		// Provide chrome driver file path
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\browserDrivers\\chromedriver.exe");
		// Create object of Chrome driver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.facebook.com/");
		System.out.println("Title of current webpage is: " + driver.getTitle());
//		driver.get("https://yahoo.com");
//		driver.navigate().back();
//		driver.navigate().forward();
		driver.findElement(By.xpath("//form[@id='login_form']//table//td//input[@id='email']"))
				.sendKeys("jsmith@gmail.com");
		driver.findElement(By.xpath("//form[@id='login_form']//table//td//input[@id='pass']")).sendKeys("abcd");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		// driver.quit();
		// driver.close();
	}

}
