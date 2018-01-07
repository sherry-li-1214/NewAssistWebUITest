package com.emc.webautomation.testcases;

import com.emc.webautomation.testcases.TestBase;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

//import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;

import com.emc.webautomation.Enum.BrowserType;
import com.emc.webautomation.action.QueryAction;
import com.emc.webautomation.commonUtil.DriverUtils;
import com.emc.webautomation.otherobject.ClientInformation;

/**
 * 
 * @author lis26
 *
 */
@SuppressWarnings("unused")

public class TestCase_BackUpAssistQuery extends TestBase {
	public String url="https://www.backupassist.com/reseller/eoi.php";
	public BrowserType browser=BrowserType.FIREFOX;
	public String queryType="MSP";
	
	//input the users from data provider
	 @DataProvider(name="SearchProvider")
	    public Object[][] getDataFromDataprovider(){
	    return new Object[][] 
	    	{
	    	    { "NewUser", new ClientInformation("f1","l1","company1","f1234.l1@gmail.com","0415629426")},
		        { "RegisteredUser", new ClientInformation("f2","l2","company1","f123.l1@gmail.com","0415629426")},
	            
	         };

	    }	
/**
 * 
 */
	 @Test(priority = 0,enabled=true)
	 @Parameters({"url","browserType","QueryType"})
	 public void setProperty(String url, String browserType,String queryType) throws Exception{
		   this.url=url;
	       System.out.println("url is:"+this.url);
	       this.queryType=queryType;
	       System.out.println("query  type is:"+this.queryType);
	  	       this.browser=BrowserType.valueOf(browserType);
	       System.out.println("browser type is :"+browser.toString());
	       super.loadBrowserByType(browser);
	       System.out.println("load the browser by this type:"+browser.toString());  
	 	 // webDriver=DriverUtils.getDriver(browser);
	     //System.out.println("here");
	    
	 }
	 
/**
 *  
 * @param userType:new user,regiserted user or invalid user
 * @param client
 */
  @Test(priority = 1,enabled=true,description = "Fill in user detailed information", dataProvider="SearchProvider")
  public void  testUserQuery(String  userType,ClientInformation client) {
    QueryAction queryAction=new QueryAction();
    queryAction.navigateToHomePage(url);
    queryAction.submitForm(client,queryType);
    String expected_text="";
    boolean actionResult=true;
    switch(userType) {
       case  "NewUser":
    	   Reporter.log("For New User Test");
    	   expected_text=client.getEmail();
     	   actionResult=queryAction.checkNewUser(expected_text);
    	   Assert.assertEquals(actionResult, true);
        	     
       break;
       case "RegisteredUser":
     	   Reporter.log("For Registered User Test");
     	   
    	   expected_text="You are already registered";
    	   actionResult=queryAction.checkRegisteredUser(expected_text);
    	   Assert.assertEquals(actionResult, true);
    	   break;
    	   
       case "InvalidUser":
    	  // queryAction.submitFormAndVerify(client);
    	   break;
    
    }
    
  }
  
  @BeforeTest
 	 
  public void beforeTest()  throws Exception {
	//System.out.println("start to test browser in :"+this.getClass().getName());  
	  //super.beforeTest(BrowserType.valueOf(browserType));
    //super.beforeTest();
	  }

  @AfterTest
  public void afterTest()  {
     super.afterTest();
  }

}
