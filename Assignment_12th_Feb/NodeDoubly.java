class NodeDoubly {
    String movieTitle;
    String director;
    int yearOfRelease;
    double rating;
    Node prev;
    Node next;

    public Node(String movieTitle, String director, int yearOfRelease, double rating) {
        this.movieTitle = movieTitle;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
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

    // Add movie at the beginning
    public void addAtBeginning(String movieTitle, String director, int yearOfRelease, double rating) {
        Node newNode = new Node(movieTitle, director, yearOfRelease, rating);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add movie at the end
    public void addAtEnd(String movieTitle, String director, int yearOfRelease, double rating) {
        Node newNode = new Node(movieTitle, director, yearOfRelease, rating);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add movie at a specific position
    public void addAtPosition(int position, String movieTitle, String director, int yearOfRelease, double rating) {
        if (position < 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 0) {
            addAtBeginning(movieTitle, director, yearOfRelease, rating);
            return;
        }

        Node newNode = new Node(movieTitle, director, yearOfRelease, rating);
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

    // Remove movie by Movie Title
    public void removeByTitle(String movieTitle) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.movieTitle.equals(movieTitle)) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        Node current = head;
        while (current != null && !current.movieTitle.equals(movieTitle)) {
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
            System.out.println("Movie not found.");
        }
    }

    // Search for movie by Director or Rating
    public Node searchByDirector(String director) {
        Node current = head;
        while (current != null) {
            if (current.director.equals(director)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public Node searchByRating(double rating) {
        Node current = head;
        while (current != null) {
            if (current.rating == rating) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Display all movie records in forward order
    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.println("Movie Title: " + current.movieTitle + ", Director: " + current.director + ", Year of Release: " + current.yearOfRelease + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display all movie records in reverse order
    public void displayReverse() {
        Node current = tail;
        while (current != null) {
            System.out.println("Movie Title: " + current.movieTitle + ", Director: " + current.director + ", Year of Release: " + current.yearOfRelease + ", Rating: " + current.rating);
            current = current.prev;
        }
    }

    // Update movie's Rating
    public void updateRating(String movieTitle, double newRating) {
        Node current = head;
        while (current != null) {
            if (current.movieTitle.equals(movieTitle)) {
                current.rating = newRating;
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList movieList = new DoublyLinkedList();

        movieList.addAtEnd("The Shawshank Redemption", "Frank Darabont", 1994, 9.3);
        movieList.addAtBeginning("The Godfather", "Francis Ford Coppola", 1972, 9.2);
        movieList.addAtPosition(1, "The Dark Knight", "Christopher Nolan", 2008, 9.0);

        movieList.displayForward();
        System.out.println("\nDisplaying in Reverse Order:");
        movieList.displayReverse();

        movieList.removeByTitle("The Dark Knight");
        System.out.println("\nAfter removing The Dark Knight:");
        movieList.displayForward();

        Node foundMovie = movieList.searchByDirector("Francis Ford Coppola");
        if (foundMovie != null) {
            System.out.println("\nMovie by Francis Ford Coppola: " + foundMovie.movieTitle);
        }

        movieList.updateRating("The Shawshank Redemption", 9.4);
        System.out.println("\nAfter updating rating:");
        movieList.displayForward();
    }
}
