package TestCases;

import constantVariables.Constant_Variables;
import groupingWRTcommonElements.Common_Elements;
import utilities.ExcelReadWrite;
import utilities.Log;
import webPages.SFF;

public class SFF_TestCases 
{
	public static void tc01sff() throws Exception
	{
		Log.sTestCaseStart("ssitc001 - open browser and open url");
		Common_Elements.openBrowser_chrome();	
		Log.sLastTestCase();
	}
	
	public static void tc02sff() throws Exception
	{
		int row=1;
		int username_col=1;
		int password_col=2;
		String username = "";
		String password = "";
		final String shopsTab = "SSI_Shops";
		for(int i=1 ; i<=1 ; i++)
		{
			System.out.println("SSI_TestCase start");
			Common_Elements.openURL(Constant_Variables.url_sff);
			SFF.SFFTestCase1();
			username = ExcelReadWrite.getExcelValue(shopsTab, row, username_col);
			password = ExcelReadWrite.getExcelValue(shopsTab, row, password_col);
			Log.sTestCaseStart("ssitc002 - get window handles - iteration ");
			SFF.SFFTestCase2(username, password, row);
		//	SFF.SSITestCase2("yqazivics123456", "fa5491b160fef922c32b46db8", 2);
			
			Log.sLastTestCase();
			row++;
			System.out.println("SSI_TestCase end");
		}
		
	}
	

}
 