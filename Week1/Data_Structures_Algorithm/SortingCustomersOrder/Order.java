package SortingCustomersOrder;

public class Order {
    final private int orderId;
    final private String customerName;
    final private double totalPrice;

    public Order(int orderId,String customerName,double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }
    
    double getPrice(){
        return totalPrice;
    }
    
}
