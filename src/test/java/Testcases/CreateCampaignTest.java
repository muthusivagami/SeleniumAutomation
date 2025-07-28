package Testcases;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import BaseClass.BaseClass;
import ExcelFileUtility.ExcelUtility;
import JavaUtility.JavaUtility;
import POM.CampaignPage;
import POM.HomePage;
import WebDriverUtility.WebdriverUtility;
@Listeners(ListenersUtility.ListenersImplementation.class)

public class CreateCampaignTest extends BaseClass{
	@Test(groups="Smoke")
//to avoid the alertpopup we are going with edgedriver, try with chromedriver and ignorepopup
	public void CreateCampaign() throws EncryptedDocumentException, IOException,
	InterruptedException {
	
	ExcelUtility eutil = new ExcelUtility();
	String campname = eutil.GetDatafromExcel("Campaign", 1, 2);
	String size = eutil.GetDatafromExcel("Campaign", 1, 3);
		
	WebdriverUtility wutil = new WebdriverUtility();
	
	
	JavaUtility jutil = new JavaUtility();
			HomePage hp = new HomePage(driver);
	hp.getCreatecampaign().click();
	
	
	//create campaign
			//driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
			//driver.findElement(By.name("campaignName")).sendKeys(campname + jutil.getRandomNumber());
			//driver.findElement(By.name("targetSize")).sendKeys(size); 

		//WebElement target = driver.findElement(By.name("targetSize"));
		//target.clear();
		//target.sendKeys(size);
		//driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		//Validation - for popup coming pause the source and check the xpath
	CampaignPage cp = new CampaignPage(driver);
	cp.getCampaignName().sendKeys(campname);
	cp.getTargetsizeTF().clear();
	cp.getTargetsizeTF().sendKeys(size);
	cp.getCreatecampaignsubmitBtn().click();
	Thread.sleep(2000);
	
		WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(toast));
		Thread.sleep(2000);
		wutil.WaitforVisibilityofElement(driver, toast);
		String msg = toast.getText();
		/*if(msg.contains(campname)) {
			System.out.println("Campaign is created");
		}
			else {
				System.out.println("campaign is not created");
			}*/
		Thread.sleep(5000);
		Assert.assertTrue(msg.contains(campname), "Campaign is not created");
		//logout
		
		//driver.findElement(By.xpath("//div[@role='alert']")).click();
		//driver.findElement(By.xpath("//button[@aria-label='close]")).click();
		//WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		//Actions act = new Actions(driver);
		//act.moveToElement(icon).click().perform();
		//wutil.mouseHoverOnWebElement(driver, icon);
		//WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
		
		//act.moveToElement(logout).click().perform();
		//wutil.clickonWebElement(driver, logout);
		//driver.findElement(By.xpath("//div[@role='alert']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@arialabel='close']")).click();
	
		hp.getUserIcon().click();
		hp.getLogoutBtn().click();
	}
}
	
	
		


	

