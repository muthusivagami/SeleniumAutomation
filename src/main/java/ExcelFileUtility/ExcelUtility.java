package ExcelFileUtility;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {

	//Getting data from Single Row
	public String GetDatafromExcel (String Sheetname,int rowNum,int cellNum) throws EncryptedDocumentException, IOException{
		FileInputStream fis = new FileInputStream("./Testdata/TestScriptDataAdv.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data=wb.getSheet(Sheetname).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	//Getting data from Multiple Row
		public int GetRowCount(String Sheetname) throws EncryptedDocumentException, IOException {
			FileInputStream fis = new FileInputStream("./Testdata/TestScriptDataAdv.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			int rowcount= wb.getSheet(Sheetname).getLastRowNum();
			return rowcount;
			
		}
		
	
	
	}

