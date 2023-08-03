package process.usecases.user;

import model.User;

public class UserLogin {
    public User execute(String email, String password) {
        if (email.equals("2072001") && password.equals("2072001")) {
            return new User("2072001", "2072001");
        } else {
            return null;
        }
    }

}
