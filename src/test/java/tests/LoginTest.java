package tests;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginP;


public class LoginTest extends LoginP {
public LoginTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

@Test
	public void login(String email, String password) {
	    enterEmail(email);
	    enterPassword(password);
	    clickSignIn();
	}


}
