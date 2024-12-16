package com.sda.travelagency.util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.sda.travelagency.model.User;


public class UserStorage {
public static Map<Integer, User> users = new ConcurrentHashMap<>();
}
