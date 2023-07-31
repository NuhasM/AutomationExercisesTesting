package com.qa.automationexercises.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.automationexercises.constants.Constants;

public class ExcelUtilities {

	public static Object[][] getTestData(String sheetName) {

		Object[][] data = null;
		try (FileInputStream fis = new FileInputStream(Constants.AMEXERCISES_BOOK)) {
			Workbook excelBook = WorkbookFactory.create(fis);
			Sheet excelSheet = excelBook.getSheet(sheetName);
			int columns = excelSheet.getRow(0).getLastCellNum();
			int rows = excelSheet.getLastRowNum();
			data = new Object[rows][columns];

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					data[i][j] = excelSheet.getRow(i + 1).getCell(j).toString();

				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
