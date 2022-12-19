package com.learnautomation.orangehrm.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.learnautomation.orangehrm.dataprovider.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	
	public WebDriver openBrowser(boolean local,String browserName, String browserVersion,String osName,String osVersion,String application)
	{
		if(local)
		{
			System.out.println("Test will be executed on Local Machine");
			
			return openBrowser(browserName, application);
		}
		else
		{
			System.out.println("Test will be executed on Browser Stack ");
			return openBrowserOnGrid(browserName, browserVersion, osName, osVersion, application);
			
			/*
			 *  Add condition for mobile devices and accept device Name and realMobile as true/false
			 * 
			 */
		}
	}
	
	
	public WebDriver openBrowserOnGrid(String browserName, String browserVersion,String osName,String osVersion,String application)
	{
		
		DesiredCapabilities caps=new DesiredCapabilities();
		
		caps.setCapability("os_version",osVersion.replace("_", " "));

		caps.setCapability("browser", browserName);
		
	    caps.setCapability("browser_version", browserVersion);		
		
	    caps.setCapability("os", osName.replace("_", " "));
		
	    String hubURL="https://"+new ConfigReader().getProperty("username")+":"+new ConfigReader().getProperty("accessKey")+"@hub-cloud.browserstack.com/wd/hub";
		
	    System.out.println("HUB URL "+hubURL);
	    
		URL url;
		WebDriver driver = null;
		try
		{
			url = new URL(hubURL);
			driver=new RemoteWebDriver(url, caps);
			
			System.out.println("Driver value is "+driver);
			
			driver.get(application);
		    
		} catch (MalformedURLException e) 
		{
			System.out.println("URL mismatch "+e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println("Could not connect to hub "+e.getMessage());
		}
		
	
		return driver;
	}
	

	public WebDriver openBrowser(String browserName,String applicationURL)
	{
		WebDriver driver=null;
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("FF")  ||  browserName.equalsIgnoreCase("Firefox") || browserName.equalsIgnoreCase("Mozila"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Sorry !! Please use Chrome, FF or Edge browser for execution");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(applicationURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
	

}
