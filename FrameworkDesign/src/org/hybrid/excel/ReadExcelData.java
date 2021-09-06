package org.hybrid.excel;

import org.hybrid.utility.ExcelReader;

public class ReadExcelData {

	public static void main(String[] args) {

		ExcelReader excelReader = new ExcelReader(System.getProperty("user.dir") + "\\Datatables", "detatable.xlsx");
		System.out.println(System.getProperty("user.dir") + "\\Datatables");
		System.out.println(excelReader.getRowCount("USERINFO"));
		int rowCount = excelReader.getRowCount("USERINFO");
		
		for (int rowNum = 2; rowNum < rowCount; rowNum++) {
			System.out.println(excelReader.getCellData("USERINFO", "FirstName", rowNum));	
		}
		
	}

}
