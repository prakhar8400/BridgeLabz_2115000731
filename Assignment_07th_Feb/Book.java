public class Book {
    private String title;
    private int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

public class Author extends Book {
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a Book object
        Book book1 = new Book("The Lord of the Rings", 1954);
        book1.displayInfo();

        // Create an Author object
        Author author1 = new Author("J.R.R. Tolkien", 1954, "English writer", "Known for his fantasy novels");
        author1.displayInfo(); 
    }
}
