package com.ws.testcase;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ws.pages.HomePage;
import com.ws.pages.LoginPage;
import com.ws.pages.PswdRecoveryPage;
import com.ws.pages.UserHomePage;
import com.ws.utils.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ws.base.DriverScript;

public class BaseTest extends DriverScript {
	protected static ExtentTest Logger;
	protected static ExtentReports report;
	HomePage homePage;
	LoginPage loginPage;
	UserHomePage userHomepage;
	PswdRecoveryPage pswdrecoverypage;
	@BeforeSuite
	public void setUpReport()
	{
		ExtentHtmlReporter extent = new ExtentHtmlReporter("./testreport/automationreport.html");
		report = new ExtentReports();
		report.attachReporter(extent);
		
	}
	@BeforeMethod
	public void setUp()
	{
		initApplication();
		homePage = new HomePage();
		loginPage = new LoginPage();
		 userHomepage = new UserHomePage();
		 pswdrecoverypage = new PswdRecoveryPage();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			try {
				Logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreen(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		report.flush();
		Thread.sleep(4000);
		quitDriver();
	}

}
