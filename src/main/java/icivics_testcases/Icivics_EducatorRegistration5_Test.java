package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Icivics_EducatorReg5;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_EducatorRegistration5_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Educator Registration5";
		testDescription = "Can you successfully register a new educator account";
		nodes = "Enrollment Form";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Educatorregistrationverification";
	}

	@Test(dataProvider = "fetchData")
	public void educatorregistration5(String URL) throws IOException, InterruptedException {

		new Icivics_EducatorReg5(driver, node, prop).launchURL(URL).msgdisplay().emailmsg().resendbutton();
	}

}
