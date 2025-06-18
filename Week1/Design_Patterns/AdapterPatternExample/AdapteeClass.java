package AdapterPatternExample;

public abstract class AdapteeClass{
    public abstract void makePayment(double amount);
}

class GPayGateway extends AdapteeClass{
    @Override
    public void makePayment(double amount){
        System.out.println("Paying "+amount+" using GPay");
    }
}

class PayTMGateway extends AdapteeClass{
    @Override
    public void makePayment(double amount){
        System.out.println("Paying "+amount+" using PayTM");
    }
}

class PhonePeGateway extends AdapteeClass{
    @Override
    public void makePayment(double amount){
        System.out.println("Paying "+amount+" using PhonePe");
    }
}
