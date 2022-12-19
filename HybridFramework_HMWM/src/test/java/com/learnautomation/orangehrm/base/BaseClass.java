package com.learnautomation.orangehrm.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.learnautomation.orangehrm.utility.BrowserFactory;

public class BaseClass 
{
	
	public WebDriver driver;

	public WebDriver getDriver()
	{
		return driver;
	}
	
	/*@Parameters({"Browser","stagingURL"})
	@BeforeClass
	public void startBrowser(String Browser,String url)
	{
		System.out.println("**** Starting Browser ****");
		
		BrowserFactory browser=new BrowserFactory();
		
		driver=browser.openBrowser(Browser,url);
		
		System.out.println("**** Browser is up and running ****");
	}*/
	
	@Parameters({"local","BrowserName","BrowserVersion","OsName","OsVersion","stagingURL"})
	@BeforeClass
	public void startBrowser(@Optional("true")boolean local,@Optional("Chrome")String BrowserName,@Optional("latest")String BrowserVersion,@Optional("Windows")String OsName,@Optional("8.1")String OsVersion,String url)
	{
		System.out.println("**** Starting Browser On BrowserStack  with below details****");
		
		System.out.println("Browser Name "+BrowserName);
		System.out.println("Browser Version "+BrowserVersion);
		System.out.println("OS Name "+OsName);
		System.out.println("OS Version "+OsVersion);
		
		BrowserFactory browser=new BrowserFactory();
		
		driver=browser.openBrowser(local,BrowserName, BrowserVersion, OsName, OsVersion, url);
		
		System.out.println("**** Browser is up and running ****");
	}
	

/*	@BeforeClass
	public void startBrowser()
	{
		System.out.println("**** Starting Browser ****");
		
		BrowserFactory browser=new BrowserFactory();
		
		ConfigReader config=new ConfigReader();
			
		driver=browser.openBrowser(config.getProperty("Browser"),config.getProperty("stagingURL"));
		
		System.out.println("**** Browser is up and running ****");
	}*/
	
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("**** Closing Browser ****");
	}
	
}
