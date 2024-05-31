package com.automation.base;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.extentReports.ExtentTestManager;

public class CommonnActions {
	public static String fileSeperator = System.getProperty("file.separator");
	public static String failedScreenshotsPath = absoluteFilePath(fileSeperator+"FailedScreenshots").getAbsolutePath();
	public static String passedScreenshotsPath = absoluteFilePath(fileSeperator+"PassedScreenshots").getAbsolutePath();
	
	public static void takeScreenshot1(String testCaseName,WebDriver tempDriver) throws Exception 
	{
		try 
		{	
			File file = new File(passedScreenshotsPath+File.separator+testCaseName+".png");
			String temp_path = file.getAbsolutePath();

			TakesScreenshot scrShot =((TakesScreenshot)tempDriver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File(temp_path);
			FileUtils.copyFile(SrcFile, DestFile);

			String imgstr = imageToBase64String(DestFile.getAbsolutePath());
			
			ExtentTestManager.getTest().pass(testCaseName,MediaEntityBuilder.createScreenCaptureFromBase64String(imgstr).build());
//			ExtentTestManager.getTest().pass(testCaseName);
		} 
		catch (Exception e)
		{
			System.out.println("Unable to takescreen shot");
			System.out.println(e.getMessage());
		}
		
		
	}

}
