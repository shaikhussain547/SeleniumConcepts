package advancedSelenium;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryLogic {
	/*
	@Test(retryAnalyzer = RetryAnalyser.class)
	public void test1() {
		System.out.println("In Test-1 Method");
		Assert.assertTrue(false);
	}*/
	
	@Test
	public void test2() {
		System.out.println("In Test-2 Method");
		Assert.assertEquals(false, false);
		}
	
	@Test
	public void test3() {
		System.out.println("In Test-3 Method");
		Assert.assertEquals(true, false);
	}
	
	
	
	
	
}
