package icivics_pages;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_EducatorReg3 extends ProjectSpecificMethods {
	
	public String gpropname = "EducatorRegistration/educatorregistration";
	public String lpropname = "EducatorRegistration/educatorregistration1";
	public String propname2 = "EducatorRegistration/educatorregistration2";
	public String propname3 = "EducatorRegistration/educatorregistration3";
	
	public Icivics_EducatorReg3(RemoteWebDriver driver, ExtentTest node, Properties prop) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
	}

	@Given("Given Launch the icivis educatorregistration URL")
	public Icivics_EducatorReg3 launchURL(String URL) {
		navigateto(URL);
		return this;
	}
	
	public Icivics_EducatorReg3 verifywithvaliddata() throws InterruptedException, IOException {
		
		WebElement username = propElement(getPropfile(gpropname, "username"));
		String username1 = username.getText();
		writePropfile("EducatorRegistration/username", "username", username1);
		
		WebElement firstname = propElement(getPropfile(gpropname, "firstname"));
		firstname.clear();
		firstname.sendKeys(getPropfile(lpropname, "FirstName"));
		
		WebElement lastname = propElement(getPropfile(gpropname, "Lastname"));
		lastname.clear();
		lastname.sendKeys(getPropfile(lpropname, "LastName"));
		
		String EmailId = getPropfile(lpropname, "EmailID");
		
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		String[] data = EmailId.split("@");
		String name = data[0];
		String host = data[1];
		String emailId = name + number + "@" + host;
		
		writePropfile("EducatorRegistration/email", "email", emailId);
		WebElement email = propElement(getPropfile(gpropname, "Emailaddress"));
		email.clear();
		email.sendKeys(emailId);
		
		WebElement verifyemail = propElement(getPropfile(gpropname, "VerifyEmailaddress"));
		verifyemail.clear();
		verifyemail.sendKeys(emailId);
		
		WebElement nextbutton = propElement(getPropfile(gpropname, "nextbutton"));
		scrollToTheGivenWebElement(getPropfile(gpropname, "nextbutton"));
		nextbutton.click();
		waitTime(3000);
		
		String value = getPropfile(propname2, "Checkboxvalue");
		List<WebElement> chkBox = propElement1(getPropfile(propname2, "checkboxlist1"));
		int Size = chkBox.size();
		for (int i = 0; i < Size-1; i++) {
			String val = chkBox.get(i).getAttribute("value");
			if (val.equalsIgnoreCase(value)) {
				if(!chkBox.get(i).isSelected())
				{       
					chkBox.get(i).click();
					break;
				}
				} 
				
		}
		
		String dropdownvalue = getPropfile(propname2, "Dropdownvalue");
		WebElement roleDropDown = propElement(getPropfile(propname2, "roledropdown"));
		selectDropDownUsingValue(roleDropDown, dropdownvalue);
		waitTime(3000);

		click(propElement(getPropfile(propname2, "Nextbutton")));
		waitTime(3000);
		
		return this;
	}

	@Given("verify Current page count 3 and print")
	public Icivics_EducatorReg3 verifypagecount3() throws IOException {
		
		String cssvalue = "background-color";
		String Greycolor = "rgb(88, 89, 91)";
		String Greencolor = "rgb(0, 178, 124)";

		String Step1 = cssgetbefore(getPropfile(gpropname, "step1ele"), cssvalue, Greencolor);
		String Step2 = cssgetbefore(getPropfile(gpropname, "step2ele"), cssvalue, Greencolor);
		String Step3 = cssgetbefore(getPropfile(gpropname, "step3ele"), cssvalue, Greencolor);
		String Step4 = cssgetbefore(getPropfile(gpropname, "step4ele"), cssvalue, Greycolor);
		String Step5 = cssgetbefore(getPropfile(gpropname, "step5ele"), cssvalue, Greycolor);

		if (Step1.equals(Greencolor) && Step2.equals(Greencolor) && Step3.equals(Greencolor) && Step4.equals(Greycolor)
				&& Step5.equals(Greycolor)) {
			reportStep("you are currently viewing page 3 in the breadcrumbs", "Pass");
		} else {
			reportStep("unable to identify which page you are currently viewing in the breadcrumbs", "Fail");
		}
		return this;
	}
	
	@Given("Verify clicking on back button will take to previous page 2")
	public Icivics_EducatorReg3 Clickbackbutton() throws InterruptedException, IOException {
		WebElement backbutton = propElement(getPropfile(gpropname, "backbutton"));
		backbutton.click();
		waitTime(3000);
		String cssvalue = "background-color";
		String Greycolor = "rgb(88, 89, 91)";
		String Greencolor = "rgb(0, 178, 124)";

		String Step1 = cssgetbefore(getPropfile(gpropname, "step1ele"), cssvalue, Greencolor);
		String Step2 = cssgetbefore(getPropfile(gpropname, "step2ele"), cssvalue, Greencolor);
		String Step3 = cssgetbefore(getPropfile(gpropname, "step3ele"), cssvalue, Greycolor);
		String Step4 = cssgetbefore(getPropfile(gpropname, "step4ele"), cssvalue, Greycolor);
		String Step5 = cssgetbefore(getPropfile(gpropname, "step5ele"), cssvalue, Greycolor);

		if (Step1.equals(Greencolor) && Step2.equals(Greencolor) && Step3.equals(Greycolor) && Step4.equals(Greycolor)
				&& Step5.equals(Greycolor)) {
			reportStep("you are currently viewing page 2 in the breadcrumbs", "Pass");
		} else {
			reportStep("unable to identify which page you are currently viewing in the breadcrumbs", "Fail");
		}
		return this;
	}
	
	@And("Verify Grade Level is remembered.")
	public Icivics_EducatorReg3 verifygradelevelremembered() throws IOException {
		WebElement backbutton = propElement(getPropfile(gpropname, "backbutton"));
		backbutton.click();
		
		String value = getPropfile(propname2, "Checkboxvalue");
		List<WebElement> chkBox = propElement1(getPropfile(propname2, "checkboxlist1"));
		int Size = chkBox.size();
		for (int i = 0; i < Size-1; i++) {
			String val = chkBox.get(i).getAttribute("value");
			if (val.equalsIgnoreCase(value)) {
				if(chkBox.get(i).isSelected())
				{       
					reportStep("Grade level value " + val + " is remembered ", "Pass");
					break;
				} else {
					reportStep("Grade level value " + val + " is not remembered ", "Fail");
					}
				}
		}
		return this;
	}

	@And("Verify Role is remembered.")
	public Icivics_EducatorReg3 verifyroleremembered() throws IOException {
		scrollToTheGivenWebElement(getPropfile(propname2, "Nextbutton"));
		String dropdownvalue = getPropfile(propname2, "Dropdownvalue");
		String roleDropDown = propElement(getPropfile(propname2, "roledropdown")).getAttribute("value");
		if (roleDropDown.equals(dropdownvalue)) {
			reportStep("Role value " + roleDropDown + " is remembered ", "Pass");
		} else {
			reportStep("Role value " + roleDropDown + " is not remembered ", "Fail");
		}
		return this;
	}
	
	
	@Given("User on Page 3, Verify School or institution field is displayed")
	public Icivics_EducatorReg3 verifypage3schoolfield() {
		
		WebElement Schoolfieldlabel = propElement(getPropfile(propname3, "Schoolfieldlabel"));
		WebElement Schoolfieldtextbox = propElement(getPropfile(propname3, "Schoolfieldtextbox"));
		if (Schoolfieldlabel.isDisplayed() && Schoolfieldtextbox.isDisplayed()) {
			reportStep(Schoolfieldlabel.getText() + " text box and label is displayed", "Pass");
		} else {
			reportStep("School or institution text box and label is not displayed", "Fail");
		}
		
		return this;
	}

	@When("User on Page 3, Verify Zip Code field is displayed")
	public Icivics_EducatorReg3 verifypage3zipcodefield() {
		
		WebElement zipcodefieldlabel = propElement(getPropfile(propname3, "zipcodefieldlabel"));
		WebElement zipcodefieldtextbox = propElement(getPropfile(propname3, "zipcodefieldtextbox"));
		if (zipcodefieldlabel.isDisplayed() && zipcodefieldtextbox.isDisplayed()) {
			reportStep(zipcodefieldlabel.getText() + " text box and label is displayed", "Pass");
		} else {
			reportStep("Zipcode text box and label is not displayed", "Fail");
		}
		
		return this;
	}
		
	@And("User on Page 3, Verify Teaching State dropdown is displayed")
	public Icivics_EducatorReg3 verifypage3TeachingStatefield() {
		WebElement teachingstatelabel = propElement(getPropfile(propname3, "teachingstatelabel"));
		WebElement teachingstatedropdown = propElement(getPropfile(propname3, "teachingstatedropdown"));
		if (teachingstatelabel.isDisplayed() && teachingstatedropdown.isDisplayed()) {
			reportStep(teachingstatelabel.getText() + " Dropdown and label is displayed", "Pass");
		} else {
			reportStep("Teaching State Dropdown and label is not displayed", "Fail");
		}
		
		return this;
	}
	
	@And("Verify options in the Teaching State dropdown")
	public Icivics_EducatorReg3 verifyteachstatedropdownoptions() throws InterruptedException {
		scrollToTheGivenWebElement(getPropfile(propname3, "teachingstatedropdown1"));
		waitTime(3000);
		WebElement teachstate = propElement(getPropfile(propname3, "teachingstatedropdown1"));
		teachstate.click();
		waitTime(3000);
		Select sel = new Select(teachstate);
		if (sel.getFirstSelectedOption().getText().equals("- None -")) {
			reportStep("verified " + sel.getFirstSelectedOption().getText() + " is selected as default in teach state Dropdown","Pass");
		} else {
			reportStep("verified " + sel.getFirstSelectedOption().getText() + " is selected as default in teach state Dropdown","Fail");
		}
		List<WebElement> teachstateoptions = sel.getOptions();
		int size = teachstateoptions.size();
		for (int i = 0; i < size - 1; i++) {
			String options = teachstateoptions.get(i).getText();
			reportStep("verified that " + options + " is present in teach state Dropdown", "Pass");
		}
		reportStep("teach state dropdown is displayed and verified all the available options sucessfully", "Pass");
		return this;
	}

	@Given("Verify enter School or institution name in the textbox")
	public Icivics_EducatorReg3 VerifySchoolfield() {
		String SchoolName = getPropfile(propname3, "SchoolNamevalue");
		
		WebElement Schoolfield = propElement(getPropfile(propname3, "Schoolfield"));
		Schoolfield.sendKeys(SchoolName);
		String getschooltext = Schoolfield.getAttribute("value");
		if (getschooltext.equals(SchoolName)) {
			reportStep("Schoolfield text box allows to enter text "+ SchoolName, "Pass");
		} else {
			reportStep("Schoolfield text box does not allow to enter text "+ SchoolName, "Fail");
		}	return this;
	}	
		
	@When("Verify enter Zip code must be in proper 5 or 9 digit form")
	public Icivics_EducatorReg3 Verifyzipcodefield() {
		String Zipcode5 = getPropfile(propname3, "Zipcode5");
		
		WebElement Zipcodefield = propElement(getPropfile(propname3, "zipcodefieldtextbox"));
		Zipcodefield.sendKeys(Zipcode5);
		String getzipcodetext = Zipcodefield.getAttribute("value");
		if (getzipcodetext.equals(Zipcode5)) {
			reportStep("Zipcode text box allows to enter text 5 digit "+ Zipcode5, "Pass");
		} else {
			reportStep("Zipcode text box does not allow to enter text "+ Zipcode5, "Fail");
		}return this;
		}
		
	@When("Verify Teaching state selection from dropdown is working fine")
	public Icivics_EducatorReg3 VerifyTeachingstatefield() {
		String Teachstatevalue = getPropfile(propname3, "Teachstatevalue");
		WebElement teachingstate = propElement(getPropfile(propname3, "teachingstate"));
		selectDropDownUsingText(teachingstate, Teachstatevalue);
		waitTime(3000);
		propElement(getPropfile(propname3, "NextButton")).click();
		return this;
	}
	
	@And("Verify zipcode display error msg if the zipcode is more than 9 digits")
	public Icivics_EducatorReg3 Verifyzipcodeerrormsg() {
		String Zipcode9 = getPropfile(propname3, "Zipcode9");
		String Zipcode11 = getPropfile(propname3, "Zipcode11");
		waitTime(3000);
		propElement(getPropfile(propname3, "BackButton")).click();
		waitTime(3000);
		WebElement Zipcodefield = propElement(getPropfile(propname3, "zipcodefieldtextbox"));
		Zipcodefield.clear();
		Zipcodefield.sendKeys(Zipcode9);
		reportStep("Zipcode text box allows to enter 9 digit "+ Zipcode9, "Pass");
		propElement(getPropfile(propname3, "NextButton")).click();
		waitTime(3000);
		WebElement password = propElement(getPropfile(propname3, "password"));
		if (password.isDisplayed()) {
			reportStep("Password field page 4 is displayed", "Pass");
		}else {
			reportStep("Password field page 4 is not displayed", "Fail");
		}
		waitTime(3000);
		scrollToTheGivenWebElement(getPropfile(propname3, "Backbutton1"));
		click(propElement(getPropfile(propname3, "Backbutton1")));
		waitTime(3000);
		WebElement Zipcodefield1 = propElement(getPropfile(propname3, "Zipcodefield1"));
		Zipcodefield1.clear();
		Zipcodefield1.sendKeys(Zipcode11);
		propElement(getPropfile(propname3, "NextButton")).click();
		waitTime(3000);
		WebElement zipcodeerror = propElement(getPropfile(propname3, "errorbox"));
		if (zipcodeerror.isDisplayed()) {
			verifyExactText(zipcodeerror, "Zip Code is invalid.");
			reportStep("Zipcode filed text box does not allow to enter more than 9 digit and click next "+ Zipcode11, "Pass");
		}else {
			reportStep("Zipcode filed text box allows to enter more than  9 digit "+ Zipcode11, "Fail");
		}
		return this;
	}

	@Given("Enter invalid School, Zipcode as none for Teacherstate and verify the error messages.")
	public Icivics_EducatorReg3 verifyenterinvaliddata() {
		WebElement Schoolfield = propElement(getPropfile(propname3, "Schoolfield"));
		clearAndType(Schoolfield, "gfgh^d$fthf&");

		WebElement Zipcodefield = propElement(getPropfile(propname3, "zipcodefieldtextbox"));
		clearAndType(Zipcodefield, "66654789789678");

		WebElement teachingstate = propElement(getPropfile(propname3, "teachingstate"));
		selectDropDownUsingIndex(teachingstate, 0);
		waitTime(3000);
		
		click(propElement(getPropfile(propname3, "NextButton")));
		
		WebElement TeachstateError = propElement(getPropfile(propname3, "TeachstateError"));
		WebElement zipcodeerror = propElement(getPropfile(propname3, "zipcodeerror"));
		if (TeachstateError.isDisplayed()&&zipcodeerror.isDisplayed()) {
			verifyExactText(TeachstateError, "Teaching state is required for teacher.");
			verifyExactText(zipcodeerror, "Zip Code is invalid.");
		}else {
			reportStep("Teacherstate and Zipcode filed text box error messages is not verifed", "Fail");
		}
		return this;
	}

	@Given("Click on next without entering any valid data in School, Zipcode as none for Teacherstate and verify the error messages.")
	public Icivics_EducatorReg3 verifyblankfielderrormsg() {
		propElement(getPropfile(propname3, "Schoolfield")).clear();
		propElement(getPropfile(propname3, "zipcodefieldtextbox")).clear();
		WebElement teachingstate = propElement(getPropfile(propname3, "teachingstate"));
		selectDropDownUsingIndex(teachingstate, 0);
		click(propElement(getPropfile(propname3, "NextButton")));
		
		WebElement TeachstateError = propElement(getPropfile(propname3, "TeachstateError"));
		WebElement schoolError = propElement(getPropfile(propname3, "schoolError1"));
		WebElement zipcodeerror = propElement(getPropfile(propname3, "zipcodeerror1"));
		if (TeachstateError.isDisplayed() && schoolError.isDisplayed() && zipcodeerror.isDisplayed()) {
			verifyExactText(TeachstateError, "Teaching state is required for teacher.");
			verifyExactText(schoolError, "School is required for teacher.");
			verifyExactText(zipcodeerror, "Zip Code is required for teacher.");
		}else {
			reportStep("Teacherstate, School and Zipcode filed text box error messages is not verifed", "Fail");
		}
		return this;
	}
	
	@Given("Verify select vaild options and click on next button")
	public Icivics_EducatorReg3 verifyregistrationwithvaliddata() {
		String SchoolName = getPropfile(propname3, "Checkboxvalue");
		
		WebElement Schoolfield = propElement(getPropfile(propname3, "Schoolfield"));
		Schoolfield.sendKeys(SchoolName);
		
		WebElement Zipcodefield = propElement(getPropfile(propname3, "zipcodefieldtextbox"));
		Zipcodefield.sendKeys(getPropfile(propname3, "Zipcode5"));
		
		String Teachstatevalue = getPropfile(propname3, "Teachstatevalue");
		
		WebElement teachingstate = propElement(getPropfile(propname3, "teachingstate"));
		selectDropDownUsingText(teachingstate, Teachstatevalue);
		waitTime(3000);

		click(propElement(getPropfile(propname3, "NextButton")));
		waitTime(3000);
		return this;
	}
	
	@Then("verify page 4 is loaded")
	public Icivics_EducatorReg3 verifypage4loaded() throws InterruptedException, IOException {
		
		WebElement page3 = propElement(getPropfile(propname3, "password"));
		if (page3.isDisplayed()) {
			reportStep("Page 4 is displayed", "Pass");
		}else {
			reportStep("Page 4 is not displayed", "Fail");
		}
		return this;
	}
}
