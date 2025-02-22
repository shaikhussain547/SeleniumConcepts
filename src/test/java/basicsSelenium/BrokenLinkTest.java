package basicsSelenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		WebDriver driver;
		
		String FFKey = "webdriver.gecko.driver";
		String FFValue =  "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
//		driver.get("https://acme-test.uipath.com/login");
		driver.get("https://makemysushi.com/");
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//links -- //a
		//image -- //img
		
		//1. get the list of all the links and images:
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));
		System.out.println("Size of full links and images --> "+linksList.size());
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		//2. iterate linkslist : exclude all the links/images which doesn't have any href attribute
		for(int i=0; i<linksList.size(); i++) {
			System.out.println(linksList.get(i).getAttribute("href"));
			if(linksList.get(i).getAttribute("href") != null && ( ! linksList.get(i).getAttribute("href").contains("javascript"))) {
				activeLinks.add(linksList.get(i));
			}
		}
		
		//get the size of active links list:
		System.out.println("Size of active links and images --> "+activeLinks.size());
		
		//3. check the href url, with http connection api:
		for(int j=0; j<activeLinks.size(); j++) {

				HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
				connection.connect();
				String response = connection.getResponseMessage();	//ok
				connection.disconnect();
				System.out.println(activeLinks.get(j).getAttribute("href")+"  ---->  "+response);
	
		}
		
		
		
		
		
	}

}
