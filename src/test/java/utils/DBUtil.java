package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBUtil {

    // Insert user into DB
    public static void insertUser(String email, String password) {

        String url = ConfigReader.get("dbUrl");
        String user = ConfigReader.get("dbUser");
        String dbPassword = ConfigReader.get("dbPassword");

        String sql = "INSERT INTO users (email, password) VALUES (alenready@gmail.com, 964523)";

        try {
            Connection conn = DriverManager.getConnection(url, user, dbPassword);
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ps.executeUpdate();

            System.out.println(" User inserted into DB: " + email);

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
