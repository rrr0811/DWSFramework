package org.testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Hayabusa_Test {
	@Test
	public void launchHayabusa() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.suzukimotorcycle.co.in/product-details/hayabusa");
		Reporter.log("Hayabusa is launched", true);
		driver.quit();
	}
}
