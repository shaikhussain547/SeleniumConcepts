package basicsSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardInteractions {

	public static void main(String[] args) {
		
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://globalsqa.com/angularJs-protractor/registration-login-example/#/login");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Actions action = new Actions(driver);
		//Keyboard based interactions::
		//KeyDown :- Pressing the key, KeyUp :- Releasing the key
		WebElement uname = driver.findElement(By.id("username"));
		action.moveToElement(uname).click().keyDown(Keys.SHIFT).sendKeys("John").build().perform();
//		action.keyDown(Keys.SHIFT).sendKeys("john").build().perform();
		
//		uname.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//		uname.sendKeys(Keys.DELETE);
		
		
		
	}

}
