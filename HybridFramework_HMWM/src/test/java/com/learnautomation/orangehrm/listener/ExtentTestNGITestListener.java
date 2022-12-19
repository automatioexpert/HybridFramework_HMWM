package com.learnautomation.orangehrm.listener;

import java.io.IOException;
import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.learnautomation.orangehrm.utility.Utility;

public class ExtentTestNGITestListener implements ITestListener {

	  ExtentReports extent = ExtentManager.getInstance();
	
	  ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest> ();
  
    
	public synchronized void onStart(ITestContext context) 
	{
    	
	}

	
	public synchronized void onFinish(ITestContext context) 
	{
		System.out.println("**** All test are done- Generating report ****");
		extent.flush();
	}
	
	
	public synchronized void onTestStart(ITestResult result) 
	{
		System.out.println("**** Test Started "+result.getMethod().getMethodName());
		ExtentTest parent = extent.createTest(result.getMethod().getMethodName());
		parentTest.set(parent);
	}

	
	public synchronized void onTestSuccess(ITestResult result) 
	{
		System.out.println("**** Test Passed ****"+result.getMethod().getMethodName());
		
		parentTest.get().pass("Test passed");
	}

	
	public synchronized void onTestFailure(ITestResult result) 
	{
		System.out.println("**** Test Failed ****"+result.getMethod().getMethodName() + " "+result.getThrowable());
		
		WebDriver driver=null;
	
		try 
		{
			Field myField= result.getTestClass().getRealClass().getDeclaredField("driver");
			
			driver=(WebDriver)myField.get(result.getInstance());
			
		} catch (Exception e1) 
		{
			
		}
		
		System.out.println("Driver value is "+driver);
		
		String src=Utility.captureScreenshot64(driver);
		
		try 
		{
			parentTest.get().fail(result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromBase64String(src).build());
		} catch (IOException e) {
			
		}
	}

	
	public synchronized void onTestSkipped(ITestResult result) {
		System.out.println("**** Test Skipped ****"+result.getMethod().getMethodName());

		parentTest.get().skip(result.getThrowable());
	}

	
	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
}