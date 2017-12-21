package constantVariables;

import utilities.ExcelReadWrite;

public class Constant_Variables 
{
	public static final String firefoxDriver = "webdriver.gecko.driver";
	public static final String firefoxDriverPath = "D:\\Java Eclipse and Selenium\\Required jars\\geckodriver-v0.15.0-win64\\geckodriver.exe";
	public static final String chromeDriver = "webdriver.chrome.driver";
	public static final String chromeDriverPath = "D:\\Java Eclipse and Selenium\\Required jars\\ChromeDrivers\\2.34 version\\chromedriver.exe";
	public static final String locatorsFilePath = "D:\\WebdriverWorkSpace\\Session9-HDF\\src\\locators.properties";
	public static final String excelFilePath = "D:\\WebdriverWorkSpace\\SmartFeedbackForm-Automation\\src\\Module9HDF-TestCases.xlsx";
	
	public static final int resultCol = 4 ;
	
	public static final String sff_suiteName = "SSI_TestSuite";
	public static final int sff_modeColumn = 3;
	public static final String url_sff = "https://sff-staging-1.ekomiapps.de/user/login";
	public static final String sff_loginCases = "SFF_Login";
	public static final String sff_loginBtnText = ExcelReadWrite.getExcelValue(sff_loginCases, 2, 2);
	public static final String sff_usernameField = ExcelReadWrite.getExcelValue(sff_loginCases, 5, 2);
	public static final String sff_passwordField = ExcelReadWrite.getExcelValue(sff_loginCases, 6, 2);
	public static final String sff_submitBtn = ExcelReadWrite.getExcelValue(sff_loginCases, 9, 2);
	public static final String sff_loginDropdown = ExcelReadWrite.getExcelValue(sff_loginCases, 11, 2);
	
	public static final String sff_createFormCases = "SFF_CreateForm" ;
	public static final String sffdefaultSurvey_icon= ExcelReadWrite.getExcelValue(sff_createFormCases, 2, 2);
	public static final String sffdefaultSurvey_heading= ExcelReadWrite.getExcelValue(sff_createFormCases, 4, 2);
	public static final String sffcreateFormBtn= ExcelReadWrite.getExcelValue(sff_createFormCases, 6, 2);
	public static final String sffformName= ExcelReadWrite.getExcelValue(sff_createFormCases, 8, 2);
	public static final String sffformDefaultLanguage= ExcelReadWrite.getExcelValue(sff_createFormCases, 9, 2);
	public static final String sffformType= ExcelReadWrite.getExcelValue(sff_createFormCases, 10, 2);
	public static final String sffformCreationBtn =  ExcelReadWrite.getExcelValue(sff_createFormCases, 12, 2);
	
	
}
