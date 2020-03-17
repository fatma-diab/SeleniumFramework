package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ContactUsPage;
import Pages.HomePage;

public class ContactUsTest extends TestBase

{
	HomePage Homeobject;
	ContactUsPage ContactUsObject;
	
	String fullname= "Fatma Diab";
	String email = "abc@gmail.com";
	String enquiry ="hello, this  is for test";
	
	@Test
	public void UserCanUseContactUs()
	{
		Homeobject= new HomePage(driver);
		Homeobject.opencontactUsPage();
		ContactUsObject= new ContactUsPage(driver);
		ContactUsObject.ContactUs(fullname,email, enquiry);
		Assert.assertTrue(ContactUsObject.Successmessage.getText().contains("Your enquiry has been successfully sent to the store owner."));
		
	}
	
}
