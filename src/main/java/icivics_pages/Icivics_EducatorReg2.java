package icivics_pages;

import java.util.List;
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

public class Icivics_EducatorReg2 extends ProjectSpecificMethods {

	public Icivics_EducatorReg2(RemoteWebDriver driver, ExtentTest node, Properties prop) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
	}

	@Given("Launch the icivis educatorregistration URL")
	public Icivics_EducatorReg2 launchURL(String URL) {
		navigateto(URL);
		return this;
	}

	@When("Validate back button on clicking will take to previous page")
	public Icivics_EducatorReg2 Clickbackbutton() throws InterruptedException {
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
		WebElement backbutton = driver.findElement(By.xpath("//button[text()='Back']"));
		backbutton.click();
	waitTime(3000);
		return this;

	}

	@When("Validate grade level field is present")
	public Icivics_EducatorReg2 verifygradelevelfield() {
		/*
		 * WebElement gradelevel=driver.findElement(By.
		 * xpath("//span[contains(@class,'fieldset-legend js-form-required')]"));
		 * if(gradelevel.isDisplayed()) { reportStep("Gradelevel is displayed", "Pass");
		 * } else { reportStep("Gradelevel is not displayed", "Fail"); }
		 */
		List<WebElement> checkbox = driver.findElements(By.xpath("//div[@class='form-checkboxes']"));

		for (int i = 1; i <= checkbox.size(); i++) {

			checkbox.get(i).isDisplayed();

		}
		reportStep("Checkbox is displayed", "pass");
		return this;
	}

	@Then("Validate role field is present")
	public Icivics_EducatorReg2 verifyrolefield() throws InterruptedException {
		WebElement nextbutton = driver.findElement(By.xpath("//button[text()='Next']"));
		nextbutton.click();
		Thread.sleep(3000);
		WebElement role = driver.findElement(By.xpath("//select[@class='form-select required form-control']"));
		Select sel = new Select(role);
		List<WebElement> roleoptions = sel.getOptions();
		int size = roleoptions.size();
		for (int i = 0; i < size; i++) {
			String options = roleoptions.get(i).getText();
			System.out.println(options);
		}
		reportStep("Roledropdown is displayed sucessfully", "pass");
		return this;
	}

	@When("Validate Grade level can have >1 value selected")
	public Icivics_EducatorReg2 verifygradelevelselection() {
		List<WebElement> chkBox = driver.findElements(By.xpath("//div[@class='form-checkboxes']"));

		int Size = chkBox.size();

		for (int i = 1; i < Size; i++) {
			String val = chkBox.get(i).getAttribute("value");
			if (val.equalsIgnoreCase("//div[@class='form-checkboxes']")) {

				chkBox.get(i).isSelected();
				System.out.println(" All check box is selected");
			}
		}
		return this;
	}

	@Then("Validate Role can have only 1 value selected")
	public Icivics_EducatorReg2 verifyroledropdown() {
		WebElement testDropDown = driver.findElement(By.xpath("//select[@id='edit-main-profiles-0-entity-field-user-type']"));
		selectDropDownUsingIndex(testDropDown,1);
		
		waitTime(3000);
		return this;

	}
	@Then("Validate on selecting other from dropdown display Other text field appears")
	public Icivics_EducatorReg2 selectotherdromdropdown() {
		WebElement testDropDown = driver.findElement(By.xpath("//select[@id='edit-main-profiles-0-entity-field-user-type']"));
		selectDropDownUsingIndex(testDropDown,7);
		waitTime(3000);
		return this;
	}

	@Then("Click on Next button and verify the error msg")
	public Icivics_EducatorReg2 clicknextbutton() {
		clickOn("XPATH&//button[.='Next']");
		
		reportStep("Error msg Is displayed", "Pass");
		return this;
	}

	@When("Validate Error message is in pink box at top")
	public Icivics_EducatorReg2 backgroundcolor() {
		String colr = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))
				.getCssValue("color");
		String bckgclr = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))
				.getCssValue("background-color");
		System.out.println(colr);
		System.out.println(bckgclr);
		return this;
	}

	@Then("Validate select the options and click on next button")
	public Icivics_EducatorReg2 registrationpage2done() {
		WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
		checkbox.isSelected();
		waitTime(3000);
		checkbox.click();
		reportStep("checkbox is selected", "Pass");
		
	
		WebElement testDropDown = driver.findElement(By.xpath("//select[@id='edit-main-profiles-0-entity-field-user-type']"));
		selectDropDownUsingIndex(testDropDown,1);
		waitTime(3000);

	
		clickOn("XPATH&//button[.='Next']");
		waitTime(3000);
		return this;
		
	}

}