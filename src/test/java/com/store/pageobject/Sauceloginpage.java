package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sauceloginpage 
{
	
	
	WebDriver ldriver;
	
	public Sauceloginpage(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="user-name")
	WebElement usernametextfield;
	
	@FindBy(id="password")
	WebElement passwordtextfield;
	
	@FindBy(id="login-button")
	WebElement loginbutton;
	
	
	public void enterusername(String username1) 
	{
		usernametextfield.sendKeys(username1);
		
	}
	
	public void enterpassword(String password1)
	{
		passwordtextfield.sendKeys(password1);
	}
	
	public void clickloginbutton()
	{
		loginbutton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
