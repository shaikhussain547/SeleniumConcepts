package basicsSelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertPopupHandle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		driver = new ChromeDriver(new ChromeOptions());
		driver.manage().window().maximize();
		
		driver.get("https://www.rediff.com/");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("proceed")).click();
		Thread.sleep(5000);
		
		//Screen switch from one screen to popup screen
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		if(text.equals("Please enter a valid user name")) {
			System.out.println("correct alert message");
		}else {
			System.out.println("incorrect alert message");
		}
		alert.accept(); //click on ok button
//		alert.dismiss(); //to click on cancel button
		
		
		
	}

}
