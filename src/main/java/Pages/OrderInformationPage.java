package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderInformationPage extends PageBase  {

	public OrderInformationPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy (xpath = "/html/body/div[6]/div[3]/div/div/div/div[1]/a[1]")
	WebElement PrintOrderBtn;
	
	@FindBy (xpath = "/html/body/div[6]/div[3]/div/div/div/div[1]/a[2]")
	WebElement PDFInvoidbtn;
	
	public void PrintOrder()
	{
		clickButton(PrintOrderBtn);
	}
	
	
	public void PDFInvoice() throws InterruptedException
	{
		clickButton(PDFInvoidbtn);
		Thread.sleep(1000);
	}
}
