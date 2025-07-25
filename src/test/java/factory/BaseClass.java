package factory;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import java.net.URI;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {

		 static WebDriver driver;
	     static Properties p;
	     static Logger logger;

	public BaseClass(WebDriver driver) {
	}

	public static WebDriver initializeBrowser() throws IOException
	{
		p = getProperties();
        String executionEnv = p.getProperty("execution_env");
        String browser = p.getProperty("browser").toLowerCase();


		if(executionEnv.equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			p = getProperties();
			String os = p.getProperty("os").toLowerCase();
			
			//os
			 switch (os) {
             case "windows":
                 capabilities.setPlatform(Platform.WINDOWS);
                 break;
             case "mac":
                 capabilities.setPlatform(Platform.MAC);
                 break;
             case "linux":
                 capabilities.setPlatform(Platform.LINUX);
                 break;
             default:
                 System.out.println("No matching OS");
                 return null;
            }
			
			//browser
			 switch (browser) {
             case "chrome":
                 capabilities.setBrowserName("chrome");
                 break;
             case "edge":
                 capabilities.setBrowserName("MicrosoftEdge");
                 break;
             case "firefox":
                 capabilities.setBrowserName("firefox");
                 break;
             default:
                 System.out.println("No matching browser");
                 return null;
             }
	       
			 driver = new RemoteWebDriver(
					    URI.create("http://localhost:4444/wd/hub").toURL(), capabilities);
			
		}
		else if(executionEnv.equalsIgnoreCase("local"))
			{
				switch(browser.toLowerCase()) 
				{
				case "chrome":
			        driver=new ChromeDriver();
			        break;
			    case "edge":
			    	driver=new EdgeDriver();
			        break;
			    case "firefox":
			    	driver=new FirefoxDriver();
			        break;
			    default:
			        System.out.println("No matching browser");
			        driver=null;
				}
			}
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		 
		 return driver;
		 
	}
	
	public static WebDriver getDriver()
	{
			return driver;
	}

	public static Properties getProperties() throws IOException
	{		 
        FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
       	p=new Properties();
		p.load(file);
		return p;
	}
	
	public static Logger getLogger() 
	{		 
		logger=LogManager.getLogger(); //Log4j
		return logger;
	}
	
	public static String randomeString()
	{
		@SuppressWarnings("deprecation")
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	
	public static String randomeNumber()
	{
		@SuppressWarnings("deprecation")
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

	public static String randomEmail()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(4);
		String generatedNumber=RandomStringUtils.randomNumeric(2);
		String email = ((generatedString+generatedNumber)+"@gmail.com");
		return email;
	}
		
	@SuppressWarnings("deprecation")
	public static String randomAlphaNumeric()
	{
	String str=RandomStringUtils.randomAlphabetic(5);
	 
	 String num=RandomStringUtils.randomNumeric(10);
	return str+num;
	}
	
	
}
