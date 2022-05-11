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
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_EducatorReg3 extends ProjectSpecificMethods {

	public Icivics_EducatorReg3(RemoteWebDriver driver, ExtentTest node, Properties prop) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
	}

	@Given("Given Launch the icivis educatorregistration URL")
	public Icivics_EducatorReg3 launchURL(String URL) {
		navigateto(URL);
		return this;
	}
	
	public Icivics_EducatorReg3 verifywithvaliddata() throws InterruptedException, IOException {
		
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
		
		return this;
	}

	@Given("verify Current page count and print")
	public Icivics_EducatorReg3 verifypagecount3() throws IOException {
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
	
	@Given("Verify clicking on back button will take to previous page 2")
	public Icivics_EducatorReg3 Clickbackbutton() throws InterruptedException, IOException {
		WebElement backbutton = driver.findElement(By.xpath("//button[text()='Back']"));
		backbutton.click();
		waitTime(3000);
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
	
	@And("Verify Grade Level is remembered.")
	public Icivics_EducatorReg3 verifygradelevelremembered() throws IOException {
		WebElement backbutton = driver.findElement(By.xpath("//button[text()='Back']"));
		backbutton.click();
		
		String value = "Middle School";
		List<WebElement> chkBox = driver.findElements(By.xpath("//div[@class='form-checkboxes']/div/label/input"));
		int Size = chkBox.size();
		for (int i = 0; i < Size-1; i++) {
			String val = chkBox.get(i).getAttribute("value");
			if (val.equalsIgnoreCase(value)) {
				if(chkBox.get(i).isSelected())
				{       
					reportStep("Grade level value " + val + " is remembered ", "Pass");
					break;
				} else {
					reportStep("Grade level value " + val + " is not remembered ", "Fail");
					}
				}
		}
		return this;
	}

	@And("Verify Role is remembered.")
	public Icivics_EducatorReg3 verifyroleremembered() throws IOException {
		scrollToTheGivenWebElement("XPATH&//button[text()='Next']");
		String dropdownvalue = "Teacher";		
		String verifyemail = driver.findElement(By.xpath("//select[@id='edit-main-profiles-0-entity-field-user-type']")).getAttribute("value");
		if (verifyemail.equals(dropdownvalue)) {
			reportStep("Role value " + verifyemail + " is remembered ", "Pass");
		} else {
			reportStep("Role value " + verifyemail + " is not remembered ", "Fail");
		}
		return this;
	}
	
	
	@Given("User on Page 3, Verify School or institution field is displayed")
	public Icivics_EducatorReg3 verifypage3schoolfield() {
		
		WebElement Schoolfieldlabel = driver.findElement(By.xpath("(//label[contains(@class,'control-label js-form-required')])[2]"));
		WebElement Schoolfieldtextbox = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[1]"));
		if (Schoolfieldlabel.isDisplayed() && Schoolfieldtextbox.isDisplayed()) {
			reportStep(Schoolfieldlabel.getText() + " text box and label is displayed", "Pass");
		} else {
			reportStep("School or institution text box and label is not displayed", "Fail");
		}
		
		return this;
	}

	@When("User on Page 3, Verify Zip Code field is displayed")
	public Icivics_EducatorReg3 verifypage3zipcodefield() {
		
		WebElement zipcodefieldlabel = driver.findElement(By.xpath("(//label[contains(@class,'control-label js-form-required')])[3]"));
		WebElement zipcodefieldtextbox = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[2]"));
		if (zipcodefieldlabel.isDisplayed() && zipcodefieldtextbox.isDisplayed()) {
			reportStep(zipcodefieldlabel.getText() + " text box and label is displayed", "Pass");
		} else {
			reportStep("Zipcode text box and label is not displayed", "Fail");
		}
		
		return this;
	}
		
	@And("User on Page 3, Verify Teaching State dropdown")
	public Icivics_EducatorReg3 verifypage3TeachingStatefield() {
		WebElement teachingstatelabel = driver.findElement(By.xpath("(//label[contains(@class,'control-label js-form-required')])[1]"));
		WebElement teachingstatedropdown = driver.findElement(By.xpath("//select[contains(@class,'form-select required')]"));
		if (teachingstatelabel.isDisplayed() && teachingstatedropdown.isDisplayed()) {
			reportStep(teachingstatelabel.getText() + " Dropdown and label is displayed", "Pass");
		} else {
			reportStep("Teaching State Dropdown and label is not displayed", "Fail");
		}
		
		return this;
	}
	
	@And("Verify options in the Teaching State dropdown")
	public Icivics_EducatorReg3 verifyteachstatedropdownoptions() throws InterruptedException {
		scrollToTheGivenWebElement("XPATH&//select[@class='form-select required form-control']");
		waitTime(3000);
		WebElement teachstate = driver.findElement(By.xpath("//select[@class='form-select required form-control']"));
		teachstate.click();
		waitTime(3000);
		Select sel = new Select(teachstate);
		if (sel.getFirstSelectedOption().getText().equals("- None -")) {
			reportStep("verified " + sel.getFirstSelectedOption().getText() + " is selected as default in teach state Dropdown","Pass");
		} else {
			reportStep("verified " + sel.getFirstSelectedOption().getText() + " is selected as default in teach state Dropdown","Fail");
		}
		List<WebElement> teachstateoptions = sel.getOptions();
		int size = teachstateoptions.size();
		for (int i = 0; i < size - 1; i++) {
			String options = teachstateoptions.get(i).getText();
			reportStep("verified that " + options + " is present in teach state Dropdown", "Pass");
		}
		reportStep("teach state dropdown is displayed and verified all the available options sucessfully", "Pass");
		return this;
	}

	@Given("Verify enter School or institution name in the textbox")
	public Icivics_EducatorReg3 VerifySchoolfield() {
		String SchoolName = "st.Thomas's School";
		
		WebElement Schoolfield = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[1]"));
		Schoolfield.sendKeys(SchoolName);
		String getschooltext = Schoolfield.getAttribute("value");
		if (getschooltext.equals(SchoolName)) {
			reportStep("Schoolfield text box allows to enter text "+ SchoolName, "Pass");
		} else {
			reportStep("Schoolfield text box does not allow to enter text "+ SchoolName, "Fail");
		}	return this;
	}	
		
	@When("Verify enter Zip code must be in proper 5 or 9 digit form")
	public Icivics_EducatorReg3 Verifyzipcodefield() {
		String Zipcode5 = "12111";
		
		WebElement Zipcodefield = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[2]"));
		Zipcodefield.sendKeys(Zipcode5);
		String getzipcodetext = Zipcodefield.getAttribute("value");
		if (getzipcodetext.equals(Zipcode5)) {
			reportStep("Zipcode text box allows to enter text 5 digit "+ Zipcode5, "Pass");
		} else {
			reportStep("Zipcode text box does not allow to enter text "+ Zipcode5, "Fail");
		}return this;
		}
		
	@When("Verify Teaching state selection from dropdown is working fine")
	public Icivics_EducatorReg3 VerifyTeachingstatefield() {
		String Teachstatevalue = "Idaho";
		WebElement teachingstate = driver.findElement(By.xpath("//select[@id='edit-main-profiles-0-entity-field-teaching-state']"));
		selectDropDownUsingText(teachingstate, Teachstatevalue);
		waitTime(3000);
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		return this;
	}
	
	@And("Verify zipcode display error msg if the zipcode is more than 9 digits")
	public Icivics_EducatorReg3 Verifyzipcodeerrormsg() {
		String Zipcode9 = "123411511";
		String Zipcode11 = "11125439711";
		driver.findElement(By.xpath("//button[@value='Back']")).click();
		waitTime(3000);
		WebElement Zipcodefield = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[2]"));
		Zipcodefield.clear();
		Zipcodefield.sendKeys(Zipcode9);
		reportStep("Zipcode text box allows to enter 9 digit "+ Zipcode9, "Pass");
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		waitTime(3000);
		WebElement password = driver.findElement(By.xpath("//label[@for='edit-pass-pass1']"));
		if (password.isDisplayed()) {
			reportStep("Password field page 4 is displayed", "Pass");
		}else {
			reportStep("Password field page 4 is not displayed", "Fail");
		}
		waitTime(3000);
		scrollToTheGivenWebElement("XPATH&//div[@id='edit-account']//h3[1]");
		click(driver.findElement(By.xpath("//*[@id='edit-back']")));
		waitTime(3000);
		WebElement Zipcodefield1 = driver.findElement(By.xpath("//*[@id='edit-main-profiles-0-entity-field-zip-code-0-value']"));
		Zipcodefield1.clear();
		Zipcodefield1.sendKeys(Zipcode11);
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		waitTime(3000);
		WebElement zipcodeerror = driver.findElement(By.xpath("//div[@role='alert']//p[1]"));
		if (zipcodeerror.isDisplayed()) {
			verifyExactText(propElement("XPATH&//div[@role='alert']//p[1]"), "Zip Code is invalid.");
			reportStep("Zipcode filed text box does not allow to enter more than 9 digit and click next "+ Zipcode11, "Pass");
		}else {
			reportStep("Zipcode filed text box allows to enter more than  9 digit "+ Zipcode11, "Fail");
		}
		return this;
	}

	@Given("Enter invalid School, Zipcode as none for Teacherstate and verify the error messages.")
	public Icivics_EducatorReg3 verifyenterinvaliddata() {
		WebElement Schoolfield = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[1]"));
		clearAndType(Schoolfield, "gfgh^d$fthf&");

		WebElement Zipcodefield = driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[2]"));
		clearAndType(Zipcodefield, "66654789789678");

		WebElement teachingstate = driver.findElement(By.xpath("//select[@id='edit-main-profiles-0-entity-field-teaching-state']"));
		selectDropDownUsingIndex(teachingstate, 0);
		waitTime(3000);
		
		click(driver.findElement(By.xpath("//button[@id='edit-next']")));
		
		WebElement TeachstateError = driver.findElement(By.xpath("(//li[@class='item item--message'])[1]"));
		WebElement zipcodeerror = driver.findElement(By.xpath("(//li[@class='item item--message'])[2]"));
		if (TeachstateError.isDisplayed()&&zipcodeerror.isDisplayed()) {
			verifyExactText(propElement("XPATH&(//li[@class='item item--message'])[1]"), "Teaching state is required for teacher.");
			verifyExactText(propElement("XPATH&(//li[@class='item item--message'])[2]"), "Zip Code is invalid.");
		}else {
			reportStep("Teacherstate and Zipcode filed text box error messages is not verifed", "Fail");
		}
		return this;
	}

	@Given("Click on next without entering any valid data in School, Zipcode as none for Teacherstate and verify the error messages.")
	public Icivics_EducatorReg3 verifyblankfielderrormsg() {
		driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[1]")).clear();
		driver.findElement(By.xpath("(//input[contains(@class,'js-text-full text-full')])[2]")).clear();
		WebElement teachingstate = driver.findElement(By.xpath("//select[@id='edit-main-profiles-0-entity-field-teaching-state']"));
		selectDropDownUsingIndex(teachingstate, 0);
		click(driver.findElement(By.xpath("//button[@id='edit-next']")));
		
		WebElement TeachstateError = driver.findElement(By.xpath("(//li[@class='item item--message'])[1]"));
		WebElement schoolError = driver.findElement(By.xpath("(//li[@class='item item--message'])[2]"));
		WebElement zipcodeerror = driver.findElement(By.xpath("(//li[@class='item item--message'])[3]"));
		if (TeachstateError.isDisplayed() && schoolError.isDisplayed() && zipcodeerror.isDisplayed()) {
			verifyExactText(propElement("XPATH&(//li[@class='item item--message'])[1]"), "Teaching state is required for teacher.");
			verifyExactText(propElement("XPATH&(//li[@class='item item--message'])[2]"), "School is required for teacher.");
			verifyExactText(propElement("XPATH&(//li[@class='item item--message'])[3]"), "Zip Code is required for teacher.");
		}else {
			reportStep("Teacherstate, School and Zipcode filed text box error messages is not verifed", "Fail");
		}
		return this;
	}
	
	@Given("Verify select vaild options and click on next button")
	public Icivics_EducatorReg3 verifyregistrationwithvaliddata() {
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
	
	@Then("verify page 4 is loaded")
	public Icivics_EducatorReg3 verifypage4loaded() throws InterruptedException, IOException {
		
		WebElement page3 = driver.findElement(By.xpath("//label[@for='edit-pass-pass1']"));
		if (page3.isDisplayed()) {
			reportStep("Page 4 is displayed", "Pass");
		}else {
			reportStep("Page 4 is not displayed", "Fail");
		}
		return this;
	}
}
