package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Icivics_EducatorReg2;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_EducatorRegistration2_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Educator Registration Page2";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Educatorregistration";
	}

	// C338 - Can you tell which page you are currently viewing in the breadcrumbs?
		@Test(dataProvider = "fetchData", priority = 0)
		public void C338_verifybreadcrumbspage1(String URL) throws IOException, InterruptedException {
			node = test.createNode("C338 - Can you tell which page you are currently viewing in the breadcrumbs?");
			extent.attachReporter(reporter);
			new Icivics_EducatorReg2(driver, node, prop)
			.launchURL(URL).verifywithvaliddata().verifypagecount2();
		}
		
		// C339 - Can you select Back to proceed to the previous page?
			@Test(dataProvider = "fetchData", priority = 1)
			public void C339_verifypreviouspage(String URL) throws IOException, InterruptedException {
				node = test.createNode("C339 - Can you select Back to proceed to the previous page?");
				extent.attachReporter(reporter);
				new Icivics_EducatorReg2(driver, node, prop)
				.launchURL(URL)
				.verifywithvaliddata()
				.Clickbackbutton();
		}
			
		//C340 - When you go Back, are your entries in all fields remembered (but not the randomly generated username)?	
			@Test(dataProvider = "fetchData", priority = 2)
			public void C340_verifyalldataremembered(String URL) throws IOException, InterruptedException {
				node = test.createNode("C340 - When you go Back, are your entries in all fields remembered (but not the randomly generated username)?");
				extent.attachReporter(reporter);
				new Icivics_EducatorReg2(driver, node, prop)
				.launchURL(URL)
				.verifywithvaliddata()
				.Clickbackbutton()
				.verifyusernameisnotremembered()
				.verifyfirstnameisremembered()
				.verifylastnameisremembered()
				.verifyemailisremembered()
				.verifyemail2isremembered();
		}	
			
		//C341 - Do you see fields for Role and Grade Level?	
			@Test(dataProvider = "fetchData", priority = 3)
			public void C341_verifyRoleandGradeLevel(String URL) throws IOException, InterruptedException {
				node = test.createNode("C341 - Do you see fields for Role and Grade Level?");
				extent.attachReporter(reporter);
				new Icivics_EducatorReg2(driver, node, prop)
				.launchURL(URL)
				.verifywithvaliddata()
				.verifygradelevelfield()
				.verifygradelevelfieldisselected()
				.verifyrolefieldoptions();
		}	
			
		//C342 - Can you make a selection for all fields?	
			@Test(dataProvider = "fetchData", priority = 4)
			public void C342_verifymakeselection(String URL) throws IOException, InterruptedException {
				node = test.createNode("C342 - Can you make a selection for all fields?");
				extent.attachReporter(reporter);
				new Icivics_EducatorReg2(driver, node, prop)
				.launchURL(URL)
				.verifywithvaliddata()
				.verifygradelevelselection()
				.verifyroledropdown();
		}	
			
		//C343 - If you select the Role 'Other' does an additional 'What is your role?' field appear?	
			@Test(dataProvider = "fetchData", priority = 5)
			public void C343_verifyotheradditionalfield(String URL) throws IOException, InterruptedException {
				node = test.createNode("C343 - If you select the Role 'Other' does an additional 'What is your role?' field appear?");
				extent.attachReporter(reporter);
				new Icivics_EducatorReg2(driver, node, prop)
				.launchURL(URL)
				.verifywithvaliddata()
				.verifyotheradditionalfield();
		}		
			
		//C344 - Are required fields marked with an asterisk?	
			@Test(dataProvider = "fetchData", priority = 6)
			public void C344_verifyasterisk(String URL) throws IOException, InterruptedException {
				node = test.createNode("C344 - Are required fields marked with an asterisk?");
				extent.attachReporter(reporter);
				new Icivics_EducatorReg2(driver, node, prop)
				.launchURL(URL)
				.verifywithvaliddata()
				.verifyGradeLevelAsteriks()
				.verifyRoleAsteriks()
				.verifyWhatisyourroleAsteriks();
		}	
			
		//C345 - If you leave a required field blank and select Next, do you receive an appropriate error message?
			@Test(dataProvider = "fetchData", priority = 7)
			public void C345_verifyblankerrormsg(String URL) throws IOException, InterruptedException {
				node = test.createNode("C345 - If you leave a required field blank and select Next, do you receive an appropriate error message?");
				extent.attachReporter(reporter);
				new Icivics_EducatorReg2(driver, node, prop)
				.launchURL(URL)
				.verifywithvaliddata()
				.verifygradeandroleerrormsg()
				.verifygradeandwhatisyourroleerrormsg();
		}	
		
		// C346 - Do all error messages display correctly?
			@Test(dataProvider = "fetchData", priority = 8)
			public void C346_verifyerrormsgboxcolor(String URL) throws IOException, InterruptedException {
				node = test.createNode("C346 - Do all error messages display correctly?");
				extent.attachReporter(reporter);
				new Icivics_EducatorReg2(driver, node, prop)
				.launchURL(URL)
				.verifywithvaliddata()
				.verifyerrormsgboxcolor();
		}	
			
		// C347 - If you fill out all required fields with valid information and select Next, are you taken to Page 3?
			@Test(dataProvider = "fetchData", priority = 9)
			public void C347_verifyvalidsubmission(String URL) throws IOException, InterruptedException {
				node = test.createNode("C347 - If you fill out all required fields with valid information and select Next, are you taken to Page 3?");
				extent.attachReporter(reporter);
				new Icivics_EducatorReg2(driver, node, prop)
				.launchURL(URL)
				.verifywithvaliddata()
				.verifyregistrationwithvaliddata()
				.verifypage3loaded();
		}	
			
}