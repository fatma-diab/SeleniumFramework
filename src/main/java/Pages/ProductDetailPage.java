package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends PageBase {

	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css="strong.current-item")
	public WebElement ProductnameBreadCrumb;

	@FindBy(css ="input.button-2.email-a-friend-button")
	public WebElement emailFriendButton;

	@FindBy(css="span.price-value-4")
	public WebElement ProductPriceCurrency;

	@FindBy(linkText = "Add your review")
	public WebElement AddReviewLink;

	@FindBy(id="add-to-wishlist-button-4")
	public WebElement AddToWishListBtn;

	@FindBy(className = "compare-products")
	public WebElement AddToCompareListbtn;


	@FindBy(id= "add-to-cart-button-4")
	WebElement AddtoCartBtn;


	public void openSendEmail()
	{
		clickButton(emailFriendButton);
	}

	public void OpenReviewPage()
	{
		clickButton(AddReviewLink);
	}

	public void AddProductToWishList()
	{
		clickButton(AddToWishListBtn);
	}

	public void AddProducttoCompareList()

	{
		clickButton(AddToCompareListbtn);
	}
	
  public void AddProducttoShoppingCart ()
  {
	  clickButton(AddtoCartBtn);
  }
  
}
