package DAO;

import Utility.JDBCConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO implements daoInterface<User>{
    @Override
    public int addData(User data) {
        return 0;
    }

    @Override
    public int delData(User data) {
        return 0;
    }

    @Override
    public int updateData(User data) {
        return 0;
    }

    @Override
    public ObservableList<User> showData() {
        ObservableList<User> uList = FXCollections.observableArrayList();

        try {
            String query = "select * from user;";
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query);
            ResultSet res = ps.executeQuery();
            while (res.next()){
                String userId = res.getString("userId");
                String userName = res.getString("userName");
                String userEmail = res.getString("userEmail");
                String userPassword = res.getString("userPassword");
                User s = new User(userId, userName, userEmail, userPassword);
                uList.add(s);
            }
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        return uList;
    }
}
