package org.testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Harley_Test {
	@Test
	public void launchHarley() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.harley-davidson.com/in/en/index.html");
		Reporter.log("Harley is launched", true);
		driver.quit();
	}
}
