package AssertionsScreenshots;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FB_Screenshot {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.facebook.com/");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		//new File("./Screenshot").mkdirs();
		File perm=new File("./Screenshot/facebook.png");
		FileHandler.copy(temp,perm);
		Thread.sleep(2000);
		File temp1=ts.getScreenshotAs(OutputType.FILE);
		File perm1=new File("./Screenshot/facebook1.png");
		FileHandler.copy(temp1,perm1);
		Thread.sleep(2000);
		File temp2=ts.getScreenshotAs(OutputType.FILE);
		File perm2=new File("./Screenshot/facebook2.png");
		FileHandler.copy(temp2,perm2);

		
		
	}

}
