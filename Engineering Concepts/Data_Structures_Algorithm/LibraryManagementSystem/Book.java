package LibraryManagementSystem;

public class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getTitle(){
        return title;
    }

    public int getBookId(){
        return bookId;
    }

    public String getAuthor(){
        return author;
    }
}
