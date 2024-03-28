package com.ws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ws.base.DriverScript;



public class HomePage extends DriverScript {
	
//*************************Page Element identification section ****************************//
	//These are local variables
	@FindBy(linkText = "Log in") WebElement loginLink;
	
	
//*************************Page Initialization *********************//
	
	public HomePage()
	
	{
		PageFactory.initElements(driver, this);
	}
	
	//*************************Page Actions/Methods *********************//
	
	public String getHomePageTitile()
	{
		return driver.getTitle();
	}
	public void clickLoginLink()
	
	{
		loginLink.click();
	}

}
