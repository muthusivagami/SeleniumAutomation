package AssertionsScreenshots;
import static org.testng.AssertJUnit.assertEquals;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class SoftAssertExample {
@Test
public void demo() {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	String expectedtitle = "Facebook - log in or sign up";
	String actualtitle= driver.getTitle();
	SoftAssert soft= new SoftAssert();
	soft.assertEquals(actualtitle,expectedtitle);
	System.out.println("step1");
	System.out.println("step2");
	soft.assertAll();

	
	
	
}
}
