package icivics_pages;

import java.io.IOException;
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
		
		if (Step1.equals(Greencolor)&& Step2.equals(Greycolor) && Step3.equals(Greycolor) && Step4.equals(Greycolor)&& Step5.equals(Greycolor)) {
		reportStep("you are currently viewing page 1 in the breadcrumbs", "Pass");
		}else {
			reportStep("unable to identify which page you are currently viewing in the breadcrumbs", "Fail");
		}
		
		return this;
	}

	@Then("Verify the text fields")
	public Icivics_EducatorReg1 Verifytextfields() {
		WebElement usernamelabel = driver.findElement(By.xpath("//span[text()='Username:']"));
		if (usernamelabel.isDisplayed()) {
			reportStep("Username label is displayed", "Pass");
		} else {
			reportStep("Username label box is not displayed", "Fail");
		}
		WebElement username = driver.findElement(By.xpath("//span[@class='name-value']"));
		if (username.isDisplayed()) {

			reportStep("username field is displayed", "Pass");
		}

		else {
			reportStep("username field is not displayed", "Fail");
		}

		WebElement firstname = driver
				.findElement(By.xpath("(//input[@class='js-text-full text-full form-text required form-control'])[1]"));
		if (firstname.isDisplayed()) {

			reportStep("Firstname field is displayed", "Pass");
		}

		else {
			reportStep("Firstname field is not displayed", "Fail");
		}

		WebElement lastname = driver
				.findElement(By.xpath("(//input[@class='js-text-full text-full form-text required form-control'])[2]"));
		if (lastname.isDisplayed()) {

			reportStep("Lastname field is displayed", "Pass");
		} else {
			reportStep("Lastname field is not displayed", "Fail");
		}

		WebElement email = driver.findElement(By.xpath("(//input[@class='form-email required form-control'])[1]"));
		if (email.isDisplayed()) {

			reportStep("email field is displayed", "Pass");
		} else {
			reportStep("email field is not displayed", "Fail");
		}

		WebElement verifyemail = driver
				.findElement(By.xpath("(//input[@class='form-email required form-control'])[2]"));
		if (verifyemail.isDisplayed()) {

			reportStep("verifyemail field is displayed", "Pass");
		} else {
			reportStep("verifyemail field is not displayed", "Fail");
		}
		return this;
	}

	@Then("Verify username is pregenerated")
	public Icivics_EducatorReg1 usernamepregenerated() throws InterruptedException {
		WebElement username = driver.findElement(By.xpath("//span[@class='name-value']"));
		waitTime(6000);
		String username1 = username.getText();

		if (!username1.isEmpty()) {
			reportStep("Username field is not empty,it is pregenerated and Verified successfully", "Pass");
		} else {
			reportStep("Username field is empty", "Fail");
		}

		return this;
	}

	public Icivics_EducatorReg1 usernamepgeneratedrandomly() throws InterruptedException {
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

	@Then("Enter text in all the fields")
	public Icivics_EducatorReg1 entertextinfields() throws InterruptedException {

		WebElement firstname = propElement(
				"XPATH&(//input[@class='js-text-full text-full form-text required form-control'])[1]");
		clearAndType(firstname, "Tripti");

		WebElement lastname = propElement(
				"XPATH&(//input[@class='js-text-full text-full form-text required form-control'])[2]");
		clearAndType(lastname, "Gupta");

		WebElement email = propElement("XPATH&(//input[@class='form-email required form-control'])[1]");
		clearAndType(email, "tripti.gupta@ameexusa.com");

		WebElement verifyemail = propElement("XPATH&(//input[@class='form-email required form-control'])[2]");
		clearAndType(verifyemail, "tripti.gupta@ameexusa.com");
		return this;

	}

	@Then("Validate all the fields have Asterisks")
	public Icivics_EducatorReg1 Asterisks() throws IOException {

		cssgetafter(getPropfile("educatorregistration", "edureg.fn*"), "content", "\"*\"");
		cssgetafter(getPropfile("educatorregistration", "edureg.ln*"), "content", "\"*\"");
		cssgetafter(getPropfile("educatorregistration", "edureg.email*"), "content", "\"*\"");
		cssgetafter(getPropfile("educatorregistration", "edureg.verifyemail*"), "content", "\"*\"");
		return this;

	}

	@Then("Hover on email/verifyemail and verify the result")
	public Icivics_EducatorReg1 hoveronemailfield() throws InterruptedException {
		String email = "XPATH&(//input[@type='email'])[1]";
		mouseOverAction(email);
		waitTime(3000);
		verifyExactAttribute(locateElement(email), "data-original-title",
				"A valid email address. All emails from the system will be sent to this address. The email address is not made public and will only be used if you wish to receive a new password or wish to receive certain news or notifications by email.");
		String verifyemail = "XPATH&(//input[@type='email'])[2]";
		mouseOverAction(verifyemail);
		waitTime(3000);
		return this;
	}

//label[text()='First Name']
	@Then("Enter invalid first name")
	public Icivics_EducatorReg1 Enterinvalidfirstname() throws InterruptedException {
		WebElement firstname = driver
				.findElement(By.xpath("(//input[@class='js-text-full text-full form-text required form-control'])[1]"));
		if (firstname.isDisplayed()) {

			firstname.clear();
			waitTime(3000);
			firstname.sendKeys("14344433%");
			reportStep("Firstname field is displayed", "Pass");
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
			Thread.sleep(3000);
			lastname.sendKeys("%ttt#12");
			reportStep("Lastname field is displayed", "Pass");
		} else {
			reportStep("Lastname field is not displayed", "Fail");
		}
		return this;
	}

	@And("Enter invalid email")

	public Icivics_EducatorReg1 Enterinvalidemailfield() throws InterruptedException {
		WebElement email = driver.findElement(By.xpath("(//input[@class='form-email required form-control'])[1]"));
		if (email.isDisplayed()) {

			email.clear();
			Thread.sleep(3000);
			email.sendKeys("gdfsgadvjh@688");
			reportStep("email field is displayed", "Pass");
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
			verifyemail.sendKeys("gdfsgadvjh@688");
			reportStep("verifyemail field is displayed", "Pass");
		} else {
			reportStep("verifyemail field is not displayed", "Fail");
		}
		return this;
	}

	@And("click on next button")
	public Icivics_EducatorReg1 clicknextbutton() {
		WebElement nextbutton = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
		nextbutton.click();

		return this;
		// need to provide the logic on entering invalid valid values error msg will
		// display

	}

	@Then("enter all the fields except verifyemail, click on next button and verify error msg")
	public Icivics_EducatorReg1 verifyerrormsgforblankfield() throws InterruptedException {
		clickOn("XPATH&//button[contains(@class,'icon-before button')]");

		WebElement firstnamealertmsg = driver.findElement(By.xpath("//li[text()='Field First Name is required']"));
		verifyExactText(firstnamealertmsg, "Field First Name is required");

		WebElement lastnamealertmsg = driver.findElement(By.xpath("//li[text()='Field Last Name is required']"));
		verifyExactText(lastnamealertmsg, "Field Last Name is required");

		WebElement alertmsg = driver.findElement(By.xpath("//li[text()='2 errors have been found: ']"));
		verifyPartialText(alertmsg, "2 errors have been found:");

		WebElement emailalertmsg = driver
				.findElement(By.xpath("(//div[@class='form-item--error-message alert alert-danger alert-sm'])[1]"));
		verifyPartialText(emailalertmsg, "Email address field is required.");

		WebElement verifyemailalertmsg = driver
				.findElement(By.xpath("(//div[@class='form-item--error-message alert alert-danger alert-sm'])[2]"));
		verifyPartialText(verifyemailalertmsg, "Verify email address field is required.");

		return this;
	}

	@When("Validate click on next button error messages will display")
	public Icivics_EducatorReg1 errormsgdisplay() throws InterruptedException {
		WebElement firstname = driver
				.findElement(By.xpath("(//input[@class='js-text-full text-full form-text required form-control'])[1]"));
		firstname.clear();
		WebElement lastname = driver
				.findElement(By.xpath("(//input[@class='js-text-full text-full form-text required form-control'])[2]"));
		lastname.clear();
		WebElement email = driver.findElement(By.xpath("(//input[@class='form-email required form-control'])[1]"));
		email.clear();

		email.clear();
		WebElement nextbutton = driver.findElement(By.xpath("//button[text()='Next']"));
		nextbutton.click();
		Thread.sleep(3000);

		return this;
	}

	@When("Enter all the data in fields and click on next button")
	public Icivics_EducatorReg1 registrationpage1done() throws InterruptedException {
		WebElement firstname = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[1]"));

		firstname.sendKeys("Tripti");
		WebElement lastname = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[2]"));
		lastname.sendKeys("Gupta");
		WebElement email = driver.findElement(By.xpath("(//input[contains(@class,'form-email required')])[1]"));
		email.sendKeys("tripti.gupta@gmail.com");
		WebElement verifyemail = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
		verifyemail.sendKeys("tripti.gupta@gmail.com");
		WebElement nextbutton = driver.findElement(By.xpath("//button[text()='Next']"));
		nextbutton.click();
		Thread.sleep(3000);
		return this;
	}
}
