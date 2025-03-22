package generateLogs;

import java.time.Duration;

//import org.apache.log4j.Logger;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLogs4jxml {
	
	WebDriver driver;
	Logger log = LogManager.getLogger("TestLogs4jxml");
//	Logger log = Logger.getLogger("TestLogs4jxml");

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		log.info("Chrome");
		driver.manage().window().maximize();
		driver.get("https://acme-test.uipath.com/login");
		log.info("Applciation opened");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test
	public void verifyLoginPage() {
		WebElement header = driver.findElement(By.xpath("//h1[@class='page-header']"));
		String headText = header.getText().trim();
		log.info("Validating Header");
		Assert.assertEquals(headText, "Login");
		delayTwoSec();	
	}
	
	@AfterTest
	public void tearDown() {
		log.info("Closing Browser");
		driver.quit();
	}
	
	public void delayTwoSec() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
