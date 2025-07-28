package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDatafromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException{
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\Muthusivagami\\Desktop\\Exceldata.xlsx");
		Workbook wb=WorkbookFactory.create(fis)	;
		Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(1);
		String user = row.getCell(0).getStringCellValue();
		String pwd = row.getCell(1).getStringCellValue();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.instagram.com/");
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pwd);

}
}
