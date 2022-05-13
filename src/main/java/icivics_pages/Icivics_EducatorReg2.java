package icivics_pages;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_EducatorReg2 extends ProjectSpecificMethods {

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
		
		WebElement username = driver.findElement(By.xpath("//span[@class='name-value']"));
		String username1 = username.getText();
		writePropfile("username", "username", username1);
		
		WebElement firstname = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[1]"));
		firstname.clear();
		firstname.sendKeys("Tripti");
		
		WebElement lastname = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[2]"));
		lastname.clear();
		lastname.sendKeys("Gupta");
		
		WebElement email = driver.findElement(By.xpath("(//input[@type='email'])[1]"));
		email.clear();
		email.sendKeys("tripti.gupta1@gmail.com");
		
		WebElement verifyemail = driver.findElement(By.xpath("(//input[@type='email'])[2]"));
		verifyemail.clear();
		verifyemail.sendKeys("tripti.gupta1@gmail.com");
		
		WebElement nextbutton = driver.findElement(By.xpath("//button[text()='Next']"));
		scrollToTheGivenWebElement("XPATH&//button[text()='Next']");
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

	@Given("verify Current page count 2 and print")
	public Icivics_EducatorReg2 verifypagecount2() throws IOException {
		String propname = "educatorregistration";
		String cssvalue = "background-color";
		String Greycolor = "rgb(88, 89, 91)";
		String Greencolor = "rgb(0, 178, 124)";

		String Step1 = cssgetbefore(getPropfile(propname, "step1ele"), cssvalue, Greencolor);
		String Step2 = cssgetbefore(getPropfile(propname, "step2ele"), cssvalue, Greencolor);
		String Step3 = cssgetbefore(getPropfile(propname, "step3ele"), cssvalue, Greycolor);
		String Step4 = cssgetbefore(getPropfile(propname, "step4ele"), cssvalue, Greycolor);
		String Step5 = cssgetbefore(getPropfile(propname, "step5ele"), cssvalue, Greycolor);

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
		WebElement backbutton = driver.findElement(By.xpath("//button[text()='Back']"));
		backbutton.click();
		waitTime(3000);
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

	@Given("Verify Username is regenerated.")
	public Icivics_EducatorReg2 verifyusernameisnotremembered() throws IOException {

		WebElement username = driver.findElement(By.xpath("//span[@class='name-value']"));
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

		String firstnamevalue = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[1]")).getAttribute("value");
		if (firstnamevalue.equals("Tripti")) {
			reportStep("Firstname value " + firstnamevalue + " is remembered ", "Pass");
		} else {
			reportStep("Firstname value " + firstnamevalue + " is not remembered ", "Fail");
		}
		return this;
	}

	@And("Verify lastname is remembered.")
	public Icivics_EducatorReg2 verifylastnameisremembered() throws IOException {

		String lastname = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[2]"))
				.getAttribute("value");
		if (lastname.equals("Gupta")) {
			reportStep("lastname value " + lastname + " is remembered ", "Pass");
		} else {
			reportStep("lastname value " + lastname + " is not remembered ", "Fail");
		}
		return this;
	}

	@And("Verify email is remembered.")
	public Icivics_EducatorReg2 verifyemailisremembered() throws IOException {
		String email = driver.findElement(By.xpath("(//input[@type='email'])[1]")).getAttribute("value");
		if (email.equals("tripti.gupta1@gmail.com")) {
			reportStep("email value " + email + " is remembered ", "Pass");
		} else {
			reportStep("email value " + email + " is not remembered ", "Fail");
		}
		return this;
	}

	@And("Verify verifyemail is remembered.")
	public Icivics_EducatorReg2 verifyemail2isremembered() throws IOException {
		String verifyemail = driver.findElement(By.xpath("(//input[@type='email'])[2]")).getAttribute("value");
		if (verifyemail.equals("tripti.gupta1@gmail.com")) {
			reportStep("verify email value " + verifyemail + " is remembered ", "Pass");
		} else {
			reportStep("verify email value " + verifyemail + " is not remembered ", "Fail");
		}
		return this;
	}


	@Given("User on Page 2, Verify grade level field and option is displayed as checkbox and nothing is selected as default")
	public Icivics_EducatorReg2 verifygradelevelfield() throws IOException {
		WebElement gradelevellabel = driver
				.findElement(By.xpath("//span[contains(@class,'fieldset-legend js-form-required')]"));
		if (gradelevellabel.isDisplayed()) {
			reportStep(gradelevellabel.getText() + " label is displayed", "Pass");
		} else {
			reportStep("Grade Level label is not displayed", "Fail");
		}
		List<WebElement> checkbox = driver.findElements(By.xpath("//div[@class='form-checkboxes']/div"));
		for (int i = 0; i <= checkbox.size() - 1; i++) {
			checkbox.get(i).isDisplayed();
			String checkboxvalue = checkbox.get(i).getText();
			writePropfile("gradelevel", "value", checkboxvalue);
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
		List<WebElement> checkbox = driver.findElements(By.xpath("//div[@class='form-checkboxes']/div/label/input"));
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
		scrollToTheGivenWebElement("XPATH&//select[@class='form-select required form-control']");
		waitTime(3000);
		WebElement rolelabel = driver
				.findElement(By.xpath("(//label[contains(@class,'control-label js-form-required')])[1]"));
		if (rolelabel.isDisplayed()) {
			reportStep(rolelabel.getText() + " label is displayed", "Pass");
		} else {
			reportStep("Role label is not displayed", "Fail");
		}
		WebElement role = driver.findElement(By.xpath("//select[@class='form-select required form-control']"));
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
		List<WebElement> chkBox = driver.findElements(By.xpath("//div[@class='form-checkboxes']/div/label/input"));
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
		WebElement DropDown = driver
				.findElement(By.xpath("//select[@id='edit-main-profiles-0-entity-field-user-type']"));
		scrollToTheGivenWebElement("XPATH&//select[@class='form-select required form-control']");
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
		WebElement DropDown = driver
				.findElement(By.xpath("//select[@id='edit-main-profiles-0-entity-field-user-type']"));
		selectDropDownUsingIndex(DropDown, 7);
		waitTime(3000);
		WebElement othertextlabel = driver
				.findElement(By.xpath("(//label[contains(@class,'control-label js-form-required')])[2]"));
		if (othertextlabel.isDisplayed()) {
			reportStep(othertextlabel.getText() + " label is displayed", "Pass");
			WebElement othertextbox = driver
					.findElement(By.xpath("//input[contains(@class,'js-text-full text-full')]"));
			othertextbox.isDisplayed();
			reportStep("What is your role? text box is displayed", "Pass");
		} else {
			reportStep("What is your role? text box and label is not displayed", "Fail");
		}
		return this;
	}

	@Given("Verify Grade Level is marked with an asterisk")
	public Icivics_EducatorReg2 verifyGradeLevelAsteriks() throws IOException {
		WebElement DropDown = driver
				.findElement(By.xpath("//select[@id='edit-main-profiles-0-entity-field-user-type']"));
		selectDropDownUsingIndex(DropDown, 7);
		cssgetafter(getPropfile("educatorregistration2", "edureg2.gl*"), "content", "\"*\"");
		reportStep("Asteriks * is present in the Grade Level label", "Pass");
		return this;
	}

	@When("Verify Role is marked with an asterisk")
	public Icivics_EducatorReg2 verifyRoleAsteriks() throws IOException {
		cssgetafter(getPropfile("educatorregistration2", "edureg2.role*"), "content", "\"*\"");
		reportStep("Asteriks * is present in the Role label", "Pass");
		return this;
	}

	@And("Verify What is your role? is marked with an asterisk")
	public Icivics_EducatorReg2 verifyWhatisyourroleAsteriks() throws IOException {
		cssgetafter(getPropfile("educatorregistration2", "edureg2.Wiyr*"), "content", "\"*\"");
		reportStep("Asteriks * is present in the What is your role? label", "Pass");
		return this;
	}

	@Given("Click on Next button and verify grade and role error msg")
	public Icivics_EducatorReg2 verifygradeandroleerrormsg() {
		scrollToTheGivenWebElement("XPATH&//select[@class='form-select required form-control']");
		WebElement DropDown = driver
				.findElement(By.xpath("//select[@id='edit-main-profiles-0-entity-field-user-type']"));
		selectDropDownUsingIndex(DropDown, 0);
		click(driver.findElement(By.xpath("//button[.='Next']")));
		
		WebElement errormsgbox = driver.findElement(By.xpath("//div[@role='alert']"));
		if (errormsgbox.isDisplayed()) {
			reportStep("Error msg box Is displayed", "Pass");
			verifyExactText(propElement("XPATH&//li[@class='item item--message'][1]"), "Role is required for teacher.");
			verifyExactText(propElement("XPATH&//li[@class='item item--message'][2]"),
					"Levels taught is required for teacher.");
		} else {
			reportStep("Error msg box Is not displayed", "Fail");
		}
		return this;
	}

	@When("Click on Next button and verify grade and what is your role error msg")
	public Icivics_EducatorReg2 verifygradeandwhatisyourroleerrormsg() {
		scrollToTheGivenWebElement("XPATH&//select[@class='form-select required form-control']");
		WebElement DropDown = driver.findElement(By.xpath("//select[@id='edit-main-profiles-0-entity-field-user-type']"));
		selectDropDownUsingIndex(DropDown, 7);
		click(driver.findElement(By.xpath("//button[.='Next']")));
		
		WebElement errormsgbox = driver.findElement(By.xpath("//div[@role='alert']"));
		if (errormsgbox.isDisplayed()) {
			reportStep("Error msg box Is displayed", "Pass");
			verifyExactText(propElement("XPATH&//li[@class='item item--message'][1]"),
					"What is your role? field is required.");
			verifyExactText(propElement("XPATH&//li[@class='item item--message'][2]"),
					"Levels taught is required for teacher.");
		} else {
			reportStep("Error msg box Is not displayed", "Fail");
		}
		return this;
	}

	@Given("Verify Error message is in pink box at top")
	public Icivics_EducatorReg2 verifyerrormsgboxcolor() {
		click(driver.findElement(By.xpath("//button[.='Next']")));
		String expectedcolor = "rgba(169, 68, 66, 1)";
		String expectedbgcolor = "rgba(242, 222, 222, 1)";
		WebElement Errormsgbox = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
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
		String value = "Middle School";
		List<WebElement> chkBox = driver.findElements(By.xpath("//div[@class='form-checkboxes']/div/label/input"));
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
		
		String dropdownvalue = "Teacher";
		WebElement roleDropDown = driver.findElement(By.xpath("//select[@id='edit-main-profiles-0-entity-field-user-type']"));
		selectDropDownUsingValue(roleDropDown, dropdownvalue);
		reportStep(dropdownvalue + " is selected", "Pass");
		waitTime(3000);

		click(driver.findElement(By.xpath("//button[.='Next']")));
		waitTime(3000);
		return this;
	}
	
	@Given("verify page 3 is loaded")
	public Icivics_EducatorReg2 verifypage3loaded() throws InterruptedException, IOException {
		waitTime(5000);
		
		WebElement page2 = driver.findElement(By.xpath("(//div[contains(@class,'form-item js-form-item')]//label)[2]"));
		if(page2.isDisplayed()) {
			reportStep("Page 3 is displayed", "Pass");
			}else {
				reportStep("Page 3 is not displayed", "Fail");
			}
		return this;
	}
}