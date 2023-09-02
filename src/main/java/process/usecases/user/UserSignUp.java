package process.usecases.user;

import Utility.JDBCConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserSignUp {

    public void executeUserSignUp(String username, String email, String password) {
        try {
            String query = "INSERT INTO user (userName, userEmail, userPassword) VALUES (?, ?, ?)";
            PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User added successfully!");
            } else {
                System.out.println("Failed to add user.");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
