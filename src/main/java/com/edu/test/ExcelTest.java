package com.edu.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.edu.domain.Population;

public class ExcelTest {

	private static HSSFWorkbook readFile(String filename) throws IOException {
		try (FileInputStream fis = new FileInputStream(filename)) {
			return new HSSFWorkbook(fis); // NOSONAR - should not be closed here
		}
	}

	public static void main(String args[]) throws IOException {
		String fileName = "C:\\Users\\15208\\Documents\\WeChat Files\\wxid_x61t6g0wif7z21\\FileStorage\\File\\2020-07\\0704Java作业说明\\2020-a.xls";
		try (HSSFWorkbook wb = readFile(fileName)) {
			System.out.println("Data dump:\n");
			// 如果有多个表格的话：int k = 0; k < wb.getNumberOfSheets(); k++
			HSSFSheet sheet = wb.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			System.out.println(rows + " row(s).");
			for (int r = 10; r < 11; r++) {// rows
				HSSFRow row = sheet.getRow(r);
				if (row == null) {
					continue;
				}

				System.out.println("\nROW " + row.getRowNum() + " has " + row.getPhysicalNumberOfCells() + " cell(s).");
				for (int c = 7; c < 30; c++) {// row.getLastCellNum()
					HSSFCell cell = row.getCell(c);
					String value;

					if (cell != null) {
						switch (cell.getCellType()) {

						case FORMULA:
							value = "FORMULA value=" + cell.getCellFormula();
							break;

						case NUMERIC:
							value = "NUMERIC value=" + cell.getNumericCellValue();
							break;

						case STRING:
							value = "STRING value=" + cell.getStringCellValue();
							break;

						case BLANK:
							value = "<BLANK>";
							break;

						case BOOLEAN:
							value = "BOOLEAN value-" + cell.getBooleanCellValue();
							break;

						case ERROR:
							value = "ERROR value=" + cell.getErrorCellValue();
							break;

						default:
							value = "UNKNOWN value of type " + cell.getCellType();
						}
						System.out.println("CELL col=" + cell.getColumnIndex() + " VALUE=" + value);
					}
				}	
			}
		}
	}
}
