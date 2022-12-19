package com.learnautomation.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.learnautomation.orangehrm.utility.Utility;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By username=By.id("txtUsername");
	
	By pass=By.name("txtPassword");
	
	By loginButton=By.id("btnLogin");
	
	
	public void enterUsername(String uname)
	{
		driver.findElement(username).sendKeys(uname);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(pass).sendKeys(password);
	}
	
	public void clickOnLoginButton()
	{
		driver.findElement(loginButton).click();
	}
	
	public void verifyLogin()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}
	
	
	public void loginWithAdmin(String uname,String password)
	{
		
		Utility.type(driver, username, uname);
		
		Utility.type(driver, pass, password);

		Utility.click(driver, loginButton);
		
		Assert.assertTrue(Utility.waitForCurrentURL(driver, "dashboard"));
	
	}
	
	

}
