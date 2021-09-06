package com.maven.project.ExcelDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDrivenDemo {

	public static void main(String[] args) throws Exception {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Datatables\\test.txt");
		//System.out.println(fis.);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheetCount = workbook.getNumberOfSheets();
		for (int i = 0; i < sheetCount; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("sample")) {
				
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> cells = firstRow.cellIterator();
				while(cells.hasNext()) {
					Cell cell = cells.next();
					if(cell.getStringCellValue().equalsIgnoreCase("Testcases")) {
						
					}
				}
			}
		}
		
		workbook.close();
	}

}
