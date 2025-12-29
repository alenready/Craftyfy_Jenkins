package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBUtilInvalidUser {

	
	
	public static void insertInvalidUser() {

	    String sql = "INSERT INTO users (email, password) VALUES (?, ?)";

	    try {
	        Connection conn = DriverManager.getConnection(
	                ConfigReader.get("dbUrl"),
	                ConfigReader.get("dbUser"),
	                ConfigReader.get("dbPassword")
	        );

	        PreparedStatement ps = conn.prepareStatement(sql);

	        ps.setString(1, "alenready@gmail.com");   
	        ps.setString(2, "964523");                
	        ps.executeUpdate();

	        System.out.println(" Invalid user inserted into DB");

	        ps.close();
	        conn.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	
}
