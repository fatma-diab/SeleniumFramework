package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase
{

	public EmailPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id=  "FriendEmail")
	WebElement FriendemailTextBox;
	
	@FindBy(id="PersonalMessage")
	WebElement PersonalMessageTextBox;
	
	@FindBy(name = "send-email")
	WebElement SendEmailbutton;
	
	@FindBy(css= "div.result")
	public WebElement NotificationMessage;
	
	
	public void SendEmailToFriend (String friendemail, String personalmessage)
	{
		setTextElementText(FriendemailTextBox, friendemail);
		setTextElementText(PersonalMessageTextBox, personalmessage);
		clickButton(SendEmailbutton);
	}
	
}
