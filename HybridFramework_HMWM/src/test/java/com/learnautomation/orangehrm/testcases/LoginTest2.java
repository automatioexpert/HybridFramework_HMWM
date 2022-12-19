package com.learnautomation.orangehrm.testcases;

import org.testng.annotations.Test;

import com.learnautomation.orangehrm.base.BaseClass;
import com.learnautomation.orangehrm.dataprovider.TestDataProvider;
import com.learnautomation.orangehrm.pages.Dashboard;
import com.learnautomation.orangehrm.pages.HomePage;

public class LoginTest2 extends BaseClass 
{
	HomePage home;
	Dashboard dashboard;
	
	@Test(dataProvider="getUserData",dataProviderClass=TestDataProvider.class)
	public void testlogin_001(String user,String pass)
	{
		home=new HomePage(driver);
		
		home.loginWithAdmin(user, pass);
		
		dashboard=new Dashboard(driver);
		
		dashboard.logOut();
	}
}
