package com.actitime.tests;

import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.generic.GenericUtils;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;
import com.actitime.pages.UserListPage;

public class RegisteredUserTest extends BaseTest
{
	@Test(enabled=false)
	public void testRegisteredUser()
	{
		LoginPage obj1=new LoginPage(driver);
		
		// Excess the testdata for valid Username
				String un=ExcelData.Data(path, "Sheet1", 1, 0);
				obj1.enterUsername(un);
				
				
				// Excess the testdata for valid password
				String pwd=ExcelData.Data(path, "Sheet1", 1, 1);
				obj1.enterPassword(pwd);
				
				
				// Click on login
				obj1.clickLogin();
				EnterTimeTrackPage obj2=new EnterTimeTrackPage(driver);
				
				//Click on Users Module
				obj2.clickOnUsers();
				
				//Object for UserListPage
				UserListPage obj3=new UserListPage(driver);
				
				
				//Click on Add User
				obj3.clickOnAddUsers();
				
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
				String UserFName=ExcelData.Data(path, "Sheet3", 1, 1);
				obj3.enterUserFirstName(UserFName);
				//Enter LastName
				String UserLName=ExcelData.Data(path, "Sheet3", 1, 2);
				obj3.enterUserLastName(UserLName);
				// Enter user's mailID
				String UserEmail=ExcelData.Data(path, "Sheet3", 1, 3);
				obj3.enterUserEmail(UserEmail);
				// Enter User's Username
				String UsersUserName=ExcelData.Data(path, "Sheet3", 1, 4);
				obj3.enterUsername(UsersUserName);
				// Enter User's Password
				String UserPassword=ExcelData.Data(path, "Sheet3", 1, 5);
				obj3.enterUserPassword(UserPassword);
				
				//Enter re-Retype Password
				String RetypePwd=ExcelData.Data(path, "Sheet3", 1, 6);
				obj3.enterRetypePassword(RetypePwd);
				
				
				//ScrollUsingElement
				obj3.ScrollUsingElementRetype();
				GenericUtils.scrollByAxis(300);
				
				//Clear the checkBoxes
			//	GenericUtils.threadSleep(5000);
				
				//Scroll Using Element
				//obj3.clickOnCreateUserBtn();
			//	GenericUtils.threadSleep(5000);
				
				GenericUtils.scrollByAxis(-300);
				obj3.verifyExistingUserMessage();
				
				
				GenericUtils.scrollByAxis(300);
				obj3.clickOnCancellBtn();
				//To accept the Pop Up
				GenericUtils.acceptJavascriptPopup();
				GenericUtils.threadSleep(3000);
			//Check for the users Name in the Table for verifying its presence	
				String UsersName=ExcelData.Data(path, "Sheet3", 1, 1);
				obj3.enterUsersNameSearchBox(UsersName);
				GenericUtils.threadSleep(5000);
				String UsersNameSearch=ExcelData.Data(path, "Sheet3", 1, 1);
				obj3.verifyUsersName(UsersNameSearch);
				
				
				
	}

}
