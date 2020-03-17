package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(id="small-searchterms")
	WebElement SearchTextbox;
	
	@FindBy(css = "input.button-1.search-box-button")
	WebElement SearchButton;
	
	@FindBy(id="ui-id-1")
	List<WebElement> ProductList;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement ProductTitle;
	
	public void ProductSearch(String Productname)
	
	{
		setTextElementText(SearchTextbox, Productname);
		clickButton(SearchButton);
	}
	
	public void OpenProductDetailsPage()
	{
		clickButton(ProductTitle);
	}
	
	public void ProductSearchUsingautocomplete(String searchText) throws InterruptedException
	{
	setTextElementText(SearchTextbox, searchText);
	Thread.sleep(3000);
	ProductList.get(0).click();
	}
}
