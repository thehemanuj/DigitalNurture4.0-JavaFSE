package AdapterPatternExample;

public class TesterClass {
    public static void main(String[] args) {
        PaymentProcessor gpayProcessor=new GPayAdapter(new GPayGateway());
        gpayProcessor.processPayment(1000.09);
        PaymentProcessor phonePeProcessor=new PhonePeAdapter(new PhonePeGateway());
        phonePeProcessor.processPayment(4000000.99);
        PaymentProcessor paytmProcessor=new PayTMAdapter(new PayTMGateway());
        paytmProcessor.processPayment(35453131.54);
    }
}
