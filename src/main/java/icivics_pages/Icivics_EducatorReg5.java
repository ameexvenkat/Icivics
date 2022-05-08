package icivics_pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
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

	@Then("verify the message")
	public Icivics_EducatorReg5 msgdisplay() {
		WebElement welcomemsg = driver.findElement(By.xpath("//div[text()='Check your inbox at:']"));
		if (welcomemsg.isDisplayed()) {
			reportStep("welcomemsg is displayed", "Pass");
		}

		else {
			reportStep("welcomemsg is not displayed", "Fail");
		}

		return this;
	}

	@Then("Verify Message says confirmation email is on its way")
	public Icivics_EducatorReg5 emailmsg()
	{
		WebElement emailmsg = driver.findElement(By.xpath("//h2[text()='Your confirmation email is on the way!']"));
		if (emailmsg.isDisplayed()) {
			reportStep("emailmsg is displayed", "Pass");
		}

		else {
			reportStep("welcomemsg is not displayed", "Fail");
		}

		return this;
	}
	@And("Verifybutton is clickable")
	public Icivics_EducatorReg5 resendbutton()
	{
		clickOn("XPATH&//a[.='RESEND CONFIRMATION']");
	
	waitTime(3000);
	return this;
	}
}
