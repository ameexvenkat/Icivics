package selenium.design;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public interface Element {
	
	
	/**
	 * This method will click the element and take snap
	 * @param ele   - The Webelement (button/link/element) to be clicked
	 * @see locateElement method in Browser Class
	 * @author Venkataraghavan
	 * @throws StaleElementReferenceException
	 */
	public void click(WebElement ele);
	
	
	/**
	 * This method will enter the value in the given text field 
	 * @param ele   - The Webelement (text field) in which the data to be entered
	 * @param data  - The data to be sent to the webelement
	 * @see locateElement method in Browser Class
	 * @author Venkataraghavan
	 * @throws ElementNotInteractable,IllegalArgumentException(throws if keysToSend is null)	
	 */
	public void append(WebElement ele, String data);
	
	/**
	 * This method will clear the value in the given text field 
	 * @param ele   - The Webelement (text field) in which the data to be entered
	 * @see locateElement method in Browser Class
	 * @author Venkataraghavan
	 * @throws InvalidElementStateException	(throws if not user-editable element)	 
	 */
	public void clear(WebElement ele);
	
	/**
	 * This method will clear and type the value in the given text field 
	 * @param ele   - The Webelement (text field) in which the data to be entered
	 * @param data  - The data to be sent to the webelement
	 * @see locateElement method in Browser Class
	 * @author Venkataraghavan
	 * @throws ElementNotInteractable,IllegalArgumentException(throws if keysToSend is null)		 
	 */
	public void clearAndType(WebElement ele,String data);
	
	/**
	 * This method will get the visible text of the element
	 * @param ele   - The Webelement (button/link/element) in which text to be retrieved
	 * @author Venkataraghavan
	 * @see locateElement method in Browser Class
	 */
	public String getElementText(WebElement ele);	
	
	/**
	 * This method will get the Color values of the element
	 * @param ele   - The Webelement (button/link/element) in which text to be retrieved
	 * @see locateElement method in Browser Class
	 * @author Venkataraghavan
	 * @return The visible text of this element.
	 */
	public String getBackgroundColor(WebElement ele);
	
	/**
	 * This method will get the text of the element textbox
	 * @param ele   - The Webelement (button/link/element) in which text to be retrieved
	 * @see locateElement method in Browser Class
	 * @author Venkataraghavan
	 * @return The attribute/property's current value (or) null if the value is not set.
	 */
	public String getTypedText(WebElement ele);
	

	/**
	 * This method will select the drop down visible text
	 * @param ele   - The Webelement (dropdown) to be selected
	 * @param value The value to be selected (visibletext) from the dropdown
	 * @see locateElement method in Browser Class 
	 * @author Venkataraghavan
	 * @throws NoSuchElementException
	 */
	public void selectDropDownUsingText(WebElement ele, String value) ;
	
	/**
	 * This method will select the drop down using index
	 * @param ele   - The Webelement (dropdown) to be selected
	 * @param index The index to be selected from the dropdown
	 * @see locateElement method in Browser Class
	 * @author venkataraghavan
	 * @throws NoSuchElementException
	 */
	public void selectDropDownUsingIndex(WebElement ele, int index) ;
	
	/**
	 * This method will select the drop down using index
	 * @param ele   - The Webelement (dropdown) to be selected
	 * @param value - The value to be selected (value) from the dropdown 
	 * @see locateElement method in Browser Class
	 * @author Venkataraghavan
	 * @throws NoSuchElementException
	 */
	public void selectDropDownUsingValue(WebElement ele, String value) ;
	
	/**
	 * This method will verify exact given text with actual text on the given element
	 * @param ele   - The Webelement in which the text to be need to be verified
	 * @param expectedText  - The expected text to be verified
	 * @author Venkataraghavan
	 * @see locateElement method in Browser Class
	 * @return true if the given object represents a String equivalent to this string, false otherwise
	 */
	public boolean verifyExactText(WebElement ele, String expectedText);
	
	/**
	 * This method will verify given text contains actual text on the given element
	 * @param ele   - The Webelement in which the text to be need to be verified
	 * @param expectedText  - The expected text to be verified
	 * @author Venkataraghavan
	 * @see locateElement method in Browser Class
	 * @return true if this String represents the same sequence of characters as the specified string, false otherwise
	 */
	public boolean verifyPartialText(WebElement ele, String expectedText);

	/**
	 * This method will verify exact given attribute's value with actual value on the given element
	 * @param ele   - The Webelement in which the attribute value to be need to be verified
	 * @param attribute  - The attribute to be checked (like value, href etc)
	 * @param value  - The value of the attribute
	 * @author Venkataraghavan
	 * @see locateElement method in Browser Class
	 * @return true if this String represents the same sequence of characters as the specified value, false otherwise
	 */
	public boolean verifyExactAttribute(WebElement ele, String attribute, String value);
	
	/**
	 * This method will verify partial given attribute's value with actual value on the given element
	 * @param ele   - The Webelement in which the attribute value to be need to be verified
	 * @param attribute  - The attribute to be checked (like value, href etc)
	 * @param value  - The value of the attribute
	 * @author Venkataraghavan
	 * @see locateElement method in Browser Class
	 * @return true if this String represents the same sequence of characters as the specified value, false otherwise
	 * 
	 */
	public void verifyPartialAttribute(WebElement ele, String attribute, String value);
	
	/**
	 * This method will verify if the element is visible in the DOM
	 * @param ele   - The Webelement to be checked
	 * @author Venkataraghavan
	 * @see locateElement method in Browser Class
	 * @return true if the element is displayed or false otherwise
	 */
	public boolean verifyDisplayed(WebElement ele);
	
	/**
	 * This method will checking the element to be invisible
	 * @param ele   - The Webelement to be checked
	 * @author Venkataraghavan
	 * @see locateElement method in Browser Class
	 */
	public boolean verifyDisappeared(WebElement ele);	
	
	/**
	 * This method will verify if the input element is Enabled
	 * @param ele   - The Webelement (Radio button, Checkbox) to be verified
	 * @return true - if the element is enabled else false
	 * @author Venkataraghavan
	 * 
	 * @see locateElement method in Browser Class
	 * @return True if the element is enabled, false otherwise.
	 */
	public boolean verifyEnabled(WebElement ele);	
	
	/**
	 * This method will verify if the element (Radio button, Checkbox) is selected
	 * @param ele   - The Webelement (Radio button, Checkbox) to be verified
	 * @author Venkataraghavan
	 * @see locateElement method in Browser Class
	 * @return True if the element is currently selected or checked, false otherwise.
	 */
	public void verifySelected(WebElement ele);


	public void waitTime(long ms);
	
	public void scrollToTheGivenWebElement(String locator);

	public String getProp(String value) throws IOException;

	public String getPropfile(String propname, String value) throws IOException;

	public WebElement propElement(String locatorType);


	public boolean verifyTitlecontains(String title);


	public String writePropfile(String propname, String value) throws IOException;


	public String writePropfile(String propname, String key, String value) throws IOException;


	public List<WebElement> propElement1(String locatorType);
	
}




