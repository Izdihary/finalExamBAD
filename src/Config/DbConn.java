package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DbConn {
    
    public static Connection getConnection() {
       
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ecommerce", "root", "");
            System.out.println("Connected to the database.");
            PreparedStatement sm = conn.prepareStatement("SELECT * FROM order");
            sm.close();
        } catch (SQLException e) {
            System.out.println("Error occured.");
        }
        return conn;
    }
}
