package com.emc.webautomation.action;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.testng.Reporter;

//import com.emc.webautomation.pageobjects.PageBase;
import com.emc.webautomation.pageobjects.*;
import com.emc.webautomation.otherobject.*;
/**
 * Created by sherry on 1/6/2018.
 */
@SuppressWarnings("unused")

public class QueryAction {

	PageMain mainPage=new PageMain();
	
	public QueryAction()	{
		
	}
	
    public void navigateToHomePage(String url){
    	mainPage= new PageMain(url);
        mainPage.navigateToPageMain();
    }

    public void submitForm(ClientInformation clientInfo,String queryType){
        mainPage.setClientInfo(clientInfo);
      /**   ArrayList<String> arrayListInvalid=new ArrayList();//clientInfo.getErrorFormatInfo(clientInfo);
         if(arrayListInvalid.size()!=0){
   //System.out.println("The test data is used to verify  invalid input, pls check  page  display for the error!")     	 
       
         } else {
        	 
         }
         **/
        mainPage.sleep(10000);
        mainPage.selectProgram(queryType);
         mainPage.submitQuery();
         
    }
    
   /**
    * verify when filled the existed user,page will show the user is existed t 
    * @param text
    * @return
    */
    public boolean checkRegisteredUser(String text){
    	mainPage.sleep(50000);
      if((this.mainPage.isTextPresent(text))){
    	  return true;
      } else {
    	  return false;
      }
    }

    
    /**
     * verify when filled the new user,page will switch to registered success page
     * @param text:the user's  email should be displayed in the success page
     * @return
     */
    
     public  boolean checkNewUser(String text) {
    	 PageBase pageSuccess = new PageRegisterSuccess();
    	 String strCurrentURL=pageSuccess.getCurrentURL();
    	 if(!strCurrentURL.contains(PageRegisterSuccess.URL)){
    		 Reporter.log("the urll  in current page is not same with expected!");
    	     return false;
    	  }
    	 if(pageSuccess.getCurrentURL().contains(text)&& pageSuccess.isTextPresent(text)){
    	   return true;
    	 }  else {
    		 Reporter.log("the text:"+text+"should be displayed on the page,but not. Failed the test");
    	     return false;   
    	 } 		 
    	 }
     

      public  void checkRegisterPage() {
    	  
      }
     
   }
