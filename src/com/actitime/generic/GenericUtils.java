package com.actitime.generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class GenericUtils 
{
public WebDriver driver;
	
	// To Handle the select drop down by index
	public static void selectByIndex(WebElement element,int n)
	{
		
		Select sel=new Select(element);
		sel.selectByIndex(n);
		
	}
	//To Handle the select drop down by value
	public static void selectByValue(WebElement element, String value)
	{
		
		Select sel=new Select(element);
		sel.selectByValue(value);
		
	}
	
	//To handle the select drop down by visible text
	public static void selectByVisibleText(WebElement element, String text)
	{
		
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
		
	}
	
	//To move/hover the mouse to the menu
	public static void moveToElement(WebElement element)
	{
		
		Actions action=new Actions(BaseTest.driver);
		action.moveToElement(element).perform();
		
	}
	
	//TO drag a particular element from the source to destination
	public static void dragAndDrop(WebElement src, WebElement dest)
	{
		Actions action=new Actions(BaseTest.driver);
		action.dragAndDrop(src, dest).perform();
	}
	
	//To bring up context menu
	public static void contextClick(WebElement element)
	{
		Actions action=new Actions(BaseTest.driver);
		action.contextClick(element).perform();
	}
	
	// To accept the Javascript pop up
	public static void acceptJavascriptPopup()
	{
		BaseTest.driver.switchTo().alert().accept();
	}
	
	//To cancell Javascript Popup
	public static void cancellJavascriptPopup()
	{
		BaseTest.driver.switchTo().alert().dismiss();
	}
	public static void handleDownloadPopUp(String key,String value)
	{
		FirefoxProfile pf=new FirefoxProfile();
		pf.setPreference(key, value);
			
	}
	
	//To handle child browser pop Up
	public static void closeAllChildBrowserPopUp()
	{
		Set<String>winHand= BaseTest.driver.getWindowHandles();
		for(String wh:winHand)
		{
			BaseTest.driver.switchTo().window(wh);
			BaseTest.driver.close();
		}
		
	}
	
	//To handle a single child browser pop up
	public static void closeSingleBrowserPopUp(String BrowserTitle)
	{
		Set<String>winhand=BaseTest.driver.getWindowHandles();
		for(String wh:winhand)
		{
			BaseTest.driver.switchTo().window(wh);
			String ParentBrowserTitle=BaseTest.driver.getTitle();
			if(ParentBrowserTitle!=BrowserTitle)
			{
				BaseTest.driver.close();
				
			}
		}
	}
	
	//To Handle window popups
	public static void handleWindowPopUp(String ApplictionPathname)
	{
		try {
			Runtime.getRuntime().exec(ApplictionPathname);
		}
		catch (IOException e) 
		{
			Reporter.log("Could not handle the window based popUP",true);
			
		}
	}
	
	
	// To clear all the check boxes
	public static void clearAllCheckBox()
	{
		BaseTest.driver.findElement(By.xpath("//input[@type='checkbox']")).clear();
	}
	
	// To Scroll by Specified Element
	
	public static void scrollByElement(WebElement element)
	{
		
		Point p=element.getLocation();
		int yAxis=p.getY();
        JavascriptExecutor jse = (JavascriptExecutor) BaseTest.driver;
        jse.executeScript("window.scrollBy(0,yAxis)", "");
	}
	
		
	//To Scroll up by axis
	
	public static void scrollByAxis(int yAxis)
	{
		JavascriptExecutor jse=(JavascriptExecutor) BaseTest.driver;
	
		//	jse.executeScript("window.scrollBy(0,500)", "");
		jse.executeScript("window.scrollBy(0,"+yAxis+")", "");
	}
	
	
	

	//ThreadSleep
	public static void threadSleep(int time)
	{
		try {
				Thread.sleep(time);
			}
		catch (InterruptedException e)
			{
				e.printStackTrace();
			}
	}
	
	public static void scrollDownUsingRobot()
	{
		try 
		{
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_SPACE);
			r.keyRelease(KeyEvent.VK_SPACE);
			  
		} 
		
		catch (AWTException e)
		{
			e.printStackTrace();
		}
	}

}
