package org.automation.element_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//===============elements===========================
	
	@FindBy(id = "Email")
	private WebElement emailTextBox;
	
	@FindBy(id = "Password")
	private WebElement passwordTextBox;
	
	@FindBy(id = "RememberMe")
	private WebElement rememberMeCheckBox;
	
	@FindBy(linkText = "Forgot password?")
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginButton;

	//=================Getters======================
	public WebElement getEmailTextBox() {
		return emailTextBox;
	}

	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}

	public WebElement getRememberMeCheckBox() {
		return rememberMeCheckBox;
	}

	public WebElement getForgotPasswordLink() {
		return forgotPasswordLink;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	//=================Business Scenarios===========================
	
	public void login(String email, String password)
	{
		getLoginLink().click();
		emailTextBox.clear();
		emailTextBox.sendKeys(email);
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
		loginButton.click();
	}
	
	public void logout() {
		getLogOutLink().click();
	}
}
