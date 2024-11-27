package org.automation.generic_utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class MyListeners extends BaseClass implements ITestListener{

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("<test> --"+ context.getName()+" started", true);;
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("<test> --"+ context.getName()+" finish" , true);
	}

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("[ Testcase -- "+result.getName()+ " started ]");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("[ Testcase -- "+result.getName()+ " sucess ]");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("[ Testcase -- "+result.getName()+ " failed ]");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(ERRORSHOTPATH+JavaUtility.timeStamp()+"screenshot.png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("[ Testcase -- "+result.getName()+ " skipped ]");
	}
	
}
