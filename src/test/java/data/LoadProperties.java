package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	
	//load the properties from the folder
	
	public static Properties userData = loadProperties (System.getProperty("user.dir")+"\\src\\main\\java\\Properties\\UserData.properties");
	
	
	private static Properties loadProperties (String path)
	{
		Properties pro = new Properties();
		//stream reading the file
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
			
		} catch (FileNotFoundException e) {
			System.out.println("Error occurred : " + e.getMessage());
			
		} catch (IOException e) {
			System.out.println("Error occurred : " + e.getMessage());

		}
		
		
		return pro;
	}
	

}
