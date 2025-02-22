package basicsSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BootstrapDropdownBox {

	public static void main(String[] args) {
		
		WebDriver driver;
		String FFKey = "webdriver.gecko.driver";
		String FFValue =  "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		String url = "https://getbootstrap.com/docs/4.0/components/dropdowns/";
		driver.get(url);
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.id("dropdownMenuButton")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='dropdown-menu show']//a"));
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().equals("Another action")) {
				list.get(i).click();
				break;
			}
		}
		
		
/*		WebDriver driver;
		driver = new ChromeDriver(new ChromeOptions());
		String url = "https://practice.expandtesting.com/dropdown#google_vignette";
		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		Thread.sleep(2000);
		
		WebElement dropdown = driver.findElement(By.id("dropdown"));
		
		Select select = new Select(dropdown);
		select.selectByVisibleText("Option 2");
		Thread.sleep(2000);
		select.selectByValue("1");
		Thread.sleep(2000);
		

		dropdown =  driver.findElement(By.id("country"));
		select = new Select(dropdown);
		select.selectByVisibleText("Antarctica");
		Thread.sleep(2000);
		select.selectByValue("IN");	*/
	}

}
