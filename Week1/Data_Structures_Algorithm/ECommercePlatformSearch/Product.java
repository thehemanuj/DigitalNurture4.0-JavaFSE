package ECommercePlatformSearch;

public class Product{
    final private int productId;
    final private String productName,category;

    Product(String productName,int productId,String category){
        this.productId=productId;
        this.productName=productName;
        this.category=category;
    }
    int getId(){
        return productId;
    }

    String getName(){
        return productName;
    }

    String getCategory(){
        return category;
    }
}
