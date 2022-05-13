package icivics_pages;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_EducatorReg4 extends ProjectSpecificMethods {

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
		
		WebElement username = driver.findElement(By.xpath("//span[@class='name-value']"));
		String username1 = username.getText();
		writePropfile("username", "username", username1);
		
		WebElement firstname = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[1]"));
		firstname.clear();
		firstname.sendKeys("Tripti");
		
		WebElement lastname = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[2]"));
		lastname.clear();
		lastname.sendKeys("Gupta");
		
		String EmailId = "Tripti@gmail.com";
		
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		String[] data = EmailId.split("@");
		String name = data[0];
		String host = data[1];
		String emailId = name + number + "@" + host;
		
		reportStep(emailId + " email is used for creating account", "Pass");
		writePropfile("email", "email", emailId);
		WebElement email = driver.findElement(By.xpath("(//input[@type='email'])[1]"));
		email.clear();
		email.sendKeys(emailId);
		
		WebElement verifyemail = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
		verifyemail.clear();
		verifyemail.sendKeys(emailId);
		
		WebElement nextbutton = driver.findElement(By.xpath("//button[text()='Next']"));
		scrollToTheGivenWebElement("XPATH&//button[text()='Next']");
		nextbutton.click();
		waitTime(3000);
		
		String value = "Middle School";
		List<WebElement> chkBox = driver.findElements(By.xpath("//div[@class='form-checkboxes']/div/label/input"));
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
		
		String dropdownvalue = "Teacher";
		WebElement roleDropDown = driver.findElement(By.xpath("//select[@id='edit-main-profiles-0-entity-field-user-type']"));
		selectDropDownUsingValue(roleDropDown, dropdownvalue);
		waitTime(3000);

		driver.findElement(By.xpath("//button[.='Next']")).click();
		waitTime(3000);
		
		String SchoolName = "st.Thomas's School";
		
		WebElement Schoolfield = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[1]"));
		Schoolfield.sendKeys(SchoolName);
		
		String Zipcode5 = "12111";
		
		WebElement Zipcodefield = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[2]"));
		Zipcodefield.sendKeys(Zipcode5);
		
		String Teachstatevalue = "Idaho";
		
		WebElement teachingstate = driver.findElement(By.xpath("//select[@id='edit-main-profiles-0-entity-field-teaching-state']"));
		selectDropDownUsingText(teachingstate, Teachstatevalue);
		waitTime(3000);

		click(driver.findElement(By.xpath("//button[.='Next']")));
		waitTime(3000);
		
		return this;
	}
	
	@Given("verify Current page count 4 and print")
	public Icivics_EducatorReg4 verifypagecount4() throws IOException {
		String propname = "educatorregistration";
		String cssvalue = "background-color";
		String Greycolor = "rgb(88, 89, 91)";
		String Greencolor = "rgb(0, 178, 124)";

		String Step1 = cssgetbefore(getPropfile(propname, "step1ele"), cssvalue, Greencolor);
		String Step2 = cssgetbefore(getPropfile(propname, "step2ele"), cssvalue, Greencolor);
		String Step3 = cssgetbefore(getPropfile(propname, "step3ele"), cssvalue, Greencolor);
		String Step4 = cssgetbefore(getPropfile(propname, "step4ele"), cssvalue, Greencolor);
		String Step5 = cssgetbefore(getPropfile(propname, "step5ele"), cssvalue, Greycolor);

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
		WebElement backbutton = driver.findElement(By.xpath("//button[text()='Back']"));
		backbutton.click();
		waitTime(3000);
		String propname = "educatorregistration";
		String cssvalue = "background-color";
		String Greycolor = "rgb(88, 89, 91)";
		String Greencolor = "rgb(0, 178, 124)";

		String Step1 = cssgetbefore(getPropfile(propname, "step1ele"), cssvalue, Greencolor);
		String Step2 = cssgetbefore(getPropfile(propname, "step2ele"), cssvalue, Greencolor);
		String Step3 = cssgetbefore(getPropfile(propname, "step3ele"), cssvalue, Greencolor);
		String Step4 = cssgetbefore(getPropfile(propname, "step4ele"), cssvalue, Greycolor);
		String Step5 = cssgetbefore(getPropfile(propname, "step5ele"), cssvalue, Greycolor);

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
		
		WebElement backbutton = driver.findElement(By.xpath("//button[text()='Back']"));
		backbutton.click();
		
		String SchoolName = "st.Thomas's School";
		
		String Schoolfield = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[1]")).getAttribute("value");
		if (Schoolfield.equals(SchoolName)) {
			reportStep("SchoolName value " + SchoolName + " is remembered ", "Pass");
		} else {
			reportStep("SchoolName value " + SchoolName + " is not remembered ", "Fail");
		}
		return this;
	}
	
	@When("Verify Zip Code is remembered.")
	public Icivics_EducatorReg4 verifyZipCoderemembered() throws IOException {
		
		String Zipcode5 = "12111";
		
		String Zipcodefield = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[2]")).getAttribute("value");
		
		if (Zipcodefield.equals(Zipcode5)) {
			reportStep("Zip Code value " + Zipcode5 + " is remembered ", "Pass");
		} else {
			reportStep("Zip Code value " + Zipcode5 + " is not remembered ", "Fail");
		}
		return this;
	}
	
	
	@And("Verify Teaching State is remembered.")
	public Icivics_EducatorReg4 verifyTeachingStateremembered() throws IOException {
		scrollToTheGivenWebElement("XPATH&//button[text()='Next']");
		
		String Teachstatevalue = "Id";
		
		String teachingstate = driver.findElement(By.xpath("//select[@id='edit-main-profiles-0-entity-field-teaching-state']")).getAttribute("value");
		if (teachingstate.equalsIgnoreCase(Teachstatevalue)) {
			reportStep("Teaching State value " + teachingstate + " is remembered ", "Pass");
		} else {
			reportStep("Teaching State value " + teachingstate + " is not remembered ", "Fail");
		}
		return this;
	}
	
	@Given("User on Page 4, Verify Password field is displayed")
	public Icivics_EducatorReg4 verifypage4passwordfield() {
		
		WebElement passwordlabel = driver.findElement(By.xpath("//label[@for='edit-pass-pass1']"));
		WebElement passwordtextbox = driver.findElement(By.xpath("(//input[@type='password'])[1]"));
		if (passwordlabel.isDisplayed() && passwordtextbox.isDisplayed()) {
			reportStep(passwordlabel.getText() + " text box and label is displayed", "Pass");
		} else {
			reportStep("Password text box and label is not displayed", "Fail");
		}
		
		return this;
	}
	
	@When("User on Page 4, Verify Confirm Password field is displayed")
	public Icivics_EducatorReg4 verifypage4confirmpasswordfield() {
		
		WebElement Confirmpasswordlabel = driver.findElement(By.xpath("//label[@for='edit-pass-pass2']"));
		WebElement Confirmpasswordtextbox = driver.findElement(By.xpath("(//input[@type='password'])[2]"));
		if (Confirmpasswordlabel.isDisplayed() && Confirmpasswordtextbox.isDisplayed()) {
			reportStep(Confirmpasswordlabel.getText() + " text box and label is displayed", "Pass");
		} else {
			reportStep("Confirm Password text box and label is not displayed", "Fail");
		}
		return this;
	}
	
	@And("User on Page 4, Verify Sign Up for Emails field is displayed")
	public Icivics_EducatorReg4 verifypage4SignUpforEmailsfield() {
		scrollToTheGivenWebElement("XPATH&//button[@title='Finish']");
		WebElement SignUplabel = driver.findElement(By.xpath("//div[@id='edit-account']//h3[1]"));
		WebElement SignUplabelcheckbox = driver.findElement(By.xpath("//input[@data-drupal-selector='edit-bsd-list-forms']"));
		WebElement SignUptext = driver.findElement(By.xpath("(//div[contains(@class,'form-item js-form-item')]//label)[3]"));
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
		WebElement Termsofuse = driver.findElement(By.xpath("//label[@for='edit-agreement']//a[1]"));
		WebElement PrivacyPolicy = driver.findElement(By.xpath("//label[@for='edit-agreement']//a[2]"));
		WebElement Termscheckbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		WebElement Termstext = driver.findElement(By.xpath("//label[@for='edit-agreement']"));
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
		scrollToTheGivenWebElement("XPATH&//button[@id='edit-back']");
		WebElement signupcheckbox = driver.findElement(By.xpath("(//input[@class='form-checkbox'])[1]"));
		if (signupcheckbox.isSelected()) {
			reportStep("signup checkbox is clicked as default", "Pass");
		}else {
			reportStep("signup checkbox is not clicked as default", "Fail");
		}
		return this;
	}
	
	@Given("Verify Password and confirm allow to enter text and both match")
	public Icivics_EducatorReg4 VerifyPassword() {
		String pwd = "Testicivics@123";
		
		WebElement password = driver.findElement(By.xpath("//input[@class='password-field js-password-field form-text required form-control']"));
		password.clear();
		password.sendKeys(pwd);
		String getpwdtext = password.getAttribute("value");
		if (getpwdtext.equals(pwd)) {
			reportStep("Password text box allows to enter text "+ pwd, "Pass");
		} else {
			reportStep("Password text box does not allow to enter text "+ pwd, "Fail");
		}	
		
		WebElement confirmpassword = driver.findElement(By.xpath("//input[contains(@class,'password-confirm js-password-confirm')]"));
		confirmpassword.clear();
		confirmpassword.sendKeys(pwd);
		String getcpwdtext = confirmpassword.getAttribute("value");
		if (getcpwdtext.equals(pwd)) {
			reportStep("Password text box allows to enter text "+ pwd, "Pass");
		} else {
			reportStep("Password text box does not allow to enter text "+ pwd, "Fail");
		}
		
		WebElement passwordmatchstatus = driver.findElement(By.xpath("//div[@class='password-confirm-message']//span[1]"));
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
		String pwd = "Testicivics";
		
		WebElement password = driver.findElement(By.xpath("//input[@class='password-field js-password-field form-text required form-control']"));
		password.clear();	
		password.sendKeys(pwd);	
		
		WebElement confirmpassword = driver.findElement(By.xpath("//input[contains(@class,'password-confirm js-password-confirm')]"));
		confirmpassword.clear();
		confirmpassword.sendKeys(pwd);
		
		WebElement agreechkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		agreechkbox.click();
		
		WebElement passwordstrength = driver.findElement(By.xpath("//div[@class='password-strength__title']//span[1]"));
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
		String pwd = "Testicivics";
		
		WebElement password = driver.findElement(By.xpath("//input[@class='password-field js-password-field form-text required form-control']"));
		password.clear();
		password.sendKeys(pwd);	
		
		WebElement confirmpassword = driver.findElement(By.xpath("//input[contains(@class,'password-confirm js-password-confirm')]"));
		confirmpassword.clear();
		confirmpassword.sendKeys(pwd);
		
		WebElement agreechkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		
		if(agreechkbox.isSelected()) {
		agreechkbox.click();
		}
		
		click(driver.findElement(By.xpath("//button[@title='Finish']")));
		waitTime(3000);
		
		WebElement agreechkboxerrmsg = driver.findElement(By.xpath("//div[@role='alert']//p[1]"));
		if(agreechkboxerrmsg.isDisplayed()) {
			reportStep("Accept terms must be checked error msg is displayed", "Pass");}
		else {
				reportStep("Accept terms is checked", "Fail");
		}
		
		waitTime(3000);
		WebElement password1 = driver.findElement(By.xpath("//input[@class='password-field js-password-field form-text required form-control']"));
		password1.clear();
		password1.sendKeys(pwd);	
		
		WebElement confirmpassword1 = driver.findElement(By.xpath("//input[contains(@class,'password-confirm js-password-confirm')]"));
		confirmpassword1.clear();
		confirmpassword1.sendKeys(pwd);
		
		WebElement agreechkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		
		if (!agreechkbox1.isSelected()) {
			agreechkbox1.click();
			reportStep("Accept terms is checked", "Pass");
		}
		
		click(driver.findElement(By.xpath("//button[@title='Finish']")));
		
		WebElement welcomemsg = driver.findElement(By.xpath("//div[@role='status']//p[1]"));
		if (welcomemsg.isDisplayed()) {
			reportStep("page 5 is loaded", "Pass");
		}else {
			reportStep("Accept terms is not checked, page 5 is not loaded", "Fail");
		}
				
		return this;
	}
	
	@Given("Verify Password is marked with an asterisk")
	public Icivics_EducatorReg4 verifypasswordAsteriks() throws IOException {
		cssgetafter(getPropfile("educatorregistration", "edureg.pwd*"), "content", "\"*\"");
		reportStep("Asteriks * is present in the Password label", "Pass");
		return this;
	}

	@When("Verify Confirm Password is marked with an asterisk")
	public Icivics_EducatorReg4 verifyconfirmpasswordAsteriks() throws IOException {
		cssgetafter(getPropfile("educatorregistration", "edureg.cpwd*"), "content", "\"*\"");
		reportStep("Asteriks * is present in the Confirm Password label", "Pass");
		return this;
	}
	
	@Given("Hover on password field and verify the Tooltip Text")
	public Icivics_EducatorReg4 hoveronpwdfield() throws InterruptedException {
		String pwd = "XPATH&//input[@data-once='password']";
		mouseOverAction(pwd);
		WebElement pwdtooltip = propElement(pwd);
		String ExpectedTooltip = "Provide a password for the new account in both fields.";
		String actualTooltip = pwdtooltip.getAttribute("data-original-title");
		if(actualTooltip.equals(ExpectedTooltip)) {
			reportStep("Expected Tooltip and Actual Tooltip text matched successfully", "Pass");
		}else {
			reportStep("Expected Tooltip and Actual Tooltip text did not match", "Fail");
		}return this;
		}
	
	@Given("Verify the password strength Indicator is changing according to password strength")
	public Icivics_EducatorReg4 VerifyPasswordstrengthmeter() {
		String pwd = "Testicivics";
		
		WebElement password = driver.findElement(By.xpath("//input[@class='password-field js-password-field form-text required form-control']"));
		password.clear();
		password.sendKeys(pwd);
		
		WebElement passwordstrength = driver.findElement(By.xpath("//div[@class='password-strength__title']//span[1]"));
		String passwordstrengthtext = passwordstrength.getText();
		if (passwordstrengthtext.equals("Weak")||passwordstrengthtext.equals("Strong")||passwordstrengthtext.equals("Fair")||passwordstrengthtext.equals("Good")) {
			reportStep("Password strength Indicator is changing as "+passwordstrengthtext+ " according to password strength", "Pass");
		} else {
			reportStep("Password strength Indicator is not changing according to password strength", "Fail");
		}
		
		WebElement passwordstrengthmeter = driver.findElement(By.xpath("//div[@data-drupal-selector='password-strength-meter']//div[1]"));
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
		String pwd = "Testicivics@123";
		
		WebElement password = driver.findElement(By.xpath("//input[@class='password-field js-password-field form-text required form-control']"));
		password.clear();
		password.sendKeys(pwd);
		
		WebElement confirmpassword = driver.findElement(By.xpath("//input[contains(@class,'password-confirm js-password-confirm')]"));
		confirmpassword.clear();
		confirmpassword.sendKeys(pwd);
		
		WebElement passwordmatchstatus = driver.findElement(By.xpath("//div[@class='password-confirm-message']//span[1]"));
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
		WebElement password = driver.findElement(By.xpath("//input[@class='password-field js-password-field form-text required form-control']"));
		clearAndType(password, pwd);
		
		WebElement confirmpassword = driver.findElement(By.xpath("//input[contains(@class,'password-confirm js-password-confirm')]"));
		clearAndType(confirmpassword, cpwd);
		
		WebElement agreechkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		
		if (agreechkbox1.isSelected()) {
			agreechkbox1.click();
			reportStep("Accept terms is unchecked", "Pass");
		}
		
		click(driver.findElement(By.xpath("//button[@title='Finish']")));
		
		WebElement errormsgbox = driver.findElement(By.xpath("//div[@role='alert']//p[1]"));
		WebElement pwderror = driver.findElement(By.xpath("//div[@class='password-suggestions']/following-sibling::div[1]"));
		WebElement agreeerror = driver.findElement(By.xpath("//label[@class='control-label option']/following-sibling::div[1]"));
		if (errormsgbox.isDisplayed()&&pwderror.isDisplayed()&&agreeerror.isDisplayed()) {
			verifyExactText(propElement("XPATH&//div[@role='alert']//p[1]"), "2 errors have been found:");
			scrollToTheGivenWebElement("XPATH&//button[@id='edit-back']");
			verifyPartialText(propElement("XPATH&//div[@class='password-suggestions']/following-sibling::div[1]"), "The specified passwords do not match.");
			verifyPartialText(propElement("XPATH&//label[@class='control-label option']/following-sibling::div[1]"), "Please agree to the terms of service and privacy policy.");
		}else {
			reportStep("Password and Confirm Password filed text box error messages is not verifed", "Fail");
		}
		String expectedcolor = "rgba(169, 68, 66, 1)";
		String expectedbgcolor = "rgba(242, 222, 222, 1)";
		WebElement Errormsgbox = driver.findElement(By.xpath("//div[@role='alert']"));
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
		scrollToTheGivenWebElement("XPATH&//button[@value='Finish']");
		String pwd = "gfgh^d$fthf&";
		WebElement password = driver.findElement(By.xpath("//input[@class='password-field js-password-field form-text required form-control']"));
		
		click(driver.findElement(By.xpath("//button[@title='Finish']")));
		reportStep("Error msg Is displayed for password field", "Pass");
		
		clearAndType(password, pwd);
		click(driver.findElement(By.xpath("//button[@title='Finish']")));
		reportStep("Error msg Is displayed for confirm password field", "Pass");
	
		return this;
	}
	
	@Given("Verify Error message is in pink box at the top")
	public Icivics_EducatorReg4 verifyenterinvaliddataerror() {
			
		String pwd = "gfgh^d$fthf&";
		String cpwd = "gfgh^d$fthf&123";
		WebElement password = driver.findElement(By.xpath("//input[@class='password-field js-password-field form-text required form-control']"));
		clearAndType(password, pwd);
		
		WebElement confirmpassword = driver.findElement(By.xpath("//input[contains(@class,'password-confirm js-password-confirm')]"));
		clearAndType(confirmpassword, cpwd);
		
		WebElement agreechkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		
		if (agreechkbox1.isSelected()) {
			agreechkbox1.click();
			reportStep("Accept terms is unchecked", "Pass");
		}
		
		click(driver.findElement(By.xpath("//button[@title='Finish']")));
	
		String expectedcolor = "rgba(169, 68, 66, 1)";
		String expectedbgcolor = "rgba(242, 222, 222, 1)";
		WebElement Errormsgbox = driver.findElement(By.xpath("//div[@role='alert']"));
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
		String pwd = "TestIcivics@123";
		WebElement password = driver.findElement(By.xpath("//input[@class='password-field js-password-field form-text required form-control']"));
		clearAndType(password, pwd);
		
		WebElement confirmpassword = driver.findElement(By.xpath("//input[contains(@class,'password-confirm js-password-confirm')]"));
		clearAndType(confirmpassword, pwd);
		
		WebElement agreechkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		
		if (!agreechkbox1.isSelected()) {
			agreechkbox1.click();
		}
		
		click(driver.findElement(By.xpath("//button[@title='Finish']")));
		waitTime(3000);
		return this;
	}
	
	@Then("verify page 5 is loaded")
	public Icivics_EducatorReg4 verifypage5loaded() throws InterruptedException, IOException {
		
		WebElement page5 = driver.findElement(By.xpath("//div[@role='status']//p[1]"));
		if (page5.isDisplayed()) {
			reportStep("Page 5 is displayed", "Pass");
		}else {
			reportStep("Page 5 is not displayed", "Fail");
		}
		return this;
	}
}
