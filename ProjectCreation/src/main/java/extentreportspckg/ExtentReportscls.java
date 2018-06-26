package extentreportspckg;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import testBase.TestBase;

public class ExtentReportscls extends TestBase
{
	@Test
	public void extentreport() throws IOException
	{

	ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/report1.html");
	
	ExtentReports extent = new ExtentReports();
		
	extent.attachReporter(reporter);
	
	ExtentTest logger = extent.createTest("Login test");
	
	logger.log(Status.INFO, "Testing the login funcionality");
	
	logger.log(Status.PASS, "Testcase has been passed");
	
	logger.pass("Test case passed", MediaEntityBuilder.createScreenCaptureFromPath("D:\\Sel\\Selenium Report Image\\Image1.jpg").build());
	
	extent.flush();
	
	ExtentTest logger2 = extent.createTest("Fail test case");
	
	logger2.log(Status.FAIL, "Test case has been failed");
		
	logger2.fail("Testcase failed", MediaEntityBuilder.createScreenCaptureFromPath("D:\\Sel\\Selenium Report Image\\Image2.jpg").build());
	
	extent.flush();
	
	}
}
