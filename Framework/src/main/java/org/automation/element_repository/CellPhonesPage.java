package org.automation.element_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CellPhonesPage extends BasePage {

	public CellPhonesPage(WebDriver driver) {
		super(driver);
	}
	
	//===================WebElements=========================
	
	@FindBy(partialLinkText = "Smartphone")
	private WebElement smartPhoneLink;
	
	@FindBy(partialLinkText = "Used phone")
	private WebElement usedPhoneLink;
	
	@FindBy(partialLinkText = "Phone Cover")
	private WebElement phoneCoverLink;

	
	//===================Getters==============================

	public WebElement getSmartPhoneLink() {
		return smartPhoneLink;
	}

	public WebElement getUsedPhoneLink() {
		return usedPhoneLink;
	}

	public WebElement getPhoneCoverLink() {
		return phoneCoverLink;
	}
	

}
