package com.ws.testcase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPasswordRecoveryPage extends BaseTest{
	
	@Test (priority = 1)
public void testIsPasswordRecoverypageDisplayed()
{
		System.out.println("testIsPasswordRecoverypageDisplayed()  : ");
		Logger = report.createTest("Test Password recovery page is displayed ");
		homePage.clickLoginLink();
		Logger.pass("clicked login link");
	loginPage.clickForgotPassword();
	Logger.pass("clicked forgot  password");
	boolean flag = pswdrecoverypage.isPswdRecoveryTextDisplayed();
	System.out.println("PswdRecoveryPageTitle:" + pswdrecoverypage.getPswdRecoveryPageTitle());
	Assert.assertTrue(flag);
	Logger.pass("password recovery page  displayed ");
		
}
	@Test (priority = 2)
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
	@Test (priority = 3)
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
