package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(name ="removefromcart")
	WebElement RemovefromCartCheck;
	
	@FindBy(css = "td.subtotal")
	WebElement subtotal;
	
	@FindBy(name= "itemquantity12089")
	WebElement Quantitytxtbox;
	
	@FindBy(name = "updatecart")
	WebElement UpdateCartbtn;
	
	@FindBy(css = "td.product")
	public WebElement ProductnameInCart;
	
	@FindBy(css = "div.no-data")
	public WebElement EmptyCartLable;
	
	@FindBy(id ="checkout")
	WebElement CheckOutBtn;

	@FindBy (id="termsofservice")
	WebElement TermsCheckbox;
	
	public void removeProductFromCart ()
	{
		clickButton(RemovefromCartCheck);
		clickButton(UpdateCartbtn);
	}
	
	
	public void UpdateShoppingCartQuantity (String quantity)
	{
		//clear the quantity
		ClearText(Quantitytxtbox);		
		
		//set new quantity
		
		setTextElementText(Quantitytxtbox, quantity);
		clickButton(UpdateCartbtn);
	}
	
	public void OpenCheckOutPage()
	{
		clickButton(TermsCheckbox);
		clickButton(CheckOutBtn);
	}
}
