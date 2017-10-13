package com.actitime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage
{

	public WebDriver driver;
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void verifyTitle(String eTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver, 15);
		try
		{
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Title is matching: "+eTitle,true);
			
		}
		catch(Exception e)
		{
			Reporter.log("Title is not matching",true);
			Assert.fail();
		}
	}	
	
	public  void verifyElement(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is matching: "+element.getText(),true);
			
		}
		catch(Exception e)
		{
			Reporter.log("Element is not matching",true);
			Assert.fail();
		}
		
	}
	

}
