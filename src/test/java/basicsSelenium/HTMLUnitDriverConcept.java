package basicsSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitDriverConcept {

	public static void main(String[] args) throws InterruptedException {
		
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
//		WebDriver driver = new FirefoxDriver();
		
		//HtmlUnitDriver is not available in selenium 3.x version.
		//HtmlUnitDriver -- to use this concept, we have to download htmlunitdriver JAR file.
		
		//Advantages : 
		//1. testing is happening behind the scene -- no browser is launched.
		//2. Very fast -- execution of test cases -- very fast -- performance of the script.
		//3. Not suitable for Actions class -- user actions -- mousemovement,double click, drag and drop etc.,
		//4. Also called Ghost Driver - Headless Browser.
		
		WebDriver driver = new HtmlUnitDriver();
		driver.manage().window().maximize();
		driver.get("https://acme-test.uipath.com/login");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("n130547rguktn@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Hyder#584");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		
		
		
	}

}
