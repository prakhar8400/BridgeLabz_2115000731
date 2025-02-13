import java.util.LinkedList;

public class MyHashMap<K, V> {

    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] table;
    private int size;

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        table = new LinkedList[INITIAL_CAPACITY];
        size = 0;
    }

    private int hash(K key) {
        // Simple hash function (replace with a better hash function for production)
        return key.hashCode() % table.length;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        // Check if the key already exists
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update existing value
                return;
            }
        }

        table[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] == null) {
            return null;
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (table[index] == null) {
            return;
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                table[index].remove(entry);
                size--;
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("apple", 3); // Update value for existing key

        System.out.println("Value for apple: " + map.get("apple")); // Output: 3
        System.out.println("Value for banana: " + map.get("banana")); // Output: 2
        System.out.println("Size of map: " + map.size());

        map.remove("apple");
        System.out.println("Value for apple after removal: " + map.get("apple")); // Output: null
    }
}
