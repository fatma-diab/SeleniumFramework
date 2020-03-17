package Tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;

public class UserRegistrationDDTUsingFaker extends TestBase

{
	HomePage homeobject;
	UserRegistrationPage registerobject;
	LoginPage LoginObject;
	Faker fakeData=new Faker();
	String firstname=fakeData.name().firstName();
	String lastname= fakeData.name().lastName();
	String email =fakeData.internet().emailAddress();
	String password=fakeData.number().digits(8).toString();


	@Test(priority=1,alwaysRun = true)
	public void UserCanRegisterSuccessfully()

	{
		homeobject = new HomePage(driver);
		homeobject.openRegistrationPage();
		registerobject = new UserRegistrationPage(driver);
		registerobject.userRegistration(firstname, lastname, email, password);
		Assert.assertTrue(registerobject.RegistrationResult.getText().contains("Your registration completed"));
		registerobject.UserLogout();

		homeobject.openLoginPage();
		LoginObject = new LoginPage(driver);
		LoginObject.UserLogin(email, password);
		Assert.assertTrue(registerobject.LogoutLink.getText().contains("Log out"));
		registerobject.UserLogout();

	}

}
