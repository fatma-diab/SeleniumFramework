package Tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import cucumber.api.testng.AbstractTestNGCucumberTests;

import utility.Helper;

public class TestBase  extends AbstractTestNGCucumberTests

{
	public static WebDriver driver;
	
	public static String downloadPath = System.getProperty("user.dir") + "//Downloads";
	
	public static FirefoxOptions firefoxoptions()
	{
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf, application/octet-stream,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		option.addPreference("pdfjs.disabled", true);
		return option;
	}
	
	public static ChromeOptions ChromeOption() {
		ChromeOptions options= new ChromeOptions();
		HashMap<String, Object> ChromePrf= new HashMap<String, Object> ();
		ChromePrf.put("profile.default.content_settings.popups", 0);
		ChromePrf.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", ChromePrf);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
		
	}
	
	

	@BeforeSuite
	@Parameters({"browser"})
	
	public void StartDriver(@Optional("chrome") String browserName)

	{
		if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver = new ChromeDriver(ChromeOption());
		}
		
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			driver = new FirefoxDriver(firefoxoptions());
		}
		
		else if (browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		else if (browserName.equalsIgnoreCase("safari"))
		{
			driver = new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");

	}

	@AfterSuite
	public void StopDriver()

	{
		driver.quit();
	}
	
	//take screenshot when method failed
	@AfterMethod
	public void ScreenshotOnFailure(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("Failed");
			System.out.println("Taking screnhsot");
			Helper.CaptureScreenshot(driver, result.getTestName());
		}
			
	}
	

}
