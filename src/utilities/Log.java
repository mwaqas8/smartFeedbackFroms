package utilities;

import org.apache.log4j.Logger;

public class Log 
{
	private static Logger Log = Logger.getLogger(Log.class.getName());
	
	public static void sTestCaseStart(String message)
	{
		Log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		//Log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		Log.info("++++++++++++++++++++" +message+ "+++++++++++++++");
		//Log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		Log.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
	public static void sLastTestCase()
	{
		Log.info("+++++++++++++++"+ "END" + "+++++++++++++++++++++++++++");
	}
	
	public static void info(String message)
	{
		Log.info(message);
	}
	
	public static void warn(String message)
	{
		Log.warn(message);
	}
	public static void error(String message)
	{
		Log.error(message);
	}
	public static void debug(String message)
	{
		Log.debug(message);
	}
}
