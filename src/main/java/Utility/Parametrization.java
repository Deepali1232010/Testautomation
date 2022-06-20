package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrization {

public static String getData(int row,int cell)throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream("D:\\Velocity\\Automation program\\KiteZerodha\\src\\test\\resources\\Testdata.xlsx");
String value = WorkbookFactory.create(file).getSheet("Credencial").getRow(row).getCell(cell).getStringCellValue();
 return value;
		
	}
}
