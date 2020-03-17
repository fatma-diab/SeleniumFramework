package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetailPage;
import Pages.ProductsComparePage;
import Pages.SearchPage;

public class AddProductToCompareTest extends TestBase

{
	SearchPage searchobject;
	ProductDetailPage detailsobject;
	ProductsComparePage compareobject;
	
	String firstproductname= "Asus N551JK-XO076H Laptop";
	String secondproductname= "Apple MacBook Pro 13-inch";
	
	@Test (priority=1)
	public void UserCanAddproductstoCompare() throws InterruptedException
	{
		
		searchobject= new SearchPage(driver);
		detailsobject= new ProductDetailPage(driver);
		compareobject= new ProductsComparePage(driver);
		
		searchobject.ProductSearchUsingautocomplete("Asus");
		Assert.assertTrue(detailsobject.ProductnameBreadCrumb.getText().contains(firstproductname));
		detailsobject.AddProducttoCompareList();
		
		searchobject.ProductSearchUsingautocomplete("MacB");
		Assert.assertTrue(detailsobject.ProductnameBreadCrumb.getText().contains(secondproductname));
		detailsobject.AddProducttoCompareList();
		Thread.sleep(3000);
		
		driver.navigate().to("https://demo.nopcommerce.com"+"/compareproducts");
		Assert.assertTrue(compareobject.FirstProducutname.getText().equals(firstproductname));
		Assert.assertTrue(compareobject.SecondProductname.getText().equals(secondproductname));
		compareobject.CompareProducts();
				
	}

 @Test(priority=2)
 
 public void ClearcompareList()
 {
	 compareobject.ClearCompareList();
	 Assert.assertTrue(compareobject.noDataLabel.getText().contains("You have no items to compare."));
	 
 }
}
