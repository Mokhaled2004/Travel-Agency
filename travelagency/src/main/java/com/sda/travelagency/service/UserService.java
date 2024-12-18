package com.sda.travelagency.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.travelagency.model.User;
import com.sda.travelagency.util.UserStorage;

@Service
public class UserService {

    private static final String FILE_PATH = "users.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public UserService() {
        loadUsersFromJson(); 
    }

    // Add a user to the list
    public boolean addUser(User user) {
        
        UserStorage.users.add(user);
        saveUsersToJson();
        return true;
    }

    public boolean verifyEmail(User user) {
        String email = user.getEmail();
        if (email.contains("@") && email.contains(".")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyPassword(User user) {
        String password = user.getPassword();
        if( password.length() < 5) {
            return false;
        } else {
            return true;
        }
    }

    public String registerUser(User user) {
        if (getUserById(user.getId()) != null) {
            
            return "Id missing"; // User already exists
        }  
        if (!verifyPassword(user)) {
            return "Invalid Password"; // Password is invalid
        } 
        if (!verifyEmail(user)) {
            return "Invalid Email"; // Email is invalid
        }
        else {
        addUser(user);
        return "Added Successfully"; // User added successfully
        }
    }

    public User updateUser(int id, User user) {
        User existingUser = getUserById(id);
        if (existingUser == null) {
            return null;
        }
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        saveUsersToJson();
        return existingUser;
    }

    public User deleteUser(int id) {
        User user = getUserById(id);
        if (user == null) {
            return null;
        } else {
            UserStorage.users.remove(user);
            saveUsersToJson();
            return user;
        }

    }

    // Retrieve a user by ID from the list
    public User getUserById(int id) {
        Optional<User> user = UserStorage.users.stream()
        .filter(u -> u.getId() == id)
        .findFirst();
        return user.orElse(null);
    }

    public List <User> getAllUsers() {
        return UserStorage.users;
    }

    // Save the list of users to the JSON file
    private void saveUsersToJson() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), UserStorage.users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load users from the JSON file into the list
    private void loadUsersFromJson() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                List<User> users = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));
                if (users != null) {
                    UserStorage.users = users;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
