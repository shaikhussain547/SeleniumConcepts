package InterviewQues;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SortedDropdown {

	public static void main(String[] args) {
		
		WebDriver driver;
		driver = new ChromeDriver(new ChromeOptions());
		driver.manage().window().maximize();
		
		driver.get("https://practice.expandtesting.com/dropdown");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement dropdown = driver.findElement(By.id("country")); 
		
		Select select = new Select(dropdown);
		
		List<WebElement> options = select.getOptions();
		
		List<String> dropdownValues = new ArrayList<String>();
		
		for(WebElement option : options) {
			dropdownValues.add(option.getText().trim());
		}
		
		dropdownValues.remove("Select country");
		
		// Clone the list and sort it
        List<String> sortedValues = new ArrayList<>(dropdownValues);
		Collections.sort(sortedValues);
		
		if(dropdownValues.equals(sortedValues)) {
			System.out.println("Dropdown values are sorted in ascending order.");
        } else {
            System.out.println("Dropdown values are NOT sorted.");
        }
		
		for(String value : sortedValues) {
			System.out.print(value+"  , ");
		}
		System.out.println();
		System.out.println();
		for(String value : dropdownValues) {
			System.out.print(value+"  , ");
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
