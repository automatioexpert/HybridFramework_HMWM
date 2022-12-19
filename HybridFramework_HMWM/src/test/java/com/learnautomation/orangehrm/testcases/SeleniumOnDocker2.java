package com.learnautomation.orangehrm.testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumOnDocker2 
{
	
	@Test
	public void testOnChrome() throws MalformedURLException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setBrowserName(BrowserType.FIREFOX);

		WebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		
		driver.get("http://yahoo.com");

		System.out.println(driver.getCurrentUrl());
		
		System.out.println(driver.getTitle());
		
		driver.quit();
		
	}

}
