public class Order {
    private int orderId;
    private String orderDate;

    public Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderStatus() {
        return "Order Placed";
    }
}

public class ShippedOrder extends Order {
    private String trackingNumber;

    public ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order Shipped";
    }
}

public class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    public DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order Delivered";
    }
}

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order(101, "2023-11-20");
        System.out.println(order1.getOrderStatus()); // Output: Order Placed

        ShippedOrder order2 = new ShippedOrder(102, "2023-11-21", "SHP123");
        System.out.println(order2.getOrderStatus()); // Output: Order Shipped

        DeliveredOrder order3 = new DeliveredOrder(103, "2023-11-22", "SHP124", "2023-11-23");
        System.out.println(order3.getOrderStatus()); // Output: Order Delivered
    }
}
