package Tests;


import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;

public class UserRegistrationDDTUsingCSV extends TestBase

{
	HomePage homeobject;
	UserRegistrationPage registerobject;
	LoginPage LoginObject;


	CSVReader reader;

	@Test(priority=1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws CsvValidationException, IOException

	{  //get path for CSV file

		String CSV_file= System.getProperty("user.dir")+"/src/test/java/data/CSVTD.csv";
		reader = new CSVReader(new FileReader(CSV_file));

		String[] csvCell;

		//while loop will be executed till the last value in the CSV file

		while ((csvCell= reader.readNext()) !=null)
		{
			String fname= csvCell[0];
			String lname= csvCell[1];
			String email= csvCell[2];
			String password= csvCell[3];

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


}


