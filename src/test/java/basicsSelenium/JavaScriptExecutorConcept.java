package basicsSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		String FFKey = "webdriver.gecko.driver";
		String FFValue = "C:\\Users\\hussa\\Documents\\SDET\\Selenium\\Driver\\geckodriver.exe";
		System.setProperty(FFKey, FFValue);
		driver= new FirefoxDriver();
//		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login/");
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//executeScript -- to execute JavaScript code
		
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"loginbutton\"]"));
		flash(loginBtn, driver);
		drawBorder(loginBtn, driver);
//		generateAlert(driver,"There is an issue with login button on the login page");//alert popup will come with defined message.
		clickEleByJS(loginBtn, driver);
		refreshBrowserByJS(driver);
		Thread.sleep(3000);
		System.out.println(geTitleByJS(driver));
		System.out.println(getPageInnerTextByJS(driver));
//		scrollPageDownByJS(driver);
		WebElement element = driver.findElement(By.linkText("Sign up for Facebook"));
		scrollIntoViewByJS(element,driver);
	}
	
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0; i<5; i++) {
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgcolor, element, driver);
		//	System.out.println(" i : "+ i);
		}
	}
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js =  ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = ' "+color+" ' ", element);
		
		try {
			Thread.sleep(20);
		} catch(InterruptedException e) {
		}
	}
	
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickEleByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
	}
	
	public static String geTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static String getPageInnerTextByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	
	//Full Scroll down to bottom of the page:
	public static void scrollPageDownByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	//Scroll into view
	public static void scrollIntoViewByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	//	js.executeScript("arguments[0].scrollIntoView();",element);  Both statements are working fine.
		
	}
	

}
