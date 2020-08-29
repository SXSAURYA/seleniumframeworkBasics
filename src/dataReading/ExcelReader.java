package dataReading;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//https://www.apache.org/dyn/closer.lua/poi/release/bin/poi-bin-4.1.2-20200217.zip : Download the Zip 
		//Extract and add All
		try {
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(System.getProperty("user.dir")+"/resources/Data.xlsx");
			System.out.println(xssfWorkbook.getSheetAt(0).getRow(1).getCell(2));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
