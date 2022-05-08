package icivics_pages;

import java.util.Properties;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

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

	@When("click on back button")
	public Icivics_EducatorReg4 clickbackbutton() {
		WebElement firstname = driver
				.findElement(By.xpath("(//input[@class='js-text-full text-full form-text required form-control'])[1]"));
		firstname.sendKeys("Tripti");
		WebElement lastname = driver
				.findElement(By.xpath("(//input[@class='js-text-full text-full form-text required form-control'])[2]"));
		lastname.sendKeys("Gupta");
		WebElement email = driver.findElement(By.xpath("(//input[@class='form-email required form-control'])[1]"));
		email.sendKeys("test2@ameexusa.com");
		WebElement verifyemail = driver
				.findElement(By.xpath("(//input[@class='form-email required form-control'])[2]"));
		verifyemail.sendKeys("test2@ameexusa.com");
		WebElement nextbutton = driver.findElement(By.xpath("//button[text()='Next']"));
		nextbutton.click();
		waitTime(3000);
		WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
		checkbox.isSelected();
		waitTime(3000);
		checkbox.click();
		reportStep("checkbox is selected", "Pass");

		WebElement testDropDown = driver
				.findElement(By.xpath("//select[@id='edit-main-profiles-0-entity-field-user-type']"));
		Select dropdown = new Select(testDropDown);
		dropdown.selectByValue("Teacher");
		waitTime(3000);

		clickOn("XPATH&//button[.='Next']");
		waitTime(3000);
		WebElement Schoolfield = driver
				.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[1]"));
		Schoolfield.sendKeys("st.Thomas's");
		WebElement Zipcodefield = driver
				.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[2]"));
		Zipcodefield.sendKeys("11111");

		WebElement teachingstate = driver
				.findElement(By.xpath("//select[@id='edit-main-profiles-0-entity-field-teaching-state']"));
		selectDropDownUsingIndex(teachingstate, 15);
		waitTime(3000);
		clickOn("XPATH&//button[@id='edit-next']");
		waitTime(3000);
		clickOn("XPATH&//button[@type='submit']");
		scrollToTheGivenWebElement("XPATH&//button[@id='edit-next']");

		waitTime(3000);
		return this;
	}

	@Then("Validate all the fields for page4")
	public Icivics_EducatorReg4 verifyfield() {
		clickOn("XPATH&//button[@id='edit-next']");
		WebElement password = driver.findElement(
				By.xpath("//input[@class='password-field js-password-field form-text required form-control']"));
		if (password.isDisplayed()) {

			reportStep("password field is displayed", "Pass");
		}

		else {
			reportStep("password field is not displayed", "Fail");
		}
		WebElement confirmpassword = driver.findElement(
				By.xpath("//input[@class='password-confirm js-password-confirm form-text required form-control']"));

		if (confirmpassword.isDisplayed()) {

			reportStep("confirmpassword field is displayed", "Pass");
		}

		else {
			reportStep("confirmpassword field is not displayed", "Fail");
		}
		WebElement signup = driver.findElement(By.xpath("//input[@id='edit-bsd-list-forms']"));
		if (signup.isDisplayed()) {

			reportStep("signup field is displayed", "Pass");
		}

		else {
			reportStep("signup field is not displayed", "Fail");

		}
		WebElement agreeterms = driver.findElement(By.xpath("//input[@id='edit-agreement']"));
		if (agreeterms.isDisplayed()) {

			reportStep("agreeterms field is displayed", "Pass");
		}

		else {
			reportStep("agreeterms field is not displayed", "Fail");

		}
		return this;

	}

	@Then("Is the Sign Up for emails box checked by default")
	public Icivics_EducatorReg4 signupcheckbox() {
		WebElement signupcheckbox = driver.findElement(By.xpath("(//input[@class='form-checkbox'])[1]"));

		signupcheckbox.click();
		waitTime(3000);
		
		scrollToTheGivenWebElement("XPATH&//button[@id='edit-back']");
		waitTime(3000);
		return this;
	}

	@Then("enter data in fields")
	public Icivics_EducatorReg4 enterpassword() {
		WebElement password = driver.findElement(
				By.xpath("//input[@class='password-field js-password-field form-text required form-control']"));

		password.sendKeys("test@1234");
		WebElement confirmpassword = driver.findElement(
				By.xpath("//input[@class='password-confirm js-password-confirm form-text required form-control']"));
		confirmpassword.sendKeys("test@1234");
		waitTime(3000);
		if (password == confirmpassword) {
			reportStep("Password is matched", "Pass");
		} else {
			reportStep("Password is not matched", "Fail");
		}

		clickOn("XPATH&(//input[@class='form-checkbox'])[1]");
		waitTime(3000);

		clickOn("XPATH&//input[@id='edit-agreement']");
		waitTime(3000);
		scrollToTheGivenWebElement("XPATH&//button[@type='submit']");
		waitTime(3000);
		return this;
	}

	@Then("Hovered password field")
	public Icivics_EducatorReg4 hoverpasswordbutton() {
		String passwordfield = "XPATH&//input[@class='password-field js-password-field form-text required form-control']";
		mouseOverAction(passwordfield);
		reportStep("Password is MouseHowered successfully", "Pass");
		waitTime(3000);
		String confirmpassword = "XPATH&//input[@class='password-confirm js-password-confirm form-text required form-control']";
		mouseOverAction(confirmpassword);
		reportStep("confirmPassword is MouseHowered successfully", "Pass");
		waitTime(3000);

		return this;
	}

	@Then("Validate the password strength")
	public Icivics_EducatorReg4 passwordstrength() {
		WebElement password = driver.findElement(
				By.xpath("//input[@class='password-field js-password-field form-text required form-control']"));
		password.clear();
		password.sendKeys("Test@123456");
		waitTime(3000);
		password.clear();
		password.sendKeys("Test@1234567");
		waitTime(3000);
		return this;
	}

	@Then("enter text in confirm password")
	public Icivics_EducatorReg4 confirmpassword() {
		WebElement password = driver.findElement(
				By.xpath("//input[@class='password-field js-password-field form-text required form-control']"));
		WebElement confirmpassword = driver.findElement(
				By.xpath("//input[@class='password-confirm js-password-confirm form-text required form-control']"));
		confirmpassword.clear();
		confirmpassword.sendKeys("Test@123456");
		if (confirmpassword == password) {
			reportStep("confirmPassword is display yes ", "Pass");
		} else {
			reportStep("confirmPassword is display No ", "Fail");
		}
		scrollToTheGivenWebElement("XPATH&//input[@id='edit-agreement']");
		waitTime(3000);
		return this;
	}

	@Then("Errors are displayed in red")
	public Icivics_EducatorReg4 enterinvalidtext() {
		
		WebElement confirmpassword = driver.findElement(
				By.xpath("//input[@class='password-confirm js-password-confirm form-text required form-control']"));
		confirmpassword.clear();
		waitTime(3000);
		WebElement finishbutton=driver.findElement(By.xpath("//button[@id='edit-submit']"));
		finishbutton.click();
		waitTime(3000);
		
		return this;
	}
	@Then("enter all data and click on finish")
	public Icivics_EducatorReg4 Entervaliddata()
	{
		//WebElement password = driver.findElement(
			//By.xpath("//input[@class='password-field js-password-field form-text required form-control']"));
	WebElement confirmpassword = driver.findElement(
			By.xpath("//input[@class='password-confirm js-password-confirm form-text required form-control']"));
	
	confirmpassword.sendKeys("Test@1234567");

	waitTime(3000);
	clickOn("XPATH&//button[@id='edit-submit']");
	waitTime(3000);
	clickOn("XPATH&//a[.='RESEND CONFIRMATION']");
	waitTime(3000);
		return this;
	}
	
}
