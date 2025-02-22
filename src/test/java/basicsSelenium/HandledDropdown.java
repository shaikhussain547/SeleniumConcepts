package basicsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HandledDropdown {

	public static void main(String[] args) {
		WebDriver driver;
		
		String FFKey = "webdriver.gecko.driver";
		String FFValue =  "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		
		//Handle a drop box:
//		Select select = new Select(driver.findElement(By.id("gh-cat")));
//		select.selectByVisibleText("Music");
		
		Select element = new Select(driver.findElement(By.id("gh-cat")));
		element.selectByIndex(2);
		
		
		
	}

}
