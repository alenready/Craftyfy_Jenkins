package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtilsT {

	
	

	
	    static Connection connection;

	    //  Connect to DB
	    public static void connectToDB() {
	        try {
	            connection = DriverManager.getConnection(
	                    ConfigReader.get("dbUrl"),
	                    ConfigReader.get("dbUser"),
	                    ConfigReader.get("dbPassword")
	            );
	            System.out.println("DB Connected Successfully");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    //  Execute SELECT query
	    public static ResultSet executeQuery(String query) {
	        try {
	            Statement stmt = connection.createStatement();
	            return stmt.executeQuery(query);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    //  Close DB connection
	    public static void closeDB() {
	        try {
	            connection.close();
	            System.out.println("DB Connection Closed");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

	
	

