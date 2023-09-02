package process.usecases.user;

import Utility.JDBCConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLogin {

    public User executeUserLogin(String email, String password) {
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
}
