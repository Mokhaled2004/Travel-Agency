public class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public boolean processPayment(int userId, int amount) {
        System.out.println("Processing PayPal Payment...");
        // Simulate call to Payment Gateway API
        System.out.println("User " + userId + " paid $" + amount + " via PayPal account: " + email);
        return true; // Assume payment is successful
    }
}
