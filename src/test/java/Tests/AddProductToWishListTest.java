package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetailPage;
import Pages.SearchPage;
import Pages.WishListPage;

public class AddProductToWishListTest extends TestBase
{
	
	SearchPage Searchobject;
	ProductDetailPage ProductDetailsPageobject;
	String ProductName="Apple MacBook Pro 13-inch";
	WishListPage wishListObject;

	
	@Test(priority=1)
	public void UserCanSearchUsingAutocomplete() throws InterruptedException
	{
		Searchobject= new SearchPage(driver);
		ProductDetailsPageobject = new ProductDetailPage(driver);
		Searchobject.ProductSearchUsingautocomplete("MacB");
		Assert.assertEquals(ProductDetailsPageobject.ProductnameBreadCrumb.getText(), ProductName);
		
	}

	
	@Test (priority = 2)
	public void UserAddProducttoWishList()
	{
		ProductDetailsPageobject= new ProductDetailPage (driver);
		ProductDetailsPageobject.AddProductToWishList();
		driver.navigate().to("https://demo.nopcommerce.com" + "/wishlist");
		wishListObject= new WishListPage(driver);
		Assert.assertTrue(wishListObject.WishListHeader.isDisplayed());
		Assert.assertTrue(wishListObject.productCell.getText().contains(ProductName));
				
	}
	
	@Test(priority=3)
	public void UserCanRemoveItemfromWishList()
	{
		wishListObject= new WishListPage(driver);
		wishListObject.removeItemfromWishList();
		Assert.assertTrue(wishListObject.EmptyWishListLabel.isDisplayed());
	}
	
}
