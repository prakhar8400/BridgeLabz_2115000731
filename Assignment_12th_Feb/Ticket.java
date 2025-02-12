class Ticket {
    String ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(String ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class CircularLinkedList {
    private Ticket head;

    public CircularLinkedList() {
        head = null;
    }

    // Add a new ticket reservation at the end
    public void addReservation(String ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            newTicket.next = head; // Circular link
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
    }

    // Remove a ticket by Ticket ID
    public void removeReservation(String ticketId) {
        if (head == null) {
            System.out.println("No reservations found.");
            return;
        }

        if (head.ticketId.equals(ticketId)) {
            if (head.next == head) { // Only one ticket in the list
                head = null;
            } else {
                Ticket temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                head = head.next;
                temp.next = head;
            }
            return;
        }

        Ticket current = head;
        Ticket prev = null;

        do {
            prev = current;
            current = current.next;
            if (current.ticketId.equals(ticketId)) {
                prev.next = current.next;
                return;
            }
        } while (current != head);

        System.out.println("Ticket with ID " + ticketId + " not found.");
    }

    // Display all tickets
    public void displayAllTickets() {
        if (head == null) {
            System.out.println("No reservations found.");
            return;
        }

        Ticket current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName + ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    // Search for a ticket by Customer Name
    public void searchByCustomerName(String customerName) {
        Ticket current = head;
        boolean found = false;

        do {
            if (current.customerName.equals(customerName)) {
                System.out.println("Ticket Found: " + current.ticketId + " for " + current.movieName);
                found = true;
            }
            current = current.next;
        } while (current != head && !found);

        if (!found) {
            System.out.println("No tickets found for customer: " + customerName);
        }
    }

    // Search for a ticket by Movie Name
    public void searchByMovieName(String movieName) {
        Ticket current = head;
        boolean found = false;

        do {
            if (current.movieName.equals(movieName)) {
                System.out.println("Ticket Found: " + current.ticketId + " for " + current.customerName);
                found = true;
            }
            current = current.next;
        } while (current != head && !found);

        if (!found) {
            System.out.println("No tickets found for movie: " + movieName);
        }
    }

    // Calculate the total number of booked tickets
    public int countTickets() {
        int count = 0;
        if (head == null) {
            return count;
        }

        Ticket current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);

        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        CircularLinkedList reservationSystem = new CircularLinkedList();

        reservationSystem.addReservation("T001", "Alice", "The Shawshank Redemption", "A1", "2024-07-05 10:00");
        reservationSystem.addReservation("T002", "Bob", "The Godfather", "B2", "2024-07-05 11:30");
        reservationSystem.addReservation("T003", "Charlie", "The Dark Knight", "C3", "2024-07-05 13:00");

        reservationSystem.displayAllTickets();

        reservationSystem.removeReservation("T002");
        System.out.println("\nAfter removing ticket T002:");
        reservationSystem.displayAllTickets();

        reservationSystem.searchByCustomerName("Alice");
        reservationSystem.searchByMovieName("The Dark Knight");

        System.out.println("\nTotal number of booked tickets: " + reservationSystem.countTickets());
    }
}
