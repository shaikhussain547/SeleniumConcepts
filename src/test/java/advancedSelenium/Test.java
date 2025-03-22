package advancedSelenium;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Test {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver;
		EdgeOptions op = new EdgeOptions();
		driver = new EdgeDriver(op);
		driver.manage().window().maximize();
		
		driver.get("https://www.hackerrank.com/auth/login");
		
		
		
		Thread.sleep(3000);
		
		
		
		//driver.quit();
		
		System.out.println("Completed");
		
		
		
		
		
		
		
		
	}

}
