package com.actitime.tests;

import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.generic.GenericUtils;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;
import com.actitime.pages.UserListPage;

public class UpdatingUserTest extends BaseTest
{
	@Test (enabled=true)
	public void testUserCreation()
	{
		//Object for login Page
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
				
				GenericUtils.threadSleep(3000);
				
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
				GenericUtils.threadSleep(5000);
				obj3.clearCheckBoxes();
				GenericUtils.threadSleep(5000);
				
				//Create the user
				obj3.clickOnCreateUserBtn();
				GenericUtils.threadSleep(5000);
	}
	
	
	
	@Test (dependsOnMethods="testUserCreation")
	public void testUpdateUserDetails() 
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
				
				//Instance for UserListPage
				UserListPage obj3=new UserListPage(BaseTest.driver);
				//Click on the User
				String UsersName=ExcelData.Data(path, "Sheet3", 1, 1);
				obj3.editUser(UsersName);
				//Clear the first name
				obj3.clearFirstName();
				//Get the updated name from the excel
				String UserFName=ExcelData.Data(path, "Sheet3", 2, 1);
				//Enter the updated Firstname
				obj3.enterUserFirstName(UserFName);
				obj3.clearLastName();
				String UserLName=ExcelData.Data(path, "Sheet3", 2, 2);
				obj3.enterUserLastName(UserLName);
				obj3.clearEmailID();
				String EmailID=ExcelData.Data(path, "Sheet3", 2, 3);
				obj3.enterUserEmail(EmailID);
				String UsersUserName=ExcelData.Data(path, "Sheet3", 2, 4);
				obj3.clearUsername();
				obj3.enterUsername(UsersUserName);
				String UserPassword=ExcelData.Data(path, "Sheet3", 2, 5);
				obj3.clearPassword();
				obj3.enterUserPassword(UserPassword);
				String RetypePassword=ExcelData.Data(path, "Sheet3", 2, 6);
				obj3.clearRetypePassword();
				obj3.enterRetypePassword(RetypePassword);
				GenericUtils.threadSleep(5000);
				GenericUtils.scrollByAxis(500);
				GenericUtils.threadSleep(5000);
				obj3.clickSaveChanges();
				GenericUtils.threadSleep(5000);
				String UpdatedName=ExcelData.Data(path, "Sheet3", 2, 1);
				obj3.verifyUpdatedUserName(UpdatedName);
				GenericUtils.threadSleep(5000);
				
				
		
	}


}
