package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Icivics_EducatorReg2;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_EducatorRegistration2_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Educator Registration2";
		testDescription = "Can you successfully register a new educator account";
		nodes = "Enrollment Form";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Educatorregistration";
	}

	@Test(dataProvider = "fetchData")
	public void educatorregistration2(String URL) throws IOException, InterruptedException {

		new Icivics_EducatorReg2(driver, node, prop).launchURL(URL).Clickbackbutton().verifygradelevelfield()
				.verifyrolefield().verifygradelevelselection().verifyroledropdown().selectotherdromdropdown().clicknextbutton().backgroundcolor().registrationpage2done();

	}
}