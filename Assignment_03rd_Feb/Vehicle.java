public class Vehicle {
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;
    private static double registrationFee = 1000.0; // Default registration fee

    private static int vehicleCount = 0; 

    public Vehicle(String ownerName, String vehicleType) {
        this.registrationNumber = "V" + ++vehicleCount; 
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public static void updateRegistrationFee(double newFee) {
        if (newFee >= 0) {
            registrationFee = newFee;
        } else {
            System.out.println("Invalid registration fee. Fee must be non-negative.");
        }
    }

    public static double getRegistrationFee() {
        return registrationFee;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public static void displayVehicleDetails(Object vehicleObj) {
        if (vehicleObj instanceof Vehicle) {
            Vehicle vehicle = (Vehicle) vehicleObj;
            System.out.println("Registration Number: " + vehicle.registrationNumber);
            System.out.println("Owner Name: " + vehicle.ownerName);
            System.out.println("Vehicle Type: " + vehicle.vehicleType);
        } else {
            System.out.println("Invalid vehicle object.");
        }
    }
}
