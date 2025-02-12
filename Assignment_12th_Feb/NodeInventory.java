class NodeInventory {
    String itemName;
    String itemId;
    int quantity;
    double price;
    Node next;

    public Node(String itemName, String itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        head = null;
    }

    // Add item at the beginning
    public void addAtBeginning(String itemName, String itemId, int quantity, double price) {
        Node newNode = new Node(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    // Add item at the end
    public void addAtEnd(String itemName, String itemId, int quantity, double price) {
        Node newNode = new Node(itemName, itemId, quantity, price);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Add item at a specific position
    public void addAtPosition(int position, String itemName, String itemId, int quantity, double price) {
        if (position < 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 0) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }

        Node newNode = new Node(itemName, itemId, quantity, price);
        Node prev = null;
        Node current = head;
        int count = 0;

        while (count < position && current != null) {
            prev = current;
            current = current.next;
            count++;
        }

        if (count == position) {
            prev.next = newNode;
            newNode.next = current;
        } else {
            System.out.println("Invalid position.");
        }
    }

    // Remove item by Item ID
    public void removeByItemId(String itemId) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.itemId.equals(itemId)) {
            head = head.next;
            return;
        }

        Node prev = null;
        Node current = head;

        while (current != null && !current.itemId.equals(itemId)) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            prev.next = current.next;
        } else {
            System.out.println("Item with ID " + itemId + " not found.");
        }
    }

    // Update quantity of an item by Item ID
    public void updateQuantity(String itemId, int newQuantity) {
        Node current = head;
        while (current != null) {
            if (current.itemId.equals(itemId)) {
                current.quantity = newQuantity;
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for item by Item ID
    public Node searchByItemId(String itemId) {
        Node current = head;
        while (current != null) {
            if (current.itemId.equals(itemId)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Search for item by Item Name
    public Node searchByItemName(String itemName) {
        Node current = head;
        while (current != null) {
            if (current.itemName.equals(itemName)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Calculate total value of inventory
    public double calculateTotalValue() {
        double totalValue = 0.0;
        Node current = head;
        while (current != null) {
            totalValue += current.quantity * current.price;
            current = current.next;
        }
        return totalValue;
    }

    // Sort by Item Name (Ascending) using Merge Sort
    private Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node leftHalf = mergeSort(head);
        Node rightHalf = mergeSort(nextOfMiddle);

        return merge(leftHalf, rightHalf);
    }

    private Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }

        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        Node result;
        if (left.itemName.compareTo(right.itemName) <= 0) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }

    public void sortByNameAscending() {
        head = mergeSort(head);
    }

    // Sort by Price (Ascending) - Similar implementation as sortByNameAscending()
    // ...

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println("Item ID: " + current.itemId + ", Name: " + current.itemName + ", Quantity: " + current.quantity + ", Price: $" + current.price);
            current = current.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList inventory = new SinglyLinkedList();

        inventory.addAtEnd("Laptop", "L001", 5, 1200.00);
        inventory.addAtBeginning("Mouse", "M001", 20, 20.00);
        inventory.addAtPosition(1, "Keyboard", "K001", 10, 80.00);

        inventory.display();

        inventory.removeByItemId("M001");
        System.out.println("\nAfter removing Mouse:");
        inventory.display();

        inventory.updateQuantity("L001", 3);
        System.out.println("\nAfter updating Laptop quantity:");
        inventory.display();

        System.out.println("\nTotal Inventory Value: $" + inventory.calculateTotalValue());

        inventory.sortByNameAscending();
        System.out.println("\nInventory sorted by Name (Ascending):");
        inventory.display();

        // ... Implement sortByNameDescending() and call it here

    }
}
