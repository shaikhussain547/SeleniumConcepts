package basicsSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitConcept {

	public static void main(String[] args) {
		
		WebDriver driver;
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\OneDrive\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
	//	driver.findElement(By.linkText("Cart")).click();
	//	driver.findElement(By.className("cartTextSpan")).click();
		click(driver, driver.findElement(By.className("cartTextSpan")), Duration.ofSeconds(10));
		
		
		
	}
	
	public static void click(WebDriver driver, WebElement locator, Duration timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
	
	

}
