package basicsSelenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropertiesFile {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		
		FileInputStream ip = new FileInputStream("C:\\Users\\hussa\\eclipse-workspace\\SeleniumConcepts\\src\\test\\java\\basicsSelenium\\config.properties");
		
		prop.load(ip);
		
		System.out.println(prop.getProperty("name")); //Tom
		System.out.println(prop.getProperty("Age")); //null
		System.out.println(prop.getProperty("gender")); //null
		
		String url = prop.getProperty("URL");
		System.out.println(url); //https://www.google.com/
		
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals("firefox")) {
			
		
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		driver= new FirefoxDriver();
		
		}
		else if(browserName.equals("edge")) {
			
			String edgeKey = "webdriver.edge.driver";
			String edgeValue = "";
			System.setProperty(edgeKey, edgeValue);
			driver= new EdgeDriver();
			
		}
		
		driver.get(url);
		
		
	}

}
