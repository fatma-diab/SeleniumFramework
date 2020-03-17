package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "input.button-1.checkout-as-guest-button")
	WebElement CheckOutAsGuest;

	//address Elements

	@FindBy(id="BillingNewAddress_FirstName")
	WebElement firstnNametxt;

	@FindBy (id="BillingNewAddress_LastName")
	WebElement lastNametxt;

	@FindBy (id="BillingNewAddress_Email")
	WebElement Emailtxt;


	@FindBy (id = "BillingNewAddress_CountryId")
	WebElement CountryList;

	@FindBy (id= "BillingNewAddress_City")
	WebElement Citytxt;

	@FindBy (id="BillingNewAddress_Address1")
	WebElement Addresstxt;

	@FindBy (id = "BillingNewAddress_ZipPostalCode")
	WebElement ZipCodetxt;

	@FindBy (id= "BillingNewAddress_PhoneNumber")
	WebElement Phonenumbertxt;

	@FindBy (xpath = "//*[@id=\"billing-buttons-container\"]/input")
	WebElement AddressContinuebtn;

	//Shipping methods

	@FindBy(id="shippingoption_1")
	WebElement ShippingMethodRd;

	@FindBy ( xpath = "//*[@id=\"shipping-method-buttons-container\"]/input")
	WebElement ShippingMethodContinuebtn;

	//Payment Method

	@FindBy (id ="paymentmethod_0")
	WebElement PaymentMethodRd ;

	@FindBy (xpath = "//*[@id=\"payment-method-buttons-container\"]/input")
	WebElement PaymentMethodContinuebtn;


	//Payment Information

	@FindBy (xpath = "//*[@id=\"payment-info-buttons-container\"]/input")
	WebElement PaymentIformationContinuebtn;

	//Confirm order
	@FindBy (css= "a.product-name")
	public WebElement productname;

	@FindBy (xpath = "//*[@id=\"confirm-order-buttons-container\"]/input")
	WebElement ConfirmOrderbtn;

	//Thank you page

	@FindBy( css= "h1")
	public WebElement Thankyoulble;

	@FindBy(css = "div.title")
	public WebElement successmessage;

	@FindBy (linkText = "Click here for order details.")
	WebElement OrderDetailsbtn;

	public void RegisteredUSerCheckoutProduct (String Countryname, String City, String address,
			String postcode, String Phone, String ProductName) throws InterruptedException
	{
		Thread.sleep(1000);
		select = new Select(CountryList);
		select.selectByVisibleText(Countryname);
		setTextElementText(Citytxt, City);
		setTextElementText(Addresstxt, address);
		setTextElementText(ZipCodetxt, postcode);
		setTextElementText(Phonenumbertxt, Phone);
		clickButton(AddressContinuebtn);
		Thread.sleep(1000);
		clickButton(ShippingMethodRd);
		clickButton(ShippingMethodContinuebtn);
		Thread.sleep(1000);
		clickButton(PaymentMethodRd);
		clickButton(PaymentMethodContinuebtn);
		Thread.sleep(1000);
		clickButton(PaymentIformationContinuebtn);

	}

	public void ConfirmOrder() throws InterruptedException
	{
		Thread.sleep(1000);
		clickButton(ConfirmOrderbtn);

	}

	public void OpenOrderdetailsPage()
	{
		clickButton(OrderDetailsbtn);
	}
	
	public void openCheckoutAsGuest()
	{
		clickButton(CheckOutAsGuest);
	}
	
	public void CheckOutAsGuest (String Fname, String Lname, String email, String Countryname, String City, String address,
			String postcode, String Phone, String ProductName) throws InterruptedException
	{
		Thread.sleep(1000);
		setTextElementText(firstnNametxt, Fname);
		setTextElementText(lastNametxt, Lname);
		setTextElementText(Emailtxt, email);
		select = new Select(CountryList);
		select.selectByVisibleText(Countryname);
		setTextElementText(Citytxt, City);
		setTextElementText(Addresstxt, address);
		setTextElementText(ZipCodetxt, postcode);
		setTextElementText(Phonenumbertxt, Phone);
		clickButton(AddressContinuebtn);
		Thread.sleep(1000);
		clickButton(ShippingMethodRd);
		clickButton(ShippingMethodContinuebtn);
		Thread.sleep(1000);
		clickButton(PaymentMethodRd);
		clickButton(PaymentMethodContinuebtn);
		Thread.sleep(1000);
		clickButton(PaymentIformationContinuebtn);

	}
}
