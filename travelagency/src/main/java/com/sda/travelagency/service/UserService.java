package com.sda.travelagency.service;

import org.springframework.stereotype.Service;

import com.sda.travelagency.model.User;
import com.sda.travelagency.util.UserStorage;


@Service
public class UserService  {

    public boolean addUser(User user) {
        if (UserStorage.users.get(user.getId()) != null) {
            return false;
        }
        UserStorage.users.put(user.getId(), user);
        return true;
    }


    public User getUserById(int id) {
        return UserStorage.users.get(id);
    }

}
