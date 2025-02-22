package basicsSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BootstrapDropBoxHandle {

	public static void main(String[] args) {
		
		WebDriver driver;
		String FFKey = "webdriver.gecko.driver";
		String FFValue =  "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		String url = "https://www.jquery-az.com/boots/demo.php?ex=63.0_2";
		driver.get(url);
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		//button[@class='multiselect dropdown-toggle btn btn-default']
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//li//a//label"));
		System.out.println(list.size());
		//Selecting all the checkboxes/options  and Angular option :
		for(int i=0; i<list.size(); i++) {
			list.get(i).click();
			if(list.get(i).getText().contains("Angular")) {
				list.get(i).click();
				break;
			}
		}
		
		/*		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//label[@class='checkbox']"));
		System.out.println(checkboxes.size());
		for(int i=0; i<checkboxes.size();i++) {
			String text = checkboxes.get(i).getText();
			System.out.println(text);
			try {
				WebElement element = driver.findElement(By.xpath("//li[@class='active']//a//label//input[@value='"+text+"']"));
				if(element.isSelected()) {
					System.out.println(text+" : Already checked");
					continue;
				}
			}catch(Exception e) {
				
			}
			checkboxes.get(i).click();
		}
		
	*/
		
		
	}

}
