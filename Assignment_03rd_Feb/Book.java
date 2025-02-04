public class Book {

    private final String isbn;
    private String title;
    private String author;
    private static final String libraryName = "Central Library"; 

    public Book(String isbn, String title, String author) {
        this.isbn = isbn; 
        this.title = title;
        this.author = author;
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public static void displayBookDetails(Object bookObject) {
        if (bookObject instanceof Book) {
            Book book = (Book) bookObject;
            System.out.println("ISBN: " + book.isbn);
            System.out.println("Title: " + book.title);
            System.out.println("Author: " + book.author);
        } else {
            System.out.println("Invalid book object.");
        }
    }
}
