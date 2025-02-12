class Friend {
    int friendId;

    public Friend(int friendId) {
        this.friendId = friendId;
    }
}

class Node {
    int userId;
    String name;
    int age;
    Friend headFriend; // Head of the linked list of friends

    public Node(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.headFriend = null;
    }
}

class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        head = null;
    }

    // Add a new user
    public void addUser(int userId, String name, int age) {
        Node newNode = new Node(userId, name, age);
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

    // Add friend connection (assuming it's a mutual connection)
    public void addFriendConnection(int userId1, int userId2) {
        Node user1 = searchByUserId(userId1);
        Node user2 = searchByUserId(userId2);

        if (user1 != null && user2 != null) {
            // Add userId2 as a friend of user1
            Friend newFriend1 = new Friend(userId2);
            newFriend1.next = user1.headFriend;
            user1.headFriend = newFriend1;

            // Add userId1 as a friend of user2
            Friend newFriend2 = new Friend(userId1);
            newFriend2.next = user2.headFriend;
            user2.headFriend = newFriend2;
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Remove friend connection (assuming it's a mutual connection)
    public void removeFriendConnection(int userId1, int userId2) {
        Node user1 = searchByUserId(userId1);
        Node user2 = searchByUserId(userId2);

        if (user1 != null && user2 != null) {
            // Remove userId2 from user1's friend list
            removeFriend(user1, userId2);

            // Remove userId1 from user2's friend list
            removeFriend(user2, userId1);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Helper function to remove a friend from a user's list
    private void removeFriend(Node user, int friendId) {
        if (user.headFriend == null) {
            return;
        }

        if (user.headFriend.friendId == friendId) {
            user.headFriend = user.headFriend.next;
            return;
        }

        Friend prev = null;
        Friend current = user.headFriend;

        while (current != null && current.friendId != friendId) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            prev.next = current.next;
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        Node user1 = searchByUserId(userId1);
        Node user2 = searchByUserId(userId2);

        if (user1 != null && user2 != null) {
            System.out.println("Mutual Friends of " + userId1 + " and " + userId2 + ":");
            Friend friend1 = user1.headFriend;
            while (friend1 != null) {
                Friend friend2 = user2.headFriend;
                while (friend2 != null) {
                    if (friend1.friendId == friend2.friendId) {
                        System.out.println("Mutual Friend: " + friend1.friendId);
                    }
                    friend2 = friend2.next;
                }
                friend1 = friend1.next;
            }
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        Node user = searchByUserId(userId);

        if (user != null) {
            System.out.println("Friends of User " + userId + ":");
            Friend current = user.headFriend;
            while (current != null) {
                System.out.println("Friend ID: " + current.friendId);
                current = current.next;
            }
        } else {
            System.out.println("User not found.");
        }
    }

    // Search for a user by User ID
    public Node searchByUserId(int userId) {
        Node current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Search for a user by Name
    public Node searchByName(String name) {
        Node current = head;
        while (current != null) {
            if (current.name.equals(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Count the number of friends for a specific user
    public int countFriends(int userId) {
        Node user = searchByUserId(userId);
        if (user == null) {
            return 0;
        }

        int count = 0;
        Friend current = user.headFriend;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList socialNetwork = new SinglyLinkedList();

        socialNetwork.addUser(1, "Alice", 25);
        socialNetwork.addUser(2, "Bob", 28);
        socialNetwork.addUser(3, "Charlie", 22);

        socialNetwork.addFriendConnection(1, 2);
        socialNetwork.addFriendConnection(1, 3);
        socialNetwork.addFriendConnection(2, 3);

        socialNetwork.displayFriends(1);
        socialNetwork.findMutualFriends(1, 2);

        socialNetwork.removeFriendConnection(1, 2);
        System.out.println("\nAfter removing connection between 1 and 2:");
        socialNetwork.displayFriends(1);

        System.out.println("\nNumber of friends for User 1: " + socialNetwork.countFriends(1));
    }
}
