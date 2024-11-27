package org.automation.generic_utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Harsha G R
 * 
 * This class contains resuable components related to the selenium WebDriver
 * 
 */
public class WebDriverUtility implements FrameworkConstants{
	/**
	 * This method is used to click on OK Button in An Alert
	 * @param driver [WebDriver]
	 * @return void
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method is used to click on Cancel Button in An Alert
	 * @param driver [WebDriver]
	 * @return void
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method is used to send data to a prompt Alert
	 * @param driver [WebDriver]
	 * @param data [String]
	 * @return void
	 */
	public void sendDataToAlert(WebDriver driver , String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	 
	/**
	 * This method is used to fetch the text in an Alert
	 * @param driver [WebDriver]
	 * @return text of an alert [String]
	 */
	public String fetchTextFromAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method is used to switch to a particular tab or window using the title of the webpage
	 * @param driver [WebDriver]
	 * @param title [String]
	 * @return void
	 */
	public void switchToATabBasedOnTitle(WebDriver driver, String title)
	{
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String windowId : allWindowIds)
		{
			driver.switchTo().window(windowId);
			if(driver.getTitle().equalsIgnoreCase(title))
			{
				break;
			}
		}
	}
	
	/**
	 * This method is used to switch to a particular tab or window using URL of the webpage
	 * @param driver [WebDriver]
	 * @param url [String]
	 * @return void
	 */
	public void switchToATabBasedOnURL(WebDriver driver, String url)
	{
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String windowId : allWindowIds)
		{
			driver.switchTo().window(windowId);
			if(driver.getCurrentUrl().equalsIgnoreCase(url))
			{
				break;
			}
		}
	}
	
	/**
	 * This method is used to switch to a particular frame by using index
	 * @param driver [WebDriver]
	 * @param index [int]
	 * @return void
	 */
	public void switchToAFrameUsingIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used to switch to a particular frame by using element
	 * @param driver [WebDriver]
	 * @param element [WebElement]
	 * @return void
	 */
	public void switchToAFrameUsingElement(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method is used to switch to a particular frame by using name or id attributes value
	 * @param driver [WebDriver]
	 * @param nameOrId [String]
	 * @return void
	 */
	public void switchToAFrameUsingNameOrId(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method is used to capture the screenshot and store it in a given folder
	 * 
	 * @param driver [WebDriver]
	 * @return void
	 */
	public void captureScreenShot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File screenshot=ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(ERRORSHOTPATH+JavaUtility.timeStamp()+"screenshot.png");
		try {
			FileHandler.copy(screenshot, dest);
		} catch (IOException e) 
		{
			
		}
	}
	
	public void selectAllOptions(WebDriver driver, WebElement dropDownElement) {
		Select s = new Select(dropDownElement);
		if(s.isMultiple()) 
		{
			List<WebElement> allOptions = s.getOptions();
			for(WebElement option: allOptions)
			{
				String text=option.getText();
				s.selectByVisibleText(text);
			}
		}
		else
		{
			throw new NotAMultiSelectDropDownException("It is a Single select DropDown");
		}
	}
}
