package com.ws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ws.base.DriverScript;

public class PswdRecoveryPage extends DriverScript {
	//*************************Page Element identification section ****************************//
		//These are local variables
		@FindBy(xpath = "//h1[contains(text(),'Password recovery')]") WebElement Passwordrecoverytext;
		@FindBy(xpath = "//input[@class='email']") WebElement Emailtextbox;
		@FindBy(xpath="//input[@name='send-email']") WebElement Recoverbutton;
		@FindBy(xpath = "//div[@class='result']") WebElement EmailInstructionstext;
		@FindBy(xpath= "//span[@for='Email']") WebElement WrongEmailtext;
	//*************************Page Initialization *********************//
		
		public PswdRecoveryPage()
		
		{
			PageFactory.initElements(driver, this);
		}
		
		//*************************Page Actions/Methods *********************//
		
public boolean isPswdRecoveryTextDisplayed()
{
	return Passwordrecoverytext.isDisplayed();
}
public String getPasswordRecoveryText()
{
	return Passwordrecoverytext.getText();
}

public void EnterEmail(String email)
{
	Emailtextbox.clear();
	Emailtextbox.sendKeys(email);

}
public String getPswdRecoveryPageTitle()
{
	return driver.getTitle();
}

public void ClickRecoverButton()
{
	Recoverbutton.click();
}
public boolean isEmailInstrutionstextDisplayed()
{
	return EmailInstructionstext.isDisplayed();
}

public String getWrongEmailMsg()
{
	return WrongEmailtext.getText();
}

public String getEmailSentMsg()
{
	return EmailInstructionstext.getText();
}
public boolean istextDisplayedWrongEmail()
{
	return WrongEmailtext.isDisplayed();
}
}