package Testcases;

import Library.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportSample {
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	@Test 
	public void verifyblogTest(){
		report= new ExtentReports("C:\\Users\\sharvari.bhosale\\Desktop\\Desktop\\Report\\blogreport.html");
		logger =report.startTest("Test1verifyblogTest");
		
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		
		logger.log(LogStatus.INFO, "Browser opened");
		
		
		driver.get("http://www.gmail.com");
		
		logger.log(LogStatus.INFO, "Application is Up and Running");
		
		driver.getTitle();
		
		logger.log(LogStatus.PASS, "Test Passed");
	}
	 
@AfterMethod
public void teardown(ITestResult result){
	if(result.getStatus()==ITestResult.FAILURE)
	{
		String screenshot_path=Utility.captureScreenshot(driver,result.getName());
		logger.log(LogStatus.FAIL,"Title verification", screenshot_path);
	}
report.endTest(logger);
report.flush();

driver.get("C:\\Users\\sharvari.bhosale\\Desktop\\Desktop\\Report\\blogreport.html");
}
}
