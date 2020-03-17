package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase

{

	public UserRegistrationPage(WebDriver driver) 
	
	{
		super(driver);
	}
	
	@FindBy(id="gender-male")
	WebElement GenderRdBtn;
	
	@FindBy(id="FirstName")
	WebElement FirstNametxt;
	
	@FindBy(id="LastName")
	WebElement LastNametxt;
	
	@FindBy(id="Email")
	WebElement Emailtxt;
	
	@FindBy(id="Password")
	WebElement Passwordtxt;
	
	
	@FindBy(id="ConfirmPassword")
	WebElement ConfirmPasswordtxt;
	
	@FindBy(id="register-button")
	WebElement Registerbtn;
	
	@FindBy(css = "div.result")
	public WebElement RegistrationResult;
	
	@FindBy(linkText = "Log out")
	public WebElement LogoutLink;
	
	@FindBy(linkText = "My account")
	public WebElement  MyAccountLink;
	
	public void userRegistration(String Firstname, String Lastname, String Email, String Password)
	
	{
		clickButton(GenderRdBtn);
		setTextElementText(FirstNametxt, Firstname);
		setTextElementText(LastNametxt, Lastname);
		setTextElementText(Emailtxt, Email);
		setTextElementText(Passwordtxt, Password);
		setTextElementText(ConfirmPasswordtxt, Password);
		clickButton(Registerbtn);
	}
	
	
	public void UserLogout()
	{
		clickButton(LogoutLink);
	}
	

	public void openMyAccountPage ()
	
	{
		clickButton(MyAccountLink);
	}
}
