package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase

{

	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(id = "Email")
	WebElement EmailTextBox;
	
	@FindBy(id = "Password")
	WebElement PasswordTextBox;
	
	@FindBy(css = "input.button-1.login-button")
	WebElement LoginButton;
	
	
	public void UserLogin(String Email, String Password)
	{
		setTextElementText(EmailTextBox, Email);
		setTextElementText(PasswordTextBox, Password);
		clickButton(LoginButton);
	}
	

}
