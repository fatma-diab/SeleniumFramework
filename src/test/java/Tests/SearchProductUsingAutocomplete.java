package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetailPage;
import Pages.SearchPage;

public class SearchProductUsingAutocomplete extends TestBase {
	SearchPage Searchobject;
	ProductDetailPage ProductDetailsPageobject;
	String ProductName="Apple MacBook Pro 13-inch";

	
	@Test
	public void UserCanSearchUsingAutocomplete() throws InterruptedException
	{
		Searchobject= new SearchPage(driver);
		ProductDetailsPageobject = new ProductDetailPage(driver);
		Searchobject.ProductSearchUsingautocomplete("MacB");
		Assert.assertEquals(ProductDetailsPageobject.ProductnameBreadCrumb.getText(), ProductName);
		
	}

}
