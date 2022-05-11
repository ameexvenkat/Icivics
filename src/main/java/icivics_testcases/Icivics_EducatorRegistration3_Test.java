package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Icivics_EducatorReg3;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_EducatorRegistration3_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Educator Registration Page3";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Educatorregistration";
	}

	// C348 - Can you tell which page you are currently viewing in the breadcrumbs?
	@Test(dataProvider = "fetchData", priority = 0)
	public void C348_verifybreadcrumbspage3(String URL) throws IOException, InterruptedException {
		node = test.createNode("C348 - Can you tell which page you are currently viewing in the breadcrumbs?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg3(driver, node, prop).launchURL(URL).verifywithvaliddata().verifypagecount3();
	}

	// C349 - Can you select Back to proceed to the previous page?
	@Test(dataProvider = "fetchData", priority = 1)
	public void C349_verifypreviouspage(String URL) throws IOException, InterruptedException {
		node = test.createNode("C349 - Can you select Back to proceed to the previous page?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg3(driver, node, prop).launchURL(URL).verifywithvaliddata().Clickbackbutton();
	}

	// C350 - When you go Back, are your entries in all fields remembered?
	@Test(dataProvider = "fetchData", priority = 2)
	public void C350_verifyalldataremembered(String URL) throws IOException, InterruptedException {
		node = test.createNode("C350 - When you go Back, are your entries in all fields remembered?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg3(driver, node, prop).launchURL(URL).verifywithvaliddata().verifygradelevelremembered()
				.verifyroleremembered();
	}

	// C351 - Do you see fields for School or Institution, Zip Code, and Teaching
	// State?
	@Test(dataProvider = "fetchData", priority = 3)
	public void C351_verifyallpage3fields(String URL) throws IOException, InterruptedException {
		node = test.createNode("C351 - Do you see fields for School or Institution, Zip Code, and Teaching State?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg3(driver, node, prop).launchURL(URL).verifywithvaliddata().verifypage3schoolfield()
				.verifypage3zipcodefield().verifypage3TeachingStatefield().verifyteachstatedropdownoptions();
	}

	// C352 - Can you enter text/make a selection for all fields?
	@Test(dataProvider = "fetchData", priority = 4)
	public void C352_verifyallfieldsallowtoentertextandmakeselection(String URL)
			throws IOException, InterruptedException {
		node = test.createNode("C352 - Can you enter text/make a selection for all fields?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg3(driver, node, prop).launchURL(URL).verifywithvaliddata().VerifySchoolfield()
				.Verifyzipcodefield().VerifyTeachingstatefield().Verifyzipcodeerrormsg();
	}

	// C354 - If you enter invalid information in a required field and select Next,
	// do you receive an appropriate error message?
	@Test(dataProvider = "fetchData", priority = 5)
	public void C354_verifyallfieldswithinvaliddata(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C354 - If you enter invalid information in a required field and select Next, do you receive an appropriate error message?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg3(driver, node, prop).launchURL(URL).verifywithvaliddata().verifyenterinvaliddata();
	}

	// C355 - If you leave a required field blank and select Next, do you receive an
	// appropriate error message?
	@Test(dataProvider = "fetchData", priority = 6)
	public void C355_verifyallfieldswithblankfield(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C355 - If you leave a required field blank and select Next, do you receive an appropriate error message?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg3(driver, node, prop).launchURL(URL).verifywithvaliddata().verifyblankfielderrormsg();
	}

	// C357 - If you fill out all required fields with valid information and select
	// Next, are you taken to Page 4?
	@Test(dataProvider = "fetchData", priority = 7)
	public void C357_verifyvalidsubmission(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C357 - If you fill out all required fields with valid information and select Next, are you taken to Page 4?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg3(driver, node, prop).launchURL(URL).verifywithvaliddata()
				.verifyregistrationwithvaliddata().verifypage4loaded();
	}
}
