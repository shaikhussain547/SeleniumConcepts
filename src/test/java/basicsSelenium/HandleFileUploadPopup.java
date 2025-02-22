package basicsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleFileUploadPopup {

	public static void main(String[] args) {
		
		WebDriver driver;
		String FFKey = "webdriver.gecko.driver";
		String FFValue =  "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		driver = new FirefoxDriver(); //launch FF
		System.out.println("Firefox browser launchded ");
		driver.manage().window().maximize();
		driver.get("https://html.com/input-type-file/");
		driver.findElement(By.xpath("//*[@id='fileupload']")).sendKeys("C:\\Users\\hussa\\Downloads\\BikeReading.jpeg");
		//type = "file" should be present for Browse/AttachFile/UploadFile buttons.
		
		
	}

}
