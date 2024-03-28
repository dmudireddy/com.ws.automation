package com.ws.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ws.pages.HomePage;
import com.ws.pages.LoginPage;
import com.ws.pages.PswdRecoveryPage;
import com.ws.pages.UserHomePage;

import com.ws.base.DriverScript;

public class BaseTest extends DriverScript {
	HomePage homePage;
	LoginPage loginPage;
	UserHomePage userHomepage;
	PswdRecoveryPage pswdrecoverypage;
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
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(4000);
		quitDriver();
	}

}
