package AssertionsScreenshots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssent {
@Test
public void demo() {
	String expectedtitle = "Facebook - log in or sign up";
	WebDriver driver=new  ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	String actualtitle = driver.getTitle();
	Assert.assertEquals(actualtitle, expectedtitle);
	System.out.println("step1");
	System.out.println("step2");
	
}
}
