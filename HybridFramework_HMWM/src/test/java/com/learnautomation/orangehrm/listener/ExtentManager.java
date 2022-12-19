package com.learnautomation.orangehrm.listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    
    private static ExtentReports extent;
    
    public static ExtentReports getInstance() 
    {
    	if (extent == null)
    	{
    		createInstance(System.getProperty("user.dir")+"/Reports/Report_"+getDateTime()+".html");
    	}
    		return extent;
    }
    
    public static ExtentReports createInstance(String fileName) 
    {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        
        htmlReporter.config().setTheme(Theme.STANDARD);
        
        htmlReporter.config().setDocumentTitle("Test Automation Summary");
        
        htmlReporter.config().setReportName("Automation Report");
        
        extent = new ExtentReports();
        
        extent.attachReporter(htmlReporter);
        
        return extent;
    }
    
    public static String getDateTime()
    {
    	Date currentDate=new Date();
    	
    	SimpleDateFormat myFormat=new SimpleDateFormat("MM_dd_yy_HH_mm_ss");
    	
    	return myFormat.format(currentDate);
    }
    
    
}