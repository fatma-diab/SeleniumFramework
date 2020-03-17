package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegistrationPage;

public class MyAccountTest extends TestBase 
{
	HomePage homeobject;
	UserRegistrationPage registerobject;
	LoginPage LoginObject;
	MyAccountPage MyAccountObject;
	
	String oldpassword= "21236783";
	String newpassword= "1234567";
	String Fname="fatma";
	String Lname="diab";
	String Email= "abc3@abc.com";
	
	
	@Test(priority=1,alwaysRun = true)
	public void UserCanRegisterSuccessfully()

	{
		homeobject = new HomePage(driver);
		homeobject.openRegistrationPage();
		registerobject = new UserRegistrationPage(driver);
		registerobject.userRegistration(Fname, Lname, Email, oldpassword);
		Assert.assertTrue(registerobject.RegistrationResult.getText().contains("Your registration completed"));

	}
	
	@Test (priority=2)
	public void UserCanChangePassword ()
	
	{
		MyAccountObject = new MyAccountPage(driver);
		registerobject.openMyAccountPage();
		MyAccountObject.OpenChangePasswordLink();
		MyAccountObject.ChangePassword(oldpassword, newpassword);
		Assert.assertTrue(MyAccountObject.ChangePasswordSuccessMessage.getText().contains("Password was changed"));
	}
	
	
	@Test(priority=3)
	public void RegisteredUserCanLogout()
	{
		registerobject.UserLogout();
		
	}
	
	@Test(priority=4)
	public void RegisteredUserCanLogin()
	{
		homeobject.openLoginPage();
		LoginObject = new LoginPage(driver);
		LoginObject.UserLogin(Email, newpassword);
		Assert.assertTrue(registerobject.LogoutLink.getText().contains("Log out"));
		
	}
}
