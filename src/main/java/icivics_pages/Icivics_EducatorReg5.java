package icivics_pages;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_EducatorReg5 extends ProjectSpecificMethods {
	public String gpropname = "EducatorRegistration/educatorregistration";
	public String lpropname = "EducatorRegistration/educatorregistration1";
	public String propname2 = "EducatorRegistration/educatorregistration2";
	public String propname3 = "EducatorRegistration/educatorregistration3";
	public String propname4 = "EducatorRegistration/educatorregistration4";
	public String propname5 = "EducatorRegistration/educatorregistration5";

	public Icivics_EducatorReg5(RemoteWebDriver driver, ExtentTest node, Properties prop) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
	}

	@Given("Launch the icivis educatorregistration URL")
	public Icivics_EducatorReg5 launchURL(String URL) {
		navigateto(URL);
		return this;

	}
	
public Icivics_EducatorReg5 verifywithvaliddata() throws InterruptedException, IOException {
		
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
		
		String pwd = getPropfile(propname4, "Passwordvalue");
		WebElement password = propElement(getPropfile(propname4, "password1"));
		password.clear();
		password.sendKeys(pwd);
		
		
		WebElement confirmpassword = propElement(getPropfile(propname4, "confirmpassword1"));
		confirmpassword.clear();
		confirmpassword.sendKeys(pwd);
		
		WebElement agreechkbox1 = propElement(getPropfile(propname4, "agreechkbox"));
		
		if (!agreechkbox1.isSelected()) {
			agreechkbox1.click();
		}
		
		click(propElement(getPropfile(propname4, "finishbutton")));
		waitTime(3000);
		
		return this;
	}
	
	@Then("verify Current page count 5 and print")
	public Icivics_EducatorReg5 verifypagecount5() throws IOException {
		String cssvalue = "background-color";
		String Greencolor = "rgb(0, 178, 124)";

		String Step1 = cssgetbefore(getPropfile(propname5, "step1ele"), cssvalue, Greencolor);
		String Step2 = cssgetbefore(getPropfile(propname5, "step2ele"), cssvalue, Greencolor);
		String Step3 = cssgetbefore(getPropfile(propname5, "step3ele"), cssvalue, Greencolor);
		String Step4 = cssgetbefore(getPropfile(propname5, "step4ele"), cssvalue, Greencolor);
		String Step5 = cssgetbefore(getPropfile(propname5, "step5ele"), cssvalue, Greencolor);

		if (Step1.equals(Greencolor) && Step2.equals(Greencolor) && Step3.equals(Greencolor) && Step4.equals(Greencolor)
				&& Step5.equals(Greencolor)) {
			reportStep("you are currently viewing page 5 in the breadcrumbs", "Pass");
		} else {
			reportStep("unable to identify which page you are currently viewing in the breadcrumbs", "Fail");
		}

		return this;
	}

	@Given("verify Message says check your inbox")
	public Icivics_EducatorReg5 verifycheckmsgdisplay() throws IOException {
		WebElement emailmsg = propElement(getPropfile(propname5, "emailmsg"));
		if(emailmsg.getText().equals("Check your inbox at:")&&emailmsg.isDisplayed()) {
			reportStep(emailmsg.getText() + " label is verified", "Pass");}
		else {
			reportStep("email label is not verified", "Fail");
		}

		return this;
	}

	@Then("Verify Message says confirmation email is on its way")
	public Icivics_EducatorReg5 verifyemailheaderlabel()
	{
		WebElement emailheadermsg = propElement(getPropfile(propname5, "emailheadermsg"));
		if (emailheadermsg.isDisplayed()&&emailheadermsg.getText().equals("Your confirmation email is on the way!")) {
			reportStep(emailheadermsg.getText() + " email header msg is displayed and label text verified", "Pass");
		}
		else {
			reportStep("email header msg is not displayed and label text is not verified", "Fail");
		}

		return this;
	}
	
	@Given("Message has correct email from what was registered")
	public Icivics_EducatorReg5 verifyregisteredemaildisplay() throws IOException {
		String emailID = propElement(getPropfile(propname5, "emailID")).getText();
		String email1 = getPropfile("EducatorRegistration/email", "email");
		if (email1.equals(emailID)) {
			reportStep("Registered email Id is verified", "Pass");
		} else {
			reportStep("Registered email Id is verified not are same", "Fail");
		}return this;}
	
	@Given("Verify resend button is clickable")
	public Icivics_EducatorReg5 verifyresendbutton()
	{
	if(clickOn(getPropfile(propname5, "resendbutton"))) {
		reportStep("resend button is clicked successfully", "Pass");
	}else {
		reportStep("resend button is not clicked", "Fail");
		}
	waitTime(3000);
	return this;
	}
	
	@Given("Verify Screen shows confirmation email has been sent")
	public Icivics_EducatorReg5 verifyconfirmationemail() {
	clickOn(getPropfile(propname5, "resendbutton"));
	waitTime(3000);
	
	WebElement confirmationemailheadermsg = propElement(getPropfile(propname5, "confirmationemailheadermsg"));
	if (confirmationemailheadermsg.isDisplayed()&&confirmationemailheadermsg.getText().equals("Confirmation email has been resent.")) {
		reportStep(confirmationemailheadermsg.getText() + " conformation email msg is displayed and text verified", "Pass");
	}
	else {
		reportStep("conformation email msg is not displayed and text is not verified", "Fail");
	}
	return this;
	}
}
