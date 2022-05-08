package projectSpecific.base;

import java.io.IOException;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import selenium.base.SeleniumBase;
import utilities.DataLibrary;

public class ProjectSpecificMethods extends SeleniumBase {

	public String dataSheetName;
	
	@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws IOException {
		return DataLibrary.readExcelData(dataSheetName);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		
		//String URL = "https://staging.d9.icivics.org/";
		String browser = "chrome";
		//If u want to navigate from homepage to other icivics_pages,remove the double slash(//) line no 25,30,33 and add double slash in line no 29,32 
		if (browser.equalsIgnoreCase("chrome")) {
			driver = startApp1("chrome");
			//driver = startApp("chrome",URL);
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = startApp1("firefox");
			//driver = startApp("firefox",URL);
			}
		//node = test.createNode(testCaseName);
	}

	

	@AfterMethod
	public void afterMethod() {
		close();
	}
}