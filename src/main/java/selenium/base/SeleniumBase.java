package selenium.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.design.Browser;
import selenium.design.Element;
import utilities.Log;
import utilities.Reporter;

public class SeleniumBase extends Reporter implements Browser, Element {

	public RemoteWebDriver driver;
	public WebDriverWait wait;
	public String browser;

	int i = 1;

	@Override
	public void click(WebElement ele) {
		String text = "";
		try {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			ele.click();
			reportStep("The Element " + text + " clicked", "pass");
		} catch (StaleElementReferenceException e) {
			reportStep("The Element " + text + " could not be clicked", "fail");
			throw new RuntimeException();
		}
	}

	public void clickWithNoSnap(WebElement ele) {
		String text = "";
		try {
			text = ele.getText();
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			reportStep("The Element with text: " + text + " clicked", "pass", false);
		} catch (StaleElementReferenceException e) {
			reportStep("The Element " + ele + " could not be clicked", "fail");
			throw new RuntimeException();
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	@Override
	public void append(WebElement ele, String data) {
		ele.sendKeys(data);
	}

	@Override
	public void clear(WebElement ele) {
		try {
			ele.clear();
			reportStep("The field is cleared Successfully", "pass");
		} catch (ElementNotInteractableException e) {
			reportStep("The field is not Interactable", "fail");
			throw new RuntimeException();
		}
	}

	@Override
	public void clearAndType(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			reportStep("The Data :" + data + " entered Successfully", "pass");
		} catch (ElementNotInteractableException e) {
			reportStep("The Element " + ele + " is not Interactable", "fail");
			throw new RuntimeException();
		}

	}

	@Override
	public String getElementText(WebElement ele) {
		String text = ele.getText();
		return text;
	}

	@Override
	public String getBackgroundColor(WebElement ele) {
		String cssValue = ele.getCssValue("color");
		return cssValue;
	}

	@Override
	public String getTypedText(WebElement ele) {
		String attributeValue = ele.getAttribute("value");
		return attributeValue;
	}

	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {

		new Select(ele).selectByVisibleText(value);
	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		new Select(ele).selectByIndex(index);
	}

	@Override
	public void selectDropDownUsingValue(WebElement ele, String value) {
		new Select(ele).selectByValue(value);
	}

	@Override
	public boolean verifyExactText(WebElement ele, String expectedText) {
		try {
			if (ele.getText().equals(expectedText)) {
				reportStep("The expected text contains the actual " + expectedText, "pass");
				return true;
			} else {
				reportStep("The expected text doesn't contain the actual " + expectedText, "fail");
			}
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the Text");
		}

		return false;
	}

	@Override
	public boolean verifyPartialText(WebElement ele, String expectedText) {
		try {
			if (ele.getText().contains(expectedText)) {
				reportStep("The expected text contains the actual " + expectedText, "pass");
				return true;
			} else {
				reportStep("The expected text doesn't contain the actual " + expectedText, "fail");
			}
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the Text");
		}

		return false;
	}

	@Override
	public boolean verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			if (ele.getAttribute(attribute).equals(value)) {
				reportStep("The expected attribute :" + attribute + " value contains the actual " + value, "pass");
				return true;
			} else {
				reportStep("The expected attribute :" + attribute + " value does not contains the actual " + value,
						"fail");
			}
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the Attribute Text");
		}
		return false;
	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			if (ele.getAttribute(attribute).contains(value)) {
				reportStep("The expected attribute :" + attribute + " value contains the actual " + value, "pass");
			} else {
				reportStep("The expected attribute :" + attribute + " value does not contains the actual " + value,
						"fail");
			}
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the Attribute Text");
		}

	}

	@Override
	public boolean verifyDisplayed(WebElement ele) {
		try {
			if (ele.isDisplayed()) {
				reportStep("The element " + ele + " is visible", "pass");
				return true;
			} else {
				reportStep("The element " + ele + " is not visible", "fail");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
		return false;

	}

	@Override
	public boolean verifyDisappeared(WebElement ele) {
		return false;

	}

	@Override
	public boolean verifyEnabled(WebElement ele) {
		try {
			if (ele.isEnabled()) {
				reportStep("The element " + ele + " is Enabled", "pass");
				return true;
			} else {
				reportStep("The element " + ele + " is not Enabled", "fail");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
		return false;
	}

	@Override
	public void verifySelected(WebElement ele) {
		try {
			if (ele.isSelected()) {
				reportStep("The element " + ele + " is selected", "pass");
				// return true;
			} else {
				reportStep("The element " + ele + " is not selected", "fail");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
		// return false;

	}

	@Override
	public RemoteWebDriver navigateto(String url) {
		driver.get(url);
		return driver;
	}

	@Override
	public RemoteWebDriver startApp(String url) {
		return startApp(url);
	}

	@Override
	public RemoteWebDriver startApp1(String browser) {

		try {
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			// driver.navigate().to(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			reportStep("The Browser Could not be Launched. Hence Failed", "fail");
			throw new RuntimeException();
		}
		return driver;

	}

	@Override
	public RemoteWebDriver startApp(String browser, String url) {

		try {
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.navigate().to(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			reportStep("The Browser Could not be Launched. Hence Failed", "fail");
			throw new RuntimeException();
		}
		return driver;

	}

	@Override
	public WebElement locateElement(String locatorType, String value) {
		try {
			switch (locatorType.toLowerCase()) {
			case "id":
				return driver.findElementById(value);
			case "name":
				return driver.findElementByName(value);
			case "class":
				return driver.findElementByClassName(value);
			case "link":
				return driver.findElementByLinkText(value);
			case "xpath":
				return driver.findElementByXPath(value);
			}
		} catch (NoSuchElementException e) {
			reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value, "fail");
			throw new RuntimeException();
		} catch (Exception e) {
			reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value, "fail");
		}
		return null;
	}

	@Override
	public List<WebElement> locateElements(String type, String value) {
		try {
			switch (type.toLowerCase()) {
			case "id":
				return driver.findElementsById(value);
			case "name":
				return driver.findElementsByName(value);
			case "class":
				return driver.findElementsByClassName(value);
			case "link":
				return driver.findElementsByLinkText(value);
			case "xpath":
				return driver.findElementsByXPath(value);
			}
		} catch (NoSuchElementException e) {
			System.err.println("The Element with locator:" + type + " Not Found with value: " + value);
			throw new RuntimeException();
		}
		return null;
	}

	@Override
	public void switchToAlert() {
		driver.switchTo().alert();
	}

	@Override
	public void acceptAlert() {
		String text = "";
		try {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.accept();
			reportStep("The alert " + text + " is accepted.", "pass");
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.", "fail");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}

	}

	@Override
	public void dismissAlert() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			System.out.println("The alert " + text + " is accepted.");
		} catch (NoAlertPresentException e) {
			System.out.println("There is no alert present.");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}

	}

	@Override
	public String getAlertText() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			System.out.println("There is no alert present.");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
		return text;
	}

	@Override
	public void typeAlert(String data) {
		driver.switchTo().alert().sendKeys(data);

	}

	@Override
	public void switchToWindow(int index) {
		try {
			Set<String> allWindows = driver.getWindowHandles();
			List<String> allhandles = new ArrayList<String>(allWindows);
			String exWindow = allhandles.get(index);
			driver.switchTo().window(exWindow);
			System.out.println("The Window With index: " + index + " switched successfully");
		} catch (NoSuchWindowException e) {
			System.err.println("The Window With index: " + index + " not found");
		}
	}

	@Override
	public void switchToWindow(String title) {
		try {
			Set<String> allWindows = driver.getWindowHandles();
			for (String eachWindow : allWindows) {
				driver.switchTo().window(eachWindow);
				if (driver.getTitle().equals(title)) {
					break;
				}
			}
			System.out.println("The Window With Title: " + title + "is switched ");
		} catch (NoSuchWindowException e) {
			System.err.println("The Window With Title: " + title + " not found");
		} finally {
			takeSnap();
		}
	}

	@Override
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);

	}

	@Override
	public void switchToFrame(WebElement ele) {
		driver.switchTo().frame(ele);

	}

	@Override
	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);

	}

	@Override
	public void defaultContent() {
		driver.switchTo().defaultContent();

	}

	@Override
	public boolean verifyUrl(String url) {
		if (driver.getCurrentUrl().equals(url)) {
			System.out.println("The url: " + url + " matched successfully");
			return true;
		} else {
			System.out.println("The url: " + url + " not matched");
		}
		return false;
	}
	
	

	@Override
	public boolean verifyTitle(String title) {
		if (driver.getTitle().equals(title)) {
			System.out.println("Page title: " + title + " matched successfully");
			return true;
		} else {
			System.out.println("Page url: " + title + " not matched");
		}
		return false;
	}
	
	@Override
	public boolean verifyTitlecontains(String title) {
		if (driver.getTitle().contains(title)) {
			System.out.println("Page title: " + title + " matched successfully");
			return true;
		} else {
			System.out.println("Page url: " + title + " not matched");
		}
		return false;
	}

	public long takeSnap() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE),
					new File("./reports/images/" + number + ".jpg"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return number;
	}

	@Override
	public void close() {
		driver.close();

	}

	@Override
	public void quit() {
		driver.quit();

	}

	@Override
	public void waitTime(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void scrollToTheGivenWebElement(String locator) {
		String[] data = locator.split("&");
		String key = data[0];
		String value = data[1];
		WebElement element = null;
		if (key.equalsIgnoreCase("ID")) {
			try {
				wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
				element = driver.findElementById(value);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
			} catch (Exception e) {
				Log.fatal("Unable to find element " + e.toString());
			}
		} else if (key.equalsIgnoreCase("XPATH")) {
			try {
				wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
				element = driver.findElementByXPath(value);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
			} catch (Exception e) {
				Log.fatal("Unable to find element " + e.toString());
			}
		} else {
			Log.fatal("Kindly, provide correct locator option for element.");
			throw new RuntimeException("Kindly, provide correct locator option for element.");
		}
	}

	public boolean clickOn(String locator) {
		// Log4j Configuration XML file
		DOMConfigurator.configure("log4j.xml");

		boolean bReturn = false;
		String[] data = locator.split("&");
		String key = data[0];
		String value = data[1];
		if (key.equalsIgnoreCase("ID")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
				WebElement ele = driver.findElementById(value);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
				reportStep("The element : " + value + " is clicked.", "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("NAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
				WebElement ele = driver.findElementByName(value);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
				reportStep("The element : " + value + " is clicked.", "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("LINKTEXT")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(value)));
				driver.findElementByLinkText(value).click();
				reportStep("The element : " + value + " is clicked.", "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("PARTIALLINKTEXT")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(value)));
				driver.findElementByPartialLinkText(value).click();
				reportStep("The element : " + value + " is clicked.", "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("CLASSNAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));
				WebElement ele = driver.findElementByClassName(value);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
				reportStep("The element : " + value + " is clicked.", "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("TAGNAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(value)));
				WebElement ele = driver.findElementByTagName(value);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
				reportStep("The element : " + value + " is clicked.", "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("CSSSELECTOR")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));
				WebElement ele = driver.findElementByCssSelector(value);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
				reportStep("The element : " + value + " is clicked.", "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("XPATH")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
				WebElement ele = driver.findElementByXPath(value);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
				reportStep("The element : " + value + " is clicked.", "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else {
			Log.error("Kindly, provide correct locator option for clickOn.");
			reportStep("Kindly, provide correct option.", "WARN");
			throw new RuntimeException("Kindly, provide correct option.");
		}
		return bReturn;
	}

	public boolean enterText(String locator, String input) {
		// Log4j Configuration XML file
		DOMConfigurator.configure("log4j.xml");

		boolean bReturn = false;
		String[] data = locator.split("&");
		String key = data[0];
		String value = data[1];
		if (key.equalsIgnoreCase("ID")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
				driver.findElementById(value).clear();
				driver.findElementById(value).sendKeys(input);
				reportStep("The data: " + input + " entered successfully in field :" + value, "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("NAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
				driver.findElementByName(value).clear();
				driver.findElementByName(value).sendKeys(input);
				reportStep("The data: " + input + " entered successfully in field :" + value, "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("CLASSNAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));
				driver.findElementByClassName(value).clear();
				driver.findElementByClassName(value).sendKeys(input);
				reportStep("The data: " + input + " entered successfully in field :" + value, "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("TAGNAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(value)));
				driver.findElementByTagName(value).clear();
				driver.findElementByTagName(value).sendKeys(input);
				reportStep("The data: " + input + " entered successfully in field :" + value, "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("CSSSELECTOR")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));
				driver.findElementByCssSelector(value).clear();
				driver.findElementByCssSelector(value).sendKeys(input);
				reportStep("The data: " + input + " entered successfully in field :" + value, "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("XPATH")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
				driver.findElementByXPath(value).clear();
				driver.findElementByXPath(value).sendKeys(input);
				reportStep("The data: " + input + " entered successfully in field :" + value, "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else {
			Log.error("Kindly, provide correct locator option for enterText.");
			reportStep("Kindly, provide correct locator option for enterText.", "WARN");
			throw new RuntimeException("Kindly, provide correct locator option for enterText.");
		}
		return bReturn;
	}

	public boolean selectByValueInDropdown(String locator, String dValue) {
		// Log4j Configuration XML file
		DOMConfigurator.configure("log4j.xml");

		boolean bReturn = false;
		String[] data = locator.split("&");
		String key = data[0];
		String value = data[1];
		if (key.equalsIgnoreCase("ID")) {
			try {
				new Select(driver.findElementById(value)).selectByValue(dValue);
				reportStep("The element with id: " + value + " is selected with value: " + dValue, "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("The value: " + dValue + " could not be selected. " + e.toString());
				reportStep("The value: " + dValue + " could not be selected. " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("NAME")) {
			try {
				new Select(driver.findElementByName(value)).selectByValue(dValue);
				reportStep("The element with name: " + value + " is selected with value: " + dValue, "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("The value: " + dValue + " could not be selected. " + e.toString());
				reportStep("The value: " + dValue + " could not be selected. " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("CLASSNAME")) {
			try {
				new Select(driver.findElementByClassName(value)).selectByValue(dValue);
				reportStep("The element with classname: " + value + " is selected with value: " + dValue, "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("The value: " + dValue + " could not be selected. " + e.toString());
				reportStep("The value: " + dValue + " could not be selected. " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("TAGNAME")) {
			try {
				new Select(driver.findElementByTagName(value)).selectByValue(dValue);
				reportStep("The element with tagname: " + value + " is selected with value: " + dValue, "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("The value: " + dValue + " could not be selected. " + e.toString());
				reportStep("The value: " + dValue + " could not be selected. " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("CSSSELECTOR")) {
			try {
				new Select(driver.findElementByCssSelector(value)).selectByValue(dValue);
				reportStep("The element with cssselector: " + value + " is selected with value: " + dValue, "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("The value: " + dValue + " could not be selected. " + e.toString());
				reportStep("The value: " + dValue + " could not be selected. " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("XPATH")) {
			try {
				new Select(driver.findElementByXPath(value)).selectByValue(dValue);
				reportStep("The element with xpath: " + value + " is selected with value: " + dValue, "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("The value: " + dValue + " could not be selected. " + e.toString());
				reportStep("The value: " + dValue + " could not be selected. " + e.toString(), "FAIL");
			}
		} else {
			Log.error("Kindly, provide correct locator option for selectByValueInDropdown.");
			reportStep("Kindly, provide correct locator option for selectByValueInDropdown.", "WARN");
			throw new RuntimeException("Kindly, provide correct locator option for selectByValueInDropdown.");
		}
		return bReturn;
	}

	public boolean verifyUrlOfThePage(String expected) {
		// Log4j Configuration XML file
		DOMConfigurator.configure("log4j.xml");

		boolean bReturn = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.urlToBe(expected));
			reportStep("The expected " + expected + " url as same as the " + driver.getCurrentUrl() + " actual url.",
					"PASS");
			bReturn = true;
		} catch (Exception e) {
			Log.fatal("The expected " + expected + " url wasn't same as the " + driver.getCurrentUrl() + " actual url."
					+ e.toString());
			reportStep("The expected " + expected + " url wasn't same as the " + driver.getCurrentUrl() + " actual url."
					+ e.toString(), "FAIL");
		}
		return bReturn;
	}

	public boolean verifyTextContains(String locator, String expected) {
		// Log4j Configuration XML file
		DOMConfigurator.configure("log4j.xml");

		boolean bReturn = false;
		String[] data = locator.split("&");
		String key = data[0];
		String value = data[1];
		if (key.equalsIgnoreCase("ID")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
				if (driver.findElementById(value).getText().trim().contains(expected)) {
					reportStep("The text: " + driver.findElementById(value).getText().trim()
							+ " matches with the value : " + expected, "PASS");
					bReturn = true;
				} else {
					reportStep("The text: " + driver.findElementById(value).getText().trim()
							+ " did not match with the value : " + expected, "FAIL");
				}
			} catch (Exception e) {
				Log.error("Unable to find the given element " + value + " : " + e.toString());
				reportStep("Unable to find the given element " + value + " : " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("NAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
				if (driver.findElementByName(value).getText().trim().contains(expected)) {
					reportStep("The text: " + driver.findElementByName(value).getText().trim()
							+ " matches with the value : " + expected, "PASS");
					bReturn = true;
				} else {
					reportStep("The text: " + driver.findElementByName(value).getText().trim()
							+ " did not match with the value : " + expected, "FAIL");
				}
			} catch (Exception e) {
				Log.error("Unable to find the given element " + value + " : " + e.toString());
				reportStep("Unable to find the given element " + value + " : " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("CLASSNAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));
				if (driver.findElementByClassName(value).getText().trim().contains(expected)) {
					reportStep("The text: " + driver.findElementByClassName(value).getText().trim()
							+ " matches with the value : " + expected, "PASS");
					bReturn = true;
				} else {
					reportStep("The text: " + driver.findElementByClassName(value).getText().trim()
							+ " did not match with the value : " + expected, "FAIL");
				}
			} catch (Exception e) {
				Log.error("Unable to find the given element " + value + " : " + e.toString());
				reportStep("Unable to find the given element " + value + " : " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("TAGNAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(value)));
				if (driver.findElementByTagName(value).getText().trim().contains(expected)) {
					reportStep("The text: " + driver.findElementByTagName(value).getText().trim()
							+ " matches with the value : " + expected, "PASS");
					bReturn = true;
				} else {
					reportStep("The text: " + driver.findElementByTagName(value).getText().trim()
							+ " did not match with the value : " + expected, "FAIL");
				}
			} catch (Exception e) {
				Log.error("Unable to find the given element " + value + " : " + e.toString());
				reportStep("Unable to find the given element " + value + " : " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("CSSSELECTOR")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));
				if (driver.findElementByCssSelector(value).getText().trim().contains(expected)) {
					reportStep("The text: " + driver.findElementByCssSelector(value).getText().trim()
							+ " matches with the value : " + expected, "PASS");
					bReturn = true;
				} else {
					reportStep("The text: " + driver.findElementByCssSelector(value).getText().trim()
							+ " did not match with the value : " + expected, "FAIL");
				}
			} catch (Exception e) {
				Log.error("Unable to find the given element " + value + " : " + e.toString());
				reportStep("Unable to find the given element " + value + " : " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("XPATH")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
				if (driver.findElementByXPath(value).getText().trim().contains(expected)) {
					reportStep("The text: " + driver.findElementByXPath(value).getText().trim()
							+ " matches with the value : " + expected, "PASS");
					bReturn = true;
				} else {
					reportStep("The text: " + driver.findElementByXPath(value).getText().trim()
							+ " did not match with the value : " + expected, "FAIL");
				}
			} catch (Exception e) {
				Log.error("Unable to find the given element " + value + " : " + e.toString());
				reportStep("Unable to find the given element " + value + " : " + e.toString(), "FAIL");
			}
		} else {
			Log.fatal("Kindly, provide correct locator option for verifyText.");
			reportStep("Kindly, provide correct locator option for verifyText.", "WARN");
			throw new RuntimeException("Kindly, provide correct locator option for verifyText.");
		}
		return bReturn;
	}

	public List<WebElement> getElements(String locator) {
		// Log4j Configuration XML file
		DOMConfigurator.configure("log4j.xml");

		String[] data = locator.split("&");
		String key = data[0];
		String value = data[1];
		List<WebElement> wReturn = null;
		if (key.equalsIgnoreCase("ID")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
				wReturn = driver.findElementsById(value);
			} catch (Exception e) {
				Log.fatal("Unable to find element " + e.toString());
				reportStep("Unable to find element " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("NAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
				wReturn = driver.findElementsByName(value);
			} catch (Exception e) {
				Log.fatal("Unable to find element " + e.toString());
				reportStep("Unable to find element " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("CLASSNAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));
				wReturn = driver.findElementsByClassName(value);
			} catch (Exception e) {
				Log.fatal("Unable to find element " + e.toString());
				reportStep("Unable to find element " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("TAGNAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(value)));
				wReturn = driver.findElementsByTagName(value);
			} catch (Exception e) {
				Log.fatal("Unable to find element " + e.toString());
				reportStep("Unable to find element " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("CSSSELECTOR")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));
				wReturn = driver.findElementsByCssSelector(value);
			} catch (Exception e) {
				Log.fatal("Unable to find element " + e.toString());
				reportStep("Unable to find element " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("XPATH")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
				wReturn = driver.findElementsByXPath(value);
			} catch (Exception e) {
				Log.fatal("Unable to find element " + e.toString());
				reportStep("Unable to find element " + e.toString(), "FAIL");
			}
		} else {
			Log.fatal("Kindly, provide correct locator option for getElements.");
			reportStep("Kindly, provide correct locator option for getElements.", "WARN");
			throw new RuntimeException("Kindly, provide correct locator option for getElements.");
		}
		return wReturn;
	}

	public boolean verifyText(WebElement element, String expected) {
		// Log4j Configuration XML file
		DOMConfigurator.configure("log4j.xml");

		boolean bReturn = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
			if (element.getText().trim().equals(expected)) {
				reportStep("The text: " + element.getText().trim() + " matches with the value : " + expected, "PASS");
				bReturn = true;
			} else {
				reportStep("The text: " + element.getText().trim() + " did not match with the value : " + expected,
						"FAIL");
			}
		} catch (Exception e) {
			Log.fatal("Unable to find the given element " + element + " : " + e.toString());
			reportStep("Unable to find the given element " + element + " : " + e.toString(), "FAIL");
		}
		return bReturn;
	}

	public boolean verifyText(String locator, String expected) {
		// Log4j Configuration XML file
		DOMConfigurator.configure("log4j.xml");

		boolean bReturn = false;
		String[] data = locator.split("&");
		String key = data[0];
		String value = data[1];
		if (key.equalsIgnoreCase("ID")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
				if (driver.findElementById(value).getText().trim().equals(expected)) {
					reportStep("The text: " + driver.findElementById(value).getText().trim()
							+ " matches with the value : " + expected, "PASS");
					bReturn = true;
				} else {
					reportStep("The text: " + driver.findElementById(value).getText().trim()
							+ " did not match with the value : " + expected, "FAIL");
				}
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " : " + e.toString());
				reportStep("Unable to find the given element " + value + " : " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("NAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
				if (driver.findElementByName(value).getText().trim().equals(expected)) {
					reportStep("The text: " + driver.findElementByName(value).getText().trim()
							+ " matches with the value : " + expected, "PASS");
					bReturn = true;
				} else {
					reportStep("The text: " + driver.findElementByName(value).getText().trim()
							+ " did not match with the value : " + expected, "FAIL");
				}
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " : " + e.toString());
				reportStep("Unable to find the given element " + value + " : " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("CLASSNAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));
				if (driver.findElementByClassName(value).getText().trim().equals(expected)) {
					reportStep("The text: " + driver.findElementByClassName(value).getText().trim()
							+ " matches with the value : " + expected, "PASS");
					bReturn = true;
				} else {
					reportStep("The text: " + driver.findElementByClassName(value).getText().trim()
							+ " did not match with the value : " + expected, "FAIL");
				}
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " : " + e.toString());
				reportStep("Unable to find the given element " + value + " : " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("TAGNAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(value)));
				if (driver.findElementByTagName(value).getText().trim().equals(expected)) {
					reportStep("The text: " + driver.findElementByTagName(value).getText().trim()
							+ " matches with the value : " + expected, "PASS");
					bReturn = true;
				} else {
					reportStep("The text: " + driver.findElementByTagName(value).getText().trim()
							+ " did not match with the value : " + expected, "FAIL");
				}
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " : " + e.toString());
				reportStep("Unable to find the given element " + value + " : " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("CSSSELECTOR")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));
				if (driver.findElementByCssSelector(value).getText().trim().equals(expected)) {
					reportStep("The text: " + driver.findElementByCssSelector(value).getText().trim()
							+ " matches with the value : " + expected, "PASS");
					bReturn = true;
				} else {
					reportStep("The text: " + driver.findElementByCssSelector(value).getText().trim()
							+ " did not match with the value : " + expected, "FAIL");
				}
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " : " + e.toString());
				reportStep("Unable to find the given element " + value + " : " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("XPATH")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
				if (driver.findElementByXPath(value).getText().trim().equals(expected)) {
					reportStep("The text: " + driver.findElementByXPath(value).getText().trim()
							+ " matches with the value : " + expected, "PASS");
					bReturn = true;
				} else {
					reportStep("The text: " + driver.findElementByXPath(value).getText().trim()
							+ " did not match with the value : " + expected, "FAIL");
				}
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " : " + e.toString());
				reportStep("Unable to find the given element " + value + " : " + e.toString(), "FAIL");
			}
		} else {
			Log.error("Kindly, provide correct locator option for verifyText.");
			reportStep("Kindly, provide correct locator option for verifyText.", "WARN");
			throw new RuntimeException("Kindly, provide correct locator option for verifyText.");
		}
		return bReturn;
	}

	/**
	 * This method used to verify the url of the page and wait for 10 seconds to
	 * appear title of the web page
	 * 
	 * @param expected - web page's expected url
	 * @return boolean value
	 * @author Venkataraghavan on 20/10/2017:13:58:00PM
	 * @throws Exception
	 */

	public boolean getUrl(String url) {
		// Log4j Configuration XML file
		DOMConfigurator.configure("log4j.xml");

		boolean bReturn = false;
		try {
			driver.get(url);
			Log.info("Invoke AUT: " + url + " in " + browser + " browser successfully.");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Log.info("Implicit wait applied on the driver for 30 seconds.");
			reportStep("Invoke AUT: " + url + " in " + browser + " browser successfully.", "PASS");
		} catch (Exception e) {
			Log.fatal("Unable to launch the application " + url + " in the " + browser + " browser. " + e.toString());
			reportStep("Unable to launch the application " + url + " in the " + browser + " browser. " + e.toString(),
					"FAIL");
		}
		return bReturn;
	}

	public boolean selectByVisibleTextInDropdown(String locator, String visibleText) {
		// Log4j Configuration XML file
		DOMConfigurator.configure("log4j.xml");

		boolean bReturn = false;
		String[] data = locator.split("&");
		String key = data[0];
		String value = data[1];
		if (key.equalsIgnoreCase("ID")) {
			try {
				new Select(driver.findElementById(value)).selectByVisibleText(visibleText);
				reportStep("The element with id: " + value + " is selected with visible text: " + visibleText, "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("The visible text: " + visibleText + " could not be selected. " + e.toString());
				reportStep("The visible text: " + visibleText + " could not be selected. " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("NAME")) {
			try {
				new Select(driver.findElementByName(value)).selectByVisibleText(visibleText);
				reportStep("The element with name: " + value + " is selected with visible text: " + visibleText,
						"PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("The visible text: " + visibleText + " could not be selected. " + e.toString());
				reportStep("The visible text: " + visibleText + " could not be selected. " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("CLASSNAME")) {
			try {
				new Select(driver.findElementByClassName(value)).selectByVisibleText(visibleText);
				reportStep("The element with classname: " + value + " is selected with visible text: " + visibleText,
						"PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("The visible text: " + visibleText + " could not be selected. " + e.toString());
				reportStep("The visible text: " + visibleText + " could not be selected. " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("TAGNAME")) {
			try {
				new Select(driver.findElementByTagName(value)).selectByVisibleText(visibleText);
				reportStep("The element with tagname: " + value + " is selected with visible text: " + visibleText,
						"PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("The visible text: " + visibleText + " could not be selected. " + e.toString());
				reportStep("The visible text: " + visibleText + " could not be selected. " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("CSSSELECTOR")) {
			try {
				new Select(driver.findElementByCssSelector(value)).selectByVisibleText(visibleText);
				reportStep("The element with cssselector: " + value + " is selected with visible text: " + visibleText,
						"PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("The visible text: " + visibleText + " could not be selected. " + e.toString());
				reportStep("The visible text: " + visibleText + " could not be selected. " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("XPATH")) {
			try {
				new Select(driver.findElementByXPath(value)).selectByVisibleText(visibleText);
				reportStep("The element with xpath: " + value + " is selected with visible text: " + visibleText,
						"PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("The visible text: " + visibleText + " could not be selected. " + e.toString());
				reportStep("The visible text: " + visibleText + " could not be selected. " + e.toString(), "FAIL");
			}
		} else {
			Log.error("Kindly, provide correct locator option for selectByVisibleTextInDropdown.");
			reportStep("Kindly, provide correct locator option for selectByVisibleTextInDropdown.", "WARN");
			throw new RuntimeException("Kindly, provide correct locator option for selectByVisibleTextInDropdown.");
		}
		return bReturn;
	}

	/**
	 * This method is used to select value in the dropdown by value
	 * 
	 * @param locator - find and match the elements of web page
	 * @param dValue  - value of the dropdown
	 * @return boolean value
	 * @author Venkataraghavan on 20/10/2017:13:58:00PM
	 * @throws Exception
	 */

	public boolean mouseOverAndClickAction(String locator) {
		// Log4j Configuration XML file
		DOMConfigurator.configure("log4j.xml");

		String[] data = locator.split("&");
		String key = data[0];
		String value = data[1];
		WebElement ele;
		Actions builder = new Actions(driver);
		boolean bReturn = false;
		if (key.equalsIgnoreCase("ID")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
				ele = driver.findElementById(value);
				builder.moveToElement(ele).click().build().perform();
				bReturn = true;
				reportStep("The mouse over by id : " + value + " is performed.", "PASS");
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("NAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
				ele = driver.findElementByName(value);
				builder.moveToElement(ele).click().build().perform();
				bReturn = true;
				reportStep("The mouse over by name : " + value + " is performed.", "PASS");
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("LINKTEXT")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(value)));
				ele = driver.findElementByLinkText(value);
				builder.moveToElement(ele).click().build().perform();
				bReturn = true;
				reportStep("The mouse over by linktext : " + value + " is performed.", "PASS");
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("PARTIALLINKTEXT")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(value)));
				ele = driver.findElementByPartialLinkText(value);
				builder.moveToElement(ele).click().build().perform();
				bReturn = true;
				reportStep("The mouse over by partial linktext : " + value + " is performed.", "PASS");
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("CLASSNAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));
				ele = driver.findElementByClassName(value);
				builder.moveToElement(ele).click().build().perform();
				bReturn = true;
				reportStep("The mouse over by classname : " + value + " is performed.", "PASS");
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("TAGNAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(value)));
				ele = driver.findElementByTagName(value);
				builder.moveToElement(ele).click().build().perform();
				bReturn = true;
				reportStep("The mouse over by tagname : " + value + " is performed.", "PASS");
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("CSSSELECTOR")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));
				ele = driver.findElementByCssSelector(value);
				builder.moveToElement(ele).click().build().perform();
				bReturn = true;
				reportStep("The mouse over by cssselector : " + value + " is performed.", "PASS");
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("XPATH")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
				ele = driver.findElementByXPath(value);
				builder.moveToElement(ele).click().build().perform();
				bReturn = true;
				reportStep("The mouse over by xpath : " + value + " is performed.", "PASS");
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else {
			Log.error("Kindly, provide correct locator option for mouseOverAction.");
			reportStep("Kindly, provide correct locator option for mouseOverAction.", "WARN");
			throw new RuntimeException("Kindly, provide correct locator option for mouseOverAction.");
		}
		return bReturn;
	}

	/**
	 * This method is used to get list of web elements and wait for 10 seconds to
	 * appear title of the web page
	 * 
	 * @param locator - find and match the elements of web page
	 * @return WebElement value
	 * @author Venkataraghavan on 13/11/2017:18:00:00PM
	 * @throws Exception
	 */

	public boolean findElement(String locator) {
		// Log4j Configuration XML file
		DOMConfigurator.configure("log4j.xml");

		String[] data = locator.split("&");
		String key = data[0];
		String value = data[1];
		boolean bReturn = false;
		if (key.equalsIgnoreCase("ID")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 1);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
				reportStep(value + " : id is avaliable in the DOM elements.", "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.error("Unable to find the id : " + value + " in the DOM elements. " + e.toString());
			}
		} else if (key.equalsIgnoreCase("NAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 1);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
				reportStep(value + " : name is avaliable in the DOM elements.", "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.error("Unable to find the name : " + value + " in the DOM elements. " + e.toString());
			}
		} else if (key.equalsIgnoreCase("CLASSNAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 1);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));
				reportStep(value + " : class name is avaliable in the DOM elements.", "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.error("Unable to find the class name : " + value + " in the DOM elements. " + e.toString());
			}
		} else if (key.equalsIgnoreCase("TAGNAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 1);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(value)));
				reportStep(value + " : tag name is avaliable in the DOM elements.", "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.error("Unable to find the tag name : " + value + " in the DOM elements. " + e.toString());
			}
		} else if (key.equalsIgnoreCase("CSSSELECTOR")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 1);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));
				reportStep(value + " : css selector is avaliable in the DOM elements.", "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.error("Unable to find the css selector : " + value + " in the DOM elements. " + e.toString());
			}
		} else if (key.equalsIgnoreCase("XPATH")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 1);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
				reportStep(value + " : Xpath is avaliable in the DOM elements.", "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.error("Unable to find the Xpath : " + value + " in the DOM elements. " + e.toString());
			}
		} else {
			Log.fatal("Kindly, provide correct locator option for element.");
			reportStep("Kindly, provide correct locator option for element.", "WARN");
			throw new RuntimeException("Kindly, provide correct locator option for element.");
		}
		return bReturn;
	}

	/**
	 * This method is used to get web element and wait for 10 seconds to appear
	 * title of the web page
	 * 
	 * @param locator - find and match the elements of web page
	 * @return WebElement value
	 * @author Venkataraghavan on 06/11/2017:16:15:00PM
	 */

	public void switchToChildWindows() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}

	public void switchToParentWindow() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
	}

	public WebElement getElement(String locator) {
		// Log4j Configuration XML file
		DOMConfigurator.configure("log4j.xml");

		String[] data = locator.split("&");
		String key = data[0];
		String value = data[1];
		WebElement wReturn = null;
		if (key.equalsIgnoreCase("ID")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
				wReturn = driver.findElementById(value);
			} catch (Exception e) {
				Log.error("Unable to find the id : " + value + " in the DOM elements. " + e.toString());
				reportStep("Unable to find the id : " + value + " in the DOM elements. " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("NAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
				wReturn = driver.findElementByName(value);
			} catch (Exception e) {
				Log.error("Unable to find the id : " + value + " in the DOM elements. " + e.toString());
				reportStep("Unable to find the id : " + value + " in the DOM elements. " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("CLASSNAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));
				wReturn = driver.findElementByClassName(value);
			} catch (Exception e) {
				Log.error("Unable to find the id : " + value + " in the DOM elements. " + e.toString());
				reportStep("Unable to find the id : " + value + " in the DOM elements. " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("TAGNAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(value)));
				wReturn = driver.findElementByTagName(value);
			} catch (Exception e) {
				Log.error("Unable to find the id : " + value + " in the DOM elements. " + e.toString());
				reportStep("Unable to find the id : " + value + " in the DOM elements. " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("CSSSELECTOR")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));
				wReturn = driver.findElementByCssSelector(value);
			} catch (Exception e) {
				Log.error("Unable to find the id : " + value + " in the DOM elements. " + e.toString());
				reportStep("Unable to find the id : " + value + " in the DOM elements. " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("XPATH")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
				wReturn = driver.findElementByXPath(value);
			} catch (Exception e) {
				Log.error("Unable to find the id : " + value + " in the DOM elements. " + e.toString());
				reportStep("Unable to find the id : " + value + " in the DOM elements. " + e.toString(), "FAIL");
			}
		} else {
			Log.fatal("Kindly, provide correct locator option for element.");
			reportStep("Kindly, provide correct locator option for element.", "WARN");
			throw new RuntimeException("Kindly, provide correct locator option for element.");
		}
		return wReturn;
	}

	public boolean verifyTitleOfThePage(String expected) {
		// Log4j Configuration XML file
		DOMConfigurator.configure("log4j.xml");

		boolean bReturn = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.titleContains(expected));
			reportStep("The Title of the page is " + driver.getTitle() + " same as the expected " + expected, "PASS");
			bReturn = true;
		} catch (Exception e) {
			Log.fatal("Unable to find " + expected + " title in the page " + e.toString());
			reportStep("Unable to find " + expected + " title in the page " + e.toString(), "FAIL");
		}
		return bReturn;
	}

	public boolean checkTheCheckBoxIsCheckedDefault(String locator) {
		// Log4j Configuration XML file
		DOMConfigurator.configure("log4j.xml");

		String[] data = locator.split("&");
		String key = data[0];
		String value = data[1];
		boolean bReturn = false;
		if (key.equalsIgnoreCase("ID")) {
			try {
				bReturn = driver.findElementById(value).isSelected();
				reportStep("The checkbox " + value + " is checked default.", "PASS");
			} catch (Exception e) {
				Log.error("Unable to find the id : " + value + " in the DOM elements. " + e.toString());
				reportStep("Unable to find the id : " + value + " in the DOM elements. " + e.toString(), "FAIL");
			}
		}
		return bReturn;
	}

	public boolean selectByIndexInDropdown(String locator, int index) {
		// Log4j Configuration XML file
		DOMConfigurator.configure("log4j.xml");

		boolean bReturn = false;
		String[] data = locator.split("&");
		String key = data[0];
		String value = data[1];
		if (key.equalsIgnoreCase("ID")) {
			try {
				new Select(driver.findElementById(value)).selectByIndex(index);
				reportStep("The element with id: " + value + " is selected with index: " + index, "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("The index: " + index + " could not be selected. " + e.toString());
				reportStep("The index: " + index + " could not be selected. " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("NAME")) {
			try {
				new Select(driver.findElementByName(value)).selectByIndex(index);
				reportStep("The element with name: " + value + " is selected with index: " + index, "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("The index: " + index + " could not be selected. " + e.toString());
				reportStep("The index: " + index + " could not be selected. " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("CLASSNAME")) {
			try {
				new Select(driver.findElementByClassName(value)).selectByIndex(index);
				reportStep("The element with classname: " + value + " is selected with index: " + index, "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("The index: " + index + " could not be selected. " + e.toString());
				reportStep("The index: " + index + " could not be selected. " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("TAGNAME")) {
			try {
				new Select(driver.findElementByTagName(value)).selectByIndex(index);
				reportStep("The element with tagname: " + value + " is selected with index: " + index, "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("The index: " + index + " could not be selected. " + e.toString());
				reportStep("The index: " + index + " could not be selected. " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("CSSSELECTOR")) {
			try {
				new Select(driver.findElementByCssSelector(value)).selectByIndex(index);
				reportStep("The element with cssselector: " + value + " is selected with index: " + index, "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("The index: " + index + " could not be selected. " + e.toString());
				reportStep("The index: " + index + " could not be selected. " + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("XPATH")) {
			try {
				new Select(driver.findElementByXPath(value)).selectByIndex(index);
				reportStep("The element with xpath: " + value + " is selected with index: " + index, "PASS");
				bReturn = true;
			} catch (Exception e) {
				Log.fatal("The index: " + index + " could not be selected. " + e.toString());
				reportStep("The index: " + index + " could not be selected. " + e.toString(), "FAIL");
			}
		} else {
			Log.error("Kindly, provide correct locator option for selectByIndexInDropdown.");
			reportStep("Kindly, provide correct locator option for selectByIndexInDropdown.", "WARN");
			throw new RuntimeException("Kindly, provide correct locator option for selectByIndexInDropdown.");
		}
		return bReturn;
	}

	/**
	 * This method is used to load AUT URL and set the wait for 30 seconds.
	 * 
	 * @param url - URL that we want to load
	 * @return boolean value
	 * @author Venkataraghavan on 15/12/2017:18:00:00PM
	 * @throws Exception
	 */

	public boolean mouseOverAction(String locator) {
		// Log4j Configuration XML file
		DOMConfigurator.configure("log4j.xml");

		String[] data = locator.split("&");
		String key = data[0];
		String value = data[1];
		WebElement ele;
		Actions builder = new Actions(driver);
		boolean bReturn = false;
		if (key.equalsIgnoreCase("ID")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
				ele = driver.findElementById(value);
				builder.moveToElement(ele).build().perform();
				bReturn = true;
				reportStep("The mouse over by id : " + value + " is performed.", "PASS");
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("NAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
				ele = driver.findElementByName(value);
				builder.moveToElement(ele).build().perform();
				bReturn = true;
				reportStep("The mouse over by name : " + value + " is performed.", "PASS");
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("LINKTEXT")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(value)));
				ele = driver.findElementByLinkText(value);
				builder.moveToElement(ele).build().perform();
				bReturn = true;
				reportStep("The mouse over by linktext : " + value + " is performed.", "PASS");
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("PARTIALLINKTEXT")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(value)));
				ele = driver.findElementByPartialLinkText(value);
				builder.moveToElement(ele).build().perform();
				bReturn = true;
				reportStep("The mouse over by partial linktext : " + value + " is performed.", "PASS");
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("CLASSNAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));
				ele = driver.findElementByClassName(value);
				builder.moveToElement(ele).build().perform();
				bReturn = true;
				reportStep("The mouse over by classname : " + value + " is performed.", "PASS");
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("TAGNAME")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(value)));
				ele = driver.findElementByTagName(value);
				builder.moveToElement(ele).build().perform();
				bReturn = true;
				reportStep("The mouse over by tagname : " + value + " is performed.", "PASS");
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("CSSSELECTOR")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));
				ele = driver.findElementByCssSelector(value);
				builder.moveToElement(ele).build().perform();
				bReturn = true;
				reportStep("The mouse over by cssselector : " + value + " is performed.", "PASS");
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else if (key.equalsIgnoreCase("XPATH")) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
				ele = driver.findElementByXPath(value);
				builder.moveToElement(ele).build().perform();
				bReturn = true;
				reportStep("The mouse over by xpath : " + value + " is performed.", "PASS");
			} catch (Exception e) {
				Log.fatal("Unable to find the given element " + value + " :" + e.toString());
				reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
			}
		} else {
			Log.error("Kindly, provide correct locator option for mouseOverAction.");
			reportStep("Kindly, provide correct locator option for mouseOverAction.", "WARN");
			throw new RuntimeException("Kindly, provide correct locator option for mouseOverAction.");
		}
		return bReturn;
	}

	@Override
	public WebElement locateElement(String locatorType) {
		String[] data = locatorType.split("&");
		String key = data[0];
		String value = data[1];
		WebElement element = null;
		if (key.equalsIgnoreCase("XPATH"))
			try {
				element = driver.findElementByXPath(value);
			} catch (Exception e) {
				reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value, "fail");
			}
		else if (key.equalsIgnoreCase("ID"))
			try {
				element = driver.findElementById(value);
			} catch (Exception e) {
				reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value, "fail");
			}
		else if (key.equalsIgnoreCase("CSSSELECTOR"))
			try {
				element = driver.findElementByCssSelector(value);
			} catch (Exception e) {
				reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value, "fail");
			}
		else if (key.equalsIgnoreCase("CLASSNAME"))
			try {
				element = driver.findElementByClassName(value);
			} catch (Exception e) {
				reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value, "fail");
			}

		return element;
	}

	@Override
	public String getProp(String value) throws IOException {
		try {
			return prop.getProperty(value);
		} catch (Exception e) {
			reportStep("The Element with locatorNot Found with value: " + value, "fail");
		}
		return null;
	}

	@Override
	public String getPropfile(String propname, String value) {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./icivics_Properties/" + propname + ".properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			return prop.getProperty(value);
		} catch (Exception e) {
			reportStep("The Element with locatorNot Found with value: " + value, "fail");
		}
		return value;
	}
	
	@Override
	public String writePropfile(String propname, String key, String value) throws IOException {

		FileOutputStream fos = new FileOutputStream("./icivics_Properties/" + propname + ".properties");
		prop = new Properties();
		prop.setProperty(key, value);
		prop.store(fos, null);
		return value;
	}


	@Override
	public WebElement propElement(String locatorType) {
		String[] data = locatorType.split("&");
		String key = data[0];
		String value = data[1];
		WebElement element = null;
		if (key.equalsIgnoreCase("XPATH"))
			try {
				element = driver.findElementByXPath(value);
			} catch (Exception e) {
				reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value, "fail");
			}
		else if (key.equalsIgnoreCase("ID"))
			try {
				element = driver.findElementById(value);
			} catch (Exception e) {
				reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value, "fail");
			}
		else if (key.equalsIgnoreCase("CSSSELECTOR"))
			try {
				element = driver.findElementByCssSelector(value);
			} catch (Exception e) {
				reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value, "fail");
			}
		else if (key.equalsIgnoreCase("CLASSNAME"))
			try {
				element = driver.findElementByClassName(value);
			} catch (Exception e) {
				reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value, "fail");
			}

		return element;
	}
	
	@Override
	public List<WebElement> propElement1(String locatorType) {
		String[] data = locatorType.split("&");
		String key = data[0];
		String value = data[1];
		List<WebElement> element = null;
		if (key.equalsIgnoreCase("XPATH"))
			try {
				element = driver.findElementsByXPath(value);
			} catch (Exception e) {
				reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value, "fail");
			}
		else if (key.equalsIgnoreCase("ID"))
			try {
				element = driver.findElementsById(value);
			} catch (Exception e) {
				reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value, "fail");
			}
		else if (key.equalsIgnoreCase("CSSSELECTOR"))
			try {
				element = driver.findElementsByCssSelector(value);
			} catch (Exception e) {
				reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value, "fail");
			}
		else if (key.equalsIgnoreCase("CLASSNAME"))
			try {
				element = driver.findElementsByClassName(value);
			} catch (Exception e) {
				reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value, "fail");
			}

		return element;
	}

	public WebElement Verifylinks(WebElement element, String Expectedtext, String urlexpected, String expectedtitle)
			throws IOException {
		verifyDisplayed(element);
		verifyExactText(element, Expectedtext);
		click(element);
		verifyUrlOfThePage(urlexpected);
		verifyTitle(expectedtitle);
		return element;
	}

	public WebElement getprop(String propname, String value) throws IOException {
		return propElement(getPropfile(propname, value));
	}

	public String getpropstring(String propname, String value) throws IOException {
		return getPropfile(propname, value);
	}

	public String cssgetbefore(String cssvalue, String value, String rgbvalue) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String element = "return window.getComputedStyle(document.querySelector('" + cssvalue
					+ "'),'::before').getPropertyValue('" + value + "')";
			String backcolor = (String) js.executeScript(element);
			Assert.assertEquals(backcolor, rgbvalue);			
			if(backcolor.equals("rgb(0, 178, 124)")) {
			System.out.println("breadcrumbs back color is Green");
			}
			else {
				System.out.println("breadcrumbs back color is Grey");
			}
		} catch (Exception e) {
			Log.fatal("The backcolor is not " +rgbvalue + " :" + e.toString());
			reportStep("The backcolor is not " +rgbvalue + " :" + e.toString(), "FAIL");
		}
		return rgbvalue;
	}

	public String cssgetafter(String cssvalue, String value, String rgbvalue) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String element = "return window.getComputedStyle(document.querySelector('" + cssvalue
					+ "'),'::after').getPropertyValue('" + value + "')";
			String backcolor = (String) js.executeScript(element);
			Assert.assertEquals(backcolor, rgbvalue);
		} catch (Exception e) {
			Log.fatal("Unable to find the given element " + value + " :" + e.toString());
			reportStep("Unable to find the given element " + value + " :" + e.toString(), "FAIL");
		}
		return value;

	}

	@Override
	public String writePropfile(String propname, String value) throws IOException {
	
		return null;
	}
}