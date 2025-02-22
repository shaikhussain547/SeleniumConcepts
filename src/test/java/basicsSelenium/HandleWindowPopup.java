package basicsSelenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleWindowPopup {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		driver = new ChromeDriver(new ChromeOptions());
		String url = "https://www.hackerrank.com/auth/login";
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[text()='Continue with Google']")).click();
		
		Set<String> handler = driver.getWindowHandles();
		
		Iterator<String> it = handler.iterator();
		
		String parentWindowId = it.next();
		System.out.println("parent window id:  "+parentWindowId);
		
		String childWindowId = it.next();
		System.out.println("child window id:  "+childWindowId);
		
		driver.switchTo().window(childWindowId);
		Thread.sleep(5000);
		driver.findElement(By.id("identifierId")).sendKeys("hussainshaik@gmail.com");
		System.out.println("child window popup title "+ driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		Thread.sleep(2000);
		System.out.println("parent window title : "+ driver.getTitle());
		
		
		
	}

}
