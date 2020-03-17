package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetailPage;
import Pages.SearchPage;

public class SearchProductTest extends TestBase{
	
	
	String ProductName="Apple MacBook Pro 13-inch";
	SearchPage Searchobject;
	ProductDetailPage ProductDetailsPageobject;
	
	@Test
	public void UserCanSearchForProduct() 
	
	{
		Searchobject = new SearchPage(driver);
		ProductDetailsPageobject= new ProductDetailPage(driver);
		Searchobject.ProductSearch(ProductName);
		Searchobject.OpenProductDetailsPage();
		Assert.assertEquals(ProductDetailsPageobject.ProductnameBreadCrumb.getText(), ProductName);
		
	}

}
