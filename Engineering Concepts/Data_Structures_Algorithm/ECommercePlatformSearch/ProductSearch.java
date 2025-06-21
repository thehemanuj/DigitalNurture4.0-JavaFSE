package ECommercePlatformSearch;


import java.util.Arrays;
import java.util.Comparator;




public class ProductSearch {
    int linearSearch(Product []ar,int id,String name,String category){
        int pos=1,flag=0;
        for(Product product:ar){
            if(product.getId()==id||product.getName().equalsIgnoreCase(name)||product.getCategory().equalsIgnoreCase(category)){
                System.out.println("Product found at position:"+pos);
                flag=1;
                break;
            }
            pos++;
        }
        if (flag==0){
            System.out.println("Product not found");
        }
        return flag==0?-1:pos-1;
    }


    public static int binarySearch(Product[] products, String field, String target) {
        if (field.equalsIgnoreCase("id")) {
            Arrays.sort(products, Comparator.comparingInt(Product::getId));
        } else if (field.equalsIgnoreCase("name")) {
            Arrays.sort(products, Comparator.comparing(Product::getName));
        } else if (field.equalsIgnoreCase("category")) {
            Arrays.sort(products, Comparator.comparing(Product::getCategory));
        } else {
            return -1;
        }

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Product midProduct = products[mid];
            int cmp = 0;

            if (field.equalsIgnoreCase("id")) {
                int midId = midProduct.getId();
                int targetId = Integer.parseInt(target);
                cmp = Integer.compare(midId, targetId);
            } else if (field.equalsIgnoreCase("name")) {
                cmp = midProduct.getName().compareTo(target);
            } else if (field.equalsIgnoreCase("category")) {
                cmp = midProduct.getCategory().compareTo(target);
            }

            if (cmp == 0) return mid;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

}
