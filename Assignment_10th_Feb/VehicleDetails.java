abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate Per KM: " + ratePerKm);
    }
}

class Car extends Vehicle {

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm; 
    }
}

class Bike extends Vehicle {

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm * 0.8; // 20% discount for bikes
    }
}

class Auto extends Vehicle {

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm * 1.2; // 20% surcharge for autos
    }
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

class GPSEnabledCar extends Car implements GPS {
    private String currentLocation;

    public GPSEnabledCar(String vehicleId, String driverName, double ratePerKm, String initialLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = initialLocation;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car("C123", "John Doe", 10.0);
        vehicles[1] = new Bike("B456", "Jane Smith", 5.0);
        vehicles[2] = new GPSEnabledCar("G789", "David Lee", 12.0, "Starting Point");

        for (Vehicle vehicle : vehicles) {
            vehicle.getVehicleDetails();
            double distance = 10.0; 
            double fare = vehicle.calculateFare(distance);
            System.out.println("Distance: " + distance + " km");
            System.out.println("Fare: $" + fare);
            System.out.println("");

            if (vehicle instanceof GPSEnabledCar) {
                GPSEnabledCar gpsCar = (GPSEnabledCar) vehicle;
                System.out.println("Current Location: " + gpsCar.getCurrentLocation());
                gpsCar.updateLocation("Destination");
                System.out.println("Updated Location: " + gpsCar.getCurrentLocation());
            }
            System.out.println(" ");
        }
    }
}
