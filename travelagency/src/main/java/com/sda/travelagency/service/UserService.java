package com.sda.travelagency.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sda.travelagency.model.User;
import com.sda.travelagency.util.UserStorage;
import static com.sda.travelagency.util.UserStorage.saveUsers;
import static com.sda.travelagency.util.UserStorage.users;

@Service
public class UserService implements IAuthenticate {

    public String registerUser(User user) {
        int lastUserId = getLastUserId();

        user.setId(lastUserId + 1);

        if (UserStorage.getUserById(user.getId()) != null) {
            return "Id missing"; 
        }
        if (!verifyPassword(user)) {
            return "Invalid Password"; 
        }
        if (!verifyEmail(user)) {
            return "Invalid Email"; 
        } else {
            UserStorage.addUser(user);  
            return "Added Successfully";
        }
    }

    public String signIn(User user) {
        User existingUser = UserStorage.getUserByEmail(user.getEmail());
        if (existingUser == null) {
            return "Incorrect Email"; 
        }
        if (!existingUser.getPassword().equals(user.getPassword())) {
            return "Incorrect Password"; 
        }
        return "Signed In Successfully"; 
    }

    public User updateUserById(int id, User user) {
        User existingUser = UserStorage.getUserById(id);
        if (existingUser == null) {
            return null; 
        }

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        UserStorage.saveUsers(); 
        return existingUser;
    }

    public String viewProfileBy(int id) {
        User existingUser = UserStorage.getUserById(id);
        if (existingUser == null) {
            return "User not found"; 
        }
        
        return String.format(
            "Name: %s\nEmail: %s\nPassword: %s", 
            existingUser.getName(), 
            existingUser.getEmail(), 
            existingUser.getPassword()
        );
    }
    

    @Override
    public boolean verifyEmail(User user) {
        String email = user.getEmail();
        return email.contains("@") && email.contains(".");
    }

    @Override
    public boolean verifyPassword(User user) {
        String password = user.getPassword();
        return password.length() >= 5;
    }

    private int getLastUserId() {
        return UserStorage.getLastUserId();  
    }

    public  User TerminateUser(int id) {
        User user = getUserById(id);
        if (user != null) {
            users.remove(user);
            saveUsers(); 
        }
        return user;
    }


    public User getUserById(int id) {
        return UserStorage.getUserById(id); 
    }


    public List<User> getAllUsers() {
        return UserStorage.getAllUsers(); 
    }
}
