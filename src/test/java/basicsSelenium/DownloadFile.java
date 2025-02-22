package basicsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadFile {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.tutorialspoint.com/selenium/practice/upload-download.php");
		Thread.sleep(5000);
		
		driver.findElement(By.id("downloadButton")).click();
		Thread.sleep(5000);
		
		
		
		driver.quit();

	}

}
