package icivics_pages;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_EducatorReg5 extends ProjectSpecificMethods {

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
		
		String pwd = "TestIcivics@123";
		WebElement password = driver.findElement(By.xpath("//input[@class='password-field js-password-field form-text required form-control']"));
		password.clear();
		password.sendKeys(pwd);
		
		
		WebElement confirmpassword = driver.findElement(By.xpath("//input[contains(@class,'password-confirm js-password-confirm')]"));
		confirmpassword.clear();
		confirmpassword.sendKeys(pwd);
		
		WebElement agreechkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		
		if (!agreechkbox1.isSelected()) {
			agreechkbox1.click();
		}
		
		click(driver.findElement(By.xpath("//button[@title='Finish']")));
		waitTime(3000);
		
		return this;
	}
	
	@Then("verify Current page count 5 and print")
	public Icivics_EducatorReg5 verifypagecount5() throws IOException {
		String propname = "educatorregistration2";
		String cssvalue = "background-color";
		String Greencolor = "rgb(0, 178, 124)";

		String Step1 = cssgetbefore(getPropfile(propname, "step1ele"), cssvalue, Greencolor);
		String Step2 = cssgetbefore(getPropfile(propname, "step2ele"), cssvalue, Greencolor);
		String Step3 = cssgetbefore(getPropfile(propname, "step3ele"), cssvalue, Greencolor);
		String Step4 = cssgetbefore(getPropfile(propname, "step4ele"), cssvalue, Greencolor);
		String Step5 = cssgetbefore(getPropfile(propname, "step5ele"), cssvalue, Greencolor);

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
		WebElement emailmsg = driver.findElement(By.xpath("//div[@class='verification-email-holder']//div[1]"));
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
		WebElement emailheadermsg = driver.findElement(By.xpath("//div[@class='register-form-header-text']//h2[1]"));
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
		String emailID = driver.findElement(By.xpath("(//div[@class='verification-email-holder']//div)[2]")).getText();
		String email1 = getPropfile("email", "email");
		if (email1.equals(emailID)) {
			reportStep("Registered email Id is verified", "Pass");
		} else {
			reportStep("Registered email Id is verified not are same", "Fail");
		}return this;}
	
	@Given("Verify resend button is clickable")
	public Icivics_EducatorReg5 verifyresendbutton()
	{
	if(clickOn("XPATH&//div[@class='verification-resend-button']//a[1]")) {
		reportStep("resend button is clicked successfully", "Pass");
	}else {
		reportStep("resend button is not clicked", "Fail");
		}
	waitTime(3000);
	return this;
	}
	
	@Given("Verify Screen shows confirmation email has been sent")
	public Icivics_EducatorReg5 verifyconfirmationemail() {
	clickOn("XPATH&//div[@class='verification-resend-button']//a[1]");
	waitTime(3000);
	
	WebElement confirmationemailheadermsg = driver.findElement(By.xpath("//div[@role='status']//p[1]"));
	if (confirmationemailheadermsg.isDisplayed()&&confirmationemailheadermsg.getText().equals("Confirmation email has been resent.")) {
		reportStep(confirmationemailheadermsg.getText() + " conformation email msg is displayed and text verified", "Pass");
	}
	else {
		reportStep("conformation email msg is not displayed and text is not verified", "Fail");
	}
	return this;
	}
}
