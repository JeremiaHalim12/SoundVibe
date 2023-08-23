package Utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

//    public static Connection getConnection() {
//        Connection conn = null;
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/soundvibe", "root", "");
//        }
//        catch (ClassNotFoundException | SQLException ex){
//            System.out.println(ex.getMessage());
//        }
//
//
//        return conn;
//    }

    private static Connection connection;
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/soundvibe", "root", "");
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return connection;
    }
}
