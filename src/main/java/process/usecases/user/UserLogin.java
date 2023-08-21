package process.usecases.user;

import model.User;

public class UserLogin {
    public User execute(String email, String password) {
        if (email.equals("2072001@maranatha.ac.id") && password.equals("2072001")) {
            return new User("SV0001", "Matthew Julian","2072001@maranatha.ac.id","2072001");
        } else {
            return null;
        }
    }

}
