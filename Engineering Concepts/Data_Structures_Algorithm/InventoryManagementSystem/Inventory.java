package InventoryManagementSystem;

import java.util.HashMap;

public class Inventory {
    private HashMap<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void deleteProduct(int productId) {
        products.remove(productId);
    }

    public Product getProduct(int productId) {
        return products.get(productId);
    }
}

