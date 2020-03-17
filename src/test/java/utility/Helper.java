package utility;

import java.nio.file.Paths;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper
{
	
	//Method to take screenshot in case of failure
	
	public static void CaptureScreenshot(WebDriver driver, String screenshotname)
	{
		Path dest= Paths.get("./Screenshots" , screenshotname+".png");
		
		try {
			
		
		java.nio.file.Files.createDirectories(dest.getParent());
		FileOutputStream out= new FileOutputStream(dest.toString());
		out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
		out.close();
		
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot"+e.getMessage());
		}
		
	}

}
