package org.automation.generic_utilities;

import java.time.Duration;

import org.automation.element_repository.BasePage;
import org.automation.element_repository.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseClass implements FrameworkConstants{
	
	public static WebDriver driver;
	public BasePage basepage;
	public LoginPage loginpage;
	public ReadTestdata readTestdata;
	
	
	@Parameters("bname")
	@BeforeClass
	public void launchAndMaximizeBrowser(@Optional("chrome") String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
	}
	
	@BeforeMethod
	public void logInToApplication() {
		basepage = new BasePage(driver);
		readTestdata = new ReadTestdata();
		String url =readTestdata.readDataFromProperties("url");
		String email = readTestdata.readDataFromProperties("email");
		String password = readTestdata.readDataFromProperties("password");
		driver.get(url);
		loginpage = new LoginPage(driver);
		loginpage.login(email, password);
	}
	
	@AfterMethod
	public void logOutFromApplication() {
		loginpage.logout();
	}
	
	@AfterClass
	public void tearDownBrowser() {
		driver.close();
		driver.quit();
	}
	
}
