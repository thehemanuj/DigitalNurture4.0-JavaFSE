package LibraryManagementSystem;

import java.util.Arrays;
import java.util.Comparator;

public class LibraryManagement {
    private Book[] books;

    public LibraryManagement(Book[] books){
        this.books = books;
    }

    public int linearSearchByTitle(String title){
        for(int i = 0; i < books.length; i++){
            if(books[i].getTitle().equalsIgnoreCase(title)){
                System.out.println("Book found at index: " + i);
                return i;
            }
        }
        System.out.println("Book not found");
        return -1;
    }

    public int binarySearchByTitle(String title){
        Arrays.sort(books, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));

        int low = 0, high = books.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);

            if(cmp == 0){
                System.out.println("Book found at index: " + mid);
                return mid;
            } else if(cmp < 0){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Book not found");
        return -1;
    }
}
