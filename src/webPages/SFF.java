package webPages;

import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constantVariables.Constant_Variables;
import groupingWRTcommonElements.Common_Elements;
import utilities.ExcelReadWrite;
import utilities.Locators;
import utilities.Log;

public class SFF 
{
	public static void SFFTestCase1() throws Exception
	{
		try
		{			
			WebDriverWait wait = new WebDriverWait(Common_Elements.driver , 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.getLocator(Constant_Variables.sff_loginBtnText)));
			
			Log.info("Login page loaded");
			ExcelReadWrite.setExcelValue(Constant_Variables.sff_loginCases, 2, Constant_Variables.resultCol, "Pass");
		}
		catch(Exception e)
		{
			Log.error("Login page NOT loaded");
			ExcelReadWrite.setExcelValue(Constant_Variables.sff_loginCases, 2, Constant_Variables.resultCol, "Fail");
		}
	}
	
	public static void SFFTestCase2(String username, String password, int row) throws Exception
	{
		try
		{
			//System.out.println("username : "+username);
			//System.out.println("password : "+password);
			
		     // Store and Print the name of the First window on the console
	        String handle= Common_Elements.driver.getWindowHandle();

	        System.out.println("parent window : "+handle);

	        // Click on the Button 
	        Common_Elements.handlingWebpageElement("sff_loginBtnText").click();
	        
	        System.out.println("after click");
	        
	        // Store and Print the name of all the windows open	              
	       // Set handles = Common_Elements.driver.getWindowHandles();

	        System.out.println(Common_Elements.driver.getWindowHandles());
	        
	        int i = 1;

	        // Pass a window handle to the other window
	        for (String handle1 : Common_Elements.driver.getWindowHandles()) 
	        {
	        	System.out.println("Inside loop : "+handle1);
	        	Common_Elements.driver.switchTo().window(handle1);
	        	if(i==2)
	        	{
	        		System.out.println("URL of current Window"+Common_Elements.driver.getCurrentUrl());
	        		Thread.sleep(2000);
	        		System.out.println("Inside if condition : "+handle1);
	        		
	        		//Common_Elements.handlingWebpageElement().click(); //Constant_Variables.sff_usernameField
	        		Common_Elements.handlingWebpageElement(Constant_Variables.sff_usernameField).sendKeys(username); 
	        		Common_Elements.handlingWebpageElement(Constant_Variables.sff_passwordField).sendKeys(password);
	        		Common_Elements.handlingWebpageElement(Constant_Variables.sff_submitBtn).click();
	        	
	        	}
	        	i = i+1;
	        }
	        //Common_Elements.driver.close();	              
	      //switch back to main window
    		Thread.sleep(2000);
    		Common_Elements.driver.switchTo().window(handle);
    		
    		WebDriverWait wait = new WebDriverWait(Common_Elements.driver , 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.getLocator(Constant_Variables.sff_loginDropdown)));
			
			String loggedin_user = Common_Elements.handlingWebpageElement(Constant_Variables.sff_loginDropdown).getText();
			if (loggedin_user.contains(username))
			{
				Log.info("Dashboard loaded");
    			ExcelReadWrite.setExcelValue(Constant_Variables.sff_loginCases, 11, 4, "Pass");
			}
			else
			{
				Log.error("invalid entry");
				ExcelReadWrite.setExcelValue(Constant_Variables.sff_loginCases, 11, 4, "Fail");
			}
	        
		}
		catch(Exception e)
		{
			Log.error("Dashboard NOT loaded "+e);
			ExcelReadWrite.setExcelValue(Constant_Variables.sff_loginCases, 11, Constant_Variables.resultCol, "Fail");
			//Common_Elements.driver.close();
	        
		}
	}
	

}
