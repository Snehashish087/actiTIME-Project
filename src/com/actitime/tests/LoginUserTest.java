package com.actitime.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.generic.GenericUtils;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;
import com.actitime.pages.UserListPage;

public class LoginUserTest extends BaseTest 
{
	@Test(enabled=true)
	public void testLoginUserUpdate()
	
	{
		
	

	//Object for login Page
	LoginPage loginPage=new LoginPage(driver);
	
	
	
	// Excess the testdata for valid Username
	String un=ExcelData.Data(path, "Sheet1", 6, 2);
	loginPage.enterUsername(un);
	
	
	// Excess the testdata for valid password
	String pwd=ExcelData.Data(path, "Sheet1", 6, 3);
	loginPage.enterPassword(pwd);
	
	
	// Click on login
	loginPage.clickLogin();
	EnterTimeTrackPage enterTimeTrackPage=new EnterTimeTrackPage(driver);
	
	//Click on Users Module
	enterTimeTrackPage.clickOnUsers();
	
	//Object for UserListPage
	UserListPage userListPage=new UserListPage(driver);
	
	//Click on Add User
	userListPage.clickOnAddUsers();
	
	//Enter the Account Information
	try 
	{
		Thread.sleep(3000);
	}
	catch (InterruptedException e) 
	{
	
		e.printStackTrace();
	}
	//Enter FirstName
	String UserFName=ExcelData.Data(path, "Sheet3", 9, 3);
	userListPage.enterUserFirstName(UserFName);
	//Enter LastName
	String UserLName=ExcelData.Data(path, "Sheet3", 9, 4);
	userListPage.enterUserLastName(UserLName);
	// Enter user's mailID
	String UserEmail=ExcelData.Data(path, "Sheet3", 9, 5);
	userListPage.enterUserEmail(UserEmail);
	// Enter User's Username
	String UsersUserName=ExcelData.Data(path, "Sheet3", 9, 6);
	userListPage.enterUsername(UsersUserName);
	// Enter User's Password
	String UserPassword=ExcelData.Data(path, "Sheet3", 9, 7);
	userListPage.enterUserPassword(UserPassword);
	
	//Enter re-Retype Password
	String RetypePwd=ExcelData.Data(path, "Sheet3", 9, 8);
	userListPage.enterRetypePassword(RetypePwd);
	
	//ScrollUsingElement
	userListPage.ScrollUsingElementRetype();
	GenericUtils.scrollByAxis(300);
	//Clear the checkBoxes
	//GenericUtils.threadSleep(5000);
	//userListPage.clearCheckBoxes();
	GenericUtils.threadSleep(5000);
	
	//Scroll Using Element
	userListPage.clickOnCreateUserBtn();
	GenericUtils.threadSleep(5000);
	
	//Click on Logout
	GenericUtils.scrollByAxis(-300);
	enterTimeTrackPage.clickOnLogout();
	
	//Fetch the UserName for the created User
	String NewUserName=ExcelData.Data(path, "Sheet3", 10, 6);
	loginPage.enterUsername(NewUserName);
	//Fetch the password for the created user
	String NewPassword=ExcelData.Data(path, "Sheet3", 10, 7);
	loginPage.enterPassword(NewPassword);
	//Click on Login
	loginPage.clickLogin();
	
	GenericUtils.threadSleep(3000);
	//skip The tutorial Section
	
	enterTimeTrackPage.clickOnExploreActitimeButton();
	
	GenericUtils.threadSleep(3000);
	GenericUtils.scrollByAxis(-300);
	GenericUtils.threadSleep(3000);
	//Fetch the login User name and check for the expected name
	String fullUserName=UserFName+" "+UserLName;
	Reporter.log(fullUserName,true);
	enterTimeTrackPage.verifyLoginUserName(fullUserName);
	GenericUtils.threadSleep(5000);
	
	}
}
//Synched with excel data
