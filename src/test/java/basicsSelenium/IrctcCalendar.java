package basicsSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IrctcCalendar {

	public static void main(String[] args) {
		WebDriver driver;
		String FFKey = "webdriver.gecko.driver";
		String FFValue ="C:\\Users\\hussa\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		WebElement jDate = driver.findElement(By.xpath("//*[@id='jDate']/span/input"));
		jDate.click();
		sleep();
		String Curr_date = "20";
		String Curr_month = "June";
		String Curr_year = "2024";

		while(true) {
			WebElement Month = driver.findElement(By.xpath("//*[@id='jDate']/span/div/div/div[1]/div/span[1]"));
			WebElement Year = driver.findElement(By.xpath("//*[@id='jDate']/span/div/div/div[1]/div/span[2]"));
			if(Month.getText().equals(Curr_month) && Year.getText().equals(Curr_year)){
				break;
			}else {
				WebElement Right = driver.findElement(By.xpath("//*[@id='jDate']/span/div/div/div[1]/a[2]/span"));
				WebElement Left = driver.findElement(By.xpath("//*[@id='jDate']/span/div/div/div[1]/a[1]/span"));
				Right.click();
				sleep();
			}
		}
		List<WebElement> date = driver.findElements(By.xpath("//*[@id='jDate']/span/div/div/div[2]/table/tbody/tr/td/a"));
		System.out.println(date.size());
		for(int i=0; i <= date.size(); i++) {
			System.out.println(date.get(i).getText());
			if(date.get(i).getText().equals(Curr_date)) {
				date.get(i).click();
				break;
			}
		}
		
		System.out.println("Completed");
			
	}
	
	public static void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
