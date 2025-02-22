package basicsSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {

	public static void main(String[] args) throws InterruptedException {
		
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.flipkart.com/");
		Thread.sleep(5000);
		
		//Add-ons,SpiceClub
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Login"))).build().perform();
		driver.findElement(By.xpath("//li[text()='Orders']")).click();
		
//		actions.moveByOffset(point.getX(), point.getY()).build().perform();    --(Not worked)
//		actions.moveToElement(ele).build().perform();
//		actions.moveToElement(ele).click().build().perform();
//		actions.click(ele).build().perform();
		
		System.out.println("Execution completed");
		
	}

}
