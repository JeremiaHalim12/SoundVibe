package process.usecases.user;

import model.User;
import process.repositories.UserRepository; // Import the UserRepository

public class UserGetById {
    public User executeUserGetById(String username) {
        UserRepository userRepository = new UserRepository(); // Create an instance of UserRepository
        return userRepository.userGetByString(username); // Call the userGetByString method
    }
}
