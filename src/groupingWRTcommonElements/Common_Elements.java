package groupingWRTcommonElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import constantVariables.Constant_Variables;
import mainDriver.Driver_Executor;
import utilities.Locators;
import utilities.Log;

public class Common_Elements 
{
	public static WebElement element;
	public static WebDriver driver;
	
	public static WebDriver openBrowser_chrome() throws Exception
	{
		try
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("chrome.switches","--disable-extensions --disable-extensions-file-access-check --disable-extensions-http-throttling");
			System.setProperty(Constant_Variables.chromeDriver, Constant_Variables.chromeDriverPath);
			driver = new ChromeDriver(options);
			Log.info("Chrome browser opened successflly");
		}
		catch(Exception e)
		{
			Log.error("Chrome Browser did not open");
		}
	return driver;	 
	}
	public static WebDriver openBrowser_firefox() throws Exception
	{
		try
		{
			System.setProperty(Constant_Variables.firefoxDriver, Constant_Variables.firefoxDriverPath);
			driver = new FirefoxDriver();
			Log.info("Firefox browser opened successflly");
		}
		catch(Exception e)
		{
			Log.error("Firefox Browser did not open");
		}
		return driver;	
	}
	
	
	public static void openURL(String url) throws Exception
	{
		try
		{
			driver.get(url);
			Log.info("URL opened successfully");
		}
		catch(Exception e)
		{
			Log.error("URL could not open");
		}	
	}
	
	
	public static WebElement handlingWebpageElement(String locator) throws Exception
	{
		try
		{
			element = driver.findElement(Locators.getLocator(locator));
			Log.info("element "+locator+" found");
		}
		catch(Exception e)
		{
			Log.error(locator+" not found");
		}
		return element;
	}
	
	public static void closeBrowser()
	{
		try
		{
			driver.quit();
		}
		catch(Exception e)
		{
			
		}
	}

}
