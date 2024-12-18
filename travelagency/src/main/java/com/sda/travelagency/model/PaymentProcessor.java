public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public boolean processPayment(int userId, int amount) {
        return paymentStrategy.processPayment(userId, amount);
    }
}
