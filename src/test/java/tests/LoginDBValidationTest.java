package tests;

import java.sql.ResultSet;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.DBUtilsT;

public class LoginDBValidationTest {

	
		
	    @Test
	    public void validateEmailFromDB() throws Exception {

	        DBUtilsT.connectToDB();

	        String query = "SELECT email FROM users WHERE email='sdet2025@gmail.com'";
	        ResultSet rs = DBUtilsT.executeQuery(query);

	        rs.next(); // move to first record
	        String dbEmail = rs.getString("email");

	        String uiEmail = "sdet2025@gmail.com";

	        Assert.assertEquals(uiEmail, dbEmail,
	                "UI Email and DB Email do not match");
	        
	        DBUtilsT.closeDB();
	        
	        
	        
	    }
	}


