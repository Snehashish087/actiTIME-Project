package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements AutoConst
{

	public static WebDriver driver;
	
	@BeforeMethod
	public void preCondition()
	{
		
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com");
		
	}
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}

}
