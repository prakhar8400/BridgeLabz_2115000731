class Node {
    int rollNumber;
    String name;
    int age;
    String grade;
    Node next;

    public Node(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        head = null;
    }

    // Add student at the beginning
    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Add student at the end
    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
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

    // Add student at a specific position
    public void addAtPosition(int position, int rollNumber, String name, int age, String grade) {
        if (position < 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 0) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }

        Node newNode = new Node(rollNumber, name, age, grade);
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

    // Delete student by Roll Number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }

        Node prev = null;
        Node current = head;

        while (current != null && current.rollNumber != rollNumber) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            prev.next = current.next;
        } else {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }

    // Search for student by Roll Number
    public Node searchByRollNumber(int rollNumber) {
        Node current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Display all student records
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println("Roll Number: " + current.rollNumber + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }

    // Update student's grade
    public void updateGrade(int rollNumber, String newGrade) {
        Node current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                current.grade = newGrade;
                return;
            }
            current = current.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addAtEnd(1, "Alice", 18, "A");
        list.addAtBeginning(2, "Bob", 17, "B");
        list.addAtPosition(1, 3, "Charlie", 19, "A");

        list.display();

        list.deleteByRollNumber(2);
        System.out.println("\nAfter deleting student with Roll Number 2:");
        list.display();

        Node foundStudent = list.searchByRollNumber(1);
        if (foundStudent != null) {
            System.out.println("\nStudent with Roll Number 1: " + foundStudent.name);
        } else {
            System.out.println("\nStudent not found.");
        }

        list.updateGrade(3, "A+");
        System.out.println("\nAfter updating grade:");
        list.display();
    }
}
