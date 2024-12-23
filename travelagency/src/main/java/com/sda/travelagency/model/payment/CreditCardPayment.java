package com.sda.travelagency.model.payment;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cardHolderName, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public boolean processPayment(int userId, int amount) {
        System.out.println("Processing Credit Card Payment...");
        // Simulate call to Payment Gateway API
        System.out.println("User " + userId + " paid $" + amount + " using Credit Card ending in " + cardNumber.substring(cardNumber.length() - 4));
        return true; // Assume payment is successful
    }
}
