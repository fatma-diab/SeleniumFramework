package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailPage;
import Pages.ProductReviewPage;
import Pages.SearchPage;
import Pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase

{
	
	//1- Register user

		HomePage homeobject;
		UserRegistrationPage registerobject;
		LoginPage LoginObject;
		SearchPage Searchobject;
		ProductDetailPage ProductDetailsPageobject;
		String ProductName="Apple MacBook Pro 13-inch";
		ProductReviewPage Reviewobject;
		
		
		@Test(priority=1,alwaysRun = true)
		public void UserCanRegisterSuccessfully()

		{
			homeobject = new HomePage(driver);
			homeobject.openRegistrationPage();
			registerobject = new UserRegistrationPage(driver);
			registerobject.userRegistration("Fatma", "Diab", "5000@gmail.com", "1539563");
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
		
		//3- Add review
		@Test (priority=3)
		
		public void RegisteredUserCanAddReview()
		{
			Reviewobject= new ProductReviewPage(driver);
			ProductDetailsPageobject= new ProductDetailPage(driver);
			ProductDetailsPageobject.OpenReviewPage();
			Reviewobject.AddProductReview("Reviewtitle", "ReviewText");
			Assert.assertTrue(Reviewobject.AddReviewResultMessage.getText().contains("Product review is successfully added."));
			
		}
		
		
		//4- user logout
		@Test(dependsOnMethods = {"RegisteredUserCanAddReview"})
		public void RegisteredUserCanLogout()
		{
			registerobject.UserLogout();
			
		}

}
