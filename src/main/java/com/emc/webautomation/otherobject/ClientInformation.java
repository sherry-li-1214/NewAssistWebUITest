package com.emc.webautomation.otherobject;

import java.util.ArrayList;

//import com.emc.webautomation.commonUtil.*;


/**
 * Created by sherry on 1/7/201.
 */
@SuppressWarnings("unused")

public class ClientInformation{

    private String firstName = "";
    private String lastName = "";
    private String companyName="";
    private String email = "";
    private String phone = "";

    public ClientInformation(){
    }
    
    public ClientInformation(String firstName,String lastName,String companyName,String email,String phone){
       this.firstName=firstName;
       this.lastName=lastName;
       this.companyName=companyName;
       this.email=email;
       this.phone=phone;
}

    @Override
    public String toString(){
        return String.format(
                "First Name:  " + this.firstName + "\n"
                + "Last Name: " + this.lastName + "\n"
                + "Company Name: " + this.companyName + "\n"
                + "Email:  " + this.email + "\n"
                + "Phone:  " + this.phone + "\n"
        );
    }


        /**
         * 
         * @return
         */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName=firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
  
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /**
     * put the wrong format information into lIST
     * 
     * @param clientInfo
     * @return
     */
   /** public ArrayList<String> getErrorFormatInfo(ClientInformation clientInfo){
    	ArrayList<String>  arrayList=new ArrayList<String>();
        if(!(InputValidation.isValidString(clientInfo.getFirstName()))) {
        	//hasResult.put(clientInfo.getFirstName(),"true");
          	arrayList.add("FirstName");
        } 
        if(!InputValidation.isValidString(clientInfo.getCompanyName())) {
        	//hasResult.put(clientInfo.getFirstName(),"true");
          	arrayList.add("FirstName");
        } 
   
        if(!InputValidation.isValidEmail(clientInfo.getEmail())){
        	arrayList.add("Email");
        }
    	
        if(!InputValidation.isValidNumbe(clientInfo.getPhone())){
        	arrayList.add("Phone");
        }
    	//Iterator  iterator= clientInfo. Iterator(clientInfo);
    	return arrayList;
    	
    }
    **/
    
   
}
