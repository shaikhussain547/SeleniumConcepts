package basicsSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleNotifications {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	//	options.setAcceptInsecureCerts(true); //To accept SSL Certificates.
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.justdial.com/");
		Thread.sleep(5000);
		driver.quit();
		
	}

}
