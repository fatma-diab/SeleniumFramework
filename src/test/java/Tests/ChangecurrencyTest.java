package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ProductDetailPage;
import Pages.SearchPage;

public class ChangecurrencyTest extends TestBase
{
	HomePage homeobject;
	ProductDetailPage ProductDetailObject;
	SearchPage Searchobject;
	String ProductName="Apple MacBook Pro 13-inch";
	
	
	@Test(priority = 1)

	public void UserCanChangeCurrency()

	{
		homeobject= new HomePage(driver);
		ProductDetailObject= new ProductDetailPage(driver);
		homeobject.Chnagecurrency();


	}
	
	@Test (priority = 2)
	public void UserCanSearchUsingAutocomplete() throws InterruptedException
	{
		Searchobject= new SearchPage(driver);
		ProductDetailObject = new ProductDetailPage(driver);
		Searchobject.ProductSearchUsingautocomplete("MacB");
		Assert.assertEquals(ProductDetailObject.ProductnameBreadCrumb.getText(), ProductName);
		Assert.assertTrue(ProductDetailObject.ProductPriceCurrency.getText().contains("Ђ"));
		System.out.println(ProductDetailObject.ProductPriceCurrency.getText());
	}

}
