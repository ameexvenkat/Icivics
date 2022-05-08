package utilities;

import org.apache.log4j.Logger;

public class Log {
	
	   // Initialize Log4j logs
	   private static Logger Log = Logger.getLogger(Log.class.getName());     

	   /**
	   * This method is used to print log for the beginning of the test case, as we usually run so many test cases as a test suit
	   * @param sTestCaseName
	   * @author Venkataraghavan on 07/08/2017:07:50:00AM
	   */
	   public static void startTestCase(String sTestCaseName){    	
	        Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
	   }
	   
	  /**
	  * This method is used to print log for the ending of the test case
	  * @param sTestCaseName
	  * @author Venkataraghavan on 07/08/2017:07:50:00AM
	  */
	   public static void endTestCase(String sTestCaseName){	 
	     Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
	   }

	  /**
	  * This method is used to print info log messages into the logfile
	  * @param message
	  * @author Venkataraghavan on 07/08/2017:07:50:00AM
	  */
	  public static void info(String message) {	 
	     Log.info(message);
	  }

	  /**
	  * This method is used to print warning log messages into the logfile
	  * @param message
	  * @author Venkataraghavan on 07/08/2017:07:50:00AM
	  */
	  public static void warn(String message) {	 
	     Log.warn(message);
	   }

	   /**
	   * This method is used to print error log messages into the logfile
	   * @param message
	   * @author Venkataraghavan on 07/08/2017:07:50:00AM
	   */
	   public static void error(String message) {	 
		 Log.error(message);
	   }

	   /**
	   * This method is used to print fatal log messages into the logfile
	   * @param message
	   * @author Venkataraghavan on 07/08/2017:07:50:00AM
	   */
	   public static void fatal(String message) {	 
	     Log.fatal(message);
	   }

	   /**
	   * This method is used to print debug log messages into the logfile
	   * @param message
	   * @author Venkataraghavan on 07/08/2017:07:50:00AM
	   */
	   public static void debug(String message) {	 
	     Log.debug(message);
	   }

}
