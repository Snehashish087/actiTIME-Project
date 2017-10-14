package com.actitime.tests;

import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.generic.GenericUtils;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;
import com.actitime.pages.UserListPage;

public class InvalidUserLoginTest extends BaseTest
{
		
	@Test
	public void testwithInvalidUserPassword()
	{
		LoginPage loginPage=new LoginPage(driver);
		
		// Excess the testdata for valid Username
				String un=ExcelData.Data(path, "Sheet1", 7, 1);
				loginPage.enterUsername(un);
				
				
				// Excess the testdata for valid password
				String pwd=ExcelData.Data(path, "Sheet1", 7, 2);
				loginPage.enterPassword(pwd);
				
				
				// Click on login
				loginPage.clickLogin();
				EnterTimeTrackPage enterTimeTrackPage=new EnterTimeTrackPage(driver);
				
				//Click on Users Module
				enterTimeTrackPage.clickOnUsers();
				
				//Instance for UserListPage
				UserListPage userListPage=new UserListPage(BaseTest.driver);
				//Click on the User
				String UsersName=ExcelData.Data(path, "Sheet3", 9, 6);
				userListPage.editUser(UsersName);
				
				//Update the Password field
				String UserPassword=ExcelData.Data(path, "Sheet3", 9, 7);
				//userListPage.clearPassword();
				userListPage.enterUserPassword(UserPassword);
				
				
				//update retype Password field
				String RetypePassword=ExcelData.Data(path, "Sheet3", 9, 8);
				//userListPage.clearRetypePassword();
				userListPage.enterRetypePassword(RetypePassword);
				
				GenericUtils.threadSleep(2000);
				GenericUtils.scrollByAxis(500);
				GenericUtils.threadSleep(2000);
				userListPage.clickSaveChanges();
				GenericUtils.threadSleep(2000);
				GenericUtils.scrollByAxis(-300);
				GenericUtils.threadSleep(2000);
				enterTimeTrackPage.clickOnLogout();
				GenericUtils.threadSleep(2000);
				//Enter the same username
				loginPage.enterUsername(UsersName);
				
				//Enter Invalid Password
				String InvalidPassword=ExcelData.Data(path, "Sheet3", 10, 7);
				
				loginPage.enterPassword(InvalidPassword);
				//Click on Login Button
				loginPage.clickLogin();
				
				GenericUtils.threadSleep(2000);
				loginPage.verifyErrorMessage();
				GenericUtils.threadSleep(2000);
		
	}

}


