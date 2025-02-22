package basicsSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CustomXpathPart2 {
	
	WebDriver driver;
	
  @Test
  public void test() {
	  
	  String FFKey = "webdriver.gecko.driver";
	  String FFValue =  "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
	  System.setProperty(FFKey, FFValue);
	  driver = new FirefoxDriver(); //launch FF	
	  System.out.println("Firefox browser launchded ");
	  driver.manage().window().maximize();
	  
	  driver.get("https://www.snapdeal.com/");
		
	  //dynamic wait
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	  
	  
//		driver.findElement(By.xpath("//input[@class='col-xs-20 searchformInput keyword']")).sendKeys("Mobile");

//		driver.findElement(By.xpath("//input[@name='keyword']")).sendKeys("Mobile phone");

//		driver.findElement(By.xpath("//input[contains(@class,'col-xs-20 searchformInput keyword')]")).sendKeys("Mobile cover");
		
		//dynamic id:
		
		//starts-with
		//id = test_123
		//id = test_456
		//id = test_789
		//id = test_test_7890_test
		
		//ends-with
		//id = 1234_test_t
		//id = 23456_test_t
		//id = 6789_test_t
		
//		driver.findElement(By.xpath("//input[contains(@id,'test_')]"));
//		driver.findElement(By.xpath("//input[starts-with(@id,'test_')]"));
//		driver.findElement(By.xpath("//input[ends-with(@id,'_test_t')]"));
		
		//custom xpath for links:
		//all the links are represented by <a> html tag:
		driver.findElement(By.xpath("//a[contains(text(),'Impact@Snapdeal')]")).click();
		
		//Absolute xpath - not recommended
		//    "/html/body/div[2]/div[4]/div[2]/div/div[2]/input"
		//1. performance issue
		//2. not reliable
		//3. can be changed at any time in future	  
	  
  }
}
