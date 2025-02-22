package basicsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LocatorsPart1 {
	
	WebDriver driver;
  @Test
  public void test() throws InterruptedException {
	  
	  String FFKey = "webdriver.gecko.driver";
	  String FFValue =  "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
	  System.setProperty(FFKey, FFValue);
	  driver = new FirefoxDriver(); //launch FF	
	  System.out.println("Firefox browser launchded ");
	  driver.manage().window().maximize();
	  driver.get("https://www.ebay.com/");
	  
	  driver.findElement(By.linkText("register")).click();
	  driver.findElement(By.xpath("//label[text()='Personal']")).click();
	  driver.findElement(By.id("firstname")).sendKeys("John");
	  driver.findElement(By.name("lastname")).sendKeys("Wick");
	  driver.findElement(By.id("Email")).sendKeys("hussainhyder584@gmail.com");
	  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Marvel#987");
	  
	  Thread.sleep(3000);
	  String RegForm = driver.findElement(By.xpath("//*[@id=\"EMAIL_REG_FORM_SUBMIT\"]")).getText();
	  System.out.println("RefFrom : "+RegForm);
		
	  if(RegForm.equals("Register")) {
		  System.out.println("Register button enabled");
//		  driver.findElement(By.xpath("//*[@id=\"businessaccount-radio\"]")).click();
	  }else {
		  System.out.println("Details are invalid");
	  }
	  
	  driver.quit();
	  
	  
  }
}

/* Locators : 1. xpath (Relative xpath)  (2)
 * 							Absolute xpath should not be used.
 * 					 2. id		(1)
 * 					 3. name	(3)
 * 					 4. LinkText : Only for links	(1)
 * 					 5. Partial LinkText : Not recommended
 * 					 6. CSS Selector :		(2)
 * 							Ex: cssselector :	#{id}, .{class}
 * 					 7. class : not recommended
 */
