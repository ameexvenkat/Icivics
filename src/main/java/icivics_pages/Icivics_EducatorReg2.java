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
import cucumber.api.java.en.When;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_EducatorReg2 extends ProjectSpecificMethods {
	public String gpropname = "EducatorRegistration/educatorregistration";
	public String lpropname = "EducatorRegistration/educatorregistration1";
	public String propname2 = "EducatorRegistration/educatorregistration2";

	public Icivics_EducatorReg2(RemoteWebDriver driver, ExtentTest node, Properties prop) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
	}
	
	@Given("Given Launch the icivis educatorregistration URL")
	public Icivics_EducatorReg2 launchURL(String URL) {
		navigateto(URL);
		return this;
	}
	
	public Icivics_EducatorReg2 verifywithvaliddata() throws InterruptedException, IOException {
		
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
		WebElement emailele = propElement(getPropfile(gpropname, "Emailaddress"));
		clearAndType(emailele, emailId);
		
		WebElement verifyemail = propElement(getPropfile(gpropname, "VerifyEmailaddress"));
		verifyemail.clear();
		verifyemail.sendKeys(emailId);
		
		WebElement nextbutton = propElement(getPropfile(gpropname, "nextbutton"));
		scrollToTheGivenWebElement(getPropfile(gpropname, "nextbutton"));
		nextbutton.click();
		waitTime(3000);
		
		WebElement page2 = propElement(getPropfile(gpropname, "gradelevel"));
		if(page2.isDisplayed()) {
			reportStep("Page 2 is displayed", "Pass");
			}else {
				reportStep("Page 2 is not displayed", "Fail");
			}
		
		return this;
	}

	@Given("verify Current page count 2 and print")
	public Icivics_EducatorReg2 verifypagecount2() throws IOException {
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

	@Given("Verify clicking on back button will take to previous page 1")
	public Icivics_EducatorReg2 Clickbackbutton() throws InterruptedException, IOException {
		WebElement backbutton = propElement(getPropfile(gpropname, "backbutton"));
		backbutton.click();
		waitTime(3000);
		String cssvalue = "background-color";
		String Greycolor = "rgb(88, 89, 91)";
		String Greencolor = "rgb(0, 178, 124)";

		String Step1 = cssgetbefore(getPropfile(gpropname, "step1ele"), cssvalue, Greencolor);
		String Step2 = cssgetbefore(getPropfile(gpropname, "step2ele"), cssvalue, Greycolor);
		String Step3 = cssgetbefore(getPropfile(gpropname, "step3ele"), cssvalue, Greycolor);
		String Step4 = cssgetbefore(getPropfile(gpropname, "step4ele"), cssvalue, Greycolor);
		String Step5 = cssgetbefore(getPropfile(gpropname, "step5ele"), cssvalue, Greycolor);

		if (Step1.equals(Greencolor) && Step2.equals(Greycolor) && Step3.equals(Greycolor) && Step4.equals(Greycolor)
				&& Step5.equals(Greycolor)) {
			reportStep("you are currently viewing page 1 in the breadcrumbs", "Pass");
		} else {
			reportStep("unable to identify which page you are currently viewing in the breadcrumbs", "Fail");
		}
		return this;
	}

	@Given("Verify Username is regenerated.")
	public Icivics_EducatorReg2 verifyusernameisnotremembered() throws IOException {

		WebElement username = propElement(getPropfile(gpropname, "username"));
		String username2 = username.getText();
		String username1 = getPropfile("username", "username");
		if (!username1.equals(username2)) {
			reportStep("Username is regenerated " + username1 + " & " + username2 + " are not same", "Pass");
		} else {
			reportStep("Username is not regenerated" + username1 + " & " + username2 + " are same", "Fail");
		}
		return this;
	}

	@When("Verify firstname is remembered.")
	public Icivics_EducatorReg2 verifyfirstnameisremembered() throws IOException {

		String firstnamevalue = propElement(getPropfile(gpropname, "firstname")).getAttribute("value");
		if (firstnamevalue.equals(getPropfile(lpropname, "FirstName"))) {
			reportStep("Firstname value " + firstnamevalue + " is remembered ", "Pass");
		} else {
			reportStep("Firstname value " + firstnamevalue + " is not remembered ", "Fail");
		}
		return this;
	}

	@And("Verify lastname is remembered.")
	public Icivics_EducatorReg2 verifylastnameisremembered() throws IOException {

		String lastname = propElement(getPropfile(gpropname, "Lastname")).getAttribute("value");
		if (lastname.equals(getPropfile(lpropname, "LastName"))) {
			reportStep("lastname value " + lastname + " is remembered ", "Pass");
		} else {
			reportStep("lastname value " + lastname + " is not remembered ", "Fail");
		}
		return this;
	}

	@And("Verify email is remembered.")
	public Icivics_EducatorReg2 verifyemailisremembered() throws IOException {
		String email = propElement(getPropfile(gpropname, "Emailaddress")).getAttribute("value");
		if (email.equals(getPropfile(lpropname, "EmailID"))) {
			reportStep("email value " + email + " is remembered ", "Pass");
		} else {
			reportStep("email value " + email + " is not remembered ", "Fail");
		}
		return this;
	}

	@And("Verify verifyemail is remembered.")
	public Icivics_EducatorReg2 verifyemail2isremembered() throws IOException {
		String verifyemail = propElement(getPropfile(gpropname, "VerifyEmailaddress")).getAttribute("value");
		if (verifyemail.equals(getPropfile(lpropname, "VerifyEmailID"))) {
			reportStep("verify email value " + verifyemail + " is remembered ", "Pass");
		} else {
			reportStep("verify email value " + verifyemail + " is not remembered ", "Fail");
		}
		return this;
	}


	@Given("User on Page 2, Verify grade level field and option is displayed as checkbox and nothing is selected as default")
	public Icivics_EducatorReg2 verifygradelevelfield() throws IOException {
		WebElement gradelevellabel = propElement(getPropfile(propname2, "gradelevellabel"));
		if (gradelevellabel.isDisplayed()) {
			reportStep(gradelevellabel.getText() + " label is displayed", "Pass");
		} else {
			reportStep("Grade Level label is not displayed", "Fail");
		}
		List<WebElement> checkbox = propElement1(getPropfile(propname2, "checkboxlist"));
		for (int i = 0; i <= checkbox.size() - 1; i++) {
			checkbox.get(i).isDisplayed();
			String checkboxvalue = checkbox.get(i).getText();
			writePropfile("EducatorRegistration/gradelevel", "value", checkboxvalue);
			String checkboxvalue1 = getPropfile("gradelevel", "value");
			if (checkboxvalue.equals(checkboxvalue1)) {
				reportStep(checkboxvalue1 + "options are matched and verified", "Pass");
			} else {
				reportStep(checkboxvalue1 + "options are not matched", "Fail");
			}
		}
		return this;
	}

	@When("User on Page 2, Verify nothing is selected as default for grade level")
	public Icivics_EducatorReg2 verifygradelevelfieldisselected() throws IOException {
		List<WebElement> checkbox = propElement1(getPropfile(propname2, "checkboxlist1"));
		for (int i = 0; i <= checkbox.size() - 1; i++) {

			if (!checkbox.get(i).isSelected()) {
				reportStep(checkbox.get(i).getAttribute("value") + " option is not selected as default", "Pass");
			} else {
				reportStep(checkbox.get(i).getAttribute("value") + " option is selected as default", "Fail");
			}
		}
		reportStep("Grade level Checkbox is not selected with any default", "Pass");
		return this;
	}

	@And("Verify role options in the dropdown")
	public Icivics_EducatorReg2 verifyrolefieldoptions() throws InterruptedException {
		scrollToTheGivenWebElement(getPropfile(propname2, "roledropdown"));
		waitTime(3000);
		WebElement rolelabel = propElement(getPropfile(propname2, "rolelabel"));
		if (rolelabel.isDisplayed()) {
			reportStep(rolelabel.getText() + " label is displayed", "Pass");
		} else {
			reportStep("Role label is not displayed", "Fail");
		}
		WebElement role = propElement(getPropfile(propname2, "roledropdown"));
		role.click();
		waitTime(3000);
		Select sel = new Select(role);
		if (sel.getFirstSelectedOption().getText().equals("- None -")) {
			reportStep("verified " + sel.getFirstSelectedOption().getText() + " is selected as default in Role Dropdown","Pass");
		} else {
			reportStep("verified " + sel.getFirstSelectedOption().getText() + " is selected as default in Role Dropdown","Fail");
		}
		List<WebElement> roleoptions = sel.getOptions();
		int size = roleoptions.size();
		for (int i = 0; i < size - 1; i++) {
			String options = roleoptions.get(i).getText();
			reportStep("verified that " + options + " is present in Role Dropdown", "Pass");
		}
		reportStep("Role dropdown is displayed and verified all the available options sucessfully", "Pass");
		return this;
	}

	@Given("Verify Grade level can have >1 value selected")
	public Icivics_EducatorReg2 verifygradelevelselection() {
		List<WebElement> chkBox = propElement1(getPropfile(propname2, "checkboxlist1"));
		int Size = chkBox.size();
		for (int i = 0; i < Size; i++) {
			if (!chkBox.get(i).isSelected()) {
				chkBox.get(i).click();
				waitTime(1000);
				reportStep(chkBox.get(i).getAttribute("value") + " option is selected", "Pass");
			} else {
				reportStep("This step failed", "Fail");
			}
		}reportStep("Grade level Checkbox allows to select more than one option, all checkbox's are selected",
				"Pass");
		return this;
	}

	@When("Verify Role can have only 1 value selected")
	public Icivics_EducatorReg2 verifyroledropdown() {
		WebElement DropDown = propElement(getPropfile(propname2, "roledropdown"));
		scrollToTheGivenWebElement(getPropfile(propname2, "roledropdown"));
		Select sel = new Select(DropDown);
		boolean result = sel.isMultiple();
		if (result == false) {
			reportStep("Role Dropdown is not an multi select option", "Pass");
		} else {
			reportStep("Role Dropdown is an multi select option", "Fail");
		}
		waitTime(3000);
		return this;
	}

	@Given("Verify on selecting other from grade level dropdown display additional field")
	public Icivics_EducatorReg2 verifyotheradditionalfield() {
		WebElement DropDown = propElement(getPropfile(propname2, "roledropdown"));
		selectDropDownUsingIndex(DropDown, 7);
		waitTime(3000);
		WebElement othertextlabel = propElement(getPropfile(propname2, "othertextlabel"));
		if (othertextlabel.isDisplayed()) {
			reportStep(othertextlabel.getText() + " label is displayed", "Pass");
			WebElement othertextbox = propElement(getPropfile(propname2, "othertextbox"));
			othertextbox.isDisplayed();
			reportStep("What is your role? text box is displayed", "Pass");
		} else {
			reportStep("What is your role? text box and label is not displayed", "Fail");
		}
		return this;
	}

	@Given("Verify Grade Level is marked with an asterisk")
	public Icivics_EducatorReg2 verifyGradeLevelAsteriks() throws IOException {
		cssgetafter(getPropfile(propname2, "edureg2.gl*"), "content", "\"*\"");
		reportStep("Asteriks * is present in the Grade Level label", "Pass");
		return this;
	}

	@When("Verify Role is marked with an asterisk")
	public Icivics_EducatorReg2 verifyRoleAsteriks() throws IOException {
		cssgetafter(getPropfile(propname2, "edureg2.role*"), "content", "\"*\"");
		reportStep("Asteriks * is present in the Role label", "Pass");
		return this;
	}

	@And("Verify What is your role? is marked with an asterisk")
	public Icivics_EducatorReg2 verifyWhatisyourroleAsteriks() throws IOException {
		cssgetafter(getPropfile(propname2, "edureg2.Wiyr*"), "content", "\"*\"");
		reportStep("Asteriks * is present in the What is your role? label", "Pass");
		return this;
	}

	@Given("Click on Next button and verify grade and role error msg")
	public Icivics_EducatorReg2 verifygradeandroleerrormsg() {
		scrollToTheGivenWebElement(getPropfile(propname2, "roledropdown"));
		WebElement DropDown = propElement(getPropfile(propname2, "roledropdown"));
		selectDropDownUsingIndex(DropDown, 0);
		click(propElement(getPropfile(propname2, "Nextbutton")));
		
		WebElement errormsgbox = propElement(getPropfile(propname2, "errormsgbox"));
		if (errormsgbox.isDisplayed()) {
			reportStep("Error msg box Is displayed", "Pass");
			verifyExactText(propElement(getPropfile(propname2, "errormsg1")), "Role is required for teacher.");
			verifyExactText(propElement(getPropfile(propname2, "errormsg2")),
					"Levels taught is required for teacher.");
		} else {
			reportStep("Error msg box Is not displayed", "Fail");
		}
		return this;
	}

	@When("Click on Next button and verify grade and what is your role error msg")
	public Icivics_EducatorReg2 verifygradeandwhatisyourroleerrormsg() {
		scrollToTheGivenWebElement(getPropfile(propname2, "roledropdown"));
		WebElement DropDown = propElement(getPropfile(propname2, "roledropdown1"));
		selectDropDownUsingIndex(DropDown, 7);
		click(propElement(getPropfile(propname2, "Nextbutton")));
		
		WebElement errormsgbox = propElement(getPropfile(propname2, "errormsgbox"));
		if (errormsgbox.isDisplayed()) {
			reportStep("Error msg box Is displayed", "Pass");
			verifyExactText(propElement(getPropfile(propname2, "errormsg1")),
					"What is your role? field is required.");
			verifyExactText(propElement(getPropfile(propname2, "errormsg2")),
					"Levels taught is required for teacher.");
		} else {
			reportStep("Error msg box Is not displayed", "Fail");
		}
		return this;
	}

	@Given("Verify Error message is in pink box at top")
	public Icivics_EducatorReg2 verifyerrormsgboxcolor() {
		click(propElement(getPropfile(propname2, "Nextbutton")));
		String expectedcolor = "rgba(169, 68, 66, 1)";
		String expectedbgcolor = "rgba(242, 222, 222, 1)";
		WebElement Errormsgbox = propElement(getPropfile(propname2, "ErrorMsgBox"));
		String color = Errormsgbox.getCssValue("color");
		String bckgclr = Errormsgbox.getCssValue("background-color");
		if (color.contains(expectedcolor) && bckgclr.contains(expectedbgcolor)) {
			reportStep("Error msg box Is displayed in Pink Color", "Pass");
		} else {
			reportStep("Error msg box Is not displayed in Pink Color", "Fail");
		}
		return this;
	}

	@Given("Verify select vaild options and click on next button")
	public Icivics_EducatorReg2 verifyregistrationwithvaliddata() {
		String value = getPropfile(propname2, "Checkboxvalue");
		List<WebElement> chkBox = propElement1(getPropfile(propname2, "checkboxlist1"));
		int Size = chkBox.size();
		for (int i = 0; i < Size-1; i++) {
			String val = chkBox.get(i).getAttribute("value");
			if (val.equalsIgnoreCase(value)) {
				if(!chkBox.get(i).isSelected())
				{       
					chkBox.get(i).click();
					reportStep(val + " is selected", "Pass");
					break;
				}
				} 
				
		}
		
		String dropdownvalue = getPropfile(propname2, "Dropdownvalue");
		WebElement roleDropDown = propElement(getPropfile(propname2, "roledropdown"));
		selectDropDownUsingValue(roleDropDown, dropdownvalue);
		reportStep(dropdownvalue + " is selected", "Pass");
		waitTime(3000);

		click(propElement(getPropfile(propname2, "Nextbutton")));
		waitTime(3000);
		return this;
	}
	
	@Given("verify page 3 is loaded")
	public Icivics_EducatorReg2 verifypage3loaded() throws InterruptedException, IOException {
		waitTime(5000);
		
		WebElement page2 = propElement(getPropfile(propname2, "schoollabel"));
		if(page2.isDisplayed()) {
			reportStep("Page 3 is displayed", "Pass");
			}else {
				reportStep("Page 3 is not displayed", "Fail");
			}
		return this;
	}
}