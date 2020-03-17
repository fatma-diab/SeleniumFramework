package Tests;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import data.ExcelReader;

public class UserRegistrationWithDDTUsingExcel extends TestBase

{
	HomePage homeobject;
	UserRegistrationPage registerobject;
	LoginPage LoginObject;
	
	@DataProvider(name =  "ExcelData")
	
	public Object[][] userRegistrationData() throws IOException 
	{
		//get data from excel reader class
		ExcelReader reader= new ExcelReader();
				return reader.getExcelData();
		
	}
	
	
	@Test(priority=1,alwaysRun = true, dataProvider = "ExcelData")
	
	public void UserCanRegisterSuccessfully(String Fname, String lname, String email, String Password)

	{
		homeobject = new HomePage(driver);
		homeobject.openRegistrationPage();
		registerobject = new UserRegistrationPage(driver);
		registerobject.userRegistration(Fname, lname, email, Password);
		Assert.assertTrue(registerobject.RegistrationResult.getText().contains("Your registration completed"));
		registerobject.UserLogout();
		homeobject.openLoginPage();
		LoginObject = new LoginPage(driver);
		LoginObject.UserLogin(email, Password);
		Assert.assertTrue(registerobject.LogoutLink.getText().contains("Log out"));
		registerobject.UserLogout();


	}
	
		
	
}
