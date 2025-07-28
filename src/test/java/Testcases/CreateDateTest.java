package Testcases;

import java.util.Date;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
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
public class CreateDateTest extends BaseClass {
@Test(groups="Smoke")
	public void CreateDate() throws IOException, InterruptedException {
		WebdriverUtility wutil = new WebdriverUtility();
		ExcelUtility eutil = new ExcelUtility();
		String campname = eutil.GetDatafromExcel("Campaign", 1, 2);
		String size = eutil.GetDatafromExcel("Campaign", 1, 3);
		JavaUtility jutil=new JavaUtility();
		String expecteddate =jutil.togetRequired(30);
				//WebDriver driver= new EdgeDriver();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//driver.findElement(By.id("username")).sendKeys("rmgyantra");
		//driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		//driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		//To create random campaign name
		//Random ran = new Random();
		//int ranacnt = ran.nextInt(1000); //it will create 1000 random names 
		HomePage hp=new HomePage(driver);
		//create campaign
		//driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		hp.getCreatecampaign().click();
		
		/*Date date = new Date();
		SimpleDateFormat sim= new SimpleDateFormat("MM-dd-YYYY");
		sim.format(date);
		Calendar cal= sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String datereq = sim.format(cal.getTime());*/
		
		CampaignPage cp = new CampaignPage(driver);
		cp.getCampaignName().sendKeys(campname);
		//driver.findElement(By.name("campaignName")).sendKeys(campname+jutil.getRandomNumber());
		//driver.findElement(By.name("targetSize")).sendKeys("10");
			
		//WebElement target = driver.findElement(By.name("targetSize"));
		//target.clear();
		//target.sendKeys(size);
		cp.getTargetsizeTF().clear();
		cp.getTargetsizeTF().sendKeys(size);
		cp.getExpectedclosedate();
		
		//to select date
		
		//WebElement closeddate = driver.findElement(By.name("expectedCloseDate"));
		//wutil.clickonWebElement(driver, closeddate);
		//Actions act=new Actions(driver);
		//act.click(closeddate).sendKeys(datereq).perform();
		//click create campaign
		//driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		
		wutil.passinput(driver, cp.getExpectedclosedate(),jutil.togetRequired(30));
		cp.getCreatecampaignsubmitBtn().click();
		Thread.sleep(2000);
		WebElement toast =driver.findElement(By.xpath("//div[@role='alert']"));
		Thread.sleep(4000);
		wutil.WaitforVisibilityofElement(driver, toast);
		String msg = toast.getText();
		Assert.assertTrue(msg.contains(campname));
		/*if(msg.contains(campname)) {
		System.out.println("campaign is created");
				}
		else{
				System.out.println("campaign not created");
				}*/
		//driver.findElement(By.xpath("//button[@arialabel='close']")).click();
		driver.findElement(By.xpath("//div[@role='alert']")).click();	
		hp.getUserIcon().click();
		hp.getLogoutBtn().click();
				}


	}

