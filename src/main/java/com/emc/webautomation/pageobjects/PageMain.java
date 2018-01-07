package com.emc.webautomation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.emc.webautomation.otherobject.ClientInformation;
import com.emc.webautomation.pageobjects.PageBase;

//import  java.util.ArrayList;
@SuppressWarnings("unused")

public class PageMain extends PageBase{
	 private final By FIRST_NAME_INPUT = By.name("name");
	 private final By LAST_NAME_INPUT = By.name("ss-Lname");
	 private final By COMPANY_NAME_INPUT = By.name("company_name");
	 private final By EMAIL_ADDRESS_INPUT = By.name("email");
     private final By PHONE_INPUT= By.name("phone");
     
     private final By LIST_PROGRAM=By.cssSelector("input[type='radio']"); 
     private final By MSP_PROGRAM=By.xpath("//label[@for='dr1']"); //#dr1
     private final By Gold_Program=By.xpath("//label[@for='dr2']");//By.cssSelector("input[value='gold']");
     private  final  By Silver_Program=By.xpath("//label[@for='dr3']");
     private final By SUBMIT_BUTTON=By.id("ba-reseller-button-submit");
      private String url="";    
	 
     public PageMain(String url){
	    	this.url=url;
	    	
	    }
     public PageMain(){
    	 
     }
	    public void navigateToPageMain() {
	    	//TestHTMLReporter.
	        System.out.println("Navigating to URL:" + url);
	        navigateToURL(url);
	    }

	    public void setFirstName(String firstname){
	       sendKeys(FIRST_NAME_INPUT,firstname);
	    }
	    public void setLastName(String lastname){
		       sendKeys(LAST_NAME_INPUT,lastname);
		    }
	    public void setCompanyName(String companyname){
		       sendKeys(COMPANY_NAME_INPUT,companyname);
		    }
	    public void setEMAIL(String email){
		       sendKeys(EMAIL_ADDRESS_INPUT,email);
		    }
	    public void setPHONE(String phone){
		       sendKeys(PHONE_INPUT,phone);
		    }
	
	     public  void setClientInfo(ClientInformation client){
	    	 this.setFirstName(client.getFirstName());
	    	 this.setLastName(client.getLastName());
	    	 this.setCompanyName(client.getCompanyName());
	    	 this.setEMAIL(client.getEmail());
	    	 this.setPHONE(client.getPhone());
	     }
	     
	     
	   
	    public void selectProgram(String program) {
	    	
	     List<WebElement> listWebElement=this.getElements(this.LIST_PROGRAM);
	      switch (program){
	      case "MSP":
	    	  this.click(this.MSP_PROGRAM);
	        //  listWebElement.get(0).click();
	    	  break;
	      case "Gold":
	    	  this.click(this.Gold_Program);
	  	         break;
	      case "Silver":
	    	  this.click(this.Silver_Program);
	  	         break;
	      default:
	    	  click(this.MSP_PROGRAM);
	      }
	    }
	    
	    public void submitQuery() {
	    	click(this.SUBMIT_BUTTON);
  	    }
		    	    
}


      