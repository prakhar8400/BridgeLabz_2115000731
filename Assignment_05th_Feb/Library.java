import java.util.ArrayList;
import java.util.List;

public class Library {

    private String libraryName;
    private List<Book> books;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void displayBooks() {
        System.out.println("Books in " + libraryName + ":");
        for (Book book : books) {
            System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
        }
    }
}

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create some Book objects
        Book book1 = new Book("The Lord of the Rings", "J.R.R. Tolkien");
        Book book2 = new Book("Pride and Prejudice", "Jane Austen");
        Book book3 = new Book("1984", "George Orwell");

        // Create two libraries
        Library library1 = new Library("Central Library");
        Library library2 = new Library("University Library");

        // Add books to libraries
        library1.addBook(book1);
        library1.addBook(book2);
        library2.addBook(book2); // Book2 can exist in multiple libraries
        library2.addBook(book3);

        // Display books in each library
        library1.displayBooks();
        library2.displayBooks();
    }
}
