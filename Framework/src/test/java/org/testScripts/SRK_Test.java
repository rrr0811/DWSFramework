package org.testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SRK_Test {

	@Test(groups = {"Bollywood","PanIndia"})
	public void launchSrk() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en.wikipedia.org/wiki/Shah_Rukh_Khan");
		driver.quit();
	}
}
