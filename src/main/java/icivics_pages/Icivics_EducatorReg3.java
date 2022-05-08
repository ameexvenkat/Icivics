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

public class Icivics_EducatorReg3 extends ProjectSpecificMethods {

	public Icivics_EducatorReg3(RemoteWebDriver driver, ExtentTest node, Properties prop) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
	}

	@Given("Launch the icivis educatorregistration URL")
	public Icivics_EducatorReg3 launchURL(String URL) {
		navigateto(URL);
		return this;
	}

	@Then("Can you select Back to proceed to the previous page?")
	public Icivics_EducatorReg3 clickbackbutton() {
		WebElement firstname = driver
				.findElement(By.xpath("(//input[@class='js-text-full text-full form-text required form-control'])[1]"));
		firstname.sendKeys("Tripti");
		WebElement lastname = driver
				.findElement(By.xpath("(//input[@class='js-text-full text-full form-text required form-control'])[2]"));
		lastname.sendKeys("Gupta");
		WebElement email = driver.findElement(By.xpath("(//input[@class='form-email required form-control'])[1]"));
		email.sendKeys("tripti.gupta@gmail.com");
		WebElement verifyemail = driver
				.findElement(By.xpath("(//input[@class='form-email required form-control'])[2]"));
		verifyemail.sendKeys("tripti.gupta@gmail.com");
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

		clickOn("XPATH&//button[@id='edit-back']");
		waitTime(3000);
		return this;
	}

	@When("all the fields filled for page 1,page 2 validate page 3 fields")
	public Icivics_EducatorReg3 page3fields() {

		clickOn("XPATH&//button[.='Next']");
		waitTime(3000);

		WebElement Schoolfield = driver
				.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[1]"));
		if (Schoolfield.isDisplayed()) {

			reportStep("Schoolfield field is displayed", "Pass");
		}

		else {
			reportStep("Schoolfield field is not displayed", "Fail");
		}
		WebElement Zipcodefield = driver
				.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[2]"));
		if (Zipcodefield.isDisplayed()) {

			reportStep("Zipcodefield is displayed", "Pass");
		}

		else {
			reportStep("Zipcodefield  is not displayed", "Fail");
		}

		WebElement teachingstate = driver.findElement(By.xpath("//select[@class='form-select required form-control']"));
		if (teachingstate.isDisplayed()) {

			reportStep("teachingstate is displayed", "Pass");
		}

		else {
			reportStep("teachingstate is not displayed", "Fail");
		}
		return this;
	}

	@Then("provide data to page3 fields")
	public Icivics_EducatorReg3 enterdata() {
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

		return this;

	}

	@Then("After submit, error message appears list errors")
	public Icivics_EducatorReg3 enterinvaliddata() {
		WebElement Schoolfield = driver
				.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[1]"));
		Schoolfield.clear();
		Schoolfield.sendKeys("gfgh^d$fthf&");
		WebElement Zipcodefield = driver
				.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[2]"));
		Zipcodefield.clear();
		Zipcodefield.sendKeys("66654789789678");

		WebElement teachingstate = driver
				.findElement(By.xpath("//select[@id='edit-main-profiles-0-entity-field-teaching-state']"));
		selectDropDownUsingIndex(teachingstate, 0);
		waitTime(3000);
		clickOn("XPATH&//button[@id='edit-next']");
		return this;

	}

	@Then("After submit, error message appears list errors")
	public Icivics_EducatorReg3 blankfield() {
		WebElement Schoolfield = driver
				.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[1]"));
		Schoolfield.clear();
		WebElement Zipcodefield = driver
				.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[2]"));
		Zipcodefield.clear();

		WebElement teachingstate = driver
				.findElement(By.xpath("//select[@id='edit-main-profiles-0-entity-field-teaching-state']"));
		selectDropDownUsingIndex(teachingstate, 0);
		waitTime(3000);
		clickOn("XPATH&//button[@id='edit-next']");
		return this;
	}

	@When("Goes to page 4")
	public Icivics_EducatorReg3 validdata() {
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
		return this;

	}
}
