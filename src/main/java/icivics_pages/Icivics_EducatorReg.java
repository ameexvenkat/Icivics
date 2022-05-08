package icivics_pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import projectSpecific.base.ProjectSpecificMethods;

public class Icivics_EducatorReg extends ProjectSpecificMethods {

	public Icivics_EducatorReg(RemoteWebDriver driver, ExtentTest node, Properties prop) {
		this.driver = driver;
		this.node = node;
		this.prop = prop;
	}

	@Given("Launch the icivis educatorregistration URL")
	public Icivics_EducatorReg launchURL(String URL) {
		navigateto(URL);
		return this;
	}

	@When("Educatorregistration page is verified successfully")
	public Icivics_EducatorReg verifyeducatorpage(String URL) {
		verifyUrlOfThePage(URL);
		return this;
	}

	@And("Pagecounter is verified successfully")
	public Icivics_EducatorReg pagecounter() throws IOException {
		WebElement Pagecounter = driver.findElement(By.xpath("//div[@class='register-form-steps-wrapper']/ul"));
		if (Pagecounter.isDisplayed()) {
			reportStep("Page counter 1-5 is Displayed", "Pass");
		} else
			reportStep("Page counter 1-5 is Not Displayed", "Fail");
		return this;
	}

	@And("Username verified successfully")
	public Icivics_EducatorReg username() throws InterruptedException {
		WebElement usernamelabel = driver.findElement(By.xpath("//span[text()='Username:']"));
		if (usernamelabel.isDisplayed()) {
			reportStep("Username label is displayed", "Pass");
		} else {
			reportStep("Username label box is not displayed", "Fail");
		}
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

	@And("Reload button verified")
	public Icivics_EducatorReg reloadbutton() {
		WebElement randombutton = driver.findElement(By.xpath("//span[@class='icon reload']//i[1]"));
		if (randombutton.isDisplayed()) {
			reportStep("Randomize button is Verified successfully", "Pass");
		}
		return this;
	}

	@And("Firstname is verified successfully")
	public Icivics_EducatorReg firstname() {
		WebElement firstnamelabel = driver.findElement(By.xpath("//label[text()='First Name']"));
		if (firstnamelabel.isDisplayed()) {
			reportStep("First name label is displayed", "Pass");
		} else {
			reportStep("First name label box is not displayed", "Fail");
		}

		WebElement firstname = driver
				.findElement(By.xpath("//*[@id='edit-main-profiles-0-entity-field-first-name-0-value']"));
		String CLbox = firstname.getAttribute("value");
		if (CLbox.isEmpty()) {
			reportStep("First name text box is Blank", "Pass");
		} else {
			reportStep("First name text box is not Blank", "Fail");
		}
		return this;
	}

	@And("Lastname is verified successfully")
	public Icivics_EducatorReg lastname() {
		WebElement Lastnamelabel = driver.findElement(By.xpath("//label[text()='Last Name']"));
		if (Lastnamelabel.isDisplayed()) {
			reportStep("Lastname label is displayed", "Pass");
		} else {
			reportStep("Lastname label box is not displayed", "Fail");
		}

		WebElement Lastname = driver
				.findElement(By.xpath("//*[@id='edit-main-profiles-0-entity-field-last-name-0-value']"));
		String CLbox = Lastname.getAttribute("value");
		if (CLbox.isEmpty()) {
			reportStep("Last name text box is Blank", "Pass");
		} else {
			reportStep("Last name text box is not Blank", "Fail");
		}
		return this;
	}

	@And("Email is verified successfully")
	public Icivics_EducatorReg Email() {
		WebElement Emailaddresslabel = driver.findElement(By.xpath("//label[text()='Email address']"));
		if (Emailaddresslabel.isDisplayed()) {
			reportStep("Emailaddress label is displayed", "Pass");
		} else {
			reportStep("Emailaddress label box is not displayed", "Fail");
		}

		WebElement Emailaddress = driver.findElement(By.xpath("//*[@id='edit-mail']"));
		String CLbox = Emailaddress.getAttribute("value");
		if (CLbox.isEmpty()) {
			reportStep("Emailaddress text box is Blank", "Pass");
		} else {
			reportStep("Emailaddress text box is not Blank", "Fail");
		}
		return this;

	}

	@And("Verify Email is verified successfully")
	public Icivics_EducatorReg verifyEmail() {
		WebElement VerifyEmailaddresslabel = driver.findElement(By.xpath("//label[text()='Verify email address']"));
		if (VerifyEmailaddresslabel.isDisplayed()) {
			reportStep("VerifyEmailaddress label is displayed", "Pass");
		} else {
			reportStep("VerifyEmailaddress label box is not displayed", "Fail");
		}

		WebElement VerifyEmailaddress = driver.findElement(By.xpath("//*[@id='edit-conf-mail']"));
		String CLbox = VerifyEmailaddress.getAttribute("value");
		if (CLbox.isEmpty()) {
			reportStep("VerifyEmailaddress text box is Blank", "Pass");
		} else {
			reportStep("VerifyEmailaddress box is not Blank", "Fail");
		}
		return this;
	}

	@Then("click on next button")
	public Icivics_EducatorReg nextbutton() {
		WebElement nextbutton = driver.findElement(By.xpath("//button[@id='edit-next']"));

		if (nextbutton.isDisplayed()) {
			reportStep("nextbutton is Verified successfully", "Pass");
		} else {
			reportStep("nextbutton is not display", "Fail");
		}
		return this;
	}

	@When("Validate play button on hovering getting highlighted")
	public Icivics_EducatorReg hoverplaybutton() throws InterruptedException {
		String PlayButton = "XPATH&(//*[@title='Play Games'])[3]";
		mouseOverAction(PlayButton);
		reportStep("PlayButton is MouseHovered successfully", "Pass");
		mouseOverAndClickAction(PlayButton);
		driver.findElement(By.xpath("(//*[@class='dropdown-menu'])[5]")).isDisplayed();
		reportStep("PlayButton Dropdown is Displayed", "Pass");
		return this;
	}

	@And("Validate teach button on hovering getting highlighted")
	public Icivics_EducatorReg hoverteachbutton() {
		String teachButton = "XPATH&(//a[@title='Search Our Library'])[3]";
		mouseOverAction(teachButton);
		reportStep("TeachButton is MouseHowered successfully", "Pass");
		mouseOverAndClickAction(teachButton);
		driver.findElement(By.xpath("(//*[@class='dropdown-menu'])[6]")).isDisplayed();
		waitTime(3000);
		reportStep("TeachButton Dropdown is Displayed", "Pass");
		return this;
	}

	@And("Validate about button on hovering getting highlighted")
	public Icivics_EducatorReg hoveraboutbutton() {
		String donateButton = "XPATH&(//a[@title='Learn how you can financially support and fund iCivics.'])[3]";
		mouseOverAction(donateButton);
		reportStep("aboutButton is MouseHowered successfully", "Pass");
		mouseOverAndClickAction(donateButton);
		driver.findElement(By.xpath("(//*[@class='dropdown-menu'])[7]")).isDisplayed();
		reportStep("aboutButton Dropdown is Displayed", "Pass");
		return this;
	}

	@And("Validate donate button on hovering")
	public Icivics_EducatorReg Donatebutton() throws InterruptedException {
		String donate = "XPATH&(//a[text()='DONATE'])[2]";
		mouseOverAction(donate);
		waitTime(3000);
		return this;
	}

	@And("Validate shop button on hovering")
	public Icivics_EducatorReg shopbutton() {
		String shop = "XPATH&(//a[@title='Shop iCivics.'])[2]";
		mouseOverAction(shop);
		return this;
	}

	@And("Verify signin button on hovering getting highlighted")
	public Icivics_EducatorReg signinbutton() {
		String signinButton = "XPATH&(//a[@title='Sign In'])[3]";
		mouseOverAction(signinButton);
		reportStep("singinButton is MouseHowered successfully", "Pass");
		mouseOverAndClickAction(signinButton);
		driver.findElement(By.xpath("(//*[@class='dropdown-menu'])[8]")).isDisplayed();
		reportStep("signinButton Dropdown is Displayed", "Pass");
		return this;
	}

	@And("Firstname field on hovering get highlighted")
	public Icivics_EducatorReg hoverfirstname() {
		String firstname = "XPATH&(//input[@type='text'])[1]";
		mouseOverAction(firstname);
		waitTime(3000);
		return this;
	}

	@And("Lastname field on hovering get highlighted")
	public Icivics_EducatorReg hoverlastname() {
		String firstname = "XPATH&(//input[@type='text'])[2]";
		mouseOverAction(firstname);
		waitTime(3000);
		return this;
	}

	@And("Email field on hovering should highlighted")
	public Icivics_EducatorReg hoveremail() {
		String email = "XPATH&(//input[@type='email'])[1]";
		mouseOverAction(email);
		waitTime(3000);
		return this;
	}

	@And("Verify Email field on hovering should highlighted")
	public Icivics_EducatorReg hoververifyemail() {
		String verifyemail = "XPATH&(//input[@type='email'])[2]";
		mouseOverAction(verifyemail);
		waitTime(3000);
		return this;
	}

	@And("Validate Nextbutton on hovering getting highlighted")
	public Icivics_EducatorReg hovernextbutton() {
		String next = "XPATH&//button[contains(@class,'icon-before button')]";
		mouseOverAction(next);
		return this;
	}

	@When("click on next button check spelling for alert msgs")
	public Icivics_EducatorReg typos() {
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

	@When("window is resize it should be usable")
	public Icivics_EducatorReg resizewindow() {
		Dimension d = new Dimension(768, 1024);
		// Resize the current window to the given dimension
		driver.manage().window().setSize(d);
		takeSnap();
		waitTime(3000);
		reportStep("Ipad potrait resize is successfull", "Pass");
		Dimension d1 = new Dimension(1024, 768);
		driver.manage().window().setSize(d1);
		waitTime(3000);
		System.out.println(driver.manage().window().getSize());
		takeSnap();
		reportStep("Ipad landscape resize is successfull", "Pass");
		Dimension d2 = new Dimension(375, 667);
		driver.manage().window().setSize(d2);
		waitTime(3000);
		System.out.println(driver.manage().window().getSize());
		takeSnap();
		reportStep("Iphone potrait resize is successfull", "Pass");
		return this;

	}

	@When("Pagecounter is verified successfully")
	public Icivics_EducatorReg pagebreadcrumbs() {
		WebElement Pagecounter = driver.findElement(By.xpath("//div[@class='register-form-steps-wrapper']/ul"));
		if (Pagecounter.isDisplayed()) {
			waitTime(3000);
			reportStep("Page counter 1-5 is Displayed", "Pass");
		} else
			reportStep("Page counter 1-5 is Not Displayed", "Fail");
		return this;

	}

	@Then("On teach page, check all links of Play button")
	public Icivics_EducatorReg Playbuttonelementsverification() throws IOException {
		String propname = "playdropdown";
		String PlayButton = getPropfile(propname, "PlayButtonElement");
		String URL = "https://staging.d9.icivics.org/user/register?role=teacher";
		navigateto(URL);

		// All Games
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "AllgamesElement"), getpropstring(propname, "AllgameText"),
				getpropstring(propname, "AllgameUrL"), getpropstring(propname, "AllgameTitle"));

		// cast your vote
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "cyvElement"), getpropstring(propname, "cyvText"),
				getpropstring(propname, "cyvUrL"), getpropstring(propname, "cyvTitle"));
		verifyPartialText(getprop(propname, "cyvheaderele"), getpropstring(propname, "cyvheader"));

		// counties work Texas
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "cwtElement"), getpropstring(propname, "cwtText"),
				getpropstring(propname, "cwtUrL"), getpropstring(propname, "cwtTitle"));
		verifyPartialText(getprop(propname, "cwtheaderele"), getpropstring(propname, "cwtheader"));

		// Execute Command
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "ecElement"), getpropstring(propname, "ecText"), getpropstring(propname, "ecUrL"),
				getpropstring(propname, "ecTitle"));
		verifyPartialText(getprop(propname, "echeaderele"), getpropstring(propname, "echeader"));

		// Lawcraft
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "lcElement"), getpropstring(propname, "lcText"), getpropstring(propname, "lcUrL"),
				getpropstring(propname, "lcTitle"));
		verifyPartialText(getprop(propname, "lcheaderele"), getpropstring(propname, "lcheader"));

		// Sortify:U.S.CITIZENSHIP
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "scElement"), getpropstring(propname, "scText"), getpropstring(propname, "scUrL"),
				getpropstring(propname, "scTitle"));
		verifyPartialText(getprop(propname, "scheaderele"), getpropstring(propname, "scheader"));

		// ARGUMENT WARS
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "awElement"), getpropstring(propname, "awText"), getpropstring(propname, "awUrL"),
				getpropstring(propname, "awTitle"));
		verifyPartialText(getprop(propname, "awheaderele"), getpropstring(propname, "awheader"));

		// Convene The Council
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "ctcElement"), getpropstring(propname, "ctcText"),
				getpropstring(propname, "ctcUrL"), getpropstring(propname, "ctcTitle"));
		verifyPartialText(getprop(propname, "ctcheaderele"), getpropstring(propname, "ctcheader"));

		// Court Quest
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "cqElement"), getpropstring(propname, "cqText"), getpropstring(propname, "cqUrL"),
				getpropstring(propname, "cqTitle"));
		verifyPartialText(getprop(propname, "cqheaderele"), getpropstring(propname, "cqheader"));

		// Game Odyssey
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "goElement"), getpropstring(propname, "goText"), getpropstring(propname, "goUrL"),
				getpropstring(propname, "goTitle"));
		verifyPartialText(getprop(propname, "goheaderele"), getpropstring(propname, "goheader"));
		navigateto(URL);
		waitTime(3000);

		// newsfeeders defenders
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "nfdElement"), getpropstring(propname, "nfdText"),
				getpropstring(propname, "nfdUrL"), getpropstring(propname, "nfdTitle"));
		verifyPartialText(getprop(propname, "nfdheaderele"), getpropstring(propname, "nfdheader"));

		// Win the white house
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "wtwhElement"), getpropstring(propname, "wtwhText"),
				getpropstring(propname, "wtwhUrL"), getpropstring(propname, "wtwhTitle"));
		verifyPartialText(getprop(propname, "wtwhheaderele"), getpropstring(propname, "wtwhheader"));

		// Branches of Power
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "bopElement"), getpropstring(propname, "bopText"),
				getpropstring(propname, "bopUrL"), getpropstring(propname, "bopTitle"));
		verifyPartialText(getprop(propname, "bopheaderele"), getpropstring(propname, "bopheader"));

		// Counties Work
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "cwElement"), getpropstring(propname, "cwText"), getpropstring(propname, "cwUrL"),
				getpropstring(propname, "cwTitle"));
		verifyPartialText(getprop(propname, "cwheaderele"), getpropstring(propname, "cwheader"));

		// Do I have A Birth?
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "drElement"), getpropstring(propname, "drText"), getpropstring(propname, "drUrL"),
				getpropstring(propname, "drTitle"));
		verifyPartialText(getprop(propname, "drheaderele"), getpropstring(propname, "drheader"));

		// Immigration Nation
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "inElement"), getpropstring(propname, "inText"), getpropstring(propname, "inUrL"),
				getpropstring(propname, "inTitle"));
		verifyPartialText(getprop(propname, "inheaderele"), getpropstring(propname, "inheader"));

		// Race To Ratify
		mouseOverAndClickAction(PlayButton);
		Verifylinks(getprop(propname, "rtrElement"), getpropstring(propname, "rtrText"),
				getpropstring(propname, "rtrUrL"), getpropstring(propname, "rtrTitle"));
		verifyPartialText(getprop(propname, "rtrheaderele"), getpropstring(propname, "rtrheader"));

		reportStep("All links in the play dropdown is verified sucessfully", "Pass");

		return this;
	}

	@Then("check all links of teach button")
	public Icivics_EducatorReg Teachbuttonelementsverification() throws IOException {
		String propname = "teachdropdown";
		String TeachButton = getPropfile(propname, "TeachButtonElement");
		String URL = "https://staging.d9.icivics.org/user/register?role=teacher";
		navigateto(URL);

		// Search Our Library
		mouseOverAndClickAction(TeachButton);
		Verifylinks(getprop(propname, "solElement"), getpropstring(propname, "solText"),
				getpropstring(propname, "solUrL"), getpropstring(propname, "solTitle"));
		verifyPartialText(getprop(propname, "solheaderele"), getpropstring(propname, "solheader"));

		// SCOPE & SEQUENCE
		mouseOverAndClickAction(TeachButton);
		Verifylinks(getprop(propname, "sasElement"), getpropstring(propname, "sasText"),
				getpropstring(propname, "sasUrL"), getpropstring(propname, "sasTitle"));
		verifyPartialText(getprop(propname, "sasheaderele"), getpropstring(propname, "sasheader"));

		// PROFESSIONAL DEVELOPMENT
		mouseOverAndClickAction(TeachButton);
		Verifylinks(getprop(propname, "pdElement"), getpropstring(propname, "pdText"), getpropstring(propname, "pdUrL"),
				getpropstring(propname, "pdTitle"));
		verifyPartialText(getprop(propname, "pdheaderele"), getpropstring(propname, "pdheader"));

		// GET STARTED
		mouseOverAndClickAction(TeachButton);
		Verifylinks(getprop(propname, "gsElement"), getpropstring(propname, "gsText"), getpropstring(propname, "gsUrL"),
				getpropstring(propname, "gsTitle"));
		verifyPartialText(getprop(propname, "gsheaderele"), getpropstring(propname, "gsheader"));

		// EDUCATOR COMMUNITY
		mouseOverAndClickAction(TeachButton);
		verifyDisplayed(getprop(propname, "ecElement"));
		verifyExactText(getprop(propname, "ecElement"), getpropstring(propname, "ecText"));
		click(getprop(propname, "ecElement"));
		verifyTitle(getpropstring(propname, "Community – iCivics"));
		
		// FAQ
		navigateto(URL);
		waitTime(3000);
		mouseOverAndClickAction(TeachButton);
		Verifylinks(getprop(propname, "faqElement"), getpropstring(propname, "faqText"),
				getpropstring(propname, "faqUrL"), getpropstring(propname, "faqTitle"));
		verifyPartialText(getprop(propname, "faqheaderele"), getpropstring(propname, "faqheader"));

		reportStep("All links in the teach dropdown is verified sucessfully", "Pass");

		return this;

	}

	@Then("check all links of about button")
	public Icivics_EducatorReg aboutbuttonelementsverification() throws IOException {
		String propname = "aboutdropdown";
		String AboutButton = getPropfile(propname, "AboutButtonElement");
		String URL = "https://staging.d9.icivics.org/user/register?role=teacher";
		navigateto(URL);

		// About iCivics
		mouseOverAndClickAction(AboutButton);
		Verifylinks(getprop(propname, "aboutElement"), getpropstring(propname, "aboutText"),
				getpropstring(propname, "aboutUrL"), getpropstring(propname, "aboutTitle"));
		verifyPartialText(getprop(propname, "aboutheaderele"), getpropstring(propname, "aboutheader"));

		// Who We Are
		mouseOverAndClickAction(AboutButton);
		Verifylinks(getprop(propname, "wwaElement"), getpropstring(propname, "wwaText"),
				getpropstring(propname, "wwaUrL"), getpropstring(propname, "wwaTitle"));
		navigateto(URL);

		// Our Strategy
		mouseOverAndClickAction(AboutButton);
		Verifylinks(getprop(propname, "osElement"), getpropstring(propname, "osText"), getpropstring(propname, "osUrL"),
				getpropstring(propname, "osTitle"));
		navigateto(URL);

		// CivXNow
		mouseOverAndClickAction(AboutButton);
		Verifylinks(getprop(propname, "cxnElement"), getpropstring(propname, "cxnText"),
				getpropstring(propname, "cxnUrL"), getpropstring(propname, "cxnTitle"));
		navigateto(URL);

		// Our Team
		mouseOverAndClickAction(AboutButton);
		Verifylinks(getprop(propname, "otElement"), getpropstring(propname, "otText"), getpropstring(propname, "otUrL"),
				getpropstring(propname, "otTitle"));
		navigateto(URL);

		// Blog
		mouseOverAndClickAction(AboutButton);
		Verifylinks(getprop(propname, "blogElement"), getpropstring(propname, "blogText"),
				getpropstring(propname, "blogUrL"), getpropstring(propname, "blogTitle"));
		verifyPartialText(getprop(propname, "blogheaderele"), getpropstring(propname, "blogheader"));
		navigateto(URL);

		// Contact Us
		mouseOverAndClickAction(AboutButton);
		Verifylinks(getprop(propname, "cuElement"), getpropstring(propname, "cuText"), getpropstring(propname, "cuUrL"),
				getpropstring(propname, "cuTitle"));
		navigateto(URL);

		reportStep("All links in the About dropdown is verified sucessfully", "Pass");
		return this;

	}

	@Then("check all links of Donate button")
	public Icivics_EducatorReg donatebuttonelementsverification() throws IOException {
		String propname = "donatebutton";
		String DonateButton = getPropfile(propname, "DonateButtonElement");
		clickOn(DonateButton);
		verifyTitlecontains(getPropfile(propname, "DonateTitle"));
		verifyUrl(getPropfile(propname, "DonateUrl"));
		verifyPartialText(getprop(propname, "DonateHeaderEle"), getpropstring(propname, "DonateHeaderText"));
		return this;
	}
}
