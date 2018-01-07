package com.emc.webautomation.commonUtil;

import java.io.File;
 //import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.emc.webautomation.Enum.*;//Enum.BrowserType;
/**
 * Created by sherry on 1/7/2018.
 */
public class DriverUtils {

    public static  WebDriver webdriver;
 
    // Current users directory.
    private static final String USER_DIR = System.getProperty("user.dir");

    // Driver exe files directory.
    private static final String DRIVERS_EXE_DIR = USER_DIR + File.separator + "src" + File.separator + "main" +
            File.separator + "resources" + File.separator + "Tools" ;

    // Chrome driver location.
    private static final String CHROME_DRIVER = DRIVERS_EXE_DIR + File.separator + "chromedriver.exe";
    private static final String FireFOX_DRIVER = DRIVERS_EXE_DIR + File.separator + "geckodriver.exe";
    
    private static final String IE_DRIVER = DRIVERS_EXE_DIR + File.separator + "IEDriverServer.exe";

      public static WebDriver getDriver(BrowserType browser){
    	if(webdriver!=null){
    	    webdriver.close();
    	}
    	switch (browser) {
    		case CHROME:
    			System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
                webdriver=new ChromeDriver();
    		 break;
    		case FIREFOX:
    			System.setProperty("webdriver.firefox.marionette",FireFOX_DRIVER);
    			//System.setProperty("webdriver.gecko.driver", FireFOX_DRIVER);

    			webdriver = new FirefoxDriver();
    		     
    			break;
    		case  IE:
    			System.setProperty("webdriver.ie.driver", IE_DRIVER);
                webdriver=new InternetExplorerDriver();
    			break;
    		default:
      			//System.setProperty("webdriver.firefox.marionette",FireFOX_DRIVER);
    			//System.setProperty("webdriver.gecko.driver", FireFOX_DRIVER);

    			webdriver = new FirefoxDriver();
    			
     		}
    	 //webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	 
    	 return webdriver; 
     	
    }

    public static WebDriver getDriver() {
        if ( webdriver == null) {
        	webdriver = new FirefoxDriver();
        }
        return webdriver;
    }

    public static void  tearDown() throws Exception {
    	webdriver.close();
    	webdriver.quit();
    }
}
