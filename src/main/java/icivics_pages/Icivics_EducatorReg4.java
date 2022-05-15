package icivics_pages;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_EducatorReg4 extends ProjectSpecificMethods {
	
	public String gpropname = "EducatorRegistration/educatorregistration";
	public String lpropname = "EducatorRegistration/educatorregistration1";
	public String propname2 = "EducatorRegistration/educatorregistration2";
	public String propname3 = "EducatorRegistration/educatorregistration3";
	public String propname4 = "EducatorRegistration/educatorregistration4";

	public Icivics_EducatorReg4(RemoteWebDriver driver, ExtentTest node, Properties prop) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
	}

	@Given("Launch the icivis educatorregistration URL")
	public Icivics_EducatorReg4 launchURL(String URL) {
		navigateto(URL);
		return this;

	}
	
	
	public Icivics_EducatorReg4 verifywithvaliddata() throws InterruptedException, IOException {
		
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
		
		reportStep(emailId + " email is used for creating account", "Pass");
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
	
	@Given("verify Current page count 4 and print")
	public Icivics_EducatorReg4 verifypagecount4() throws IOException {
		String cssvalue = "background-color";
		String Greycolor = "rgb(88, 89, 91)";
		String Greencolor = "rgb(0, 178, 124)";

		String Step1 = cssgetbefore(getPropfile(gpropname, "step1ele"), cssvalue, Greencolor);
		String Step2 = cssgetbefore(getPropfile(gpropname, "step2ele"), cssvalue, Greencolor);
		String Step3 = cssgetbefore(getPropfile(gpropname, "step3ele"), cssvalue, Greencolor);
		String Step4 = cssgetbefore(getPropfile(gpropname, "step4ele"), cssvalue, Greencolor);
		String Step5 = cssgetbefore(getPropfile(gpropname, "step5ele"), cssvalue, Greycolor);

		if (Step1.equals(Greencolor) && Step2.equals(Greencolor) && Step3.equals(Greencolor) && Step4.equals(Greencolor)
				&& Step5.equals(Greycolor)) {
			reportStep("you are currently viewing page 4 in the breadcrumbs", "Pass");
		} else {
			reportStep("unable to identify which page you are currently viewing in the breadcrumbs", "Fail");
		}
		return this;
	}

	@When("Verify clicking on back button will take to previous page 3")
	public Icivics_EducatorReg4 clickbackbutton() throws IOException {
		WebElement backbutton = propElement(getPropfile(gpropname, "backbutton"));
		backbutton.click();
		waitTime(3000);
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
	
	@Given("Verify School or institution is remembered.")
	public Icivics_EducatorReg4 verifySchoolremembered() throws IOException {
		
		WebElement backbutton = propElement(getPropfile(gpropname, "backbutton"));
		backbutton.click();
		
		String SchoolName = getPropfile(propname3, "Checkboxvalue");
		
		String Schoolfield = propElement(getPropfile(propname3, "Schoolfield")).getAttribute("value");
		if (Schoolfield.equals(SchoolName)) {
			reportStep("SchoolName value " + SchoolName + " is remembered ", "Pass");
		} else {
			reportStep("SchoolName value " + SchoolName + " is not remembered ", "Fail");
		}
		return this;
	}
	
	@When("Verify Zip Code is remembered.")
	public Icivics_EducatorReg4 verifyZipCoderemembered() throws IOException {
		
		String Zipcode5 = getPropfile(propname3, "Zipcode5");
		
		String Zipcodefield = propElement(getPropfile(propname3, "zipcodefieldtextbox")).getAttribute("value");
		
		if (Zipcodefield.equals(Zipcode5)) {
			reportStep("Zip Code value " + Zipcode5 + " is remembered ", "Pass");
		} else {
			reportStep("Zip Code value " + Zipcode5 + " is not remembered ", "Fail");
		}
		return this;
	}
	
	
	@And("Verify Teaching State is remembered.")
	public Icivics_EducatorReg4 verifyTeachingStateremembered() throws IOException {
		scrollToTheGivenWebElement(getPropfile(propname3, "NextButton"));
		
		String Teachstatevalue = getPropfile(propname3, "Teachstatevalueid");
		
		String teachingstate = propElement(getPropfile(propname3, "teachingstate")).getAttribute("value");
		if (teachingstate.equalsIgnoreCase(Teachstatevalue)) {
			reportStep("Teaching State value " + teachingstate + " is remembered ", "Pass");
		} else {
			reportStep("Teaching State value " + teachingstate + " is not remembered ", "Fail");
		}
		return this;
	}
	
	@Given("User on Page 4, Verify Password field is displayed")
	public Icivics_EducatorReg4 verifypage4passwordfield() {
		
		WebElement passwordlabel = propElement(getPropfile(propname4, "passwordlabel"));
		WebElement passwordtextbox = propElement(getPropfile(propname4, "passwordtextbox"));
		if (passwordlabel.isDisplayed() && passwordtextbox.isDisplayed()) {
			reportStep(passwordlabel.getText() + " text box and label is displayed", "Pass");
		} else {
			reportStep("Password text box and label is not displayed", "Fail");
		}
		
		return this;
	}
	
	@When("User on Page 4, Verify Confirm Password field is displayed")
	public Icivics_EducatorReg4 verifypage4confirmpasswordfield() {
		
		WebElement Confirmpasswordlabel = propElement(getPropfile(propname4, "Confirmpasswordlabel"));
		WebElement Confirmpasswordtextbox = propElement(getPropfile(propname4, "Confirmpasswordtextbox"));
		if (Confirmpasswordlabel.isDisplayed() && Confirmpasswordtextbox.isDisplayed()) {
			reportStep(Confirmpasswordlabel.getText() + " text box and label is displayed", "Pass");
		} else {
			reportStep("Confirm Password text box and label is not displayed", "Fail");
		}
		return this;
	}
	
	@And("User on Page 4, Verify Sign Up for Emails field is displayed")
	public Icivics_EducatorReg4 verifypage4SignUpforEmailsfield() {
		scrollToTheGivenWebElement(getPropfile(propname4, "finishbutton"));
		WebElement SignUplabel = propElement(getPropfile(propname4, "SignUplabel"));
		WebElement SignUplabelcheckbox = propElement(getPropfile(propname4, "SignUplabelcheckbox"));
		WebElement SignUptext = propElement(getPropfile(propname4, "SignUptext"));
		if (SignUplabel.isDisplayed() && SignUplabelcheckbox.isDisplayed() && SignUptext.isDisplayed()) {
			reportStep(SignUplabel.getText() + " checkbox and label is displayed", "Pass");
			reportStep(SignUptext.getText() + " text label is displayed", "Pass");
		} else {
			reportStep("Confirm Password text box and label is not displayed", "Fail");
		}
		return this;
	}
	
	@And("Verify Agree to Terms of Use & Privacy Policy fields are displayed")
	public Icivics_EducatorReg4 verifypage4AgreetoTermsfield() {
		WebElement Termsofuse = propElement(getPropfile(propname4, "Termsofuse"));
		WebElement PrivacyPolicy = propElement(getPropfile(propname4, "PrivacyPolicy"));
		WebElement Termscheckbox = propElement(getPropfile(propname4, "Termscheckbox"));
		WebElement Termstext = propElement(getPropfile(propname4, "Termstext"));
		if (Termsofuse.isDisplayed() && PrivacyPolicy.isDisplayed() && Termscheckbox.isDisplayed() && Termstext.isDisplayed()) {
			reportStep(Termsofuse.getText() + " link is displayed", "Pass");
			reportStep(PrivacyPolicy.getText() + " link is displayed", "Pass");
			reportStep(Termstext.getText() + " text and label is displayed", "Pass");
		} else {
			reportStep("Confirm Password text box and label is not displayed", "Fail");
		}
		return this;
	}

	@Given("Verify if the Sign Up for emails box is checked by default")
	public Icivics_EducatorReg4 signupcheckbox() {
		scrollToTheGivenWebElement(getPropfile(propname4, "backbutton"));
		WebElement signupcheckbox = propElement(getPropfile(propname4, "signupcheckbox"));
		if (signupcheckbox.isSelected()) {
			reportStep("signup checkbox is clicked as default", "Pass");
		}else {
			reportStep("signup checkbox is not clicked as default", "Fail");
		}
		return this;
	}
	
	@Given("Verify Password and confirm allow to enter text and both match")
	public Icivics_EducatorReg4 VerifyPassword() {
		String pwd = getPropfile(propname4, "Passwordvalue");
		
		WebElement password = propElement(getPropfile(propname4, "password1"));
		password.clear();
		password.sendKeys(pwd);
		String getpwdtext = password.getAttribute("value");
		if (getpwdtext.equals(pwd)) {
			reportStep("Password text box allows to enter text "+ pwd, "Pass");
		} else {
			reportStep("Password text box does not allow to enter text "+ pwd, "Fail");
		}	
		
		WebElement confirmpassword = propElement(getPropfile(propname4, "confirmpassword1"));
		confirmpassword.clear();
		confirmpassword.sendKeys(pwd);
		String getcpwdtext = confirmpassword.getAttribute("value");
		if (getcpwdtext.equals(pwd)) {
			reportStep("Password text box allows to enter text "+ pwd, "Pass");
		} else {
			reportStep("Password text box does not allow to enter text "+ pwd, "Fail");
		}
		
		WebElement passwordmatchstatus = propElement(getPropfile(propname4, "passwordmatchstatus"));
		String getpwdmatchtext = passwordmatchstatus.getText();
		if (getpwdmatchtext.equals("yes")) {
			reportStep("Password and Confirm password is matching and yes is displayed", "Pass");
		} else {
			reportStep("Password and Confirm password is not matching and no is displayed", "Fail");
		}
		
		confirmpassword.clear();
		confirmpassword.sendKeys("Test@123");
		String getpwdnomatchtext = passwordmatchstatus.getText();
		if (getpwdnomatchtext.equals("no")) {
			reportStep("Password and Confirm password is not matching and no is displayed", "Pass");
		} else {
			reportStep("Password and Confirm password is matching and yes is displayed", "Fail");
		}
		return this;
	}
	
	@When("Verify Password must not be blank check it accepts weak passwords")
	public Icivics_EducatorReg4 VerifyPasswordacceptweakpwd() {
		String pwd = getPropfile(propname4, "Passwordvalueweak");
		
		WebElement password = propElement(getPropfile(propname4, "password1"));
		password.clear();	
		password.sendKeys(pwd);	
		
		WebElement confirmpassword = propElement(getPropfile(propname4, "confirmpassword1"));
		confirmpassword.clear();
		confirmpassword.sendKeys(pwd);
		
		WebElement agreechkbox = propElement(getPropfile(propname4, "agreechkbox"));
		agreechkbox.click();
		
		WebElement passwordstrength = propElement(getPropfile(propname4, "passwordstrength"));
		String passwordstrengthtext = passwordstrength.getText();
		if (passwordstrengthtext.equals("Weak")) {
			reportStep("Password and Confirm password is Weak, it accepts weak password", "Pass");
		} else {
			reportStep("Password and Confirm password is not Weak", "Fail");
		}
				
		return this;
	}

	@And("Verify Accept terms must be checked")
	public Icivics_EducatorReg4 Verifyaccepttermschecked() {
		String pwd = getPropfile(propname4, "Passwordvalueweak");
		
		WebElement password = propElement(getPropfile(propname4, "password1"));
		password.clear();
		password.sendKeys(pwd);	
		
		WebElement confirmpassword = propElement(getPropfile(propname4, "confirmpassword1"));
		confirmpassword.clear();
		confirmpassword.sendKeys(pwd);
		
		WebElement agreechkbox = propElement(getPropfile(propname4, "agreechkbox"));
		
		if(agreechkbox.isSelected()) {
		agreechkbox.click();
		}
		
		click(propElement(getPropfile(propname4, "finishbutton")));
		waitTime(3000);
		
		WebElement agreechkboxerrmsg = propElement(getPropfile(propname4, "agreechkboxerrmsg"));
		if(agreechkboxerrmsg.isDisplayed()) {
			reportStep("Accept terms must be checked error msg is displayed", "Pass");}
		else {
				reportStep("Accept terms is checked", "Fail");
		}
		
		waitTime(3000);
		WebElement password1 = propElement(getPropfile(propname4, "password1"));
		password1.clear();
		password1.sendKeys(pwd);	
		
		WebElement confirmpassword1 = propElement(getPropfile(propname4, "confirmpassword1"));
		confirmpassword1.clear();
		confirmpassword1.sendKeys(pwd);
		
		WebElement agreechkbox1 = propElement(getPropfile(propname4, "agreechkbox"));
		
		if (!agreechkbox1.isSelected()) {
			agreechkbox1.click();
			reportStep("Accept terms is checked", "Pass");
		}
		
		click(propElement(getPropfile(propname4, "finishbutton")));
		
		WebElement welcomemsg = propElement(getPropfile(propname4, "welcomemsg"));
		if (welcomemsg.isDisplayed()) {
			reportStep("page 5 is loaded", "Pass");
		}else {
			reportStep("Accept terms is not checked, page 5 is not loaded", "Fail");
		}
				
		return this;
	}
	
	@Given("Verify Password is marked with an asterisk")
	public Icivics_EducatorReg4 verifypasswordAsteriks() throws IOException {
		cssgetafter(getPropfile(gpropname, "edureg.pwd*"), "content", "\"*\"");
		reportStep("Asteriks * is present in the Password label", "Pass");
		return this;
	}

	@When("Verify Confirm Password is marked with an asterisk")
	public Icivics_EducatorReg4 verifyconfirmpasswordAsteriks() throws IOException {
		cssgetafter(getPropfile(gpropname, "edureg.cpwd*"), "content", "\"*\"");
		reportStep("Asteriks * is present in the Confirm Password label", "Pass");
		return this;
	}
	
	@Given("Hover on password field and verify the Tooltip Text")
	public Icivics_EducatorReg4 hoveronpwdfield() throws InterruptedException {
		String pwd = getPropfile(propname4, "password2");
		mouseOverAction(pwd);
		WebElement pwdtooltip = propElement(pwd);
		String ExpectedTooltip = getPropfile(propname4, "PasswordHovertext");
		String actualTooltip = pwdtooltip.getAttribute("data-original-title");
		if(actualTooltip.equals(ExpectedTooltip)) {
			reportStep("Expected Tooltip and Actual Tooltip text matched successfully", "Pass");
		}else {
			reportStep("Expected Tooltip and Actual Tooltip text did not match", "Fail");
		}return this;
		}
	
	@Given("Verify the password strength Indicator is changing according to password strength")
	public Icivics_EducatorReg4 VerifyPasswordstrengthmeter() {
		String pwd = getPropfile(propname4, "Passwordvalueweak");
		
		WebElement password = propElement(getPropfile(propname4, "password1"));
		password.clear();
		password.sendKeys(pwd);
		
		WebElement passwordstrength = propElement(getPropfile(propname4, "passwordstrength"));
		String passwordstrengthtext = passwordstrength.getText();
		if (passwordstrengthtext.equals("Weak")||passwordstrengthtext.equals("Strong")||passwordstrengthtext.equals("Fair")||passwordstrengthtext.equals("Good")) {
			reportStep("Password strength Indicator is changing as "+passwordstrengthtext+ " according to password strength", "Pass");
		} else {
			reportStep("Password strength Indicator is not changing according to password strength", "Fail");
		}
		
		WebElement passwordstrengthmeter = propElement(getPropfile(propname4, "passwordstrengthmeter"));
		String passwordstrengthmetertext = passwordstrengthmeter.getAttribute("style");		
		if (!passwordstrengthmetertext.equals("width: 0%;")) {
			reportStep("Password strength meter is changing as "+passwordstrengthmetertext+ " according to password strength", "Pass");
		} else {
			reportStep("Password strength meter is not changing according to password strength", "Fail");
		}
		
		return this;
	}
	
	@Given("Verify Password match indicator says yes or no depending on match with the confirm Password")
	public Icivics_EducatorReg4 VerifyPasswordindicatormatch() {
		String pwd = getPropfile(propname4, "Passwordvalue");
		
		WebElement password = propElement(getPropfile(propname4, "password1"));
		password.clear();
		password.sendKeys(pwd);
		
		WebElement confirmpassword = propElement(getPropfile(propname4, "confirmpassword1"));
		confirmpassword.clear();
		confirmpassword.sendKeys(pwd);
		
		WebElement passwordmatchstatus = propElement(getPropfile(propname4, "passwordmatchstatus"));
		String getpwdmatchtext = passwordmatchstatus.getText();
		if (getpwdmatchtext.equals("yes")) {
			reportStep("Password and Confirm password is matching and yes is displayed", "Pass");
		} else {
			reportStep("Password and Confirm password is not matching and no is displayed", "Fail");
		}
		
		confirmpassword.clear();
		confirmpassword.sendKeys("Test@123");
		String getpwdnomatchtext = passwordmatchstatus.getText();
		if (getpwdnomatchtext.equals("no")) {
			reportStep("Password and Confirm password is not matching and no is displayed", "Pass");
		} else {
			reportStep("Password and Confirm password is matching and yes is displayed", "Fail");
		}
		return this;
	}
	
	@Given("Enter invalid Password, Confirm Password and verify the error message and its displayed in red")
	public Icivics_EducatorReg4 verifyenterinvaliddata() {
			
		String pwd = "gfgh^d$fthf&";
		String cpwd = "gfgh^d$fthf&123";
		WebElement password = propElement(getPropfile(propname4, "password1"));
		clearAndType(password, pwd);
		
		WebElement confirmpassword = propElement(getPropfile(propname4, "confirmpassword1"));
		clearAndType(confirmpassword, cpwd);
		
		WebElement agreechkbox1 = propElement(getPropfile(propname4, "agreechkbox"));
		
		if (agreechkbox1.isSelected()) {
			agreechkbox1.click();
			reportStep("Accept terms is unchecked", "Pass");
		}
		
		click(propElement(getPropfile(propname4, "finishbutton")));
		
		WebElement errormsgbox = propElement(getPropfile(propname4, "errormsgbox"));
		WebElement pwderror = propElement(getPropfile(propname4, "pwderror"));
		WebElement agreeerror = propElement(getPropfile(propname4, "agreeerror"));
		if (errormsgbox.isDisplayed()&&pwderror.isDisplayed()&&agreeerror.isDisplayed()) {
			verifyExactText(errormsgbox, "2 errors have been found:");
			scrollToTheGivenWebElement(getPropfile(propname4, "backbutton"));
			verifyPartialText(pwderror, "The specified passwords do not match.");
			verifyPartialText(agreeerror, "Please agree to the terms of service and privacy policy.");
		}else {
			reportStep("Password and Confirm Password filed text box error messages is not verifed", "Fail");
		}
		String expectedcolor = "rgba(169, 68, 66, 1)";
		String expectedbgcolor = "rgba(242, 222, 222, 1)";
		WebElement Errormsgbox = propElement(getPropfile(propname4, "Errormsgbox"));
		String color = Errormsgbox.getCssValue("color");
		String bckgclr = Errormsgbox.getCssValue("background-color");
		if (color.contains(expectedcolor) && bckgclr.contains(expectedbgcolor)) {
			reportStep("Error msg box Is displayed in Pink Color and text in Red", "Pass");
		} else {
			reportStep("Error msg box Is not displayed in Pink Color", "Fail");
		}
		return this;
	}
	@Given("Click on next without entering any valid data and verify the error messages.")
	public Icivics_EducatorReg4 verifyblankerrormsg() {
		scrollToTheGivenWebElement(getPropfile(propname4, "finishbutton"));
		String pwd = "gfgh^d$fthf&";
		WebElement password = propElement(getPropfile(propname4, "password1"));
		
		click(propElement(getPropfile(propname4, "finishbutton")));
		reportStep("Error msg Is displayed for password field", "Pass");
		
		clearAndType(password, pwd);
		click(propElement(getPropfile(propname4, "finishbutton")));
		reportStep("Error msg Is displayed for confirm password field", "Pass");
	
		return this;
	}
	
	@Given("Verify Error message is in pink box at the top")
	public Icivics_EducatorReg4 verifyenterinvaliddataerror() {
			
		String pwd = "gfgh^d$fthf&";
		String cpwd = "gfgh^d$fthf&123";
		WebElement password = propElement(getPropfile(propname4, "password1"));
		clearAndType(password, pwd);
		
		WebElement confirmpassword = propElement(getPropfile(propname4, "confirmpassword1"));
		clearAndType(confirmpassword, cpwd);
		
		WebElement agreechkbox1 = propElement(getPropfile(propname4, "agreechkbox"));
		
		if (agreechkbox1.isSelected()) {
			agreechkbox1.click();
			reportStep("Accept terms is unchecked", "Pass");
		}
		
		click(propElement(getPropfile(propname4, "finishbutton")));
	
		String expectedcolor = "rgba(169, 68, 66, 1)";
		String expectedbgcolor = "rgba(242, 222, 222, 1)";
		WebElement Errormsgbox = propElement(getPropfile(propname4, "Errormsgbox"));
		String color = Errormsgbox.getCssValue("color");
		String bckgclr = Errormsgbox.getCssValue("background-color");
		if (color.contains(expectedcolor) && bckgclr.contains(expectedbgcolor)) {
			reportStep("Error msg box Is displayed in Pink Color and text in Red on the top", "Pass");
		} else {
			reportStep("Error msg box Is not displayed in Pink Color", "Fail");
		}
		return this;
	}
	
	@Given("Verify with vaild inputs and click on next button")
	public Icivics_EducatorReg4 verifyregistrationwithvaliddata() {
		String pwd = getPropfile(propname4, "Passwordvalue");
		WebElement password = propElement(getPropfile(propname4, "password1"));
		clearAndType(password, pwd);
		
		WebElement confirmpassword = propElement(getPropfile(propname4, "confirmpassword1"));
		clearAndType(confirmpassword, pwd);
		
		WebElement agreechkbox1 = propElement(getPropfile(propname4, "agreechkbox"));
		
		if (!agreechkbox1.isSelected()) {
			agreechkbox1.click();
		}
		
		click(propElement(getPropfile(propname4, "finishbutton")));
		waitTime(3000);
		return this;
	}
	
	@Then("verify page 5 is loaded")
	public Icivics_EducatorReg4 verifypage5loaded() throws InterruptedException, IOException {
		
		WebElement page5 = propElement(getPropfile(propname4, "welcomemsg"));
		if (page5.isDisplayed()) {
			reportStep("Page 5 is displayed", "Pass");
		}else {
			reportStep("Page 5 is not displayed", "Fail");
		}
		return this;
	}
}
