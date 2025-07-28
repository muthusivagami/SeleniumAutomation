package BaseClass;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesUtility;

public class BaseClass {
//remove test<scope> in pom.xml when we use testng in main/java
public static WebDriver sdriver=null;
	public WebDriver driver = null;
	public PropertiesUtility putil = new PropertiesUtility();
	@BeforeSuite(groups= {"Smoke","Regression"})
	public void beforesuite() {
		Reporter.log("db connectivity open",true);
	}
	@BeforeTest(groups= {"Smoke","Regression"})
	public void beforetest() {
		System.out.println("preconditions");
	}
	
	@BeforeClass(groups= {"Smoke","Regression"})
	public void beforeclass() throws IOException {
		String BROWSER = putil.GetDatafromPropFile("Browser");
		if(BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		}
		else if(BROWSER.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("Firefox")) {
			driver=new FirefoxDriver();
		}
		sdriver=driver;
		System.out.println("launching browser");
		driver.manage().window().maximize();
	}
	@BeforeMethod(groups= {"Smoke","Regression"})
	public void beforemethod() throws IOException{
		String URL = putil.GetDatafromPropFile("URL");
		String USERNAME = putil.GetDatafromPropFile("Username");
		String PASSWORD = putil.GetDatafromPropFile("Password");
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.getUN().sendKeys(USERNAME);
		lp.getPW().sendKeys(PASSWORD);
		lp.getLoginbtn().click();
		System.out.println("Login done");				
	}
	@AfterMethod(groups= {"Smoke","Regression"})
	public void aftermethod() {
		HomePage hp = new HomePage(driver);
		hp.getUserIcon().click();
		hp.getLogoutBtn().click();
		System.out.println("Logout done");
	}
	@AfterClass(groups= {"Smoke","Regression"})
	public void afterClass() {
	driver.quit();
	System.out.println("closing browser");
	}
	@AfterTest(groups= {"Smoke","Regression"})
	public void aftertest() {
	System.out.println("POST CONDITIONS");
	}
	@AfterSuite(groups= {"Smoke","Regression"})
	public void afterSuite() {
	System.out.println("closeDB Connectivity");
	}
	
}
