package com.actitime.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.actitime.generic.BasePage;
import com.actitime.generic.GenericUtils;

public class UserListPage extends BasePage
{
	@FindBy (xpath="(//div[.='Add User'])[1]")
	private WebElement AddUser;
	@FindBy (name="firstName")
	private WebElement FirstName;
	@FindBy (name="lastName")
	private WebElement LastName;
	@FindBy (name="email")
	private WebElement Email;
	@FindBy (name="username")
	private WebElement EmpUserName;
	@FindBy (name="password")
	private WebElement EmpPassword;
	@FindBy (name="passwordCopy")
	private WebElement RetypePassword;
	@FindBy (xpath="(//div[.='Create User'])[1]")
	private WebElement CreateUser;
	@FindBy (xpath="(//table[@id='userDataLightBox_permissionsTable']//input[@type='checkbox'])[1]")
	private WebElement EnterTimeTrack;
	@FindBy (xpath="(//table[@id='userDataLightBox_permissionsTable']//input[@type='checkbox'])[2]")
	private WebElement ModifyTimeTrack;
	@FindBy (xpath="(//table[@id='userDataLightBox_permissionsTable']//input[@type='checkbox'])[4]")
	private WebElement ManageCustomerAndProject;
	@FindBy (xpath="(//table[@id='userDataLightBox_permissionsTable']//input[@type='checkbox'])[5]")
	private WebElement ManageTask;
	@FindBy (xpath="(//table[@id='userDataLightBox_permissionsTable']//input[@type='checkbox'])[6]")
	private WebElement GenerateTimeReports;
	@FindBy (xpath="(//table[@id='userDataLightBox_permissionsTable']//input[@type='checkbox'])[7]")
	private WebElement GenerateBillingReport;
	@FindBy (xpath="(//table[@id='userDataLightBox_permissionsTable']//input[@type='checkbox'])[9]")
	private WebElement ManageAccountsAndPermission;
	@FindBy (xpath="(//table[@id='userDataLightBox_permissionsTable']//input[@type='checkbox'])[10]")
	private WebElement ManageSystemSetting;
	@FindBy (xpath="//span[.='Create User']")
	private WebElement CreateUserBtn;
	@FindBy (xpath="//input[contains(@class,'filterFieldInput')]")
	private WebElement UserSearchFilter;
	@FindBy (xpath="//span[@id='userListTableContainer']")
	private List<WebElement> UserListTableContainer;
	@FindBy (xpath="(//div[.='this username is already registered'])[2]")
	private WebElement ExistingUserMessage;	
	@FindBy (xpath="(//div[.='Cancel'])[1]")
	private WebElement CancelButton;
	@FindBy (xpath="//span[@class='userNameSpan']//span")
	private WebElement UserDetails;
	@FindBy (xpath="//span[.='Save Changes']")
	private WebElement SavesChanges;
	
	
	
	
	
	public UserListPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	// To click on the add Users Module
	public void clickOnAddUsers()
	{
		AddUser.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Enter the information regarding the Account Information
	public void enterUserFirstName(String UserFName)
	{
		FirstName.sendKeys(UserFName);
	}
	
	public void enterUserLastName(String UserLName)
	{
		LastName.sendKeys(UserLName);
	}
	
	public void enterUserEmail(String UserEmail)
	{
		Email.sendKeys(UserEmail);
	}
	
	public void enterUsername(String UsersUserName)
	{
		EmpUserName.sendKeys(UsersUserName);
	}
	
	public void enterUserPassword(String UserPassword)
	{
		EmpPassword.sendKeys(UserPassword);
	}
	public void enterRetypePassword(String RetypePwd)
	{
		RetypePassword.sendKeys(RetypePwd);
	}
	public void ScrollUsingElementRetype()
	{
		RetypePassword.sendKeys(Keys.PAGE_DOWN);
	}
	
	
	public void clearCheckBoxes()
	{
		//EnterTimeTrack.click();
		ModifyTimeTrack.click();
		ManageCustomerAndProject.click();
		ManageTask.click();
		GenerateTimeReports.click();
		GenerateBillingReport.click();
		ManageAccountsAndPermission.click();
		ManageSystemSetting.click();
	}
	
	public void clickOnCreateUserBtn()
	{
		CreateUser.click();
	}
	
	public void enterUsersNameSearchBox(String UsersName)
	{
		UserSearchFilter.sendKeys(UsersName);
		UserSearchFilter.sendKeys(Keys.ENTER);
	}
	public void editUser(String UsersName)
	{
		UserSearchFilter.sendKeys(UsersName);
		UserSearchFilter.sendKeys(Keys.ENTER);
		GenericUtils.threadSleep(5000);
		UserDetails.click();
		GenericUtils.threadSleep(5000);
		/*
		for(WebElement element:UserListTableContainer)
		{
			String tableData=element.getText()
			
			
			if(tableData.contains(UsersName))
			{
				UserDetails.click();
			}
		}
		*/
				
	}
	public void verifyUsersName(String UsersName)
	{
		
		
		for(WebElement element:UserListTableContainer)
		{
			String tableData=element.getText();
			
			
			try
			{
				boolean Result = (tableData.contains(UsersName));
				Assert.assertTrue(Result);
				Reporter.log("Username exist in the Table",true);
			}
			catch(Exception e)
			{
				Assert.fail();
			}
		
		
			
		}
			
	}
	
	public void verifyExistingUserMessage()
	{
		verifyElement(ExistingUserMessage);
	
	}
	public void clickOnCancellBtn()
	{
		CancelButton.click();
	}
	
	public void verifyTitleUserPage(String eTitle)
	{
		verifyTitle(eTitle);
	}
	
	public void clearFirstName()
	{
		FirstName.clear();
	}
	public void clearLastName()
	{
		LastName.clear();
	}
	public void clearEmailID()
	{
		Email.clear();
	}
	public void clearUsername()
	{
		EmpUserName.clear();
	}
	public void clearPassword()
	{
		EmpPassword.clear();
	}
	public void clearRetypePassword()
	{
		RetypePassword.clear();
	}
	public void clickSaveChanges()
	{
		SavesChanges.click();
	}
	
	public void verifyUpdatedUserName(String expectedName)
	{
		String actualName=UserDetails.getText();
		
		if(actualName.equals(expectedName))
		{
			Reporter.log("Both actual and expected name matches",true);
		}
		else
		{
			Reporter.log("Strings are not matching");
			Assert.fail();
		}
	
	}

}
