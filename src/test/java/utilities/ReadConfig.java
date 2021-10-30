package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig()
	{
		File src = new File("./config.properties");
		
		try
		{
			FileInputStream fis = new FileInputStream(src); //to read a src file
			prop = new Properties();
			prop.load(fis); //to load in reference variable prop.
			
		}
		catch(Exception e)
		{
			System.out.println("In ReadConfig Class | Exception is "+e);
		}
	}
	
	
	public String getApplicationURL()
	{
		return prop.getProperty("baseURL");
	}
	
	public String getUsername()
	{
		return prop.getProperty("username");
	}

	
	public String getPassword()
	{
		return prop.getProperty("password");
	}

	
	public String getChromeDriverPath()
	{
		return prop.getProperty("chromeDriverPath");
	}

	
	public String getFirefoxDriverPath()
	{
		return prop.getProperty("FirefoxDriverPath");
	}
	
	public String getIEDriverPath()
	{
		return prop.getProperty("IEDriverPath");
	}

}
