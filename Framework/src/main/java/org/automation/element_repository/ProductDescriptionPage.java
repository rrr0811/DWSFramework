package org.automation.element_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDescriptionPage extends BasePage{

	public ProductDescriptionPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//input[@value='Add to cart']")
	private WebElement addToCartButton;
	
	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

}
