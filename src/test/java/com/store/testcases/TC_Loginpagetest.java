package com.store.testcases;

import org.testng.annotations.Test;

import com.store.pageobject.Sauceloginpage;

public class TC_Loginpagetest extends Baseclass 

{
@Test
	public void verifylogin() throws InterruptedException 
	{
		
		
		
		Sauceloginpage pg=new Sauceloginpage(driver);
		pg.enterusername("standard_user");
		
		logger.info("username is entered");
		pg.enterpassword("secret_sauce");
		
		logger.info("password is entered");
		
		Thread.sleep(3000);
		
		pg.clickloginbutton();
		logger.info("click on signinbutton");
		
	}
	
	
	
	
	
}
