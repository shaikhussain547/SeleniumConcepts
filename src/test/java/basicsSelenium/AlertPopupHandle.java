package basicsSelenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertPopupHandle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		String FFKey = "webdriver.gecko.driver";
		String FFValue =  "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		driver = new FirefoxDriver(); //launch FF
		System.out.println("Firefox browser launchded ");
		driver.manage().window().maximize();
		driver.get("https://www.rediff.com/");
		driver.findElement(By.linkText("Sign in")).click();
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
