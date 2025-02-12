class NodeCircular {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Node next;

    public Node(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class CircularLinkedList {
    private Node head;

    public CircularLinkedList() {
        head = null;
    }

    // Add task at the beginning
    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Circular link
        } else {
            newNode.next = head;
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            head = newNode;
        }
    }

    // Add task at the end
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Circular link
        } else {
            newNode.next = head;
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Add task at a specific position
    public void addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position < 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 0) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Node newNode = new Node(taskId, taskName, priority, dueDate);
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
            current.next = newNode;
        }
    }

    // Remove task by Task ID
    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.taskId == taskId) {
            if (head.next == head) { // Only one node in the list
                head = null;
            } else {
                Node temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                head = head.next;
                temp.next = head;
            }
            return;
        }

        Node current = head;
        Node prev = null;

        do {
            prev = current;
            current = current.next;
            if (current.taskId == taskId) {
                prev.next = current.next;
                return;
            }
        } while (current != head);

        System.out.println("Task with ID " + taskId + " not found.");
    }

    // View current task and move to the next
    public Node viewCurrentTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return null;
        }

        Node current = head;
        System.out.println("Current Task: " + current.taskId + " - " + current.taskName);
        head = current.next;
        return current;
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Node current = head;
        do {
            System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    // Search for task by Priority
    public void searchByPriority(int priority) {
        Node current = head;
        boolean found = false;

        do {
            if (current.priority == priority) {
                System.out.println("Task Found: " + current.taskId + " - " + current.taskName);
                found = true;
            }
            current = current.next;
        } while (current != head && !found);

        if (!found) {
            System.out.println("No tasks with priority " + priority + " found.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CircularLinkedList scheduler = new CircularLinkedList();

        scheduler.addAtEnd(1, "Task 1", 1, "2023-12-15");
        scheduler.addAtBeginning(2, "Task 2", 2, "2023-12-14");
        scheduler.addAtPosition(1, 3, "Task 3", 3, "2023-12-13");

        scheduler.displayAllTasks();

        scheduler.removeByTaskId(2);
        System.out.println("\nAfter removing Task 2:");
        scheduler.displayAllTasks();

        scheduler.searchByPriority(3);

        System.out.println("\nCurrent Task:");
        scheduler.viewCurrentTask();
        System.out.println("Current Task:");
        scheduler.viewCurrentTask(); 
    }
}
