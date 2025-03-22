package advancedSelenium;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer{
	
	int count = 1;
	int maxTry = 3;
	@Override
	public boolean retry(ITestResult result) {
		if(count < maxTry) {
			count++;
			return true;
		}
		return false;
	}
	
	
	
}
