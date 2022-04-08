package com.edu.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.edu.MySpringBootApplication;
import com.edu.domain.Population;
import com.edu.repository.PopulationDAO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MySpringBootApplication.class)
public class ExcelTranslator2 {

	@Autowired
	private  PopulationDAO populationDAO;


	private  HSSFWorkbook readFile(String filename) throws IOException {
		try (FileInputStream fis = new FileInputStream(filename)) {
			return new HSSFWorkbook(fis); // NOSONAR - should not be closed here
		}
	}

	@SuppressWarnings("incomplete-switch")
	@Test
	public  void main() throws IOException {
		String fileName = "C:\\Users\\15208\\Documents\\WeChat Files\\wxid_x61t6g0wif7z21\\FileStorage\\File\\2020-07\\0704Java作业说明\\2020-a.xls";
		try (HSSFWorkbook wb = readFile(fileName)) {
			System.out.println("Data dump:\n");
			// 如果有多个表格的话：int k = 0; k < wb.getNumberOfSheets(); k++
			HSSFSheet sheet = wb.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			List<Population> list = new ArrayList<Population>();
			System.out.println(rows + " row(s).");
			for (int r = 10; r < 1974; r++) {// rows
				HSSFRow row = sheet.getRow(r);
				Population p = new Population();
				if (row == null) {
					continue;
				}

				System.out.println("\nROW " + row.getRowNum() + " has " + row.getPhysicalNumberOfCells() + " cell(s).");
				for (int c = 7; c < 30; c++) {// row.getLastCellNum()
					HSSFCell cell = row.getCell(c);
					@SuppressWarnings("unused")
					String value;

					if (cell != null) {
						switch (c) {

						case 7:
							p.setId(row.getCell(7).getStringCellValue().trim());
							break;

						case 8:
							p.setCity(row.getCell(8).getStringCellValue());
							break;

						case 9:
							p.setMunicipalities(row.getCell(9).getStringCellValue());
							break;

						case 10:
							p.setTotalPopulation((long) row.getCell(10).getNumericCellValue());
							break;

						case 11:
							p.setTotalPopulation0_14((long)row.getCell(11).getNumericCellValue());
							break;

						case 12:
							p.setTotalPopulation15_64((long)row.getCell(12).getNumericCellValue());
							break;
						case 13:
							p.setTotalPopulation65AndOver((long)row.getCell(13).getNumericCellValue());
							break;

						case 14:
							p.setForeignersTotal(Long.valueOf((long) row.getCell(14).getNumericCellValue()));
							break;

						case 15:
							switch(cell.getCellType()) {

							case STRING:
								p.setDenselyInhabitedDistrictsPopulation(row.getCell(15).getStringCellValue());
								break;
							case NUMERIC:
								p.setDenselyInhabitedDistrictsPopulation(String.valueOf(row.getCell(15).getNumericCellValue()));
								break;
							}

						case 16:
							p.setLiveBirths((long)row.getCell(16).getNumericCellValue());
							break;

						case 17:
							p.setDeath(Long.valueOf((long) row.getCell(17).getNumericCellValue()));
							break;

						case 18:
							p.setNumberOfIn_migrantsFromOtherMunicipalities(Long.valueOf((long) row.getCell(18).getNumericCellValue()));
							break;

						case 19:
							p.setNumberOfOut_migrantsFromOtherMunicipalities(Long.valueOf((long) row.getCell(19).getNumericCellValue()));
							break;

						case 20:
							p.setDayTimePopulation(Long.valueOf((long) row.getCell(20).getNumericCellValue()));
							break;

						case 21:
							p.setNumberOfHouseholds_Total(Long.valueOf((long) row.getCell(21).getNumericCellValue()));
							break;

						case 22:
							p.setNumberOfPrivateHouseholds(Long.valueOf((long) row.getCell(22).getNumericCellValue()));
							break;

						case 23:
							p.setNuclearFamilies(Long.valueOf((long) row.getCell(23).getNumericCellValue()));
							break;

						case 24:
							p.setOne_personHouseholds(Long.valueOf((long) row.getCell(24).getNumericCellValue()));
							break;

						case 25:
							p.setNumberOfNuclearFamiliesWithHouseholdMembers65AndOver(Long.valueOf((long) row.getCell(25).getNumericCellValue()));
							break;

						case 26:
							p.setNumberOfAged_coupleHouseholdsOnlyAgedCouple(Long.valueOf((long) row.getCell(26).getNumericCellValue()));
							break;

						case 27:
							p.setNumberOfAged_single_personHouseholdsAged65AndOver(Long.valueOf((long) row.getCell(27).getNumericCellValue()));
							break;

						case 28:
							p.setMarriages(Long.valueOf((long) row.getCell(28).getNumericCellValue()));
							break;

						case 29:
							p.setDivorces(Long.valueOf((long) row.getCell(29).getNumericCellValue()));
							break;

						default:
							value = "UNKNOWN value of type " + cell.getCellType();
						}

					}

				}
				list.add(p);
				populationDAO.saveAll(list);
			}

		}
	}
}
