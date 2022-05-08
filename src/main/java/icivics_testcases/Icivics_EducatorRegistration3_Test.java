package icivics_testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import icivics_pages.Icivics_EducatorReg3;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_EducatorRegistration3_Test extends ProjectSpecificMethods {

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
	public void educatorregistration3(String URL) throws IOException, InterruptedException {

		new Icivics_EducatorReg3(driver, node, prop).launchURL(URL).clickbackbutton().page3fields().enterdata()
				.enterinvaliddata().blankfield().validdata();
	}

}
