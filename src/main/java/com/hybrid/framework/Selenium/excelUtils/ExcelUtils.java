package com.hybrid.framework.Selenium.excelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {
	
	
	public static String getTestdataPath(String excelFilename) {
		return System.getProperty("user.dir") + File.separator + "src" + File.separator
				+ "test" + File.separator + "resources" + File.separator + "Testdata" + File.separator + excelFilename+".xlsx".toString();
	}
	
	public static XSSFWorkbook getWorkBook() {
		FileInputStream file;
		XSSFWorkbook workbook = null;		
		try {
			file = new FileInputStream(getTestdataPath("OpenCartTCs"));			
			workbook = new XSSFWorkbook(file);	
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Testdata file not found");
		}
		return workbook;
	}
	
	public static int getRowCount(String sheetName) {		
		XSSFSheet sheetname=getWorkBook().getSheet(sheetName);
		int rowCount=sheetname.getLastRowNum();
		return rowCount;		
	}
	
	public static int getActiveRowNumber(String sheetName, String rowName) {
		XSSFSheet sheetname = getWorkBook().getSheet(sheetName);
		int rowCount = sheetname.getLastRowNum();
		int rowNum = 0;
		XSSFCell rowDataValue;
		for (int i = 0; i < rowCount; i++) {
			rowDataValue = sheetname.getRow(i).getCell(0);
			if (rowName.equalsIgnoreCase(rowDataValue.toString())) {
				rowNum = i;
				break;
				}

		}
		return rowNum;
	}
	
	
	public static int getCellCount(String sheetName, String rowName) {
		XSSFSheet sheetname=getWorkBook().getSheet(sheetName);
		XSSFRow row=sheetname.getRow(getActiveRowNumber(sheetName, rowName)+1);
		short lastcellNum= row.getLastCellNum();
		return (int)lastcellNum;			
	}
	
	public static int getRowTestCaseCount(String sheetName, String rowName) {		
		XSSFSheet sheetname=getWorkBook().getSheet(sheetName);
		int rowCount=sheetname.getLastRowNum();
		int rowActiveNum=getActiveRowNumber(sheetName, rowName);
		int rowNum = 0;
		XSSFCell rowData;
		for (int i = rowActiveNum; i < rowCount; i++) {
			try {
				rowData = sheetname.getRow(i).getCell(0);
			} catch (NullPointerException e) {				
				break;
			}
			rowNum = i;
		}
		return rowNum-1;		
	}
	
	
	public static ArrayList<Hashtable<String, String>> getRowTestdata(String sheetName, String rowName, int rowNum) {
		XSSFSheet sheetname=getWorkBook().getSheet(sheetName);
		int rowActiveNum=getActiveRowNumber(sheetName, rowName);
		int LastTCsRowCount=getRowTestCaseCount(sheetName,rowName);
		int cellCount=getCellCount(sheetName, rowName);
		String key;
		String value;
	
		Hashtable<String, String> RowData = new Hashtable<String, String>();
		ArrayList<Hashtable<String, String>> testCaseList=new ArrayList<Hashtable<String, String>>();
		
		for (int i=rowActiveNum+1;i<=LastTCsRowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				key=sheetname.getRow(rowActiveNum+1).getCell(j).toString();				
				value=sheetname.getRow(i+1).getCell(j).toString();
				System.out.println(key+"     "+  value);
				RowData.put(key, value);				
			}	
			testCaseList.add(RowData);
		}
		System.out.println(testCaseList.size());
		return testCaseList;
	}
	
	
	
}
