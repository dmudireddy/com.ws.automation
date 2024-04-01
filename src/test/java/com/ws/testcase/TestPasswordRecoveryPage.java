package com.ws.testcase;
import org.testng.annotations.Test;

public class TestPasswordRecoveryPage extends BaseTest{
	
	@Test
	public void testPasswordRecoverPage()
	{
		Logger = report.createTest("Test Password Revoery Page");
		homePage.clickLoginLink();
		Logger.pass("clicked login link");
		
		
	}

	
	

}
