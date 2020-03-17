package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase	
{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Change password")
	WebElement ChangePasswordLink;
	
	@FindBy(id = "OldPassword")
	WebElement OldPasswordText;
	
	@FindBy(id = "NewPassword")
	WebElement NewPasswordText;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement ConfirmNewPasswordText;
	
	@FindBy(css = "input.button-1.change-password-button")
	WebElement ChangePasswordButton;
	
	@FindBy(css="div.result")
	public WebElement ChangePasswordSuccessMessage;
	
	public void OpenChangePasswordLink()
	{
		clickButton(ChangePasswordLink);
	}
	
	public void ChangePassword (String OldPassword, String NewPassword)
	{
		setTextElementText(OldPasswordText, OldPassword);
		setTextElementText(NewPasswordText, NewPassword);
		setTextElementText(ConfirmNewPasswordText, NewPassword);
		clickButton(ChangePasswordButton);
	}

}
