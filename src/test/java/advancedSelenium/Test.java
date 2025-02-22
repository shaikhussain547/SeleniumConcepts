package advancedSelenium;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Test {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver;
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html#google_vignette");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement table = driver.findElement(By.xpath("//table[@id='customers']"));
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView()", table);
		
		//*[@id='customers']/tbody/tr[2]/td[3]
		
		for(int i=1; i<=3; i++) {
			System.out.print(driver.findElement(By.xpath("//*[@id='customers']/tbody/tr/th["+i+"]")).getText());
			System.out.print("  ");
		}
		System.out.println();
		
		for(int i=2; i<=7; i++) {
			for(int j=1; j<=3; j++) {
				System.out.print(driver.findElement(By.xpath("//*[@id='customers']/tbody/tr["+i+"]/td["+j+"]")).getText());
				System.out.print("  ");
			}
			System.out.println();
		}
		
		String input = "Adobe";
		String actual = "";
		
		for(int i=2; i<=7; i++) {
				actual = driver.findElement(By.xpath("//*[@id='customers']/tbody/tr["+i+"]/td[1]")).getText();
				if(actual.equals(input)) {
					System.out.println(driver.findElement(By.xpath("//*[@id='customers']/tbody/tr["+i+"]/td[3]")).getText());
				}
		}
		
		
	}

}
