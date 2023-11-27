package com.store.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.store.utilities.Readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass 
{

	Readconfig readconfig=new Readconfig();
	
	String url=readconfig.getBaseUrl();
	String browser=readconfig.getBrowser();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup()
	{
		String browser="chrome";
		
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			
			default:
				driver=null;
				break;
}
		//implicity wait for 10 sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		logger=LogManager.getLogger("inetbanking_v1");
		
		
		//open url
		
		driver.get(url);
		logger.info("url opened");
		
	}
	
	/*@AfterClass
	
	public void teardown()
	{
		driver.close();
		driver.quit();
	}*/
	
	public void capturescreenshot(WebDriver driver,String testname) throws IOException 
	{
		TakesScreenshot screenshot=((TakesScreenshot)driver);
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir") + "//screenshot//" + testname + ".png");
		FileUtils.copyFile(src, dest);
	}
	
	public String randomeString() 
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(16);
		return generatedstring;
		
	}
	
	public static String randomenum() 
	{
		String generatedstring2=RandomStringUtils.randomNumeric(8);
		return generatedstring2;
		
	}
	
}
