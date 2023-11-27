package com.store.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.store.pageobject.Sauceloginpage;
import com.store.utilities.ReadExcel;

public class TC_Loginpagetest_Datadriven extends Baseclass 

{
@Test(dataProvider ="LoginDataProvider")
	public void verifylogin(String username3,String userpwd3) throws InterruptedException 
	{
		
		
		
		Sauceloginpage pg=new Sauceloginpage(driver);
		pg.enterusername("username3");
		
		logger.info("username is entered");
		pg.enterpassword("userpwd3");
		
		logger.info("password is entered");
		
		Thread.sleep(3000);
		
		pg.clickloginbutton();
		logger.info("click on signinbutton");
		
	}
@DataProvider(name = "LoginDataProvider")
public String[][] LoginDataProvider()
{
	
	System.out.println(System.getProperty("user.dir"));
	String filename=System.getProperty("user.dir") + "\\TestData\\Secretsauce_logincredential.xlsx";
	int ttlrows=ReadExcel.getRowCount(filename, "Logintestdata");
	int ttlColumns=ReadExcel.getColcount(filename, "Logintestdata");
	
	String data[][]= new String[ttlrows-1][ttlColumns];
	
	for(int i=1;i<ttlrows;i++) 
	{
		for(int j=0;j<ttlColumns;j++) 
		{
			data[i-1][j]=ReadExcel.getCellValue(filename, "Logintestdata", i, j);
		}
		
	}
	return data;
	
}
	
	
	
	
	
}
