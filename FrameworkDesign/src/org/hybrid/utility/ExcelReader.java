package org.hybrid.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public String filePath;
	public String fileName;
	public FileInputStream fis = null;
	private Workbook workbook = null;
	private Sheet sheet = null;
	private Row row = null;
	private Cell cell = null;
	
	
	public ExcelReader(String filePath, String fileName) {
		this.filePath = filePath;
		this.fileName = fileName;
		System.out.println(filePath + "\\" + fileName);
		File excleFile = new File(filePath + "\\" + fileName);
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		try {
			fis = new FileInputStream(excleFile);
			if(fileExtensionName.equals(".xlsx")) {
				workbook = new XSSFWorkbook(fis);
			} else if(fileExtensionName.equals(".xlx")) {
				workbook = new HSSFWorkbook(fis);
			}
			sheet = workbook.getSheetAt(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
		
		
		
		// returns the row count in a sheet
		public int getRowCount(String sheetName) {
			int index = workbook.getSheetIndex(sheetName);
			if(index == -1) return 0;
			else {
				sheet = workbook.getSheetAt(index);
				int number = sheet.getLastRowNum() + 1;
				return number;
			}
		}
		
		//
		public String getCellData(String sheetName, String colName, int rowNum) {
			try {
			if(rowNum <= 0) return "";
			
			int index = workbook.getSheetIndex(sheetName);
			int col_num = -1;
			if(index == -1) return "";
			
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for(int i = 0; i < row.getLastCellNum(); i++) {
				
				if(row.getCell(i).getStringCellValue().trim().equals(colName.trim())) col_num = i;
			}
			
			if(col_num == -1) return "";
			
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(col_num);

			if (cell == null)
				return "";

			//System.out.println(cell.getCellType().name());
			//
			if (cell.getCellType().name().equals("STRING"))
				return cell.getStringCellValue();

			// if (cell.getCellType().STRING != null)

			// if(cell.getCellType()==Xls_Reader.CELL_TYPE_STRING)
			// return cell.getStringCellValue();
			else if ((cell.getCellType().name().equals("NUMERIC")) || (cell.getCellType().name().equals("FORMULA"))) {

				String cellText = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// format in form of M/D/YY
					double d = cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;

					// System.out.println(cellText);

				}

				return cellText;
			} else if (cell.getCellType().BLANK != null)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());

		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowNum + " or column " + colName + " does not exist in xls";
		}
		}
		
		
		
		
		
		

	

}
