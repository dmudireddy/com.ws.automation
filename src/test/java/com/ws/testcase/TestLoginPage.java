package com.ws.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginPage extends BaseTest{
	
	@Test(priority = 1)	
public void testLoginPageTitle() 
{
		System.out.println("testLoginPageTitle() : ");
		Logger = report.createTest("Test login page");
		homePage.clickLoginLink();
		Logger.pass("clicked login link");
		String title = loginPage.getLoginPageTitle();
		Logger.pass("get the login page title:" +title);
		System.out.println("Page title : " + title);
		Assert.assertTrue(title.contains("Login"));
		Logger.pass("login page verificaitn successful");
		
			
}
	
	@Test(priority = 2)
	public void testLoginFunction() 
	{
		System.out.println(" testLoginFunction()  : ");
		Logger = report.createTest("Test Login Function");
		homePage.clickLoginLink();
		Logger.pass("clicked login link");
		loginPage.enterEmail("selauto1@test.com");
		Logger.pass("entered username");
		loginPage.enterPassword("Pass@123");
		Logger.pass("entered password");
		loginPage.clickLoginButton();
		Logger.pass(" Click login button");
		boolean flag = userHomepage.isLogoutLinkDisplayed();
		Assert.assertTrue(flag);
		System.out.println("UserHomepagetitle :" + userHomepage.getUserHomePageTitle() );
		userHomepage.clickLogout();
		Logger.pass(" Login page verificaition successful");
		
				
	}
	
	@Test(priority =3)
	public void testForgotPasswordIsDisplayed()
	{
		System.out.println("testForgotPasswordIsDisplayed()");
		Logger = report.createTest("Test Forgot password link is displayed ");
		homePage.clickLoginLink();
		Logger.pass("clicked login link");
		boolean flag  = loginPage.isForgotPassowrdLinkDisplayed();
		Assert.assertTrue(flag);
		Logger.pass(" Forgot passwrd link  is displayed");
		
	}
	
	

}
