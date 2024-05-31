package base.automation;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparReproter;
	public ExtentReports extent;
	public ExtentTest test;
	String reportName;
	
	public void onStart(ITestContext testContext) {
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		reportName ="Test-Report-"+timeStamp+".html";
		sparReproter = new ExtentSparkReporter(".\\reprot\\"+reportName);
		sparReproter.config().setDocumentTitle("PetStoreProjectAPI");
		sparReproter.config().setReportName("TestReports");
		sparReproter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(sparReproter);
		extent.setSystemInfo("Application", "Pet store API");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("Environment", "Test Environment");
		extent.setSystemInfo("user", "Rajkapoor");		
	}

	public void onTestSuccess(ITestResult testResult) {
		test= extent.createTest(testResult.getName());
		test.assignCategory(testResult.getMethod().getGroups());
		test.createNode(testResult.getName());
		test.log(Status.PASS, "Test Passed");
	}
     public void onTestFail(ITestResult testResult) {
    	test= extent.createTest(testResult.getName());
 		test.assignCategory(testResult.getMethod().getGroups());
 		test.createNode(testResult.getName());
 		test.log(Status.FAIL, "Test Failed");
 		test.log(Status.FAIL, testResult.getThrowable().getMessage());
 		
		
	}
     public void onTestSkip(ITestResult testResult) {
    	 test= extent.createTest(testResult.getName());
  		test.assignCategory(testResult.getMethod().getGroups());
  		test.createNode(testResult.getName());
  		test.log(Status.SKIP, "Test Skipped");
  		test.log(Status.SKIP, testResult.getThrowable().getMessage());
  		
	
     }
     
     public void onFinish()
     {
    	 extent.flush();
     }


}
