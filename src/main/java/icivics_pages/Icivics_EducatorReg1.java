package icivics_pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
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

	@Then("verify Current page count and print")
	public Icivics_EducatorReg1 verifypagecount1() throws IOException {
		String propname = "educatorregistration";
		String cssvalue = "background-color";
		String Greycolor = "rgb(88, 89, 91)";
		String Greencolor = "rgb(0, 178, 124)";

		String Step1 = cssgetbefore(getPropfile(propname, "step1ele"), cssvalue, Greencolor);
		String Step2 = cssgetbefore(getPropfile(propname, "step2ele"), cssvalue, Greycolor);
		String Step3 = cssgetbefore(getPropfile(propname, "step3ele"), cssvalue, Greycolor);
		String Step4 = cssgetbefore(getPropfile(propname, "step4ele"), cssvalue, Greycolor);
		String Step5 = cssgetbefore(getPropfile(propname, "step5ele"), cssvalue, Greycolor);

		if (Step1.equals(Greencolor) && Step2.equals(Greycolor) && Step3.equals(Greycolor) && Step4.equals(Greycolor)
				&& Step5.equals(Greycolor)) {
			reportStep("you are currently viewing page 1 in the breadcrumbs", "Pass");
		} else {
			reportStep("unable to identify which page you are currently viewing in the breadcrumbs", "Fail");
		}

		return this;
	}

	@Given("Verify the Username text fields")
	public Icivics_EducatorReg1 Verifyusernametextfields() {
		WebElement usernamelabel = driver.findElement(By.xpath("//span[text()='Username:']"));
		// verifyDisplayed(usernamelabel);
		if (usernamelabel.isDisplayed()) {
			reportStep("Username label is displayed", "Pass");
		} else {
			reportStep("Username label box is not displayed", "Fail");
		}
		WebElement username = driver.findElement(By.xpath("//span[@class='name-value']"));
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
	public Icivics_EducatorReg1 Verifyfirstnamenametextfields() {

		WebElement firstnamelabel = driver.findElement(By.xpath("//label[text()='First Name']"));
		
		if (firstnamelabel.isDisplayed()) {
			reportStep("First name label is displayed", "Pass");
		} else {
			reportStep("First name label box is not displayed", "Fail");
		}
		
		WebElement firstname = driver
				.findElement(By.xpath("(//input[@class='js-text-full text-full form-text required form-control'])[1]"));
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
	public Icivics_EducatorReg1 Verifylastnametextfields() {

		WebElement Lastnamelabel = driver.findElement(By.xpath("//label[text()='Last Name']"));
		if (Lastnamelabel.isDisplayed()) {
			reportStep("Lastname label is displayed", "Pass");
		} else {
			reportStep("Lastname label box is not displayed", "Fail");
		}
		
		WebElement lastname = driver
				.findElement(By.xpath("(//input[@class='js-text-full text-full form-text required form-control'])[2]"));
		if (lastname.isDisplayed()) {

			reportStep("Lastname field is displayed", "Pass");
		} else {
			reportStep("Lastname field is not displayed", "Fail");
		}
		
		WebElement Lastname = driver
				.findElement(By.xpath("//*[@id='edit-main-profiles-0-entity-field-last-name-0-value']"));
		String CLbox = Lastname.getAttribute("value");
		if (CLbox.isEmpty()) {
			reportStep("Last name text box is Blank", "Pass");
		} else {
			reportStep("Last name text box is not Blank", "Fail");
		}
		return this;
	}

	@And("Verify the E-mail text fields")
	public Icivics_EducatorReg1 Verifyemailtextfields() {

		WebElement Emailaddresslabel = driver.findElement(By.xpath("//label[text()='Email address']"));
		if (Emailaddresslabel.isDisplayed()) {
			reportStep("Emailaddress label is displayed", "Pass");
		} else {
			reportStep("Emailaddress label box is not displayed", "Fail");
		}
		
		WebElement email = driver.findElement(By.xpath("(//input[@class='form-email required form-control'])[1]"));
		if (email.isDisplayed()) {

			reportStep("email field is displayed", "Pass");
		} else {
			reportStep("email field is not displayed", "Fail");
		}
		
		WebElement Emailaddress = driver.findElement(By.xpath("//*[@id='edit-mail']"));
		String CLbox = Emailaddress.getAttribute("value");
		if (CLbox.isEmpty()) {
			reportStep("Emailaddress text box is Blank", "Pass");
		} else {
			reportStep("Emailaddress text box is not Blank", "Fail");
		}
		
		return this;
	}

	@And("Verify the Verify E-mail text fields")
	public Icivics_EducatorReg1 Verifyemail2textfields() {
		
		WebElement VerifyEmailaddresslabel = driver.findElement(By.xpath("//label[text()='Verify email address']"));
		if (VerifyEmailaddresslabel.isDisplayed()) {
			reportStep("VerifyEmailaddress label is displayed", "Pass");
		} else {
			reportStep("VerifyEmailaddress label box is not displayed", "Fail");
		}
		
		WebElement verifyemail = driver
				.findElement(By.xpath("(//input[@class='form-email required form-control'])[2]"));
		if (verifyemail.isDisplayed()) {

			reportStep("verifyemail field is displayed", "Pass");
		} else {
			reportStep("verifyemail field is not displayed", "Fail");
		}
		WebElement VerifyEmailaddress = driver.findElement(By.xpath("//*[@id='edit-conf-mail']"));
		String CLbox = VerifyEmailaddress.getAttribute("value");
		if (CLbox.isEmpty()) {
			reportStep("VerifyEmailaddress text box is Blank", "Pass");
		} else {
			reportStep("VerifyEmailaddress box is not Blank", "Fail");
		}
		return this;
	}

	@Given("Verify username is pregenerated")
	public Icivics_EducatorReg1 usernamepregenerated() throws InterruptedException {
		WebElement username = driver.findElement(By.xpath("//span[@class='name-value']"));
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
	public Icivics_EducatorReg1 usernamegeneratedrandomly() throws InterruptedException {
		WebElement username = driver.findElement(By.xpath("//span[@class='name-value']"));
		waitTime(6000);
		String username1 = username.getText();
		System.out.println(username1);
		driver.findElement(By.xpath("//span[@class='icon reload']//i[1]")).click();
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
	public Icivics_EducatorReg1 entertextinusernamefield() throws InterruptedException {
		WebElement username = driver.findElement(By.xpath("//span[@class='name-value']"));
		try{
			clearAndType(username, "Tripti");}
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
	public Icivics_EducatorReg1 entertextinfirstnamefield() throws InterruptedException {
		WebElement firstname = propElement(
				"XPATH&(//input[@class='js-text-full text-full form-text required form-control'])[1]");
		clearAndType(firstname, "Tripti");
		return this;
	}
	
	@And("Verify typing text allowed in lastname field")
	public Icivics_EducatorReg1 entertextinlastnamefield() throws InterruptedException {
		WebElement lastname = propElement(
				"XPATH&(//input[@class='js-text-full text-full form-text required form-control'])[2]");
		clearAndType(lastname, "Gupta");
		return this;
	}
	
	@And("Verify typing text allowed in email field")
	public Icivics_EducatorReg1 entertextinemailfield() throws InterruptedException {
		WebElement email = propElement("XPATH&(//input[@class='form-email required form-control'])[1]");
		clearAndType(email, "tripti.gupta@ameexusa.com");
		return this;
		}
	
	@And("Verify typing text allowed in Verify email field")
	public Icivics_EducatorReg1 entertextinverifyemailfield() throws InterruptedException {
		WebElement verifyemail = propElement("XPATH&(//input[@class='form-email required form-control'])[2]");
		clearAndType(verifyemail, "tripti.gupta@ameexusa.com");
		return this;
	}

	@Given("Verify username is not marked with an asterisk")
	public Icivics_EducatorReg1 usernameAsteriks() throws IOException {
		WebElement username = driver.findElement(By.xpath("(//div[@class='form-item']//span)[1]"));
		if(!username.getText().contains("*"))
		{
			reportStep("* is not present in the username label", "Pass");	
		}else {
			reportStep("* is present in the username label", "Fail");	
		}
		return this;
	}
	
	@Then("Verify firstname is marked with an asterisk")
	public Icivics_EducatorReg1 firstnameAsteriks() throws IOException {
		cssgetafter(getPropfile("educatorregistration", "edureg.fn*"), "content", "\"*\"");
		reportStep("* is present in the firstname label", "Pass");
		return this;
	}
	
	@And("Verify lastname is marked with an asterisk")
	public Icivics_EducatorReg1 lastnameAsteriks() throws IOException {
		cssgetafter(getPropfile("educatorregistration", "edureg.ln*"), "content", "\"*\"");
		reportStep("* is present in the lastname label", "Pass");
		return this;
	}
		
	@And("Verify email is marked with an asterisk")
	public Icivics_EducatorReg1 emailAsteriks() throws IOException {
		cssgetafter(getPropfile("educatorregistration", "edureg.email*"), "content", "\"*\"");
		reportStep("* is present in the email label", "Pass");
		return this;
	}
			
	@And("Verify verify email is marked with an asterisk")
	public Icivics_EducatorReg1 verifyemailAsteriks() throws IOException {
	cssgetafter(getPropfile("educatorregistration", "edureg.verifyemail*"), "content", "\"*\"");
	reportStep("* is present in the verify email label", "Pass");
	return this;
	}

	@Given("verify the Tooltip Text by Hovering on email field")
	public Icivics_EducatorReg1 hoveronemailfield() throws InterruptedException {
		String email = "XPATH&(//input[@type='email'])[1]";
		mouseOverAction(email);
		WebElement emailtooltip = propElement(email);
		String ExpectedTooltip = "A valid email address. All emails from the system will be sent to this address. The email address is not made public and will only be used if you wish to receive a new password or wish to receive certain news or notifications by email.";
		String actualTooltip = emailtooltip.getAttribute("data-original-title");
		if(actualTooltip.equals(ExpectedTooltip)) {
			reportStep("Expected Tooltip and Actual Tooltip text matched successfully", "Pass");
		}else {
			reportStep("Expected Tooltip and Actual Tooltip text did not match", "Fail");
		}return this;
		}
		
	@Then("verify the Tooltip Text by Hovering on verify email field")
	public Icivics_EducatorReg1 hoveronverifyemailfield() throws InterruptedException {
		String verifyemail = "XPATH&(//input[@type='email'])[2]";
		mouseOverAction(verifyemail);
		reportStep("No Tool Tip present for Verifyemail text box", "Pass");
		return this;
	}


	@Given("Enter invalid first name")
	public Icivics_EducatorReg1 Enterinvalidfirstname() throws InterruptedException {
		WebElement firstname = driver.findElement(By.xpath("(//input[@class='js-text-full text-full form-text required form-control'])[1]"));
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
	public Icivics_EducatorReg1 Enterinvalidlastname() throws InterruptedException {
		WebElement lastname = driver
				.findElement(By.xpath("(//input[@class='js-text-full text-full form-text required form-control'])[2]"));
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
		WebElement email = driver.findElement(By.xpath("(//input[@class='form-email required form-control'])[1]"));
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
		WebElement verifyemail = driver
				.findElement(By.xpath("(//input[@class='form-email required form-control'])[2]"));
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
		scrollToTheGivenWebElement("XPATH&//label[text()='Email address']");
		clickOn("XPATH&(//button[@type='submit'])[1]");
		return this;
	}
	
	@But("error message should be displayed for email and verify email")
	public Icivics_EducatorReg1 verifyerrormsgforinvaliddatasubmit() {
		WebElement alertmsg = driver.findElement(By.xpath("//div[@role='alert']//p[1]"));
		String Actualerrmsg = alertmsg.getText();
		String Expectederrmsg = "2 errors have been found:";
		verifyPartialText(alertmsg, "2 errors have been found:");
		if(Expectederrmsg.equals(Actualerrmsg)) {
			reportStep("Error alert message is displayed", "Pass");
		}
		
		WebElement emailerrormsg = driver.findElement(By.xpath("//label[text()='Email address']/following-sibling::div"));
		if(emailerrormsg.getText().contains("The email address gdfsgadvjh is not valid.")) {
			scrollToTheGivenWebElement("XPATH&//label[text()='Email address']");
			reportStep(emailerrormsg.getText() + " is displayed", "Pass");
		}
		
		WebElement verifyemailerrormsg = driver.findElement(By.xpath("//label[text()='Verify email address']/following-sibling::div"));
		if(verifyemailerrormsg.getText().contains("The email address gdfsgadvjh is not valid.")) {
		reportStep(verifyemailerrormsg.getText() + " is displayed", "Pass");
		}
		return this;
	}

	@Given("Verify error message for all required field by leaving the fields blank and click on next button")
	public Icivics_EducatorReg1 verifyerrormsgblankfieldall() throws InterruptedException {
		WebElement firstname = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[1]"));
		firstname.clear();
		WebElement lastname = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[2]"));
		lastname.clear();
		WebElement email = driver.findElement(By.xpath("(//input[@type='email'])[1]"));
		email.clear();
		WebElement verifyemail = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
		verifyemail.clear();
		
		scrollToTheGivenWebElement("XPATH&//button[contains(@class,'icon-before button')]");
		clickOn("XPATH&//button[contains(@class,'icon-before button')]");

		WebElement firstnamealertmsg = driver.findElement(By.xpath("(//li[@class='item item--message'])[1]"));
		verifyExactText(firstnamealertmsg, "Field First Name is required");

		WebElement lastnamealertmsg = driver.findElement(By.xpath("(//li[@class='item item--message'])[2]"));
		verifyExactText(lastnamealertmsg, "Field Last Name is required");

		WebElement alertmsg = driver.findElement(By.xpath("(//li[@class='item item--message'])[3]"));
		verifyPartialText(alertmsg, "2 errors have been found:");
		
		scrollToTheGivenWebElement("XPATH&//label[text()='Email address']");

		WebElement emailalertmsg = driver
				.findElement(By.xpath("(//div[@class='form-item--error-message alert alert-danger alert-sm'])[1]"));
		verifyPartialText(emailalertmsg, "Email address field is required.");

		WebElement verifyemailalertmsg = driver
				.findElement(By.xpath("(//div[@class='form-item--error-message alert alert-danger alert-sm'])[2]"));
		verifyPartialText(verifyemailalertmsg, "Verify email address field is required.");

		return this;
	}
	
	@When("Verify error message by leaving the Firstname field blank and enter values in the remaining required fields and click on next button")
	public Icivics_EducatorReg1 verifyerrormsgfirstnameblankfield() throws InterruptedException {
		WebElement firstname = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[1]"));
		firstname.clear();
		WebElement lastname = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[2]"));
		lastname.clear();
		lastname.sendKeys("Gupta");
		WebElement email = driver.findElement(By.xpath("(//input[@type='email'])[1]"));
		email.clear();
		email.sendKeys("Gupta@gmail.com");
		WebElement verifyemail = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
		verifyemail.clear();
		verifyemail.sendKeys("Gupta@gmail.com");
		
		scrollToTheGivenWebElement("XPATH&//button[contains(@class,'icon-before button')]");
		clickOn("XPATH&//button[contains(@class,'icon-before button')]");

		WebElement firstnamealertmsg = driver.findElement(By.xpath("//div[@role='alert']//p[1]"));
		verifyExactText(firstnamealertmsg, "Field First Name is required");

		return this;
	}
	
	
	@And("Verify error message by leaving the Lastname field blank and enter values in the remaining required fields and click on next button")
	public Icivics_EducatorReg1 verifyerrormsglastnameblankfield() throws InterruptedException {
		WebElement firstname = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[1]"));
		firstname.clear();
		firstname.sendKeys("Tripti");
		WebElement lastname = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[2]"));
		lastname.clear();
		WebElement email = driver.findElement(By.xpath("(//input[@type='email'])[1]"));
		email.clear();
		email.sendKeys("Gupta@gmail.com");
		WebElement verifyemail = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
		verifyemail.clear();
		verifyemail.sendKeys("Gupta@gmail.com");
		
		scrollToTheGivenWebElement("XPATH&//button[contains(@class,'icon-before button')]");
		clickOn("XPATH&//button[contains(@class,'icon-before button')]");

		WebElement lastnamealertmsg = driver.findElement(By.xpath("//div[@role='alert']//p[1]"));
		verifyExactText(lastnamealertmsg, "Field Last Name is required");

		return this;
	}
	
	@And("Verify error message by leaving the email field blank and enter values in the remaining required fields and click on next button")
	public Icivics_EducatorReg1 verifyerrormsgemailblankfield() throws InterruptedException {
		WebElement firstname = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[1]"));
		firstname.clear();
		firstname.sendKeys("Tripti");
		WebElement lastname = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[2]"));
		lastname.clear();
		lastname.sendKeys("Gupta");
		WebElement email = driver.findElement(By.xpath("(//input[@type='email'])[1]"));
		email.clear();
		WebElement verifyemail = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
		verifyemail.clear();
		verifyemail.sendKeys("Gupta@gmail.com");
		
		scrollToTheGivenWebElement("XPATH&//button[contains(@class,'icon-before button')]");
		clickOn("XPATH&//button[contains(@class,'icon-before button')]");

		WebElement alertmsg = driver.findElement(By.xpath("//div[@role='alert']//p[1]"));
		verifyPartialText(alertmsg, "2 errors have been found:");
		
		scrollToTheGivenWebElement("XPATH&//label[text()='Email address']");

		WebElement emailalertmsg = driver.findElement(By.xpath("(//div[@class='form-item--error-message alert alert-danger alert-sm'])[1]"));
		verifyPartialText(emailalertmsg, "Email address field is required.");

		WebElement verifyemailalertmsg = driver.findElement(By.xpath("(//div[@class='form-item--error-message alert alert-danger alert-sm'])[2]"));
		verifyPartialText(verifyemailalertmsg, "Your e-mail address and confirmed e-mail address must match.");
		
		return this;
	}
	
	@And("Verify error message by leaving the verify email field blank and enter values in the remaining required fields and click on next button")
	public Icivics_EducatorReg1 verifyerrormsgverifyemailblankfield() throws InterruptedException {
		WebElement firstname = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[1]"));
		firstname.clear();
		firstname.sendKeys("Tripti");
		WebElement lastname = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[2]"));
		lastname.clear();
		lastname.sendKeys("Gupta");
		waitTime(5000);
		WebElement email = driver.findElement(By.xpath("(//input[@type='email'])[1]"));
		email.clear();
		email.sendKeys("Gupta@gmail.com");
		WebElement verifyemail = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
		verifyemail.clear();
		waitTime(5000);
		
		scrollToTheGivenWebElement("XPATH&//button[contains(@class,'icon-before button')]");
		waitTime(3000);
		clickOn("XPATH&//button[contains(@class,'icon-before button')]");

		WebElement alertmsg = driver.findElement(By.xpath("//div[@role='alert']//p[1]"));
		verifyPartialText(alertmsg, "1 error has been found:");
		
		scrollToTheGivenWebElement("XPATH&//label[text()='Email address']");

		WebElement verifyemailalertmsg = driver.findElement(By.xpath("(//div[@class='form-item--error-message alert alert-danger alert-sm'])"));
		verifyPartialText(verifyemailalertmsg, "Verify email address field is required.");
		
		return this;
	}
	
	@Given("Verify all error messages for invalid inputs")
	public Icivics_EducatorReg1 verifyinvaliderrormsg() throws InterruptedException {

		WebElement firstname = driver.findElement(By.xpath("(//input[@class='js-text-full text-full form-text required form-control'])[1]"));
		firstname.clear();
		firstname.sendKeys("14344433%");
		
		WebElement lastname = driver.findElement(By.xpath("(//input[@class='js-text-full text-full form-text required form-control'])[2]"));
		lastname.clear();
		lastname.sendKeys("%ttt#12");
		
		WebElement verifyemail = driver.findElement(By.xpath("(//input[@class='form-email required form-control'])[2]"));
		verifyemail.clear();
		verifyemail.sendKeys("GHDGFH!#!#!");
			
		WebElement email = driver.findElement(By.xpath("(//input[@class='form-email required form-control'])[1]"));
		email.clear();
		email.sendKeys("GHDGFH!#!#!");
	
		WebElement nextbutton = driver.findElement(By.xpath("//button[text()='Next']"));
		nextbutton.click();
		
		WebElement alertmsg = driver.findElement(By.xpath("//div[@role='alert']//p[1]"));
		String Actualerrmsg = alertmsg.getText();
		String Expectederrmsg = "2 errors have been found:";
		verifyPartialText(alertmsg, "2 errors have been found:");
		if(Expectederrmsg.equals(Actualerrmsg)) {
			reportStep("Error alert message is displayed", "Pass");
		}
		
		WebElement emailerrormsg = driver.findElement(By.xpath("//label[text()='Email address']/following-sibling::div"));
		if(emailerrormsg.getText().contains("The email address GHDGFH!#!#! is not valid.")) {
			scrollToTheGivenWebElement("XPATH&//label[text()='Email address']");
			reportStep(emailerrormsg.getText() + " is displayed", "Pass");
		}
		
		WebElement verifyemailerrormsg = driver.findElement(By.xpath("//label[text()='Verify email address']/following-sibling::div"));
		if(verifyemailerrormsg.getText().contains("The email address GHDGFH!#!#! is not valid.")) {
		reportStep(verifyemailerrormsg.getText() + " is displayed", "Pass");
		}
		Thread.sleep(3000);

		return this;
	}

	@Given("Enter valid firstname, lastname, email, verifyemail and click on next and verify page 2 is loaded")
	public Icivics_EducatorReg1 verifyregistrationwithvaliddata() throws InterruptedException, IOException {
		waitTime(5000);
		WebElement username = driver.findElement(By.xpath("//span[@class='name-value']"));
		String username1 = username.getText();
		writePropfile("username", "username", username1);
		reportStep("User name is " + username1, "Pass");
		
		WebElement firstname = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[1]"));
		firstname.clear();
		firstname.sendKeys("Tripti");
		reportStep("Firstname is entered", "Pass");
		
		WebElement lastname = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[2]"));
		lastname.clear();
		lastname.sendKeys("Gupta");
		reportStep("Lastname is entered", "Pass");
		
		WebElement email = driver.findElement(By.xpath("(//input[@type='email'])[1]"));
		email.clear();
		email.sendKeys("tripti.gupta1@gmail.com");
		reportStep("Email is entered", "Pass");
		
		WebElement verifyemail = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
		verifyemail.clear();
		verifyemail.sendKeys("tripti.gupta1@gmail.com");
		reportStep("Verify email is entered", "Pass");
		
		WebElement nextbutton = driver.findElement(By.xpath("//button[text()='Next']"));
		scrollToTheGivenWebElement("XPATH&//button[text()='Next']");
		reportStep("Next Button is clicked", "Pass");
		nextbutton.click();
		waitTime(3000);
		
		WebElement page2 = driver.findElement(By.xpath("//span[text()='Grade Level']"));
		if(page2.isDisplayed()) {
			reportStep("Page 2 is displayed", "Pass");
			}else {
				reportStep("Page 2 is not displayed", "Fail");
			}
		
		return this;
	}
}
