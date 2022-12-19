package com.learnautomation.orangehrm.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	
	public static Object [][] getExcelData(String sheetName)
	{
		System.out.println("****Generating Test Data****");
		
		XSSFWorkbook wb = null;
		try 
		{
			wb = new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/TestData/Data.xlsx")));
		} catch (FileNotFoundException e) 
		{
			
		} catch (IOException e) 
		{
			
		}
		
		int rowcount=wb.getSheet(sheetName).getPhysicalNumberOfRows();
		
		int column=wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
		
		Object [][]arr=new Object[rowcount][column];
		
		for(int i=0;i<rowcount;i++)
		{
			for(int j=0;j<column;j++)
			{
				arr[i][j]=wb.getSheet(sheetName).getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		
		System.out.println("****Test Data Generated****");
		
		return arr;
	}
	

}
