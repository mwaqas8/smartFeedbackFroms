package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class Locators 
{
	static Properties prop ;
	public Locators(String fileName) throws IOException
	{
		prop = new Properties();
		FileInputStream fs = new FileInputStream(fileName);
		prop.load(fs);
		fs.close();
	}
	public static By getLocator(String element) throws Exception
	{
		String locator = prop.getProperty(element);
		String elementType = locator.split(":")[0];
		String elementValue = locator.split(":")[1];
		
		if(elementType.equalsIgnoreCase("id"))
		{
			return By.id(elementValue);
		}
		else if(elementType.equalsIgnoreCase("name"))
		{
			return By.name(elementValue);
		}
		else if(elementType.equalsIgnoreCase("xpath"))
		{
			return By.xpath(elementValue);
		}
		else if(elementType.equalsIgnoreCase("cssSelector"))
		{
			return By.cssSelector(elementValue);
		}
		else if(elementType.equalsIgnoreCase("link") || elementType.equalsIgnoreCase("linkText"))
		{
			return By.linkText(elementValue);
		}
		else if(elementType.equalsIgnoreCase("partialLinkText"))
		{
			return By.partialLinkText(elementValue);
		}
		else if(elementType.equalsIgnoreCase("class") || elementType.equalsIgnoreCase("className"))
		{
			return By.className(elementValue);
		}
		else if(elementType.equalsIgnoreCase("tag") || elementType.equalsIgnoreCase("tagName"))
		{
			return By.tagName(elementValue);
		}
		else 
		{
			throw new Exception (elementType+" Locator type Not found");
		}
	}

}
