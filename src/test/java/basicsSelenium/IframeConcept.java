package basicsSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class IframeConcept {

	public static void main(String[] args) throws Exception {
		
		String FFKey = "webdriver.gecko.driver";
		String FFValue ="C:\\Users\\hussa\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		WebDriver driver = new FirefoxDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/");
		//"C:\Users\hussa\Downloads\geckodriver-v0.34.0-win64\geckodriver.exe"
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//li[@id='iFrame']")).click();
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='globalSqa']")));
		driver.findElement(By.xpath("/html/body/div/header/div[2]/div/div/div[2]")).click();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[@id='portfolio_filter']"))).build().perform();
		
		
		driver.switchTo().defaultContent();
		
		driver.quit();
	}

}
