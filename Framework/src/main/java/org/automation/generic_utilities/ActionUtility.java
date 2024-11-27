package org.automation.generic_utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;

/**
 * @author Harsha G R
 * 
 */
public class ActionUtility {
	
	Actions actions;
	
	/**
	 * This constructor is used to create Object for Actions class , it accepts driver ref
	 * @param driver [WebDriver]
	 */
	public ActionUtility(WebDriver driver) {
		this.actions = new Actions(driver);
	}
	
	/**
	 * This method is used to perform click action on a given Element
	 * @param element [WebElement]
	 * @return void
	 */
	public void clickOnElement(WebElement element) {
		actions.click(element).perform();
	}
	
	/**
	 * This method is used to send or pass the data to a given Element
	 * @param element [WebElement]
	 * @param data [String]
	 * @return void
	 */
	public void passDataToElement(WebElement element, String data) {
		actions.sendKeys(element, data).perform();
	}
	
	/**
	 * This method is used to perform double click action on a given Element
	 * @param element [WebElement]
	 * @return void
	 */
	public void doubleClickOnElement(WebElement element)
	{
		actions.doubleClick(element).perform();
	}
	
	/**
	 *  This method is used to perform right click action on a given Element
	 * @param element [WebElement]
	 * @return void
	 */
	public void rightClickOnElement(WebElement element) {
		actions.contextClick(element).perform();
	}
	
	/**
	 * This method is used to perform mouse Hover on a given Element
	 * @param element [WebElement]
	 * @return void
	 */
	public void mouseHoverOnElement(WebElement element) {
		actions.moveToElement(element).perform();
	}
	
	/**
	 * This method is used to perform drag and Drop action on a given Element, Here we have to pass
	 * the element which has to be drag and dropped and destination element 
	 * @param element [WebElement]
	 * @param dest [WebElement]
	 * @return void
	 */
	public void dragAndDropAnElement(WebElement element, WebElement dest) {
		actions.dragAndDrop(element, dest).perform();
	}
	
	/**
	 * This method is used to perform drag and Drop action on a given Element, Here we have to pass
	 * the element which has to be drag and dropped and x and y offset values for destination
	 * @param element [WebElement]
	 * @param xOffset [int]
	 * @param yOffset [int]
	 * @return void
	 */
	public void dragAndDropAnElementBasedOnOffset(WebElement element, int xOffset, int yOffset)
	{
		actions.dragAndDropBy(element, xOffset, yOffset).perform();
	}
	
	/**
	 * This method is used to scroll the Webpage based on the given offset values
	 * @param xOffset [int]
	 * @param yOffset [int]
	 * @return void
	 */
	public void scrollBasedOnAmount(int xOffset, int yOffset) {
		actions.scrollByAmount(xOffset, yOffset).perform();
	}
	
	/**
	 * This method is used to scroll the Webpage until the given element is visible in 
	 * view port area
	 * @param element [WebElement]
	 * @return void
	 */
	public void scrollUntilElementIsVisible(WebElement element) {
		actions.scrollToElement(element).perform();
	}
	
	/**
	 * This method is used to scroll the Webpage until the given element is visible in 
	 * view port area and it allows us to scroll extra after the element is visible in 
	 * View port area by accepting offset values
	 *  
	 * @param element [WebElement]
	 * @param xOffset [int]
	 * @param yOffset [int]
	 * @return void
	 */
	public void scrollUntilElementIsVisible(WebElement element, int xOffset, int yOffset) {
		actions.scrollFromOrigin(ScrollOrigin.fromElement(element), xOffset, yOffset).perform();
	}
	
	/**
	 * This method is used to perform pause action on the webpage, it accepts time in seconds
	 * @param seconds [int]
	 */
	public void pauseAction(int seconds) {
		actions.pause(Duration.ofSeconds(seconds)).perform();
	}
}
