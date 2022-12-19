package com.learnautomation.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.learnautomation.orangehrm.utility.Utility;

public class Dashboard {

	WebDriver driver;
	
	public Dashboard(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	By welcomeText=By.xpath("//a[contains(text(),'Welcome')]");
	
	By logout=By.xpath("//a[contains(text(),'Logout')]");
	
	By mamun=By.xpath("");
	
	public void logOut()
	{
		Utility.click(driver, welcomeText);
		
		Utility.click(driver, logout);
		
		Assert.assertTrue(Utility.waitForCurrentURL(driver, "login"));
		
	}
	
	
}
