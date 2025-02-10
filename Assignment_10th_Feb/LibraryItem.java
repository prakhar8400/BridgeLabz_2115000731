abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public abstract int getLoanDuration(); 

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class Book extends LibraryItem {

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // Books can be loaned for 14 days
    }
}

class Magazine extends LibraryItem {

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // Magazines can be loaned for 7 days
    }
}

class DVD extends LibraryItem {

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // DVDs can be loaned for 3 days
    }
}

interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

class ReservableBook extends Book implements Reservable {
    private boolean isReserved;

    public ReservableBook(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
    }

    @Override
    public void reserveItem() {
        isReserved = true;
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

public class Main {
    public static void main(String[] args) {
        LibraryItem[] libraryItems = new LibraryItem[3];
        libraryItems[0] = new Book("B001", "The Lord of the Rings", "J.R.R. Tolkien");
        libraryItems[1] = new Magazine("M002", "National Geographic", "Various");
        libraryItems[2] = new ReservableBook("B003", "The Hobbit", "J.R.R. Tolkien");

        for (LibraryItem item : libraryItems) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                if (reservableItem.checkAvailability()) {
                    System.out.println("Item is available for reservation.");
                } else {
                    System.out.println("Item is currently reserved.");
                }
            }
            System.out.println("");
        }
    }
}
