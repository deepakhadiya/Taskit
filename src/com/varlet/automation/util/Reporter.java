package com.varlet.automation.util;

import java.util.ArrayList;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.varlet.automation.common.BaseTest;

public class Reporter extends BaseTest{


	static ExtentReports extent;
	static ExtentTest parent;
	static ExtentTest child;
	static ArrayList<ExtentTest> childArray;
	
	public static void getReporter() {
		if (extent == null) {
			String workingDir = System.getProperty("user.dir");
			extent = new ExtentReports(workingDir + "\\Reports\\Results.html", true);
		}
	}
	
	public void startParent(String testName,String description){
		parent=extent.startTest(testName, description);
		childArray=new ArrayList<ExtentTest>();
	}
	
	public void startStep(String stepName,String stepDescription){
		
		child=extent.startTest(stepName, stepDescription);
	}
	
	public void logChildStatus(LogStatus status,String description){
		child.log(status, description);
	}
	
	public void logParentStatus(LogStatus status,String description){
		parent.log(status, description);
	}
	public void logMessage(String description){
		child.log(LogStatus.INFO, description);
	}
	public void logChildStatusWithScreenShots(LogStatus logStatus,String desString){
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)getDriver()).
                getScreenshotAs(OutputType.BASE64);
        child.log(logStatus, desString+child.addBase64ScreenShot(base64Screenshot));
	}
	
	public void logParentStatusWithScreenShots(LogStatus logStatus,String desString){
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot) getDriver()).
                getScreenshotAs(OutputType.BASE64);
        parent.log(logStatus, desString+child.addBase64ScreenShot(base64Screenshot));
	}
	public void endStep(){
		extent.endTest(child);
		childArray.add(child);
	}
	
	public static void endParent(){
		for (ExtentTest test:childArray) {
			parent.appendChild(test);
		}
		extent.endTest(parent);
	}
	
	public static void endReport(){
		extent.flush();
	}
}
