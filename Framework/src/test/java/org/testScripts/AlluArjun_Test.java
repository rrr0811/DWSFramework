package org.testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AlluArjun_Test {

	@Test(groups = {"Tollywood","PanIndia"})
	public void launchAlluArjun() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en.wikipedia.org/wiki/Allu_Arjun");
		driver.quit();
	}
}
