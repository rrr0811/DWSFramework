package org.testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BMW_Test {
	@Test
	public void launchBmw() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bmw-motorrad.in/en/home.html#/filter-all");
		Reporter.log("BMW is launched", true);
		driver.quit();
	}
}
