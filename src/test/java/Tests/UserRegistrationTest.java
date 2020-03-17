package Tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase

{
	HomePage homeobject;
	UserRegistrationPage registerobject;
	LoginPage LoginObject;
	
	@Test(priority=1,alwaysRun = true)
	public void UserCanRegisterSuccessfully()

	{
		homeobject = new HomePage(driver);
		homeobject.openRegistrationPage();
		registerobject = new UserRegistrationPage(driver);
		registerobject.userRegistration("Fatma", "Diab", "ab300@gmail.com", "001236786");
		Assert.assertTrue(registerobject.RegistrationResult.getText().contains("Your registration completed"));

	}
	
	@Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
	public void RegisteredUserCanLogout()
	{
		registerobject.UserLogout();
		
	}
	
	@Test(dependsOnMethods = {"RegisteredUserCanLogout"})
	public void RegisteredUserCanLogin()
	{
		homeobject.openLoginPage();
		LoginObject = new LoginPage(driver);
		LoginObject.UserLogin("ab36300@gmail.com", "001236786");
		Assert.assertTrue(registerobject.LogoutLink.getText().contains("Log out"));
		
	}
	
}
