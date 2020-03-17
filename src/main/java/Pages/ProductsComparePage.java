package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsComparePage extends PageBase	{

	public ProductsComparePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css ="a.clear-list")
	WebElement ClearListLink;
	
	@FindBy(css= "div.no-data")
	public WebElement noDataLabel;
	
	@FindBy(css= "table.compare-products-table")
	WebElement compareTable;
	
	@FindBy(tagName = "tr")
	public List<WebElement> allrows;
	
	@FindBy(tagName = "td")
	public List<WebElement> allcolumns;
	
	@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	public WebElement FirstProducutname;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement SecondProductname;
	
	
	
	public void ClearCompareList()
	{
		clickButton(ClearListLink);
	}

	public void CompareProducts() {
	
	//Get all rows
	
	System.out.println(allrows.size());
	
	//get data from all rows
	
	for (WebElement row : allrows) 
	
	{
		System.out.println(row.getText() + "\t");
		
		for (WebElement Col : allcolumns) 
			
		{
			System.out.println(Col.getText() + "\t");
						
		}
		
		
	}
	
	
	
}
}
