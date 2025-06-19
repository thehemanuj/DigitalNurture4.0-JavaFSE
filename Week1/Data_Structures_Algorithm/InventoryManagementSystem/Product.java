package InventoryManagementSystem;

public class Product {
    private int productID,quantity;
    private double price;
    private String productName;

    Product(int pId,int q,double p,String name){
        productID=pId;
        quantity=q;
        price=p;
        productName=name;
    }

    public int getProductId(){
        return productID;
    }

    public String getProductName(){
        return productName;
    }

    public double getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public void modifyPrice(double price){
        System.out.println("Price of Item "+productName+" modified from:"+this.price+" to:"+price);
        this.price=price;
    }

    public void removeFromInventory(int n){
        if(n<=quantity){
            quantity-=n;
            System.out.println(n+" "+productName+" removed from inventory");
        }else{
            System.out.println("Only "+quantity+" items remaining");
        }
    }

    public void addToInventory(int n){
        quantity+=n;
        System.out.println(n+" items added to inventory of product:"+productName );
    }
}
