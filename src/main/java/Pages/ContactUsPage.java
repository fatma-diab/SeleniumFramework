package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase 
{

	public ContactUsPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(id = "FullName")
	WebElement FullNameTextbox;
	
	@FindBy(id="Email")
	 WebElement EmailTextbox;
	
	@FindBy(id="Enquiry")
	WebElement EnquiryTextbox;
	
	@FindBy(name="send-email")
	WebElement Submitbutton;
	
	@FindBy(css="div.result")
	public WebElement Successmessage;
	
	public void ContactUs(String fullname , String email , String enquiry)
	{
		setTextElementText(FullNameTextbox, fullname);
		setTextElementText(EmailTextbox, email);
		setTextElementText(EnquiryTextbox, enquiry);
		clickButton(Submitbutton);
	}
	

}
