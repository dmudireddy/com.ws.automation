package com.ws.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginPage extends BaseTest{
	
	@Test(priority = 1)	
public void testLoginPageTitle() 
{
		//System.out.println("Now  TestLoginPAgeTitle test  : ");
		homePage.clickLoginLink();
		String title = loginPage.getLoginPageTitle();
		System.out.println("Page title : " + title);
		Assert.assertTrue(title.contains("Login"));
		
			
}
	
	@Test(priority = 2)
	public void testLoginFunction() 
	{
		//System.out.println("Inside testLoginFunction test  : ");
		homePage.clickLoginLink();
		loginPage.enterEmail("selauto1@test.com");
		loginPage.enterPassword("Pass@123");
		loginPage.clickLoginButton();
		boolean flag = userHomepage.isLogoutLinkDisplayed();
		Assert.assertTrue(flag);
		System.out.println("UserHomepagetitle :" + userHomepage.getUserHomePageTitle() );
		userHomepage.clickLogout();
		
				
	}
	
	@Test(priority =3)
	public void testForgotPasswordIsDisplayed()
	{
		//System.out.println("Inside testForgotPassword  : ");
		homePage.clickLoginLink();
		boolean flag  = loginPage.isForgotPassowrdLinkDisplayed();
		Assert.assertTrue(flag);
		
	}
	
	
	@Test (priority = 4)
public void testIsPasswordRecoverypageDisplayed()
{
		//System.out.println("Inside testispasswordrecovery test  : ");
homePage.clickLoginLink();
	loginPage.clickForgotPassword();
	boolean flag = pswdrecoverypage.isTextDisplayed();
	System.out.println("PswdRecoveryPageTitle:" + pswdrecoverypage.getPswdRecoveryPageTitle());
	Assert.assertTrue(flag);
	
	
}
	@Test (priority = 5)
	public void testEnterActualEmail() throws InterruptedException
	{
		//System.out.println("Inside testEnterActualEmail test  : ");
		homePage.clickLoginLink();
			loginPage.clickForgotPassword();
		pswdrecoverypage.EnterEmail("selauto1@test.com");
		pswdrecoverypage.ClickRecoverButton();
		//Thread.sleep(4000);
		boolean flag = pswdrecoverypage.isEmailInstrutionstextDisplayed();
		
		Assert.assertTrue(flag);
		//Display email is snet
		
	}
	@Test (priority = 6)
	public void testEnterWrongEmail() throws InterruptedException
	{
		//
		System.out.println("Inside testEnterWrongEmail test  : ");
		homePage.clickLoginLink();
			loginPage.clickForgotPassword();
		pswdrecoverypage.EnterEmail("selauto1");
		pswdrecoverypage.ClickRecoverButton();
		//Thread.sleep(4000);
		boolean flag = pswdrecoverypage.istextDisplayedWrongEmail();
		Assert.assertTrue(flag);
		
		
		//Display wrong email text msg
		
	}
}
