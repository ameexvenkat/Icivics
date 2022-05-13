package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Icivics_EducatorReg5;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_EducatorRegistration5_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Educator Registration Page5";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Educatorregistration";
	}

	// C372 - Can you tell which page you are currently viewing in the breadcrumbs?
	@Test(dataProvider = "fetchData", priority = 0)
	public void C372_verifybreadcrumbspage5(String URL) throws IOException, InterruptedException {
		node = test.createNode("C372 - Can you tell which page you are currently viewing in the breadcrumbs?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg5(driver, node, prop).launchURL(URL).verifywithvaliddata().verifypagecount5();
	}

	// C373 - Do you see a notification that a welcome message has been sent to your email address?
	@Test(dataProvider = "fetchData", priority = 0)
	public void C373_verifywelcomemessage(String URL) throws IOException, InterruptedException {
		node = test.createNode(
				"C373 - Do you see a notification that a welcome message has been sent to your email address?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg5(driver, node, prop).launchURL(URL).verifywithvaliddata().verifycheckmsgdisplay();
	}

	// C374 - Do you see text that your confirmation email is on the way?
	@Test(dataProvider = "fetchData", priority = 0)
	public void C374_verifyconfirmationemail(String URL) throws IOException, InterruptedException {
		node = test.createNode("C374 - Do you see text that your confirmation email is on the way?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg5(driver, node, prop).launchURL(URL).verifywithvaliddata().verifyemailheaderlabel();
	}

	// C375 - Is your email displayed on the page?
	@Test(dataProvider = "fetchData", priority = 0)
	public void C375_verifyconfirmationemail(String URL) throws IOException, InterruptedException {
		node = test.createNode("C375 - Is your email displayed on the page?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg5(driver, node, prop).launchURL(URL).verifywithvaliddata()
				.verifyregisteredemaildisplay();
	}

	// C376 - Can you select a button to resend your confirmation email?
	@Test(dataProvider = "fetchData", priority = 0)
	public void C376_verifyresendbutton(String URL) throws IOException, InterruptedException {
		node = test.createNode("C376 - Can you select a button to resend your confirmation email?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg5(driver, node, prop).launchURL(URL).verifywithvaliddata().verifyresendbutton();
	}

	// C377 - Do you see a notification when the email has been resent?
	@Test(dataProvider = "fetchData", priority = 0)
	public void C377_verifynotification(String URL) throws IOException, InterruptedException {
		node = test.createNode("C377 - Do you see a notification when the email has been resent?");
		extent.attachReporter(reporter);
		new Icivics_EducatorReg5(driver, node, prop).launchURL(URL).verifywithvaliddata().verifyconfirmationemail();
	}
}
