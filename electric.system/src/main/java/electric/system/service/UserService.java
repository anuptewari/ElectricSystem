package electric.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import electric.system.model.User;
import electric.system.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method to retrieve all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Method to retrieve a user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Method to create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Method to update an existing user
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            // Update user details
            user.setSurName(userDetails.getSurName());
            user.setFirstName(userDetails.getFirstName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());

            return userRepository.save(user);
        }
        return null; // or throw an exception indicating user not found
    }

    // Method to delete a user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Method to authenticate user login
    public boolean login(String email, String password) {
        User user = userRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}
