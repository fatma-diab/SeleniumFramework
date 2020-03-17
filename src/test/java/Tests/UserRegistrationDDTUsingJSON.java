package Tests;


import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import data.JsonDataReader;

public class UserRegistrationDDTUsingJSON extends TestBase

{
	HomePage homeobject;
	UserRegistrationPage registerobject;
	LoginPage LoginObject;


	@Test(priority=1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws IOException, ParseException

	{
		JsonDataReader jsonReader= new JsonDataReader();
		jsonReader.JsonReader();
		
		homeobject = new HomePage(driver);
		homeobject.openRegistrationPage();
		registerobject = new UserRegistrationPage(driver);
		registerobject.userRegistration(jsonReader.firstname, jsonReader.lastname, jsonReader.email, jsonReader.password);
		Assert.assertTrue(registerobject.RegistrationResult.getText().contains("Your registration completed"));
		registerobject.UserLogout();
		homeobject.openLoginPage();
		LoginObject = new LoginPage(driver);
		LoginObject.UserLogin(jsonReader.email, jsonReader.password);
		Assert.assertTrue(registerobject.LogoutLink.getText().contains("Log out"));
		registerobject.UserLogout();
	}



}


