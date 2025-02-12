class TextState {
    String text;
    TextState next;
    TextState prev;

    public TextState(String text) {
        this.text = text;
        this.next = null;
        this.prev = null;
    }
}

class TextEditor {
    private TextState head;
    private TextState tail;
    private TextState current;
    private int maxSize; // Maximum number of states to store

    public TextEditor(int maxSize) {
        this.maxSize = maxSize;
        head = null;
        tail = null;
        current = null;
    }

    public void addState(String text) {
        TextState newState = new TextState(text);

        if (head == null) {
            head = newState;
            tail = newState;
            current = newState;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;

            // Limit the history size
            if (maxSize > 0 && size() > maxSize) {
                head = head.next;
                head.prev = null;
            }
        }
    }

    public void undo() {
        if (current.prev != null) {
            current = current.prev;
        }
    }

    public void redo() {
        if (current.next != null) {
            current = current.next;
        }
    }

    public String getCurrentText() {
        return current.text;
    }

    private int size() {
        int count = 0;
        TextState temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10); // Limit history to 10 states

        editor.addState("Hello");
        editor.addState("Hello, ");
        editor.addState("Hello, World!");
        editor.addState("Hello, World! How");
        editor.addState("Hello, World! How are");
        editor.addState("Hello, World! How are you?");

        System.out.println("Current Text: " + editor.getCurrentText());

        editor.undo();
        System.out.println("After Undo: " + editor.getCurrentText());

        editor.redo();
        System.out.println("After Redo: " + editor.getCurrentText());

        // Add more states and perform undo/redo operations
    }
}
