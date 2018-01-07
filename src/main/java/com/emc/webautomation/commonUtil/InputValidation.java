package com.emc.webautomation.commonUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * to validate the input  format
 * @author lis26
 *
 */

public class InputValidation {
	 public static boolean isValidString(String ss) {
  	   System.out.print(ss + " is valid string: ");
  	   String regex = "^[a-zA-Z_]+[a-zA-Z0-9_]*";
  	   Pattern p = Pattern.compile(regex);
  	   Matcher m = p.matcher(ss);
  	   System.out.println(m.matches());
  	   return m.matches();
	 }
  	   
	 
  	   public static boolean isValidNumbe(String ss) {
    	   System.out.print(ss + " is valid string: ");
    	   
    	 //  String phoneegex = "?([0-9]{3,4})+([ .-]?)([0-9]{3})\2([0-9]{3})";
           String regex = "^[a-zA-Z_]+[a-zA-Z0-9_]*";
    	   Pattern p = Pattern.compile(regex);
    	   Matcher m = p.matcher(ss);
    	   System.out.println(m.matches());
            return m.matches();
  }
  	  public static boolean isValidEmail(String ss) {
   	   System.out.print(ss + " is valid string: ");
   	   String emailregex ="[^ ]+@[^ ]+.[^ ]";
         
   	   Pattern p = Pattern.compile(emailregex);
   	   Matcher m = p.matcher(ss);
   	   System.out.println(m.matches());
       return m.matches();
 }
	 
}
	 
