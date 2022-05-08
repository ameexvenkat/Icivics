package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Icivics_EducatorReg4;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_EducatorRegistration4_Test extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Educator Registration3";
		testDescription = "Can you successfully register a new educator account";
		nodes = "Enrollment Form";
		authors = "Venkat";
		category = "Smoke";
		dataSheetName = "Icivics_Educatorregistration";
	}

	@Test(dataProvider = "fetchData")
	public void educatorregistration4(String URL) throws IOException, InterruptedException {

		new Icivics_EducatorReg4(driver, node, prop).launchURL(URL).clickbackbutton().verifyfield().signupcheckbox()
				.enterpassword().hoverpasswordbutton().passwordstrength().confirmpassword().enterinvalidtext()
				.Entervaliddata();

	}
}
