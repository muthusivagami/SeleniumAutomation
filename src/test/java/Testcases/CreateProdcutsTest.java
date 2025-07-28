package Testcases;

import java.io.IOException;


import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ExcelFileUtility.ExcelUtility;
import JavaUtility.JavaUtility;
import POM.AddProduct;
import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesUtility;
import WebDriverUtility.WebdriverUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateProdcutsTest extends BaseClass  {
@Test(groups="Regression")
	public void CreateProducts() throws IOException, InterruptedException {
		
		WebdriverUtility wutil = new WebdriverUtility();
		ExcelUtility eutil = new ExcelUtility();
		JavaUtility jutil = new JavaUtility();
		String pname = eutil.GetDatafromExcel("Product", 1, 2);
		String psize = eutil.GetDatafromExcel("Product", 1, 3);
		String pprize = eutil.GetDatafromExcel("Product", 1,4);
			
		HomePage hp=new HomePage(driver);
		hp.getProducts().click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		//hp.getGetproduct.click();
		AddProduct ap = new AddProduct(driver);
		ap.getAddProduct().click();
		ap.getProductid();
		//driver.findElement(By.xpath("//span[text()='Add Product']")).click();
		
		
		//Random rand = new Random();
		//int randcount = rand.nextInt(1000);
		//driver.findElement(By.name("productName")).sendKeys(pname + jutil.getRandomNumber());
		ap.getProductName().sendKeys(pname);
		
		//WebElement categorydropdown = driver.findElement(By.name("productCategory"));
		
		
		
		//Select sel = new Select(product);
		//sel.selectByIndex(2);
		//wutil.select(categorydropdown, "Electricals");
		//wutil.select(ap.getProductCategory(),2);
		//WebElement quantity = driver.findElement(By.name("quantity"));
		ap.getQuantity().clear();
		ap.getQuantity().sendKeys(psize);
		
		//WebElement price= driver.findElement(By.name("price"));
		ap.getPrice().clear();
		ap.getPrice().sendKeys(pprize);
		
		//WebElement vendordropdown = driver.findElement(By.name("vendorId"));
		//Select vendor = new Select(sel_Vendor);
		//vendor.selectByIndex(5);
		Thread.sleep(2000);
		wutil.select(ap.getProductCategory(),2);
 		//ap.getVendorId().click();
 		wutil.select(ap.getVendorId(),3);
		//driver.findElement(By.xpath("//button[text()='Add']")).click();
 		Thread.sleep(2000);
		ap.getAddprodButton().click();
		Thread.sleep(4000);
		hp.getClosemsg().click();
	}

}
