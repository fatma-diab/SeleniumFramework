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

public class RegisteredUserCheckOutTest extends TestBase {

	//1- Register user

	HomePage homeobject;
	UserRegistrationPage registerobject;
	ShoppingCartPage cartobject;
	SearchPage Searchobject;
	ProductDetailPage ProductDetailsPageobject;
	String ProductName ="Apple MacBook Pro 13-inch";
	CheckOutPage checkoutObject;
	OrderInformationPage Orderdetailsobject;
	
	
	@Test(priority=1,alwaysRun = true)
	public void UserCanRegisterSuccessfully()

	{
		homeobject = new HomePage(driver);
		homeobject.openRegistrationPage();
		registerobject = new UserRegistrationPage(driver);
		registerobject.userRegistration("Fatma", "Diab", "1098@gmail.com", "1078523");
		Assert.assertTrue(registerobject.RegistrationResult.getText().contains("Your registration completed"));

	}


	//2- Search for product

	
	@Test (priority= 2)
	public void UserCanSearchUsingAutocomplete() throws InterruptedException
	{
		Searchobject= new SearchPage(driver);
		ProductDetailsPageobject = new ProductDetailPage(driver);
		Searchobject.ProductSearchUsingautocomplete("MacB");
		Assert.assertEquals(ProductDetailsPageobject.ProductnameBreadCrumb.getText(), ProductName);

	}


	//3- Add to cart
	@Test(priority = 3)

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

	//4- Checkout
	
	@Test (priority=4)
	public void  RegisteredUSerCanCheckOut() throws InterruptedException
	{
		cartobject= new ShoppingCartPage(driver);
		checkoutObject= new CheckOutPage(driver);
		cartobject.OpenCheckOutPage();
		Thread.sleep(100);
		checkoutObject.RegisteredUSerCheckoutProduct("Egypt", "Kuwait", "TheAddress", "123456", "123456987", ProductName);
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
	
	
	//6- Logout
	@Test(priority= 5)
	public void RegisteredUserCanLogout()
	{
		registerobject.UserLogout();

	}
}
