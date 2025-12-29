package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginP;
import utils.ConfigReader;

public class LoginT {

	

	

	public class LoginTest extends BaseTest {

	    @Test
	    public void validLoginTest() {

	        //  Open login page
	        driver.get("https://craftyfy-frontend.vercel.app/login");

	        //  Create LoginPage object
	        LoginP login = new LoginP(driver);

	        //  Perform login using config values
	        login.login(
	                ConfigReader.get("validEmail"),
	                ConfigReader.get("validPassword")
	        );

	        //  Validation (URL check after login)
	        String currentUrl = driver.getCurrentUrl();

	        Assert.assertTrue(
	                currentUrl.contains("collection") || currentUrl.contains("home"),
	                "Login failed, user not redirected"
	        );
	    }
	    
	    @Test
	    public void invalidLoginShouldShowErrorPopup() {

	        // Open login page
	        driver.get("https://craftyfy-frontend.vercel.app/login");

	        LoginP login = new LoginP(driver);

	        // Perform invalid login
	        login.login(
	                ConfigReader.get("invalidEmail"),
	                ConfigReader.get("invalidPassword")
	        );

	        // Get popup message
	        String actualErrorMessage = login.getErrorMessage();

	        // Validate popup text
	        Assert.assertTrue(
	                actualErrorMessage.contains("User doesn't exists"),
	                "Expected error message not displayed"
	        );
	        
	        System.out.println("Error Message Displayed: " + actualErrorMessage);

	    }

	}

}
