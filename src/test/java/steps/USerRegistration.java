package steps;


import Pages.HomePage;
import Pages.UserRegistrationPage;
import Tests.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class USerRegistration extends TestBase

{	
	HomePage homeobject;
	UserRegistrationPage registrationObject;


	@Given("^the user in the home page$")
	public void the_user_in_the_home_page()
	{ homeobject = new HomePage(driver);
	homeobject.openRegistrationPage();

	}

	@When("^I click on Register link$")
	public void I_click_on_Register_link()

	{
		org.testng.Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	
	
	@When("^I entered \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$") 
			public void I_enter(String firstname, String lastname, String email, String password)

	{
		registrationObject= new UserRegistrationPage(driver);
		registrationObject.userRegistration(firstname, lastname, email, password);
	}



	@Then("^the registration page displayed successfully$")
	public void the_registration_page_displayed_successfull()
	{
		registrationObject.UserLogout();
	}

}
