package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetailPage;
import Pages.SearchPage;
import Pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase {
	
	ProductDetailPage detailsobject;
	SearchPage searchobject;
	ShoppingCartPage cartobject;
	String productname = "Apple MacBook Pro 13-inch";
	String Quantity ="2";
	
	
	
	
	@Test (priority=1)
	public void UserCansearchforProduct () throws InterruptedException
	{
		detailsobject = new ProductDetailPage(driver);
		searchobject = new SearchPage(driver);
		
	
		searchobject.ProductSearchUsingautocomplete("MacB");
		Assert.assertTrue(detailsobject.ProductnameBreadCrumb.getText().contains(productname));
		
	}
	

	@Test(priority = 2)
	
	public void UserCanAddProductToShoppingCart() throws InterruptedException
	{
		cartobject= new ShoppingCartPage(driver);
		detailsobject = new ProductDetailPage(driver);
		
		detailsobject.AddProducttoShoppingCart();
		Thread.sleep(2000);
		
		driver.navigate().to("https://demo.nopcommerce.com"+"/cart");
		Assert.assertTrue(cartobject.ProductnameInCart.getText().contains(productname));
		Thread.sleep(2000);
	}
	
	@Test (priority= 3)
	
	public void UserCanRemoveProductfromShoppingCart()
	{
		cartobject = new ShoppingCartPage(driver);
		cartobject.removeProductFromCart();
		Assert.assertTrue(cartobject.EmptyCartLable.getText().contains("Your Shopping Cart is empty!"));
	}
}
