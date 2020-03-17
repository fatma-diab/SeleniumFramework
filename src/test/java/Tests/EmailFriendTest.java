package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.EmailPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailPage;
import Pages.SearchPage;
import Pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase {
	
	//1-Register user

	HomePage homeobject;
	UserRegistrationPage registerobject;
	LoginPage LoginObject;
	
	SearchPage Searchobject;
	ProductDetailPage ProductDetailsPageobject;
	String ProductName="Apple MacBook Pro 13-inch";
	
	EmailPage Emailobject;
	
	@Test(priority=1,alwaysRun = true)
	public void UserCanRegisterSuccessfully()

	{
		homeobject = new HomePage(driver);
		homeobject.openRegistrationPage();
		registerobject = new UserRegistrationPage(driver);
		registerobject.userRegistration("Fatma", "Diab", "3000@gmail.com", "1239563");
		Assert.assertTrue(registerobject.RegistrationResult.getText().contains("Your registration completed"));

	}
	
	//2- Search for a product
		
	@Test (priority=2)
	public void UserCanSearchUsingAutocomplete() throws InterruptedException
	{
		Searchobject= new SearchPage(driver);
		ProductDetailsPageobject = new ProductDetailPage(driver);
		Searchobject.ProductSearchUsingautocomplete("MacB");
		Assert.assertEquals(ProductDetailsPageobject.ProductnameBreadCrumb.getText(), ProductName);
		
	}
	
	//3- email to friend
	@Test (priority=3)
	
	public void RegisteredUserCanSendProductToFriend ()
	
	{   ProductDetailsPageobject= new ProductDetailPage (driver);
		ProductDetailsPageobject.emailFriendButton.click();
		Emailobject = new EmailPage(driver);
		Emailobject.SendEmailToFriend("abc@gmail.com", "hello my friend");
		Assert.assertTrue(Emailobject.NotificationMessage.getText().contains("Your message has been sent."));
		
	}
	//4- user logout
	@Test(dependsOnMethods = {"RegisteredUserCanSendProductToFriend"})
	public void RegisteredUserCanLogout()
	{
		registerobject.UserLogout();
		
	}

}
