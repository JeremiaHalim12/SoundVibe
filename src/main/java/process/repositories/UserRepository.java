package process.repositories;

import model.User;

public class UserRepository {
    public User signIn(String email, String password) {
        // Here, you can implement the actual sign-in logic, such as querying a database or API
        // For the sake of simplicity, let's assume successful sign-in with hardcoded data
        if (email.equals("user@example.com") && password.equals("password")) {
            return new User("12345", "John Doe");
        } else {
            return null; // Return null for failed sign-in attempt
        }
    }
}
