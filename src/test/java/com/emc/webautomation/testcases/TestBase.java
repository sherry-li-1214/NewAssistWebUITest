package com.emc.webautomation.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;


//import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import com.emc.webautomation.commonUtil.*;
import  com.emc.webautomation.Enum.BrowserType;

@SuppressWarnings("unused")
public class TestBase {
  WebDriver  webDriver;
  BrowserType browser=BrowserType.FIREFOX;

  
	public void loadBrowserByType(BrowserType browser){
	System.out.println("load the browser by this type:"+browser.toString());  
	  webDriver=DriverUtils.getDriver(browser);
      webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      
    System.out.println("here");
    
  }
  
  @BeforeTest
 	
	public void beforeTest() throws Exception {
	  
	  webDriver=DriverUtils.getDriver(browser);
      System.out.println("here");
      webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      
  }
	@AfterTest
	public void afterTest() {
	   try   {
		DriverUtils.tearDown();
	   } catch (Exception e){
		   e.printStackTrace();
	   }
	}
}
