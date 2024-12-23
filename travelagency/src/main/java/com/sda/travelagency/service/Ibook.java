package com.sda.travelagency.service;

import com.sda.travelagency.model.User;
import com.sda.travelagency.model.payment;

public interface Ibook {
    boolean book(int userid, PaymentStrategy paymentstrategy);
}
