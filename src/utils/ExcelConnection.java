package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import utils.FKProperties;

import jxl.Cell;
import jxl.read.biff.BiffException;

import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConnection {

	public static String getEmailExcelJXL(String sheetName, String searchedString) throws BiffException, IOException {

		int row, column, adjRow, adjCol;
		String excelPath = FKProperties.getValue("excelPath");

		jxl.Workbook wb = jxl.Workbook.getWorkbook((new File(excelPath)));
		jxl.Sheet sh = wb.getSheet(sheetName);
		jxl.Cell c = sh.findCell(searchedString); // finding the cell containing the searched string
													
		row = c.getRow(); // getting the last row in the sheet
		column = c.getColumn(); // getting the last column in the sheet
		Cell adjCell = sh.getCell(++column, row); // getting the adjacent
													// Cell

		String value = adjCell.getContents();
		return value;

	}

	public static String getEmailExcelPOI(String sheetName, String searchedString)
			throws  IOException, GeneralSecurityException {


		String excelPath = FKProperties.getValue("excelpath");
		String valueReceived = null;
		String password = "test123";
		File file = new File(excelPath);
		FileInputStream fs = new FileInputStream(file);
		
		/*
		// Cracking the password with .xls file
		NPOIFSFileSystem fs = new NPOIFSFileSystem(file, true);
        Biff8EncryptionKey.setCurrentUserPassword("nimda");
        Workbook wb = new HSSFWorkbook(fs); */
       
		
	//	 Cracking the password with .xlsx file
	/*	NPOIFSFileSystem fs = new NPOIFSFileSystem(file, true);
		EncryptionInfo info = new EncryptionInfo(fs);
		Decryptor decryptor = Decryptor.getInstance(info);
		if (!decryptor.verifyPassword(password)) {
		    throw new RuntimeException("Unable to process: document is encrypted.");
		}
		//Biff8EncryptionKey.setCurrentUserPassword(password); 
		InputStream ds = decryptor.getDataStream(fs); */
		
		Workbook wb = new HSSFWorkbook(fs);
		
		Sheet sh = wb.getSheet(sheetName);
		
		


		int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();
		//System.out.println(rowCount);

		// Create a loop over all the rows of excel file to read it

		for (int i = 0; i < rowCount + 1; i++) {
			Row row = sh.getRow(i);
			// Create a loop to print cell values in a row
			for (int j = 0; j < row.getLastCellNum(); j++) {
				// Print excel data in console
				if ((row.getCell(j).getStringCellValue().equals(searchedString)))
					valueReceived = row.getCell(++j).getStringCellValue();
			}

		}
		return valueReceived;
	}

}
