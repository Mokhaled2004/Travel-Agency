public interface PaymentStrategy {
    boolean processPayment(int userId, int amount);
}
