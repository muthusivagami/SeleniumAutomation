package HelperAttributes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
//invocation count > thread pool size and it will open three browsers two times
//invoation count is mandatory and default value is 0

public class HA_threadpoolsize {
	@Test(invocationCount=6,threadPoolSize=3)
	public void login() throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		Reporter.log("login done", true);
		Thread.sleep(2000);
		driver.quit();
	}
}
