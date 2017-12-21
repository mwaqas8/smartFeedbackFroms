package webPages;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import constantVariables.Constant_Variables;
import groupingWRTcommonElements.Common_Elements;
import utilities.ExcelReadWrite;
import utilities.Locators;
import utilities.Log;

public class CreateForm 
{
	//click at default survey manage forms and verify if page loaded
	public static void CreateForm_case0() throws Exception
	{
		try
		{
			System.out.println("window handle : "+Common_Elements.driver.getWindowHandle());
			System.out.println("URL of current Window"+Common_Elements.driver.getCurrentUrl());
    		
			System.out.println("------------------- "+(Constant_Variables.sffdefaultSurvey_icon));
			
			//Common_Elements.handlingWebpageElement("defaultSurvey_icon").click();
			//Common_Elements.driver.findElement(Locators.getLocator("defaultSurvey_icon")).click();
			Common_Elements.driver.findElement(By.xpath("/html/body/section/div/div/div/div/div[1]/table/tbody/tr/td[3]/a[2]")).click();
			
			WebDriverWait wait = new WebDriverWait(Common_Elements.driver , 20);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.getLocator(Constant_Variables.sffdefaultSurvey_heading)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div/div/div/div/div[1]/h3")));
			
			Log.info("Default survey page loaded");
			ExcelReadWrite.setExcelValue(Constant_Variables.sff_createFormCases, 3, 4, "Pass");
		}
		catch(Exception e)
		{
			Log.error("Default survey page NOT loaded");
			ExcelReadWrite.setExcelValue(Constant_Variables.sff_createFormCases, 3, 4, "Fail");
		}	
		
	}
	
	//step1 - popup
	public static void CreateForm_case1()
	{
		try
		{
			String parentWindow = Common_Elements.driver.getWindowHandle();
			
			//Common_Elements.handlingWebpageElement("createFormBtn").click();
			Common_Elements.driver.findElement(By.xpath("/html/body/section/div/div/div/div/button[1]")).click();
			
			WebDriverWait wait = new WebDriverWait(Common_Elements.driver , 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create-survey-form")));
			
			//Set handles = Common_Elements.driver.getWindowHandles();
			System.out.println("createForm ALL windows : "+Common_Elements.driver.getWindowHandles());
			Common_Elements.driver.findElement(By.id("survey_name")).sendKeys("SFFAuto2");
			//new Select(Common_Elements.handlingWebpageElement("formDefaultLanguage")).selectByIndex(2);
			new Select(Common_Elements.driver.findElement(By.id("form_default_language"))).selectByIndex(2);
			//new Select(Common_Elements.handlingWebpageElement("formType")).selectByIndex(0);
			new Select(Common_Elements.driver.findElement(By.id("review_type"))).selectByIndex(0);
	
			//Common_Elements.handlingWebpageElement("formCreationBtn").click();
			Common_Elements.driver.findElement(By.id("survey_submit_button")).click();
			
			
			//Alert promptAlert  = Common_Elements.driver.switchTo().alert();
			//promptAlert.accept();
			
			/*
			int i=1;
			for (String handle1 : Common_Elements.driver.getWindowHandles()) 
	        {
	        	System.out.println("Inside loop of CreateForm_case1 : "+handle1);
	        	Common_Elements.driver.switchTo().window(handle1);
	        	if(i==2)
	        	{
	        		//92  , 477 , 554 , 631
	        		//Common_Elements.handlingWebpageElement("formName").sendKeys("SFFAuto1");
					Common_Elements.driver.findElement(By.id("survey_name")).sendKeys("SFFAuto1");
    				//new Select(Common_Elements.handlingWebpageElement("formDefaultLanguage")).selectByIndex(2);
    				new Select(Common_Elements.driver.findElement(By.id("form_default_language"))).selectByIndex(2);
    				//new Select(Common_Elements.handlingWebpageElement("formType")).selectByIndex(0);
    				new Select(Common_Elements.driver.findElement(By.id("review_type"))).selectByIndex(0);
    		
    				//Common_Elements.handlingWebpageElement("formCreationBtn").click();
    				Common_Elements.driver.findElement(By.id("survey_submit_button")).click();
	        	}
	        	i++;
	        }
			Common_Elements.driver.switchTo().window(parentWindow);*/
			Log.info("create form step-1 popup opened");
		}
		catch(Exception e)
		{
			Log.error("Create form step-1 popup not open");
		}
	}
	//step2 - template
	public static void CreateForm_case2()
	{
		Common_Elements.driver.findElement(By.id("choose-survey-btn")).click();
		
	}
	//step3 - form builder
	public static void CreateForm_case3()
	{
		WebDriverWait wait = new WebDriverWait(Common_Elements.driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("save_changes_btn")));
		Common_Elements.driver.findElement(By.id("save_changes_btn")).click();
	}

}
