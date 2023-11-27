package com.store.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentlistnerclass implements ITestListener

{
	
	
	ExtentSparkReporter htmlreporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport() 
	{
		
		String timestamp=new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportname="inetbanking_v1" + timestamp + ".html";
		
		htmlreporter=new ExtentSparkReporter("ExtentlistnerReportdemo.html");
		reports=new ExtentReports();
		reports.attachReporter(htmlreporter);
		
		reports.setSystemInfo("machine", "testpc1");
		reports.setSystemInfo("os", "windows10");
		reports.setSystemInfo("browser", "chrome");
		
		htmlreporter.config().setDocumentTitle("Extent Listner Report demo");
		htmlreporter.config().setReportName("this is my first report");
		htmlreporter.config().setTheme(Theme.DARK);
	}
	
	public void onStart(ITestContext Result) 
	{
		configureReport();
		System.out.println("on start method invoked");
		
	}
	
	public void onFinish(ITestContext Result) 
	{
		
		System.out.println("on start method invoked");
		reports.flush();
		
	}
	
	public void onTestFailure(ITestResult Result) 
	{
		
		System.out.println("Name of test method failed:" + Result.getName());
		test=reports.createTest(Result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of failed test case is:" + Result.getName(), ExtentColor.RED));
		String screenshotpath=System.getProperty("user.dir") + "\\screenshot\\" + Result.getName() + ".png";
		File screenshotfile=new File(screenshotpath);
		if(screenshotfile.exists()) {
			test.fail("CapturevScreenshot is below:" + test.addScreenCaptureFromPath(screenshotpath));
		}
		
	}
	
	public void onTestSkipped(ITestResult Result) 
	{
		
		System.out.println("Name of test method skipped:" + Result.getName());
		test=reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of skip test case is:" + Result.getName(), ExtentColor.YELLOW));
		
	}
	
	public void onTestStart(ITestContext Result) 
	{
		
		System.out.println("Name of the testmethod started:" + Result.getName());
	}
	
	public void onTestSuccess(ITestResult Result) 
	{
		
		System.out.println("Name of test method successfully executed:" + Result.getName());
		test=reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of  test case is executed succesfully:" + Result.getName(), ExtentColor.GREEN));
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) 
	{
		
		
	}
	
	
	
	
	
	
	
	
	

}
