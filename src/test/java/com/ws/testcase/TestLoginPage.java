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
	
	
	@Test (priority = 4)
public void testIsPasswordRecoverypageDisplayed()
{
		System.out.println("testIsPasswordRecoverypageDisplayed()  : ");
		Logger = report.createTest("Test Password recovery page is displayed ");
		homePage.clickLoginLink();
		Logger.pass("clicked login link");
	loginPage.clickForgotPassword();
	Logger.pass("clicked forgot  password");
	boolean flag = pswdrecoverypage.isTextDisplayed();
	System.out.println("PswdRecoveryPageTitle:" + pswdrecoverypage.getPswdRecoveryPageTitle());
	Assert.assertTrue(flag);
	Logger.pass("password recovery page  displayed ");
		
}
	@Test (priority = 5)
	public void testEnterActualEmail() throws InterruptedException
	{
		System.out.println(" testEnterActualEmail() : ");
		Logger = report.createTest("Test EnterActualEmail ");
		homePage.clickLoginLink();
		Logger.pass("clicked login link");
			loginPage.clickForgotPassword();
			Logger.pass("clicked forgot  password");
		pswdrecoverypage.EnterEmail("selauto1@test.com");
		Logger.pass("Entered a valid email");
		pswdrecoverypage.ClickRecoverButton();
		Logger.pass("clicked on password recover button  ");
		//Thread.sleep(4000);
		boolean flag = pswdrecoverypage.isEmailInstrutionstextDisplayed();
		
		Assert.assertTrue(flag);
		Logger.pass("Message of'Email with instructions has been sent to you.' is displayed");
		
	}
	@Test (priority = 6)
	public void testEnterWrongEmail() throws InterruptedException
	{
		
		System.out.println("testEnterWrongEmail() : ");
		Logger = report.createTest("Test testEnterWrongEmail ");
		homePage.clickLoginLink();
		Logger.pass("clicked login link");
			loginPage.clickForgotPassword();
			Logger.pass("clicked forgot  password");
		pswdrecoverypage.EnterEmail("selauto1");
		Logger.pass("Entered an INvalid email");
		pswdrecoverypage.ClickRecoverButton();
		Logger.pass("clicked on password recover button  ");
		//Thread.sleep(4000);
		boolean flag = pswdrecoverypage.istextDisplayedWrongEmail();
		Assert.assertTrue(flag);
		Logger.pass("Message of'Wrong email' is displayed");
		
		//Display wrong email text msg
		
	}
}
