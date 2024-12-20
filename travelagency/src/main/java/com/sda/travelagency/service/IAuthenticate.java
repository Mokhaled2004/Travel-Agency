package com.sda.travelagency.service;

import com.sda.travelagency.model.User;

public interface IAuthenticate {

    boolean verifyEmail(User user);

    boolean verifyPassword(User user);
}
