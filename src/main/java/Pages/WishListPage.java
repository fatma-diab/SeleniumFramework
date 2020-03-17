package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage  extends PageBase {

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(css= "td.product")
	public WebElement productCell;
	
	@FindBy(css= "h1")
	public WebElement WishListHeader;
	
	@FindBy(name= "updatecart")
	WebElement UpdatecartBtn;
	
	@FindBy(name= "removefromcart")
	WebElement RemoveFromCartCheck;
	
	@FindBy(css="div.no-data")
	public WebElement EmptyWishListLabel;
	
	public void removeItemfromWishList()
	{
		clickButton(RemoveFromCartCheck);
		clickButton(UpdatecartBtn);
		
	}
	

}
