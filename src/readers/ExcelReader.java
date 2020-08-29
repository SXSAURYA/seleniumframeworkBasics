package readers;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	// TODO : Create one method and then Pass the script name and column name and
	// get the value for particular script for particlular column
	public static String getRowData(String fileName, String sheetName) {
		String value = null;
		XSSFWorkbook workbook = null;
		try {
			// We are getting workbook
			workbook = new XSSFWorkbook(System.getProperty("user.dir") + "/resources/" + fileName + ".xlsx");
			// How we can get the Sheet
			XSSFSheet xssfSheet = workbook.getSheet(sheetName);
			// How we can get the Row
			XSSFRow xssfRow = xssfSheet.getRow(1);

			int noOfRows = xssfSheet.getLastRowNum();

			for (int i = 0; i < noOfRows; i++) {
				XSSFRow xssfRowindex = xssfSheet.getRow(i);
				int noOfCell = xssfRowindex.getLastCellNum();
			}
			// How we can get the cell
			XSSFCell xssfCell = xssfRow.getCell(2);
			value = xssfCell.getStringCellValue();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return value;
	}
	
	
	public static String getRowData(String fileName, String sheetName,String scriptName,String columnName) {
		String value = null;
		XSSFWorkbook workbook = null;
		try {
			// We are getting workbook
			workbook = new XSSFWorkbook(System.getProperty("user.dir") + "/resources/" + fileName + ".xlsx");
			// How we can get the Sheet
			XSSFSheet xssfSheet = workbook.getSheet(sheetName);
			// How we can get the Row
			XSSFRow xssfRow = xssfSheet.getRow(1);

			int noOfRows = xssfSheet.getLastRowNum();

			for (int i = 0; i < noOfRows; i++) {
				XSSFRow xssfRowindex = xssfSheet.getRow(i);
				int noOfCell = xssfRowindex.getLastCellNum();
			}
			// How we can get the cell
			XSSFCell xssfCell = xssfRow.getCell(2);
			value = xssfCell.getStringCellValue();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return value;
	}

}
