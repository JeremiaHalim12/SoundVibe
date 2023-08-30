package process.repositories;

import Utility.JDBCConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
//    public User signIn(String email, String password) {
//        // Here, you can implement the actual sign-in logic, such as querying a database or API
//        // For the sake of simplicity, let's assume successful sign-in with hardcoded data
//        if (email.equals("user@example.com") && password.equals("password")) {
//            return new User("SV0001", "Matthew Julian","2072001@maranatha.ac.id","2072001");
//        } else {
//            return null; // Return null for failed sign-in attempt
//        }
//    }


    // ALTERNATIF TANPA DAO
    public User signIn(String email, String password) {
        ObservableList<User> uList = FXCollections.observableArrayList();

        try {
            String query = "SELECT * FROM user WHERE userEmail = ? AND userPassword = ?";
            PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet res = ps.executeQuery();
            if (res.next()) {
                int userId = res.getInt("userId");
                String userName = res.getString("userName");
                String userEmail = res.getString("userEmail");
                String userPassword = res.getString("userPassword");
                return new User(userId, userName, userEmail, userPassword);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    public void addUser(String username, String email, String password) {
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

    public User updateUsername(String newUsername, String newEmail) {
        User updatedUser = null;
        try {
            String query = "UPDATE user SET userName = ? WHERE userEmail = ?";
            PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(query);
            ps.setString(1, newUsername);
            ps.setString(2, newEmail);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Username updated successfully!");

                String selectQuery = "SELECT * FROM user WHERE userEmail = ?";
                PreparedStatement selectPs = JDBCConnection.getConnection().prepareStatement(selectQuery);
                selectPs.setString(1, newEmail);

                ResultSet resultSet = selectPs.executeQuery();
                if (resultSet.next()) {
                    updatedUser = new User(
                            resultSet.getInt("userId"),
                            newUsername,
                            resultSet.getString("userEmail"),
                            resultSet.getString("userPassword")
                    );
                }
            } else {
                System.out.println("Failed to update username.");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return updatedUser;
    }

    public User updateUserEmail(String newUsername, String newEmail) {
        User updatedUser = null;
        try {
            String query = "UPDATE user SET userEmail = ? WHERE userName = ?";
            PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(query);
            ps.setString(1, newEmail);
            ps.setString(2, newUsername);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Email updated successfully!");

                String selectQuery = "SELECT * FROM user WHERE userName = ?";
                PreparedStatement selectPs = JDBCConnection.getConnection().prepareStatement(selectQuery);
                selectPs.setString(1, newUsername);

                ResultSet resultSet = selectPs.executeQuery();
                if (resultSet.next()) {
                    updatedUser = new User(
                            resultSet.getInt("userId"),
                            resultSet.getString("userName"),
                            newEmail,
                            resultSet.getString("userPassword")
                    );
                }
            } else {
                System.out.println("Failed to update email.");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return updatedUser;
    }

    public User updateUserPassword(String newUsername, String newPassword) {
        User updatedUser = null;
        try {
            String query = "UPDATE user SET userPassword = ? WHERE userName = ?";
            PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(query);
            ps.setString(1, newPassword);
            ps.setString(2, newUsername);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Password updated successfully!");

                String selectQuery = "SELECT * FROM user WHERE userName = ?";
                PreparedStatement selectPs = JDBCConnection.getConnection().prepareStatement(selectQuery);
                selectPs.setString(1, newUsername);

                ResultSet resultSet = selectPs.executeQuery();
                if (resultSet.next()) {
                    updatedUser = new User(
                            resultSet.getInt("userId"),
                            resultSet.getString("userName"),
                            resultSet.getString("userEmail"),
                            newPassword
                    );
                }
            } else {
                System.out.println("Failed to update password.");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return updatedUser;
    }


}
