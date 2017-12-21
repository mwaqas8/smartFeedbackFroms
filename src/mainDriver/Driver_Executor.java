package mainDriver;

import org.apache.log4j.xml.DOMConfigurator;

import TestCases.CreateForm_TestCases;
import TestCases.SFF_TestCases;
import constantVariables.Constant_Variables;
import groupingWRTcommonElements.Common_Elements;
import utilities.ExcelReadWrite;
import utilities.Locators;

public class Driver_Executor 
{
	
	public static String rMode = "Y";
	public static Locators LocatorObj;

	public static void main (String []args) throws Exception
	{
		LocatorObj = new Locators(Constant_Variables.locatorsFilePath);
		String Excel_runMode = "";
		ExcelReadWrite.setExcel(Constant_Variables.excelFilePath);
		DOMConfigurator.configure("log4j.xml");

		//----------- Start of SSI Execution --------------------------
		try
		{
			Excel_runMode = ExcelReadWrite.getExcelValue(Constant_Variables.sff_suiteName, 1, Constant_Variables.sff_modeColumn);
			System.out.println("SFF1 - Excel run mode is : "+Excel_runMode);
			if(Excel_runMode.equalsIgnoreCase(rMode))
			{
				System.out.println("driver 1 start");
				SFF_TestCases.tc01sff();
				System.out.println("driver 1 end");
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//System.out.println("This is the END of SSI");	
		
		try
		{
			Excel_runMode = ExcelReadWrite.getExcelValue(Constant_Variables.sff_suiteName, 2, Constant_Variables.sff_modeColumn);
			System.out.println("SFF2 - Excel run mode is : "+Excel_runMode);
			if(Excel_runMode.equalsIgnoreCase(rMode))
			{
				System.out.println("driver 2 start");
				SFF_TestCases.tc02sff();
				System.out.println("driver 2 end");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// ---------- End of SSI execution ----------------------
		
		
		try
		{ // create form
			System.out.println("driver 3 start");
			CreateForm_TestCases.tc03sff();
			System.out.println("driver 3 end");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		//Common_Elements.driver.quit();
		
		System.out.println("This is the END of SSI");	
	}

}
