package AdapterPatternExample;

class GPayAdapter implements PaymentProcessor{
    private GPayGateway gpay;

    public GPayAdapter(GPayGateway gpay){
        this.gpay=gpay;
    }

    @Override 
    public void processPayment(double amount){
        gpay.makePayment(amount);
    }
}

class PayTMAdapter implements PaymentProcessor{
    private PayTMGateway paytm;

    public PayTMAdapter(PayTMGateway paytm){
        this.paytm=paytm;
    }

    @Override 
    public void processPayment(double amount){
        paytm.makePayment(amount);
    }
}

class PhonePeAdapter implements PaymentProcessor{
    private PhonePeGateway phonepe;

    public PhonePeAdapter(PhonePeGateway phonepe){
        this.phonepe=phonepe;
    }

    @Override 
    public void processPayment(double amount){
        phonepe.makePayment(amount);
    }
}
