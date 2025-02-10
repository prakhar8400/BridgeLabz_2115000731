abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Invalid price. Price cannot be negative.");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Invalid quantity. Quantity cannot be negative.");
        }
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
    }
}

class VegItem extends FoodItem {

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return price * quantity; 
    }
}

class NonVegItem extends FoodItem {

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (price * quantity) * 1.1; // 10% extra charge for non-veg items
    }
}

interface Discountable {
    double applyDiscount(double discountPercentage);
    String getDiscountDetails();
}

class DiscountedVegItem extends VegItem implements Discountable {
    public DiscountedVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double applyDiscount(double discountPercentage) {
        return calculateTotalPrice() * (1 - (discountPercentage / 100));
    }

    @Override
    public String getDiscountDetails() {
        return "Discount applied to VegItem.";
    }
}

public class Main {
    public static void main(String[] args) {
        FoodItem vegItem = new VegItem("Vegetable Biryani", 200, 1);
        FoodItem nonVegItem = new NonVegItem("Chicken Tikka Masala", 300, 1);
        FoodItem discountedItem = new DiscountedVegItem("Paneer Butter Masala", 250, 1);

        FoodItem[] order = {vegItem, nonVegItem, discountedItem};

        for (FoodItem item : order) {
            item.getItemDetails();
            System.out.println("Total Price: $" + item.calculateTotalPrice());
            if (item instanceof Discountable) {
                Discountable discountableItem = (Discountable) item;
                double discountedPrice = discountableItem.applyDiscount(10); // 10% discount
                System.out.println("Discounted Price: $" + discountedPrice);
                System.out.println(discountableItem.getDiscountDetails());
            }
            System.out.println("");
        }
    }
}
