package generateLogs;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	WebDriver driver;
	Logger log = Logger.getLogger(LoginTest.class);
	
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		log.info("launching chrome browser");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://acme-test.uipath.com/login");
		log.info("entering into application url");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test(priority=1)
	public void verifyTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		log.info("login page title is : "+title);
		Assert.assertEquals(title, "ACME System 1 - Log In","Home Page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUsernameLable() {
		WebElement usernameLable = driver.findElement(By.xpath("//h1//strong"));
		System.out.println(usernameLable);
		Assert.assertTrue(usernameLable.isDisplayed());
		if(usernameLable.isDisplayed()){
			log.info("Username found");
		}else {
			log.error("Username mismatch");
		}
		
	}
	
	
	@AfterMethod
	public void tearDown() {
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
