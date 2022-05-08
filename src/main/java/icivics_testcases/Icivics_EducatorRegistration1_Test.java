package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Icivics_EducatorReg1;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_EducatorRegistration1_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Educator Registration Page1";		
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Educatorregistration";
	}
	
	//C327 - Can you tell which page you are currently viewing in the breadcrumbs?
	@Test(dataProvider = "fetchData", priority=0)
	public void verifybreadcrumbspage1(String URL) throws IOException, InterruptedException {
		node = test.createNode("Can you tell which page you are currently viewing in the breadcrumbs?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg1(driver, node, prop)
		.launchURL(URL)
		.verifypagecount1();
	}
	
	//C328 - Do you see fields for Username, First Name, Last Name, E-mail address, and Verify email address?
		@Test(dataProvider = "fetchData", priority=1)
		public void educatorregistration1(String URL) throws IOException, InterruptedException {
			node = test.createNode("Do you see fields for Username, First Name, Last Name, E-mail address, and Verify email address?");
			extent.attachReporter(reporter);
			new Icivics_EducatorReg1(driver, node, prop)
			.launchURL(URL)
			.verifypagecount1();
		}
}