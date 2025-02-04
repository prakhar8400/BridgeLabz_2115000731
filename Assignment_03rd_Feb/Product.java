public class Product {
    private final String productID;
    private String productName;
    private double price;
    private int quantity;
    private static double discount = 0.0; // Default discount: 0%

    private static int productCount = 0; // Counter for generating unique product IDs

    public Product(String productName, double price, int quantity) {
        this.productID = "P" + ++productCount; // Generate unique product ID
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double newDiscount) {
        if (newDiscount >= 0 && newDiscount <= 100) { // Validate discount percentage
            discount = newDiscount; 
        } else {
            System.out.println("Invalid discount percentage. Must be between 0 and 100.");
        }
    }

    public static double getDiscount() {
        return discount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public double calculateTotalPrice() {
        double discountedPrice = price - (price * discount / 100); 
        return discountedPrice * quantity;
    }

    public static void displayProductDetails(Object productObj) {
        if (productObj instanceof Product) {
            Product product = (Product) productObj;
            System.out.println("Product ID: " + product.productID);
            System.out.println("Product Name: " + product.productName);
            System.out.println("Price: $" + product.price);
            System.out.println("Quantity: " + product.quantity);
            System.out.println("Total Price: $" + product.calculateTotalPrice());
        } else {
            System.out.println("Invalid product object.");
        }
    }
}
