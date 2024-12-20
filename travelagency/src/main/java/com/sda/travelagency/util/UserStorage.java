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

    public static void addUser(User user) {
        users.add(user);
        saveUsers();
    }

    public static User getUserById(int id) {
        return users.stream()
                    .filter(user -> user.getId() == id)
                    .findFirst()
                    .orElse(null);
    }

    public static User getUserByEmail(String email) {
        return users.stream()
                    .filter(user -> user.getEmail().equals(email))
                    .findFirst()
                    .orElse(null);
    }


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

    public static void saveUsers() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<User> getAllUsers() {
        return new ArrayList<>(users); 
    }


    public static int getLastUserId() {
        if (users.isEmpty()) {
            return 0; 
        }
        return users.stream()
                    .mapToInt(User::getId)
                    .max()
                    .orElse(0); 
    }
}
