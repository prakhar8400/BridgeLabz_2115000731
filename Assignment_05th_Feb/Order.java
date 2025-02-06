import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;

    // Assuming a static counter for generating unique order IDs
    private static int orderCount = 0;

    public Order(Customer customer) {
        this.orderId = ++orderCount;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}

public class Customer {
    private String customerName;
    private List<Order> orders;

    public Customer(String customerName) {
        this.customerName = customerName;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public String getCustomerName() {
        return customerName;
    }
}

public class Product {
    private String productName;
    private double price;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a Customer
        Customer customer = new Customer("John Doe");

        // Create Products
        Product product1 = new Product("Laptop", 1200.0);
        Product product2 = new Product("Mouse", 30.0);

        // Create an Order
        Order order = new Order(customer); 

        // Add products to the order
        order.addProduct(product1);
        order.addProduct(product2);

        // Place the order for the customer
        customer.placeOrder(order);

        // Calculate and display total order amount
        System.out.println("Total Order Amount: $" + order.calculateTotal()); 
    }
}
