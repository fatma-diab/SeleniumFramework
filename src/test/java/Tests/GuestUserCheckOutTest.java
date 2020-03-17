package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CheckOutPage;
import Pages.HomePage;
import Pages.OrderInformationPage;
import Pages.ProductDetailPage;
import Pages.SearchPage;
import Pages.ShoppingCartPage;
import Pages.UserRegistrationPage;

public class GuestUserCheckOutTest extends TestBase {
	
	HomePage homeobject;
	UserRegistrationPage registerobject;
	ShoppingCartPage cartobject;
	SearchPage Searchobject;
	ProductDetailPage ProductDetailsPageobject;
	String ProductName ="Apple MacBook Pro 13-inch";
	CheckOutPage checkoutObject;
	OrderInformationPage Orderdetailsobject;
	
	
	
	//1- Search for product

	
		@Test (priority= 1)
		public void UserCanSearchUsingAutocomplete() throws InterruptedException
		{
			Searchobject= new SearchPage(driver);
			ProductDetailsPageobject = new ProductDetailPage(driver);
			Searchobject.ProductSearchUsingautocomplete("MacB");
			Assert.assertEquals(ProductDetailsPageobject.ProductnameBreadCrumb.getText(), ProductName);

		}


		//2- Add to cart
		@Test(priority = 2)

		public void UserCanAddProductToShoppingCart() throws InterruptedException
		{
			cartobject= new ShoppingCartPage(driver);
			ProductDetailsPageobject = new ProductDetailPage(driver);

			ProductDetailsPageobject.AddProducttoShoppingCart();
			Thread.sleep(2000);

			driver.navigate().to("https://demo.nopcommerce.com"+"/cart");
			Assert.assertTrue(cartobject.ProductnameInCart.getText().contains(ProductName));
			Thread.sleep(2000);
		}

		//3- Checkout
		
		@Test(priority = 3)
		public void GuestUserCheckOut () throws InterruptedException
		{
			cartobject= new ShoppingCartPage(driver);
			checkoutObject= new CheckOutPage(driver);
			cartobject.OpenCheckOutPage();
			Thread.sleep(100);
			checkoutObject.openCheckoutAsGuest();
			checkoutObject.CheckOutAsGuest("fatma", "diab", "fatma@gmail.com", "Egypt", "Cairo", "address", "1234", "98745632", ProductName);
			Thread.sleep(1000);
			Assert.assertTrue(checkoutObject.productname.getText().contains(ProductName));
			Thread.sleep(1000);
			checkoutObject.ConfirmOrder();
			Thread.sleep(1000);
			Assert.assertTrue(checkoutObject.Thankyoulble.isDisplayed());
			checkoutObject.OpenOrderdetailsPage();
			Thread.sleep(100);
			Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
			Orderdetailsobject = new OrderInformationPage(driver);
			Orderdetailsobject.PDFInvoice();
			Orderdetailsobject.PrintOrder();
			
		}
		
		
		

}

