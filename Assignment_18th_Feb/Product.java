import java.util.ArrayList;
import java.util.List;

enum BookCategory { FICTION, NON_FICTION, TECHNICAL }
enum ClothingCategory { TOPS, BOTTOMS, ACCESSORIES }
enum GadgetCategory { ELECTRONICS, HOME_APPLIANCES, GADGETS }

abstract class Product<T extends Enum<?>> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}

class Book extends Product<BookCategory> {
    public Book(String name, double price, BookCategory category) {
        super(name, price, category);
    }
}

class Clothing extends Product<ClothingCategory> {
    public Clothing(String name, double price, ClothingCategory category) {
        super(name, price, category);
    }
}

class Gadget extends Product<GadgetCategory> {
    public Gadget(String name, double price, GadgetCategory category) {
        super(name, price, category);
    }
}

class OnlineMarketplace {
    private List<Product<?>> products;

    public OnlineMarketplace() {
        products = new ArrayList<>();
    }

    public void addProduct(Product<?> product) {
        products.add(product);
    }

    // Generic method to apply discount
    public <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discount);
    }

    public void displayAllProducts() {
        for (Product<?> product : products) {
            System.out.println(product);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        OnlineMarketplace marketplace = new OnlineMarketplace();

        marketplace.addProduct(new Book("The Lord of the Rings", 29.99, BookCategory.FICTION));
        marketplace.addProduct(new Clothing("T-Shirt", 19.99, ClothingCategory.TOPS));
        marketplace.addProduct(new Gadget("Smartphone", 999.99, GadgetCategory.ELECTRONICS));

        System.out.println("Products before discount:");
        marketplace.displayAllProducts();

        // Apply 10% discount to all products
        for (Product<?> product : marketplace.products) {
            marketplace.applyDiscount(product, 10);
        }

        System.out.println("\nProducts after discount:");
        marketplace.displayAllProducts();
    }
}
