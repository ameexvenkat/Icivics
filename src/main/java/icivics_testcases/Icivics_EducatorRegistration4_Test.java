package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Icivics_EducatorReg4;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_EducatorRegistration4_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Educator Registration Page4";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Educatorregistration";
	}

	// C358 - Can you tell which page you are currently viewing in the breadcrumbs?
	@Test(dataProvider = "fetchData", priority = 0)
	public void C358_verifybreadcrumbspage4(String URL) throws IOException, InterruptedException {
		node = test.createNode("C358 - Can you tell which page you are currently viewing in the breadcrumbs?");
		extent.attachReporter(reporter);

		new Icivics_EducatorReg4(driver, node, prop).launchURL(URL).verifywithvaliddata().verifypagecount4();
	}

	// C359 - Can you select Back to proceed to the previous page?
	@Test(dataProvider = "fetchData", priority = 1)
	public void C359_verifypreviouspage(String URL) throws IOException, InterruptedException {
		node = test.createNode("C359 - Can you select Back to proceed to the previous page?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg4(driver, node, prop).launchURL(URL).verifywithvaliddata().clickbackbutton();
	}

	// C360 - When you go Back, are your entries in all fields remembered?
	@Test(dataProvider = "fetchData", priority = 2)
	public void C360_verifyalldataremembered(String URL) throws IOException, InterruptedException {
		node = test.createNode("C360 - When you go Back, are your entries in all fields remembered?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg4(driver, node, prop).launchURL(URL).verifywithvaliddata().verifySchoolremembered()
				.verifyZipCoderemembered().verifyTeachingStateremembered();
	}
	
	// C361 - Do you see fields for Password, Confirm Password, Sign Up for Emails, and Agree to Terms of Use/Privacy Policy?
	@Test(dataProvider = "fetchData", priority = 3)
	public void C361_verifyallpage3fields(String URL) throws IOException, InterruptedException {
		node = test.createNode("C361 - Do you see fields for Password, Confirm Password, Sign Up for Emails, and Agree to Terms of Use/Privacy Policy?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg4(driver, node, prop)
		.launchURL(URL)
		.verifywithvaliddata()
		.verifypage4passwordfield()
		.verifypage4confirmpasswordfield()
		.verifypage4SignUpforEmailsfield()
		.verifypage4AgreetoTermsfield();
	}
	
		// C362 - Is the Sign Up for emails box checked by default?
		@Test(dataProvider = "fetchData", priority = 4)
		public void C362_verifySignUpischecked(String URL) throws IOException, InterruptedException {
			node = test.createNode("C362 - Is the Sign Up for emails box checked by default?");
			extent.attachReporter(reporter);
			new Icivics_EducatorReg4(driver, node, prop)
			.launchURL(URL)
			.verifywithvaliddata()
			.signupcheckbox();
		}
		
		// C363 - Can you enter text/make a selection for all fields?
		@Test(dataProvider = "fetchData", priority = 5)
		public void C363_verifyallpage4fields(String URL) throws IOException, InterruptedException {
			node = test.createNode("C363 - Can you enter text/make a selection for all fields?");
			extent.attachReporter(reporter);
			new Icivics_EducatorReg4(driver, node, prop)
			.launchURL(URL)
			.verifywithvaliddata()
			.VerifyPassword()
			.VerifyPasswordacceptweakpwd()
			.Verifyaccepttermschecked();
		}
		
		// C364 - Are required fields marked with an asterisk?
		@Test(dataProvider = "fetchData", priority = 6)
		public void C364_verifyallfieldasterisk(String URL) throws IOException, InterruptedException {
			node = test.createNode("C364 - Are required fields marked with an asterisk?");
			extent.attachReporter(reporter);
			new Icivics_EducatorReg4(driver, node, prop)
			.launchURL(URL)
			.verifywithvaliddata()
			.verifypasswordAsteriks()
			.verifyconfirmpasswordAsteriks();
		}	
		
		// C365 - If you hover over the password field, do you see a hover tooltip with appropriate text?
		@Test(dataProvider = "fetchData", priority = 7)
		public void C365_verifypasswordtooltips(String URL) throws IOException, InterruptedException {
			node = test.createNode("C365 - If you hover over the password field, do you see a hover tooltip with appropriate text?");
			extent.attachReporter(reporter);
			new Icivics_EducatorReg4(driver, node, prop)
			.launchURL(URL)
			.verifywithvaliddata()
			.hoveronpwdfield();
		}
		
		// C366 - When you enter text in the Password field, do you see text indicating the current password's strength?
				@Test(dataProvider = "fetchData", priority = 8)
				public void C366_verifypasswordstrengthIndicator(String URL) throws IOException, InterruptedException {
					node = test.createNode("C366 - When you enter text in the Password field, do you see text indicating the current password's strength?");
					extent.attachReporter(reporter);
					new Icivics_EducatorReg4(driver, node, prop)
					.launchURL(URL)
					.verifywithvaliddata()
					.VerifyPasswordstrengthmeter();
				}
				// C367 - When you enter text in the Confirm Password field do you see text indicating whether the two passwords match?
				@Test(dataProvider = "fetchData", priority = 9)
				public void C367_verifypasswordIndicatormatch(String URL) throws IOException, InterruptedException {
					node = test.createNode("C367 - When you enter text in the Confirm Password field do you see text indicating whether the two passwords match?");
					extent.attachReporter(reporter);
					new Icivics_EducatorReg4(driver, node, prop)
					.launchURL(URL)
					.verifywithvaliddata()
					.VerifyPasswordindicatormatch();
				}	
				
				// C368 - If you enter invalid information in a required field and select Next, do you receive an appropriate error message?
				@Test(dataProvider = "fetchData", priority = 10)
				public void C368_verifyallfieldswithinvaliddata(String URL) throws IOException, InterruptedException {
					node = test.createNode("C368 - If you enter invalid information in a required field and select Next, do you receive an appropriate error message?");
					extent.attachReporter(reporter);
					new Icivics_EducatorReg4(driver, node, prop)
					.launchURL(URL)
					.verifywithvaliddata()
					.verifyenterinvaliddata();
				}
				// C369 - If you leave a required field blank and select Next, do you receive an appropriate error message?
				@Test(dataProvider = "fetchData", priority = 11)
				public void C369_verifyallfieldswithblankdata(String URL) throws IOException, InterruptedException {
					node = test.createNode("C369 - If you leave a required field blank and select Next, do you receive an appropriate error message?");
					extent.attachReporter(reporter);
					new Icivics_EducatorReg4(driver, node, prop)
					.launchURL(URL)
					.verifywithvaliddata()
					.verifyblankerrormsg();
				}
				
				// C370 - Do all error messages display correctly?
				@Test(dataProvider = "fetchData", priority = 12)
				public void C370_verifyallfieldswithblankandinvaliddata(String URL) throws IOException, InterruptedException {
					node = test.createNode("C370 - Do all error messages display correctly?");
					extent.attachReporter(reporter);
					new Icivics_EducatorReg4(driver, node, prop)
					.launchURL(URL)
					.verifywithvaliddata()
					.verifyenterinvaliddataerror();
				}
				
				// C371 - If you fill out all required fields with valid information and select Finish, are you taken to Page 5?
				@Test(dataProvider = "fetchData", priority = 13)
				public void C371_verifyvalidsubmission(String URL) throws IOException, InterruptedException {
					node = test.createNode("C371 - If you fill out all required fields with valid information and select Finish, are you taken to Page 5?");
					extent.attachReporter(reporter);
					new Icivics_EducatorReg4(driver, node, prop)
					.launchURL(URL)
					.verifywithvaliddata()
					.verifyregistrationwithvaliddata()
					.verifypage5loaded();
				}
}
