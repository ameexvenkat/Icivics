package icivics_pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_EducatorReg1 extends ProjectSpecificMethods {
	public String gpropname = "EducatorRegistration/educatorregistration";
	public String lpropname = "EducatorRegistration/educatorregistration1";

	public Icivics_EducatorReg1(RemoteWebDriver driver, ExtentTest node, Properties prop) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
	}

	@Given("Launch the icivis educatorregistration URL")
	public Icivics_EducatorReg1 launchURL(String URL) {
		navigateto(URL);
		return this;
	}

	@Then("verify Current page count 1 and print")
	public Icivics_EducatorReg1 verifypagecount1() throws IOException {
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

	@Given("Verify the Username text fields")
	public Icivics_EducatorReg1 Verifyusernametextfields() throws IOException {
		WebElement usernamelabel = propElement(getPropfile(gpropname, "usernamelabel"));
		if (usernamelabel.isDisplayed()) {
			reportStep("Username label is displayed", "Pass");
		} else {
			reportStep("Username label box is not displayed", "Fail");
		}
		WebElement username = propElement(getPropfile(gpropname, "username"));
		if (username.isDisplayed()) {
			reportStep("username field is displayed", "Pass");
		} else {
			reportStep("username field is not displayed", "Fail");
		}
		if (!username.getText().isEmpty()) {
			reportStep("username field is not empty", "Pass");
		} else {
			reportStep("username field is empty", "Fail");
		}
		return this;
	}

	@Then("Verify the First Name text fields")
	public Icivics_EducatorReg1 Verifyfirstnamenametextfields() throws IOException {

		WebElement firstnamelabel =  propElement(getPropfile(gpropname, "firstnamelabel"));
		
		if (firstnamelabel.isDisplayed()) {
			reportStep("First name label is displayed", "Pass");
		} else {
			reportStep("First name label box is not displayed", "Fail");
		}
		
		WebElement firstname = propElement(getPropfile(gpropname, "firstname"));
		if (firstname.isDisplayed()) {

			reportStep("Firstname field is displayed", "Pass");
		}

		else {
			reportStep("Firstname field is not displayed", "Fail");
		}
		
		String CLbox = firstname.getAttribute("value");
		if (CLbox.isEmpty()) {
			reportStep("First name text box is Blank", "Pass");
		} else {
			reportStep("First name text box is not Blank", "Fail");
		}
		
		return this;
	}

	@And("Verify the Last Name text fields")
	public Icivics_EducatorReg1 Verifylastnametextfields() throws IOException {

		WebElement Lastnamelabel = propElement(getPropfile(gpropname, "Lastnamelabel"));
		if (Lastnamelabel.isDisplayed()) {
			reportStep("Lastname label is displayed", "Pass");
		} else {
			reportStep("Lastname label box is not displayed", "Fail");
		}
		
		WebElement lastname = propElement(getPropfile(gpropname, "Lastname"));
		if (lastname.isDisplayed()) {

			reportStep("Lastname field is displayed", "Pass");
		} else {
			reportStep("Lastname field is not displayed", "Fail");
		}
		
		String CLbox = lastname.getAttribute("value");
		if (CLbox.isEmpty()) {
			reportStep("Last name text box is Blank", "Pass");
		} else {
			reportStep("Last name text box is not Blank", "Fail");
		}
		return this;
	}

	@And("Verify the E-mail text fields")
	public Icivics_EducatorReg1 Verifyemailtextfields() throws IOException {

		WebElement Emailaddresslabel = propElement(getPropfile(gpropname, "Emailaddresslabel"));
		if (Emailaddresslabel.isDisplayed()) {
			reportStep("Emailaddress label is displayed", "Pass");
		} else {
			reportStep("Emailaddress label box is not displayed", "Fail");
		}
		
		WebElement email = propElement(getPropfile(gpropname, "Emailaddress"));
		if (email.isDisplayed()) {

			reportStep("email field is displayed", "Pass");
		} else {
			reportStep("email field is not displayed", "Fail");
		}
		
		String CLbox = email.getAttribute("value");
		if (CLbox.isEmpty()) {
			reportStep("Emailaddress text box is Blank", "Pass");
		} else {
			reportStep("Emailaddress text box is not Blank", "Fail");
		}
		
		return this;
	}

	@And("Verify the Verify E-mail text fields")
	public Icivics_EducatorReg1 Verifyemail2textfields() throws IOException {
		
		WebElement VerifyEmailaddresslabel = propElement(getPropfile(gpropname, "VerifyEmailaddresslabel"));
		if (VerifyEmailaddresslabel.isDisplayed()) {
			reportStep("VerifyEmailaddress label is displayed", "Pass");
		} else {
			reportStep("VerifyEmailaddress label box is not displayed", "Fail");
		}
		
		WebElement verifyemail = propElement(getPropfile(gpropname, "VerifyEmailaddress"));
		if (verifyemail.isDisplayed()) {

			reportStep("verifyemail field is displayed", "Pass");
		} else {
			reportStep("verifyemail field is not displayed", "Fail");
		}
		
		String CLbox = verifyemail.getAttribute("value");
		if (CLbox.isEmpty()) {
			reportStep("VerifyEmailaddress text box is Blank", "Pass");
		} else {
			reportStep("VerifyEmailaddress box is not Blank", "Fail");
		}
		return this;
	}

	@Given("Verify username is pregenerated")
	public Icivics_EducatorReg1 usernamepregenerated() throws InterruptedException, IOException {
		WebElement username = propElement(getPropfile(gpropname, "username"));
		waitTime(6000);
		String username1 = username.getText();

		if (!username1.isEmpty()) {
			reportStep("Username field is not empty,it is pregenerated with "+ username1 + " and Verified successfully", "Pass");
		} else {
			reportStep("Username field is empty", "Fail");
		}
		return this;
	}
	
	@Given("Verify New username is randomly generated and appears in the box")
	public Icivics_EducatorReg1 usernamegeneratedrandomly() throws InterruptedException, IOException {
		WebElement username = propElement(getPropfile(gpropname, "username"));
		waitTime(6000);
		String username1 = username.getText();
		System.out.println(username1);
		propElement(getPropfile(gpropname, "reloadicon")).click();
		waitTime(6000);
		String username2 = username.getText();
		System.out.println(username2);
		if (!username1.equals(username2)) {
			reportStep(username1 + " is not equal to " + username2 + " new generated name is Verified successfully",
					"Pass");
		} else {
			reportStep(username1 + " is same as " + username2 + "new generated name is not Verified successfully",
					"Fail");
		}
		return this;
	}
	
	@Given("Verify username is enabled and user able to enter text in username field")
	public Icivics_EducatorReg1 entertextinusernamefield() throws InterruptedException, IOException {
		WebElement username = propElement(getPropfile(gpropname, "username"));
		try{
			clearAndType(username, getPropfile(lpropname, "UserName"));}
		catch (InvalidElementStateException e){
			reportStep("The Element is not Interactable", "Pass");
		}
		if(!username.getText().isEmpty())
			{
			reportStep("Username will not allow to enter text", "Pass");
			} else {
				reportStep("Username is enabled it will allow to enter text", "Fail");
			}
		return this;
	}

	@Then("Verify typing text allowed in firstname field")
	public Icivics_EducatorReg1 entertextinfirstnamefield() throws InterruptedException, IOException {
		WebElement firstname = propElement(getPropfile(gpropname, "firstname"));
		clearAndType(firstname, getPropfile(lpropname, "FirstName"));
		return this;
	}
	
	@And("Verify typing text allowed in lastname field")
	public Icivics_EducatorReg1 entertextinlastnamefield() throws InterruptedException, IOException {
		WebElement lastname = propElement(getPropfile(gpropname, "Lastname"));
		clearAndType(lastname, getPropfile(lpropname, "LastName"));
		return this;
	}
	
	@And("Verify typing text allowed in email field")
	public Icivics_EducatorReg1 entertextinemailfield() throws InterruptedException, IOException {
		String EmailId = getPropfile(lpropname, "EmailID");
		
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		String[] data = EmailId.split("@");
		String name = data[0];
		String host = data[1];
		String emailId = name + number + "@" + host;
		
		writePropfile("EducatorRegistration/email", "email", emailId);
		WebElement emailele = propElement(getPropfile(gpropname, "Emailaddress"));
		clearAndType(emailele, emailId);
		return this;
		}
	
	@And("Verify typing text allowed in Verify email field")
	public Icivics_EducatorReg1 entertextinverifyemailfield() throws InterruptedException, IOException {
		String email1 = getPropfile("email", "email");
		WebElement verifyemail = propElement(getPropfile(gpropname, "VerifyEmailaddress"));
		clearAndType(verifyemail, email1);
		return this;
	}

	@Given("Verify username is not marked with an asterisk")
	public Icivics_EducatorReg1 usernameAsteriks() throws IOException {
		WebElement usernamelabel = propElement(getPropfile(gpropname, "usernamelabel"));
		if(!usernamelabel.getText().contains("*"))
		{
			reportStep("* is not present in the username label", "Pass");	
		}else {
			reportStep("* is present in the username label", "Fail");	
		}
		return this;
	}
	
	@Then("Verify firstname is marked with an asterisk")
	public Icivics_EducatorReg1 firstnameAsteriks() throws IOException {
		cssgetafter(getPropfile(gpropname, "edureg.fn*"), "content", "\"*\"");
		reportStep("* is present in the firstname label", "Pass");
		return this;
	}
	
	@And("Verify lastname is marked with an asterisk")
	public Icivics_EducatorReg1 lastnameAsteriks() throws IOException {
		cssgetafter(getPropfile(gpropname, "edureg.ln*"), "content", "\"*\"");
		reportStep("* is present in the lastname label", "Pass");
		return this;
	}
		
	@And("Verify email is marked with an asterisk")
	public Icivics_EducatorReg1 emailAsteriks() throws IOException {
		cssgetafter(getPropfile(gpropname, "edureg.email*"), "content", "\"*\"");
		reportStep("* is present in the email label", "Pass");
		return this;
	}
			
	@And("Verify verify email is marked with an asterisk")
	public Icivics_EducatorReg1 verifyemailAsteriks() throws IOException {
	cssgetafter(getPropfile(gpropname, "edureg.verifyemail*"), "content", "\"*\"");
	reportStep("* is present in the verify email label", "Pass");
	return this;
	}

	@Given("verify the Tooltip Text by Hovering on email field")
	public Icivics_EducatorReg1 hoveronemailfield() throws InterruptedException, IOException {
		String email = getPropfile(gpropname, "Emailaddress");
		mouseOverAction(email);
		WebElement emailtooltip = propElement(email);
		String ExpectedTooltip = getPropfile(gpropname, "EmailTooltip");
		String actualTooltip = emailtooltip.getAttribute("data-original-title");
		if(actualTooltip.equals(ExpectedTooltip)) {
			reportStep("Expected Tooltip and Actual Tooltip text matched successfully", "Pass");
		}else {
			reportStep("Expected Tooltip and Actual Tooltip text did not match", "Fail");
		}return this;
		}
		
	@Then("verify the Tooltip Text by Hovering on verify email field")
	public Icivics_EducatorReg1 hoveronverifyemailfield() throws InterruptedException, IOException {
		mouseOverAction(getPropfile(gpropname, "VerifyEmailaddress"));
		reportStep("No Tool Tip present for Verifyemail text box", "Pass");
		return this;
	}


	@Given("Enter invalid first name")
	public Icivics_EducatorReg1 Enterinvalidfirstname() throws InterruptedException, IOException {
		WebElement firstname = propElement(getPropfile(gpropname, "firstname"));
		if (firstname.isDisplayed()) {
			firstname.clear();
			firstname.sendKeys("14344433%");
			reportStep("Firstname field allows to type invalid data", "Pass");
		} else {
			reportStep("Firstname field is not displayed", "Fail");
		}
		return this;
	}

	@And("Enter invalid last name")
	public Icivics_EducatorReg1 Enterinvalidlastname() throws InterruptedException, IOException {
		WebElement lastname = propElement(getPropfile(gpropname, "Lastname"));
		if (lastname.isDisplayed()) {
			lastname.clear();
			lastname.sendKeys("%ttt#12");
			reportStep("Last name field allows to type invalid data", "Pass");
		} else {
			reportStep("Last name field is not displayed", "Fail");
		}
		return this;
	}

	@And("Enter invalid email")
	public Icivics_EducatorReg1 Enterinvalidemailfield() throws InterruptedException {
		WebElement email = propElement(getPropfile(gpropname, "Emailaddress"));
		if (email.isDisplayed()) {
			email.clear();
			email.sendKeys("gdfsgadvjh");
			reportStep("email field allows to type invalid data", "Pass");
		} else {
			reportStep("email field is not displayed", "Fail");
		}
		return this;
	}

	@And("Enter Invalid verify Email")
	public Icivics_EducatorReg1 Enterinvalidverifyemailfield() throws InterruptedException {
		WebElement verifyemail = propElement(getPropfile(gpropname, "VerifyEmailaddress"));
		if (verifyemail.isDisplayed()) {
			verifyemail.clear();
			Thread.sleep(3000);
			verifyemail.sendKeys("gdfsgadvjh");
			reportStep("verify email field allows to type invalid data", "Pass");
		} else {
			reportStep("verigy email field is not displayed", "Fail");
		}
		return this;
	}

	@And("click on next button")
	public Icivics_EducatorReg1 clicknextbutton() {
		scrollToTheGivenWebElement(getPropfile(gpropname, "Emailaddresslabel"));
		clickOn(getPropfile(gpropname, "nextbutton"));
		return this;
	}
	
	@But("error message should be displayed for email and verify email")
	public Icivics_EducatorReg1 verifyerrormsgforinvaliddatasubmit() {
		WebElement alertmsg = propElement(getPropfile(gpropname, "alertpopup1"));
		String Actualerrmsg = alertmsg.getText();
		String Expectederrmsg = "2 errors have been found:";
		verifyPartialText(alertmsg, "2 errors have been found:");
		if(Expectederrmsg.equals(Actualerrmsg)) {
			reportStep("Error alert message is displayed", "Pass");
		}
		
		WebElement emailerrormsg = propElement(getPropfile(gpropname, "emailinvalidalert1"));
		if(emailerrormsg.getText().contains("The email address gdfsgadvjh is not valid.")) {
			scrollToTheGivenWebElement(getPropfile(gpropname, "Emailaddresslabel"));
			reportStep(emailerrormsg.getText() + " is displayed", "Pass");
		}
		
		WebElement verifyemailerrormsg = propElement(getPropfile(gpropname, "verifyemailinvalidalert1"));
		if(verifyemailerrormsg.getText().contains("The email address gdfsgadvjh is not valid.")) {
		reportStep(verifyemailerrormsg.getText() + " is displayed", "Pass");
		}
		return this;
	}

	@Given("Verify error message for all required field by leaving the fields blank and click on next button")
	public Icivics_EducatorReg1 verifyerrormsgblankfieldall() throws InterruptedException {
		WebElement firstname = propElement(getPropfile(gpropname, "firstname"));
		firstname.clear();
		WebElement lastname = propElement(getPropfile(gpropname, "Lastname"));
		lastname.clear();
		WebElement email = propElement(getPropfile(gpropname, "Emailaddress"));
		email.clear();
		WebElement verifyemail = propElement(getPropfile(gpropname, "VerifyEmailaddress"));
		verifyemail.clear();
		
		scrollToTheGivenWebElement(getPropfile(gpropname, "nextbutton"));
		clickOn(getPropfile(gpropname, "nextbutton"));

		WebElement firstnamealertmsg = propElement(getPropfile(gpropname, "firstnamealertmsg1"));
		verifyExactText(firstnamealertmsg, "Field First Name is required");

		WebElement lastnamealertmsg = propElement(getPropfile(gpropname, "lastnamealertmsg1"));
		verifyExactText(lastnamealertmsg, "Field Last Name is required");

		WebElement alertmsg = propElement(getPropfile(gpropname, "alertmsg1"));
		verifyPartialText(alertmsg, "2 errors have been found:");
		
		scrollToTheGivenWebElement(getPropfile(gpropname, "Emailaddresslabel"));

		WebElement emailalertmsg = propElement(getPropfile(gpropname, "emailalertmsg"));
		verifyPartialText(emailalertmsg, "Email address field is required.");

		WebElement verifyemailalertmsg = propElement(getPropfile(gpropname, "verifyemailalertmsg"));
		verifyPartialText(verifyemailalertmsg, "Verify email address field is required.");

		return this;
	}
	
	@When("Verify error message by leaving the Firstname field blank and enter values in the remaining required fields and click on next button")
	public Icivics_EducatorReg1 verifyerrormsgfirstnameblankfield() throws InterruptedException {
		WebElement firstname = propElement(getPropfile(gpropname, "firstname"));
		firstname.clear();
		WebElement lastname = propElement(getPropfile(gpropname, "Lastname"));
		lastname.clear();
		lastname.sendKeys(getPropfile(lpropname, "LastName"));
		WebElement emailele = propElement(getPropfile(gpropname, "Emailaddress"));
		emailele.clear();
		emailele.sendKeys(getPropfile(lpropname, "EmailID"));
		WebElement verifyemailele = propElement(getPropfile(gpropname, "VerifyEmailaddress"));
		verifyemailele.clear();
		verifyemailele.sendKeys(getPropfile(lpropname, "VerifyEmailID"));
		
		scrollToTheGivenWebElement(getPropfile(gpropname, "nextbutton"));
		clickOn(getPropfile(gpropname, "nextbutton"));

		WebElement firstnamealertmsg = propElement(getPropfile(gpropname, "alertpopup1"));
		verifyExactText(firstnamealertmsg, "Field First Name is required");

		return this;
	}
	
	
	@And("Verify error message by leaving the Lastname field blank and enter values in the remaining required fields and click on next button")
	public Icivics_EducatorReg1 verifyerrormsglastnameblankfield() throws InterruptedException {
		WebElement firstname = propElement(getPropfile(gpropname, "firstname"));
		firstname.clear();
		firstname.sendKeys(getPropfile(lpropname, "FirstName"));
		WebElement lastname = propElement(getPropfile(gpropname, "Lastname"));
		lastname.clear();
		WebElement emailele = propElement(getPropfile(gpropname, "Emailaddress"));
		emailele.clear();
		emailele.sendKeys(getPropfile(lpropname, "EmailID"));
		WebElement verifyemailele = propElement(getPropfile(gpropname, "VerifyEmailaddress"));
		verifyemailele.clear();
		verifyemailele.sendKeys(getPropfile(lpropname, "VerifyEmailID"));
		
		scrollToTheGivenWebElement(getPropfile(gpropname, "nextbutton"));
		clickOn(getPropfile(gpropname, "nextbutton"));

		WebElement lastnamealertmsg = propElement(getPropfile(gpropname, "alertpopup1"));
		verifyExactText(lastnamealertmsg, "Field Last Name is required");

		return this;
	}
	
	@And("Verify error message by leaving the email field blank and enter values in the remaining required fields and click on next button")
	public Icivics_EducatorReg1 verifyerrormsgemailblankfield() throws InterruptedException {
		WebElement firstname = propElement(getPropfile(gpropname, "firstname"));
		firstname.clear();
		firstname.sendKeys(getPropfile(lpropname, "FirstName"));
		WebElement lastname = propElement(getPropfile(gpropname, "Lastname"));
		lastname.clear();
		lastname.sendKeys(getPropfile(lpropname, "LastName"));
		WebElement email = propElement(getPropfile(gpropname, "Emailaddress"));
		email.clear();
		WebElement verifyemailele = propElement(getPropfile(gpropname, "VerifyEmailaddress"));
		verifyemailele.clear();
		verifyemailele.sendKeys(getPropfile(lpropname, "VerifyEmailID"));
		
		scrollToTheGivenWebElement(getPropfile(gpropname, "nextbutton"));
		clickOn(getPropfile(gpropname, "nextbutton"));

		WebElement alertmsg = propElement(getPropfile(gpropname, "alertpopup1"));
		verifyPartialText(alertmsg, "2 errors have been found:");
		
		scrollToTheGivenWebElement(getPropfile(gpropname, "Emailaddresslabel"));

		WebElement emailalertmsg = propElement(getPropfile(gpropname, "emailalertmsg"));
		verifyPartialText(emailalertmsg, "Email address field is required.");

		WebElement verifyemailalertmsg = propElement(getPropfile(gpropname, "verifyemailalertmsg"));
		verifyPartialText(verifyemailalertmsg, "Your e-mail address and confirmed e-mail address must match.");
		
		return this;
	}
	
	@And("Verify error message by leaving the verify email field blank and enter values in the remaining required fields and click on next button")
	public Icivics_EducatorReg1 verifyerrormsgverifyemailblankfield() throws InterruptedException {
		WebElement firstname = propElement(getPropfile(gpropname, "firstname"));
		firstname.clear();
		firstname.sendKeys(getPropfile(lpropname, "FirstName"));
		WebElement lastname = propElement(getPropfile(gpropname, "Lastname"));
		lastname.clear();
		lastname.sendKeys(getPropfile(lpropname, "LastName"));
		waitTime(5000);
		WebElement emailele = propElement(getPropfile(gpropname, "Emailaddress"));
		emailele.clear();
		emailele.sendKeys(getPropfile(lpropname, "EmailID"));
		WebElement verifyemail = propElement(getPropfile(gpropname, "VerifyEmailaddress"));
		verifyemail.clear();
		waitTime(5000);
		
		scrollToTheGivenWebElement(getPropfile(gpropname, "nextbutton"));
		waitTime(3000);
		clickOn(getPropfile(gpropname, "nextbutton"));

		WebElement alertmsg = propElement(getPropfile(gpropname, "alertpopup1"));
		verifyPartialText(alertmsg, "1 error has been found:");
		
		scrollToTheGivenWebElement(getPropfile(gpropname, "Emailaddresslabel"));

		WebElement verifyemailalertmsg = propElement(getPropfile(gpropname, "emailalertmsg"));
		verifyPartialText(verifyemailalertmsg, "Verify email address field is required.");
		
		return this;
	}
	
	@Given("Verify all error messages for invalid inputs")
	public Icivics_EducatorReg1 verifyinvaliderrormsg() throws InterruptedException {

		WebElement firstname = propElement(getPropfile(gpropname, "firstname"));
		firstname.clear();
		firstname.sendKeys("14344433%");
		
		WebElement lastname = propElement(getPropfile(gpropname, "Lastname"));
		lastname.clear();
		lastname.sendKeys("%ttt#12");
		
		WebElement email = propElement(getPropfile(gpropname, "Emailaddress"));
		email.clear();
		email.sendKeys("GHDGFH!#!#!");
		
		WebElement verifyemail = propElement(getPropfile(gpropname, "VerifyEmailaddress"));
		verifyemail.clear();
		verifyemail.sendKeys("GHDGFH!#!#!");
	
		WebElement nextbutton = propElement(getPropfile(gpropname, "nextbutton"));
		nextbutton.click();
		
		WebElement alertmsg = propElement(getPropfile(gpropname, "alertpopup1"));
		String Actualerrmsg = alertmsg.getText();
		String Expectederrmsg = "2 errors have been found:";
		verifyPartialText(alertmsg, "2 errors have been found:");
		if(Expectederrmsg.equals(Actualerrmsg)) {
			reportStep("Error alert message is displayed", "Pass");
		}
		
		WebElement emailerrormsg = propElement(getPropfile(gpropname, "emailinvalidalert1"));
		if(emailerrormsg.getText().contains("The email address GHDGFH!#!#! is not valid.")) {
			scrollToTheGivenWebElement(getPropfile(gpropname, "Emailaddresslabel"));
			reportStep(emailerrormsg.getText() + " is displayed", "Pass");
		}
		
		WebElement verifyemailerrormsg = propElement(getPropfile(gpropname, "verifyemailinvalidalert1"));
		if(verifyemailerrormsg.getText().contains("The email address GHDGFH!#!#! is not valid.")) {
		reportStep(verifyemailerrormsg.getText() + " is displayed", "Pass");
		}
		Thread.sleep(3000);

		return this;
	}

	@Given("Enter valid firstname, lastname, email, verifyemail and click on next and verify page 2 is loaded")
	public Icivics_EducatorReg1 verifyregistrationwithvaliddata() throws InterruptedException, IOException {
		waitTime(5000);
		WebElement username = propElement(getPropfile(gpropname, "username"));
		String username1 = username.getText();
		writePropfile("EducatorRegistration/username", "username", username1);
		reportStep("User name is " + username1, "Pass");
		
		WebElement firstname = propElement(getPropfile(gpropname, "firstname"));
		firstname.clear();
		firstname.sendKeys(getPropfile(lpropname, "FirstName"));
		reportStep(getPropfile(lpropname, "FirstName") + " is entered as Firstname", "Pass");
		
		WebElement lastname = propElement(getPropfile(gpropname, "Lastname"));
		lastname.clear();
		lastname.sendKeys(getPropfile(lpropname, "LastName"));
		reportStep(getPropfile(lpropname, "LastName") + " is entered as Lastname", "Pass");
		
		WebElement emailele = propElement(getPropfile(gpropname, "Emailaddress"));
		emailele.clear();
		emailele.sendKeys(getPropfile(lpropname, "EmailID"));
		reportStep(getPropfile(lpropname, "EmailID") + " is entered as Email", "Pass");
		
		WebElement verifyemailele = propElement(getPropfile(gpropname, "VerifyEmailaddress"));
		verifyemailele.clear();
		verifyemailele.sendKeys(getPropfile(lpropname, "VerifyEmailID"));
		reportStep(getPropfile(lpropname, "VerifyEmailID") + " is entered as Verify email", "Pass");
		
		scrollToTheGivenWebElement(getPropfile(gpropname, "nextbutton"));
		reportStep("Next Button is clicked", "Pass");
		click(propElement(getPropfile(gpropname, "nextbutton")));
		waitTime(3000);
		
		WebElement page2 = propElement(getPropfile(gpropname, "gradelevel"));
		if(page2.isDisplayed()) {
			reportStep("Page 2 is displayed", "Pass");
			}else {
				reportStep("Page 2 is not displayed", "Fail");
			}
		
		return this;
	}
}
