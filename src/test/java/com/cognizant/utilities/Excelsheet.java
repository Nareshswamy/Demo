//Author:KOPPARAPU VENKATA NARESH
package com.cognizant.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class Excelsheet 
{
	public static String[][] data() throws IOException{
		FileInputStream f = new FileInputStream("C:\\Users\\pc1\\eclipse-workspace\\Spicejet\\Inputs.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet sh = wb.getSheet("Sheet1");
		String celldata[][]  = new String[1][2];
		celldata[0][0] = sh.getRow(0).getCell(0).getStringCellValue();
		System.out.println(celldata[0][0]);
		celldata[0][1] = sh.getRow(0).getCell(1).getStringCellValue();
		System.out.println(celldata[0][1]);
		return celldata;
		
		
	}


	}
