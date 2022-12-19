package com.learnautomation.orangehrm.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility 
{

	/*
	 *  
	 *  
	 */
	
	public static void waitForAlert()
	{
		
	}
	
	
	public static boolean waitForTitle(WebDriver driver,String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		return wait.until(ExpectedConditions.titleContains(title));
		
	}
	
	
	public static boolean waitForTitle(WebDriver driver,String title,int time)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		
		return wait.until(ExpectedConditions.titleContains(title));
		
	}
	
	
	
	public static boolean waitForCurrentURL(WebDriver driver,String url)
	{
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		return wait.until(ExpectedConditions.urlContains(url));
	}
	
	public static boolean waitForCurrentURL(WebDriver driver,String url,int time)
	{
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		
		return wait.until(ExpectedConditions.urlContains(url));
	}
	
	
	
	public static String captureText(WebDriver driver,By locator)
	{
		return findElement(driver, locator).getText();
	}
	
	
	public static WebElement findElement(WebDriver driver,By locator)
	{
		return driver.findElement(locator);
	}
	

	public static void click(WebDriver driver,By locator)
	{
		findElement(driver,locator).click();
	}
	
	public static void type(WebDriver driver,By locator,String data)
	{
		findElement(driver,locator).sendKeys(data);
	}
	
	
	public static void selectValuesFromDropDown(WebDriver driver,By locator,String text) 
	{
		new Select(findElement(driver,locator)).selectByVisibleText(text);
	}
	
	
	public static void wait(int time)
	{
		try 
		{
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			
		}
	}
	
	
	
	public static String captureScreenshot64(WebDriver driver)
	{
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		String src=ts.getScreenshotAs(OutputType.BASE64);
		
		String img="data:image/png;base64,"+src;
		
		System.out.println("Image data is "+img);
		
		return img;
		
	}
	
	
}
