abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount(); 
}

class Electronics extends Product {

    public Electronics(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        // Example: 10% discount on electronics
        return 0.10 * price;
    }
}

class Clothing extends Product {

    public Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        // Example: 5% discount on clothing
        return 0.05 * price;
    }
}

class Groceries extends Product {

    public Groceries(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        // Example: No discount on groceries
        return 0.0; 
    }
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class TaxableElectronics extends Electronics implements Taxable {

    public TaxableElectronics(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateTax() {
        // Example: 18% tax on electronics
        return 0.18 * price; 
    }

    @Override
    public String getTaxDetails() {
        return "Taxable at 18%";
    }
}

class TaxableClothing extends Clothing implements Taxable {

    public TaxableClothing(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateTax() {
        // Example: 5% tax on clothing
        return 0.05 * price; 
    }

    @Override
    public String getTaxDetails() {
        return "Taxable at 5%";
    }
}

public class Main {
    public static void main(String[] args) {
        Product electronics = new TaxableElectronics("E001", "Laptop", 1000.00);
        Product clothing = new TaxableClothing("C001", "T-Shirt", 20.00);
        Product groceries = new Groceries("G001", "Milk", 15.00);

        Product[] products = {electronics, clothing, groceries};

        for (Product product : products) {
            double discount = product.calculateDiscount();
            double tax = 0.0; 
            if (product instanceof Taxable) {
                tax = ((Taxable) product).calculateTax();
            }
            double finalPrice = product.getPrice() + tax - discount;
            System.out.println("Product: " + product.getName());
            System.out.println("Final Price: $" + finalPrice);
            if (product instanceof Taxable) {
                System.out.println(((Taxable) product).getTaxDetails());
            }
            System.out.println("");
        }
    }
}
