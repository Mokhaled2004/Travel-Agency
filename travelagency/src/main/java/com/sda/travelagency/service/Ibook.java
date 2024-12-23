package com.sda.travelagency.service;

import com.sda.travelagency.model.payment.PaymentStrategy;

public interface Ibook {
    boolean book(int userid, PaymentStrategy paymentstrategy);
}
