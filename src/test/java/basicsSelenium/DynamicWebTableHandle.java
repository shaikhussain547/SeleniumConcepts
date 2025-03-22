package basicsSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DynamicWebTableHandle {

	public static void main(String[] args) {
		
		WebDriver driver;
		driver = new ChromeDriver(new ChromeOptions());
		driver.manage().window().maximize();
		
		driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html#google_vignette");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement table = driver.findElement(By.id("customers"));
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", table);
		
		
		List<WebElement> headers = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
		
		for(WebElement header : headers) {
			System.out.print(header.getText()+"       ");
		}
		System.out.println();
		
		
		for(int i=2; i<=7;i++) {
			for(int j=1; j<=3;j++) {
				WebElement value = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+i+"]/td["+j+"]"));
				System.out.print(value.getText()+"       ");
			}
			System.out.println();
		}
		
		
		
	}

}
