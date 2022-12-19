package com.learnautomation.orangehrm.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.learnautomation.orangehrm.base.BaseClass;
import com.learnautomation.orangehrm.dataprovider.TestDataProvider;
import com.learnautomation.orangehrm.pages.Dashboard;
import com.learnautomation.orangehrm.pages.HomePage;

public class LoginTest extends BaseClass 
{
	HomePage home;
	Dashboard dashboard;
	public WebDriver driver;
	
	
	@Test(dataProvider="getUserData",dataProviderClass=TestDataProvider.class)
	public void testlogin_001(String user,String pass)
	{
		driver=getDriver();
		
		home=new HomePage(driver);
		
		home.loginWithAdmin(user, pass);
	}
	
	@Test(dependsOnMethods="testlogin_001")
	public void testlogout_002()
	{
		dashboard=new Dashboard(driver);
		
		dashboard.logOut();
		
	}

}
