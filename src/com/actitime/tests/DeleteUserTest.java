package com.actitime.tests;

import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;
import com.actitime.pages.UserListPage;

public class DeleteUserTest extends BaseTest
{
	@Test (enabled=false)
	public void testDeletingTheExistingUser()
	{
			//Object for login Page
			LoginPage loginPage=new LoginPage(driver);
			
			
			
			// Excess the testdata for valid Username
			String un=ExcelData.Data(path, "Sheet1", 1, 2);
			loginPage.enterUsername(un);
			
			
			// Excess the testdata for valid password
			String pwd=ExcelData.Data(path, "Sheet1", 1, 3);
			loginPage.enterPassword(pwd);
			
			
			// Click on login
			loginPage.clickLogin();
			EnterTimeTrackPage enterTimeTrackPage=new EnterTimeTrackPage(driver);
			
			//Click on Users Module
			enterTimeTrackPage.clickOnUsers();
			
			//Object for UserListPage
			UserListPage userListPage=new UserListPage(driver);
			
			//Search for the existing user from the list
			String ExistingUser=ExcelData.Data(path, "Sheet3", 6, 3);
			//Edit the user from the master Grid by searching the existing User
		//	userListPage.editUser(ExistingUser);
			userListPage.searchVerifyAndDelete(ExistingUser);
			
		
			
			
			
			

	}
}


//This test class has been synced with test Data file.