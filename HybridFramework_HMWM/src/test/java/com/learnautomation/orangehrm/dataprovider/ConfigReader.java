package com.learnautomation.orangehrm.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	FileInputStream fis;
	Properties pro;
	
	public ConfigReader()
	{
		try 
		{
			
		fis=new FileInputStream(new File(System.getProperty("user.dir")+"/Config/Config.properties"));
		pro=new Properties();
		pro.load(fis);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Could not read the file "+e.getMessage());
		}
		catch (IOException e) 
		{
			System.out.println("Could not read the file "+e.getMessage());
		}	
	}
	
	
	public String getProperty(String key)
	{
		return pro.getProperty(key);
	}
	

}
