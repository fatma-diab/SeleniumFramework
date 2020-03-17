package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase
{

	public HomePage(WebDriver driver) 
	
	{
		super(driver);
		jse= (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	
	
	@FindBy(linkText = "Register")
	WebElement RegisterLink;
	
	@FindBy(linkText = "Log in")
	WebElement LoginLink;
	
	@FindBy(linkText = "Contact us")
	WebElement ContactusLink;
	
	@FindBy(id= "customerCurrency")
	WebElement CurrencyDroplist;
	
	
	@FindBy(linkText ="Computers")
	WebElement ComputerMenu;
	
	@FindBy(linkText ="Notebooks")
	WebElement NoteBooksMenu;
	
	
	
	public void openRegistrationPage()
	{
		clickButton(RegisterLink);
	}

	
	public void openLoginPage()
	{
		clickButton(LoginLink);
	}
	
	public void opencontactUsPage()
	{
		ScrollToButtom();
		clickButton(ContactusLink);
		
	}
	
	public void Chnagecurrency()
	{
		select= new Select(CurrencyDroplist);
		select.selectByVisibleText("Euro");
		
	}
	
	public void selectNoteBookmenu()
	{
		action.moveToElement(ComputerMenu).moveToElement(NoteBooksMenu).click().build().perform();
	}
	
}
