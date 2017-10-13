package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.actitime.generic.BasePage;

public class LoginPage extends BasePage
{
	

		@FindBy(id="username")
		private WebElement userName;
		@FindBy(name="pwd")
		private WebElement passWord;
		@FindBy(xpath="//a[.='Login ']")
		private WebElement Login;
		@FindBy(xpath="//span[contains(.,'invalid')]")
		private WebElement ErrMessage;
		@FindBy(xpath="//nobr[contains(.,'actiTIME 2017')]")
		private WebElement version;
		
		public LoginPage(WebDriver driver)
		{
			super(driver);
			PageFactory.initElements(driver, this);
		}
		
		//Enter the username
		public void enterUsername(String un)
		{
			userName.sendKeys(un);
		}
		//Enter the password
		public void enterPassword(String pwd)
		{
			passWord.sendKeys(pwd);
		}
		//Click on Login
		public void clickLogin()
		{
			Login.click();
		}
		// To Verify the Title
		public void verifyTitleofLogin(String ActualTitle)
		{
			verifyTitle(ActualTitle);
		}
		//To verify the version
		public void verifyfVersion(String ExpectedVersion)
		{
			String ActualVersion=version.getText();
			try
			{
				Assert.assertEquals(ActualVersion, ExpectedVersion);
				Reporter.log("The actual and expected Versions are matching",true);
			}
			catch(Exception e)
			{
				Reporter.log("The actual and the expected versions are not matching",true);
				Assert.fail();
			}
		}
		
		//To verify the error Message
		public void verifyErrorMessage()
		{
			verifyElement(ErrMessage);
		}
		

}
