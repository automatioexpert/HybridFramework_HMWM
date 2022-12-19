package com.learnautomation.orangehrm.dataprovider;

import org.testng.annotations.DataProvider;

public class TestDataProvider 
{
		
	@DataProvider(name="getUserData")
	public static Object [][] getDataNew()
	{
		return ExcelReader.getExcelData("User");
	
	}

}
