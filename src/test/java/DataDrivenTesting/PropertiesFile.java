package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PropertiesFile {
//Sign in with data from properties file
	//in properties file we can only store string data
	public static void main(String[] args) throws IOException {
		//FileInputStream fis= new FileInputStream("C:\\Users\\Muthusivagami\\Desktop\\DataDrivenProperties.properties");
		FileInputStream fis= new FileInputStream("./ConfigData/NinzaCrmCommondata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String BROWSER = prop.getProperty("Browser");
		String URL = prop.getProperty("URL");
		String USERNAME = prop.getProperty("Username");
		String PASSWORD = prop.getProperty("Password");
		WebDriver driver = null;
		if(BROWSER.equals("Edge")) {
			driver= new EdgeDriver();
		}
		if(BROWSER.equals("Chrome")) {
			driver= new ChromeDriver();
		}
		if(BROWSER.equals("Firefox")) {
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();

	}

}
