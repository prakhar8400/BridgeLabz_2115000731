import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private String name;
    private String description;

    public WarehouseItem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Description: " + description;
    }
}

class Electronics extends WarehouseItem {
    private String brand;

    public Electronics(String name, String description, String brand) {
        super(name, description);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return super.toString() + ", Brand: " + brand;
    }
}

class Groceries extends WarehouseItem {
    private String expiryDate;

    public Groceries(String name, String description, String expiryDate) {
        super(name, description);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", Expiry Date: " + expiryDate;
    }
}

class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, String description, String material) {
        super(name, description);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return super.toString() + ", Material: " + material;
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public void displayAllItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }

    public void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

public class WarehouseManagement {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", "High-performance laptop", "Dell"));
        electronicsStorage.addItem(new Electronics("Smartphone", "Latest flagship model", "Samsung"));
        electronicsStorage.displayAllItems(); 

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Milk", "Fresh milk", "2024-07-05"));
        groceriesStorage.addItem(new Groceries("Bread", "Whole wheat bread", "2024-07-04"));
        groceriesStorage.displayAllItems();

        // Displaying all items using wildcard
        List<Electronics> electronicsList = electronicsStorage.items;
        List<Groceries> groceriesList = groceriesStorage.items;
        Storage<WarehouseItem> warehouse = new Storage<>(); 
        warehouse.displayAllItems(electronicsList);
        warehouse.displayAllItems(groceriesList);
    }
}
