package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.actitime.generic.BasePage;

public class EnterTimeTrackPage extends BasePage
{
	@FindBy (id="logoutLink")
	private WebElement Logout;
	@FindBy (xpath="//div[@class='popup_menu_button popup_menu_button_support']")
	private WebElement Help;
	@FindBy (xpath="//a[.='About your actiTIME']")
	private WebElement AboutYouractiTIME;
	@FindBy (xpath="//span[contains(.,'40004')]")
	private WebElement BuildNumber;
	@FindBy (xpath="//a[@class='content users']//div[.='USERS']")
	private WebElement Users;
	
	
	
	public EnterTimeTrackPage(WebDriver driver) 
	{	super(driver);
		PageFactory.initElements(driver, this);
	
	}
	
	public void verifyTitleofHomePage(String ExpectedTitle)
	{
		verifyTitle(ExpectedTitle);
	}
	
	public void clickOnHelpMenu()
	{
		Help.click();
	}
	
	public void clickOnAboutactiTIME()
	{
		AboutYouractiTIME.click();
	}
	
	public void verifyBuildNumber(String expectedBuildno)
	{
		String actualBuildNumber=BuildNumber.getText();
		Reporter.log(actualBuildNumber);
		try
		{
			Assert.assertEquals(actualBuildNumber, expectedBuildno);
			Reporter.log("Both actual and expected build numbers are matching",true);
		}
		catch(Exception e)
		{
			Reporter.log("Both actual and expected build numbers are not matching",true);
			Assert.fail();
		}
		
	}
	
	public void clickOnUsers()
	{
		Users.click();
	}
	
	
	
	public void clickOnLogout()
	{
		Logout.click();
	}


}
