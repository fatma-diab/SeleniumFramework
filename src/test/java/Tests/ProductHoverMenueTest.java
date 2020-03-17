
package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;

public class ProductHoverMenueTest extends TestBase 

{
	HomePage homeobject;


	@Test

	public void UserCanSelectsubcategoryFromMainMenu()
	{
		homeobject = new HomePage(driver);
		homeobject.selectNoteBookmenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));

	}

}
