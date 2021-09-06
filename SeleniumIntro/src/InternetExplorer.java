import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorer {

	public static void main(String[] args) {

		System.setProperty("webdriver.ie.driver", "D:\\Selenium\\browserDrivers\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		System.out.println("Title of current webpage is: " + driver.getTitle());
		System.out.println("URL of current webpage is: " + driver.getCurrentUrl());
		// driver.close();
	}

}
