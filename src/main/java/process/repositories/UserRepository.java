package process.repositories;

import model.User;

public class UserRepository {
    public User signIn(String email, String password) {
        // Here, you can implement the actual sign-in logic, such as querying a database or API
        // For the sake of simplicity, let's assume successful sign-in with hardcoded data
        if (email.equals("user@example.com") && password.equals("password")) {
            return new User("SV0001", "Matthew Julian","2072001@maranatha.ac.id","2072001");
        } else {
            return null; // Return null for failed sign-in attempt
        }
    }

    // ALTERNATIF TANPA DAO
//    public User signIn(String email, String password) {
//        ObservableList<User> uList = FXCollections.observableArrayList();
//
//        try {
//            String query = "SELECT * FROM user WHERE userEmail = ? AND userPassword = ?";
//            PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(query);
//            ps.setString(1, email);
//            ps.setString(2, password);
//
//            ResultSet res = ps.executeQuery();
//            if (res.next()) {
//                String userId = res.getString("userId");
//                String userName = res.getString("userName");
//                String userEmail = res.getString("userEmail");
//                String userPassword = res.getString("userPassword");
//                return new User(userId, userName, userEmail, userPassword);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        return null;
//    }
}
