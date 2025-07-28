package HelperAttributes;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
//when invocation count is 0, it will skip the particular testcase
public class HA_InvocationCount {
@Test(invocationCount=3)
public void login() throws InterruptedException{
	
		WebDriver driver = new ChromeDriver();
		Reporter.log("login done", true);
		Thread.sleep(2000);
		driver.quit();
}
}
