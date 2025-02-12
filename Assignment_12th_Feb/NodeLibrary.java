class NodeLibrary {
    String bookTitle;
    String author;
    String genre;
    String bookId;
    boolean isAvailable;
    Node prev;
    Node next;

    public Node(String bookTitle, String author, String genre, String bookId, boolean isAvailable) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    // Add book at the beginning
    public void addAtBeginning(String bookTitle, String author, String genre, String bookId, boolean isAvailable) {
        Node newNode = new Node(bookTitle, author, genre, bookId, isAvailable);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add book at the end
    public void addAtEnd(String bookTitle, String author, String genre, String bookId, boolean isAvailable) {
        Node newNode = new Node(bookTitle, author, genre, bookId, isAvailable);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add book at a specific position
    public void addAtPosition(int position, String bookTitle, String author, String genre, String bookId, boolean isAvailable) {
        if (position < 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 0) {
            addAtBeginning(bookTitle, author, genre, bookId, isAvailable);
            return;
        }

        Node newNode = new Node(bookTitle, author, genre, bookId, isAvailable);
        Node current = head;
        int count = 0;

        while (count < position - 1 && current != null) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Invalid position.");
        } else {
            newNode.next = current.next;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    // Remove book by Book ID
    public void removeByBookId(String bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        if (head.bookId.equals(bookId)) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        Node current = head;
        while (current != null && !current.bookId.equals(bookId)) {
            current = current.next;
        }

        if (current != null) {
            if (current == tail) {
                tail = current.prev;
            }
            current.prev.next = current.next;
            if (current.next != null) {
                current.next.prev = current.prev;
            }
        } else {
            System.out.println("Book with ID " + bookId + " not found.");
        }
    }

    // Search for book by Book Title
    public Node searchByTitle(String bookTitle) {
        Node current = head;
        while (current != null) {
            if (current.bookTitle.equals(bookTitle)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Search for book by Author
    public Node searchByAuthor(String author) {
        Node current = head;
        while (current != null) {
            if (current.author.equals(author)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Update book's Availability Status
    public void updateAvailability(String bookId, boolean isAvailable) {
        Node current = head;
        while (current != null) {
            if (current.bookId.equals(bookId)) {
                current.isAvailable = isAvailable;
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display all books in forward order
    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.println("Book ID: " + current.bookId + ", Title: " + current.bookTitle + ", Author: " + current.author + ", Genre: " + current.genre + ", Available: " + (current.isAvailable ? "Yes" : "No"));
            current = current.next;
        }
    }

    // Display all books in reverse order
    public void displayReverse() {
        Node current = tail;
        while (current != null) {
            System.out.println("Book ID: " + current.bookId + ", Title: " + current.bookTitle + ", Author: " + current.author + ", Genre: " + current.genre + ", Available: " + (current.isAvailable ? "Yes" : "No"));
            current = current.prev;
        }
    }

    // Count the total number of books
    public int countBooks() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList library = new DoublyLinkedList();

        library.addAtEnd("The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", "B001", true);
        library.addAtBeginning("To Kill a Mockingbird", "Harper Lee", "Classic", "B002", true);
        library.addAtPosition(1, "The Hobbit", "J.R.R. Tolkien", "Fantasy", "B003", true);

        library.displayForward();
        System.out.println("\nDisplaying in Reverse Order:");
        library.displayReverse();

        library.removeByBookId("B002");
        System.out.println("\nAfter removing To Kill a Mockingbird:");
        library.displayForward();

        library.updateAvailability("B001", false);
        System.out.println("\nAfter updating availability:");
        library.displayForward();

        System.out.println("\nTotal number of books: " + library.countBooks());

        Node foundBook = library.searchByTitle("The Hobbit");
        if (foundBook != null) {
            System.out.println("\nBook found: " + foundBook.bookTitle);
        }
    }
}
