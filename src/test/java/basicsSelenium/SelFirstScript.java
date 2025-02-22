package basicsSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SelFirstScript {
	
	WebDriver driver;
	String browser ="firefox"; //chrome,edge,firefox
  @Test
  public void test() {
	  
	  
	if(browser.equals("firefox")) {
		//1. FF browser:
		String FFKey = "webdriver.gecko.driver";
		String FFValue =  "C:\\Users\\hussa\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		driver = new FirefoxDriver(); //launch FF	
		System.out.println("Firefox browser launchded ");
	}else if(browser.equals("chrome")) {
		//2. Chrome browser:
		String ChromeKey = "webdriver.chrome.driver";
		String ChromeValue = "";
		System.setProperty(ChromeKey, ChromeValue);
		driver = new ChromeDriver();
		System.out.println("Chrome browser launchded ");
	}else if(browser.equals("edge")) {
		//3. Edge browser:
		String edgeKey = "webdriver.edge.driver";
		String edgeValue = "";
		System.setProperty(edgeKey, edgeValue);	
		driver= new EdgeDriver();
		System.out.println("Egde browser launchded ");
	}

	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	
	//driver.quit();
  }
  
  
}

/*
 * 		Chrome		-->	webdriver.chrome.driver
 * 		Firefox	-->	webdriver.gecko.driver
 * 		Edge			-->	webdriver.edge.driver
 * 		Internet Explorer -->	webdriver.ie.driver
 * 		Opera		-->	webdriver.opera.driver
 */