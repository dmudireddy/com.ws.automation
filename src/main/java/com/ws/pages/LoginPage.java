package com.ws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ws.base.DriverScript;

public class LoginPage extends DriverScript {
	
	//*************************Page Element identification section ****************************//
	
		@FindBy(id = "Email") WebElement emailTextBox;
		@FindBy(id="Password11") WebElement passwordTextBox;
		@FindBy(xpath = "//input[@value = 'Log in']") WebElement loginButton;
		@FindBy(linkText = "Forgot password?") WebElement forgotPasswordLink;
		
		
	//*************************Page Initialization *********************//
		
		public LoginPage()
		
		{
			PageFactory.initElements(driver, this);
		}
		
		//*************************Page Actions/Methods *********************//

		public void enterEmail(String email)
		
		{
			emailTextBox.sendKeys(email);
		}
		
		public void enterPassword(String password)
		{
			passwordTextBox.sendKeys(password);
			
		}
		
		public String getLoginPageTitle()
		{
			return driver.getTitle();
		}
		
		public void clickLoginButton()
		{
			loginButton.click();
		}
		
		public boolean isForgotPassowrdLinkDisplayed()
		{
			return forgotPasswordLink.isDisplayed();
		}
		public void clickForgotPassword()
		{
			forgotPasswordLink.click();
		}
		
		public boolean isDisplayed()
		{
			return false;
			
		}
		}
