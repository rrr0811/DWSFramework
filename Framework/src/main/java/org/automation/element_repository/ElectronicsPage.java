package org.automation.element_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElectronicsPage extends BasePage{

	public ElectronicsPage(WebDriver driver) {
		super(driver);
		
	}
	
	//==================WebElements=============================
	@FindBy(partialLinkText = "Camera, photo")
	private WebElement cameraPhotoLink;
	
	@FindBy(partialLinkText = "Cell phones")
	private WebElement cellPhonesLink;

	
	//===================Getters=================================
	public WebElement getCameraPhotoLink() {
		return cameraPhotoLink;
	}

	public WebElement getCellPhonesLink() {
		return cellPhonesLink;
	}

}
