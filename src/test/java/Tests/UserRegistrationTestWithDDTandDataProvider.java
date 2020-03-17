package Tests;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTandDataProvider extends TestBase

{
	HomePage homeobject;
	UserRegistrationPage registerobject;
	LoginPage LoginObject;


	@DataProvider (name = "testData")
	public static Object[] [] userData()
	{
		return new Object[] [] {
			{"Fatma", "Diab", "fabc@ghj.com" ,"789456123"},
			{"ahmed", "momo", "ffrt@hgt.com", "8788888"}
		};


	}


	@Test(priority=1,alwaysRun = true, dataProvider ="testData")
	public void UserCanRegisterSuccessfully(String fname, String lname, String email, String password)

	{
		homeobject = new HomePage(driver);
		homeobject.openRegistrationPage();
		registerobject = new UserRegistrationPage(driver);
		registerobject.userRegistration(fname, lname, email, password);
		Assert.assertTrue(registerobject.RegistrationResult.getText().contains("Your registration completed"));
		registerobject.UserLogout();
		homeobject.openLoginPage();
		LoginObject = new LoginPage(driver);
		LoginObject.UserLogin(email, password);
		Assert.assertTrue(registerobject.LogoutLink.getText().contains("Log out"));
		registerobject.UserLogout();


	}

	

}
