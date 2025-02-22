package basicsSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicWebTableHandle {

	public static void main(String[] args) {
		
		WebDriver driver;
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().window().maximize();
		driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
		
		//dynamic wait
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
		
		
		
	}

}
