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
	@Test (enabled=true)
	public void testValidLogin()
	{
		
		//Object for login Page
		LoginPage obj1=new LoginPage(driver);
		
		//Check for the login page Title
		String LoginPageActualTitle=ExcelData.Data(path, "Sheet1", 1, 4);
		obj1.verifyTitleofLogin(LoginPageActualTitle);
		
		
		// Excess the testdata for valid Username
		String un=ExcelData.Data(path, "Sheet1", 1, 2);
		obj1.enterUsername(un);
		
		
		// Excess the testdata for valid password
		String pwd=ExcelData.Data(path, "Sheet1", 1, 3);
		obj1.enterPassword(pwd);
		
		
		// Click on login
		obj1.clickLogin();
		EnterTimeTrackPage obj2=new EnterTimeTrackPage(driver);
		
		//Check for the homePage Title
		String HomePageActualTitle=ExcelData.Data(path, "Sheet2", 1, 2);
		obj2.verifyTitleofHomePage(HomePageActualTitle);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Click on Users Module
		obj2.clickOnUsers();
		
		//Object for UserListPage
		UserListPage obj3=new UserListPage(driver);
		
		//Check for the Title of Users Page
	//	String UserListPageActualTitle=ExcelData.Data(path, "Sheet3", 1, 0);
	//	obj3.verifyTitle(UserListPageActualTitle);
		
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
		String UserFName=ExcelData.Data(path, "Sheet3", 2, 3);
		obj3.enterUserFirstName(UserFName);
		//Enter LastName
		String UserLName=ExcelData.Data(path, "Sheet3", 2, 4);
		obj3.enterUserLastName(UserLName);
		// Enter user's mailID
		String UserEmail=ExcelData.Data(path, "Sheet3", 2, 5);
		obj3.enterUserEmail(UserEmail);
		// Enter User's Username
		String UsersUserName=ExcelData.Data(path, "Sheet3", 2, 6);
		obj3.enterUsername(UsersUserName);
		// Enter User's Password
		String UserPassword=ExcelData.Data(path, "Sheet3", 2, 7);
		obj3.enterUserPassword(UserPassword);
		
		//Enter re-Retype Password
		String RetypePwd=ExcelData.Data(path, "Sheet3", 2, 8);
		obj3.enterRetypePassword(RetypePwd);
		
		//ScrollUsingElement
		obj3.ScrollUsingElementRetype();
		GenericUtils.scrollByAxis(300);
		//Clear the checkBoxes
		GenericUtils.threadSleep(5000);
		obj3.clearCheckBoxes();
		GenericUtils.threadSleep(5000);
		
		//Scroll Using Element
		obj3.clickOnCreateUserBtn();
		GenericUtils.threadSleep(5000);
		
		GenericUtils.scrollByAxis(-300);
		
			
	}

	
	
	@Test(enabled=false,dependsOnMethods="testValidLogin")
	public void testRegisteredUser()
	{
		LoginPage obj1=new LoginPage(driver);
		
		// Excess the testdata for valid Username
				String un=ExcelData.Data(path, "Sheet1", 1, 2);
				obj1.enterUsername(un);
				
				
				// Excess the testdata for valid password
				String pwd=ExcelData.Data(path, "Sheet1", 1, 3);
				obj1.enterPassword(pwd);
				
				
				// Click on login
				obj1.clickLogin();
				EnterTimeTrackPage obj2=new EnterTimeTrackPage(driver);
				GenericUtils.threadSleep(3000);
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
				String UserFName=ExcelData.Data(path, "Sheet3", 3, 3);
				obj3.enterUserFirstName(UserFName);
				//Enter LastName
				String UserLName=ExcelData.Data(path, "Sheet3", 3, 4);
				obj3.enterUserLastName(UserLName);
				// Enter user's mailID
				String UserEmail=ExcelData.Data(path, "Sheet3", 3, 5);
				obj3.enterUserEmail(UserEmail);
				// Enter User's Username
				String UsersUserName=ExcelData.Data(path, "Sheet3", 3, 6);
				obj3.enterUsername(UsersUserName);
				// Enter User's Password
				String UserPassword=ExcelData.Data(path, "Sheet3", 3, 7);
				obj3.enterUserPassword(UserPassword);
				
				//Enter re-Retype Password
				String RetypePwd=ExcelData.Data(path, "Sheet3", 3, 8);
				obj3.enterRetypePassword(RetypePwd);
				
				
				//ScrollUsingElement
				obj3.ScrollUsingElementRetype();
				GenericUtils.scrollByAxis(300);
				
			
				GenericUtils.threadSleep(5000);
				
				//Scroll Using Element
				obj3.clickOnCreateUserBtn();
				GenericUtils.threadSleep(5000);
				
				GenericUtils.scrollByAxis(-300);
				obj3.verifyExistingUserMessage();
				
				
				GenericUtils.scrollByAxis(300);
				obj3.clickOnCancellBtn();
				//To accept the Pop Up
				GenericUtils.acceptJavascriptPopup();
				GenericUtils.threadSleep(3000);
			//Check for the users Name in the Table for verifying its presence	
				String UsersName=ExcelData.Data(path, "Sheet3", 3, 3);
				obj3.enterUsersNameSearchBox(UsersName);
				GenericUtils.threadSleep(5000);
				String UsersNameSearch=ExcelData.Data(path, "Sheet3", 3, 3);
				obj3.verifyUsersName(UsersNameSearch);
				
				
				
	}

}

//This has being synched with the excel Data