package basicsSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) {
		
		WebDriver driver;
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//1. isDisplayed() method : applicable for all the elements
		boolean b1 = driver.findElement(By.name("websubmit")).isDisplayed(); //for SignUp button
		System.out.println(b1);
		
		//2. isEnabled() method :
		boolean b2 = driver.findElement(By.name("websubmit")).isEnabled();
		System.out.println(b2);
		
		//3. isSelected() method : only applicable for checkbox, dropdown, radiobutton.
		boolean b3 = driver.findElement(By.xpath("//input[@value='2']")).isSelected();
		if(b3) {
			System.out.println("b3 -- 1 :"+b3);
		} else {
			driver.findElement(By.xpath("//input[@value='2']")).click();
			b3 = driver.findElement(By.xpath("//input[@value='2']")).isSelected();
			System.out.println("b3 -- 2 :"+b3);
		}
		
	}

}
