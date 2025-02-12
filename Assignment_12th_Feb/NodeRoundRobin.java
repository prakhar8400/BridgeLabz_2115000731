class NodeRoundRobin {
    int processId;
    int burstTime;
    int priority;
    int remainingTime;
    Node next;

    public Node(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime; 
        this.next = null;
    }
}

class CircularLinkedList {
    private Node head;

    public CircularLinkedList() {
        head = null;
    }

    // Add process at the end
    public void addProcess(int processId, int burstTime, int priority) {
        Node newNode = new Node(processId, burstTime, priority);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Circular link
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    // Remove process by Process ID
    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        if (head.processId == processId) {
            if (head.next == head) { // Only one process in the queue
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
            if (current.processId == processId) {
                prev.next = current.next;
                return;
            }
        } while (current != head);

        System.out.println("Process with ID " + processId + " not found.");
    }

    // Simulate round-robin scheduling
    public void roundRobinScheduling(int timeQuantum) {
        Node current = head;
        int totalTime = 0;
        int[] waitingTimes = new int[4]; // Assuming a maximum of 4 processes
        int[] turnaroundTimes = new int[4];

        while (true) {
            if (current.remainingTime <= 0) {
                // Process completed
                current = current.next;
                continue;
            }

            if (current.remainingTime <= timeQuantum) {
                totalTime += current.remainingTime;
                current.remainingTime = 0;
            } else {
                totalTime += timeQuantum;
                current.remainingTime -= timeQuantum;
            }

            // Update waiting and turnaround times
            waitingTimes[current.processId - 1] = totalTime - current.burstTime;
            turnaroundTimes[current.processId - 1] = totalTime;

            System.out.println("Executing Process " + current.processId + " for " + (current.remainingTime > 0 ? timeQuantum : current.remainingTime) + " units");
            displayProcesses(); 

            current = current.next;

            // Check if all processes are completed
            boolean allCompleted = true;
            Node temp = head;
            do {
                if (temp.remainingTime > 0) {
                    allCompleted = false;
                    break;
                }
                temp = temp.next;
            } while (temp != head);

            if (allCompleted) {
                break;
            }
        }

        // Calculate and display average waiting time and turnaround time
        double avgWaitingTime = 0.0;
        double avgTurnaroundTime = 0.0;
        for (int i = 0; i < waitingTimes.length; i++) {
            avgWaitingTime += waitingTimes[i];
            avgTurnaroundTime += turnaroundTimes[i];
        }
        avgWaitingTime /= waitingTimes.length;
        avgTurnaroundTime /= turnaroundTimes.length;

        System.out.println("\nAverage Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }

    // Display processes in the queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Node current = head;
        System.out.print("Queue: ");
        do {
            System.out.print("P" + current.processId + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        CircularLinkedList scheduler = new CircularLinkedList();

        scheduler.addProcess(1, 5, 1); // Process 1: Burst Time 5, Priority 1
        scheduler.addProcess(2, 3, 2); // Process 2: Burst Time 3, Priority 2
        scheduler.addProcess(3, 2, 1); // Process 3: Burst Time 2, Priority 1
        scheduler.addProcess(4, 4, 3); // Process 4: Burst Time 4, Priority 3

        int timeQuantum = 2; // Set time quantum
        scheduler.roundRobinScheduling(timeQuantum);
    }
}
