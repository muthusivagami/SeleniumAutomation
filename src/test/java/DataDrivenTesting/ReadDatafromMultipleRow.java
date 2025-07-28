package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDatafromMultipleRow {
//before run the program close the excel and run 
	//to run multiple rows, we have to use FOR condition and get the rowcount
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./Testdata/MultipleRow.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet("Sheet1");
		int rowcount = sh.getLastRowNum();
		System.out.println(rowcount);
		for(int row=1 ; row<=rowcount ; row++) {
			String ProductCategory=sh.getRow(row).getCell(0).getStringCellValue();
			String ProductName = sh.getRow(row).getCell(1).getStringCellValue();
			System.out.println(ProductCategory + "====" + ProductName);
	}
	}

}
