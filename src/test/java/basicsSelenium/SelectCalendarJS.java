package basicsSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectCalendarJS {

	public static void main(String[] args) {
		
		String FFKey = "webdriver.gecko.driver";
		String FFValue ="C:\\Users\\hussa\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.switchTo().frame(0);
		
		WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
		String dateVal = "01/31/2024";
		selectDateByJS(date, dateVal, driver);
		System.out.println("Done");
		
	}
	
	public static void selectDateByJS(WebElement element, String dateVal, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
		
	}

}
