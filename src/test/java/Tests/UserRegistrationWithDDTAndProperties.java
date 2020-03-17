package Tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import data.LoadProperties;

public class UserRegistrationWithDDTAndProperties extends TestBase

{
	HomePage homeobject;
	UserRegistrationPage registerobject;
	LoginPage LoginObject;
	String firstname= LoadProperties.userData.getProperty("firstname");
	String lastname= LoadProperties.userData.getProperty("lastname");
	String email= LoadProperties.userData.getProperty("email");
	String password= LoadProperties.userData.getProperty("password");

			
			
	@Test(priority=1,alwaysRun = true)
	public void UserCanRegisterSuccessfully()

	{
		homeobject = new HomePage(driver);
		homeobject.openRegistrationPage();
		registerobject = new UserRegistrationPage(driver);
		registerobject.userRegistration(firstname, lastname, email, password);
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
		LoginObject.UserLogin(email, password);
		Assert.assertTrue(registerobject.LogoutLink.getText().contains("Log out"));
		
	}
	
}
