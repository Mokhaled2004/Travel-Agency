package com.sda.travelagency.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.travelagency.model.User;

public class UserStorage {

    private static final String FILE_PATH = "users.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static List<User> users = loadUsers();

    // Add a user and save to file
    public static void addUser(User user) {
        users.add(user);
        saveUsers();
    }

    // Retrieve a user by ID
    public static User getUserById(int id) {
        return users.stream()
                    .filter(user -> user.getId() == id)
                    .findFirst()
                    .orElse(null);
    }

    // Load users from JSON file
    private static List<User> loadUsers() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Save users to JSON file
    private static void saveUsers() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
