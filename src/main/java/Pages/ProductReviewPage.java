package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase	{

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id= "AddProductReview_Title")
	WebElement ReviewTitleTextBox;
	
	@FindBy(id="AddProductReview_ReviewText")
	WebElement AddReviewTextBox;
	
	@FindBy(id="addproductrating_4")
	WebElement Rating;
	
	@FindBy(name="add-review")
	WebElement submitReviewButton;
	
	@FindBy(css= "div.result")
   public WebElement AddReviewResultMessage;
	
	public void AddProductReview (String reviewtitle, String Reviewtext)
	{
		setTextElementText(ReviewTitleTextBox, reviewtitle);
		setTextElementText(AddReviewTextBox, Reviewtext);
		clickButton(Rating);
		clickButton(submitReviewButton);
	}
}
