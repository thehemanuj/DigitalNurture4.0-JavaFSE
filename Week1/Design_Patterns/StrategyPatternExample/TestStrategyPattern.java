package StrategyPatternExample;

public class TestStrategyPattern {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        context.executePayment(1500);

        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.executePayment(3000);
    }
}
