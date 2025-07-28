package Testcases;

import java.io.IOException;


import java.time.Duration;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ExcelFileUtility.ExcelUtility;
import JavaUtility.JavaUtility;
import POM.CampaignPage;
import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesUtility;
import WebDriverUtility.WebdriverUtility;
@Listeners(ListenersUtility.ListenersImplementation.class)
public class CreateCompaignStatusTest extends BaseClass{
@Test(groups="Regression")
	public void CreateCampaighStatus() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebdriverUtility wutil=new WebdriverUtility();
		ExcelUtility eutil = new ExcelUtility();
		String campname = eutil.GetDatafromExcel("Campaign", 1, 2);
		String size = eutil.GetDatafromExcel("Campaign", 1, 3);
		String status = eutil.GetDatafromExcel("Campaign", 1, 4);
			
		
		HomePage hp= new HomePage(driver);
		hp.getCampaign().click();
		hp.getCreatecampaign().click();
		
		JavaUtility jutil = new JavaUtility();
		int ran=jutil.getRandomNumber();
		String CampaignName = campname;
		//Random ran = new Random();
		//int ranacnt = ran.nextInt(1000);
		CampaignPage cp = new CampaignPage(driver);
		
		//driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		//wutil.WaitforPageload(driver);
		//driver.findElement(By.name("campaignName")).sendKeys(campname+jutil.getRandomNumber());
		cp.getCampaignName().sendKeys(campname);
		//WebElement target = driver.findElement(By.name("targetSize"));
		//target.clear();
		//target.sendKeys(size);
		cp.getTargetsizeTF().clear();
		cp.getTargetsizeTF().sendKeys(size);
		//driver.findElement(By.name("campaignStatus")).sendKeys("Ongoing");
		cp.getCampaignstatus().sendKeys("Ongoing");
		cp.getCreatecampaignsubmitBtn().click();
		Thread.sleep(2000);
		WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(toast));
		//wutil.WaitforVisibilityofElement(driver, toast);
		Thread.sleep(2000);
		String msg = toast.getText();
		Thread.sleep(5000);
		Assert.assertEquals(msg,"Campaign"+" " +CampaignName+" "+"Successfully Added");
		Assert.assertTrue(msg.contains(campname));
		Thread.sleep(2000);
		/*	if(msg.contains(campname)) {
			System.out.println("Campaign is created");
		}
			else {
				System.out.println("campaign is not created");
			}
		//logout */
		//driver.findElement(By.xpath("//div[@role='alert']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@arialabel='close']")).click();
		hp.getUserIcon().click();
		hp.getLogoutBtn().click();

	}

}
