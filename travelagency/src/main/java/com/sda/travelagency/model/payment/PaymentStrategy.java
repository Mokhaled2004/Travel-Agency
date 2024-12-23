package com.sda.travelagency.model.payment;

public interface PaymentStrategy {
    boolean processPayment(int userId, int amount);
}
