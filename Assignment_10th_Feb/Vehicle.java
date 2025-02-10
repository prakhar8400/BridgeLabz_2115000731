abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public abstract double calculateRentalCost(int days); 
}

class Car extends Vehicle {

    public Car(String vehicleNumber, String type, double rentalRate) {
        super(vehicleNumber, type, rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * rentalRate; 
    }
}

class Bike extends Vehicle {

    public Bike(String vehicleNumber, String type, double rentalRate) {
        super(vehicleNumber, type, rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * rentalRate * 0.8; // 20% discount for bikes
    }
}

class Truck extends Vehicle {

    public Truck(String vehicleNumber, String type, double rentalRate) {
        super(vehicleNumber, type, rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * rentalRate * 1.2; // 20% surcharge for trucks
    }
}

interface Insurable {
    double calculateInsurance(int days);
    String getInsuranceDetails();
}

class InsurableCar extends Car implements Insurable {
    private String insurancePolicyNumber; // Encapsulation

    public InsurableCar(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, type, rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateInsurance(int days) {
        // Calculate insurance based on days and vehicle type (example)
        return days * 5; 
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Policy Number: " + insurancePolicyNumber; 
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car("C123", "Sedan", 50.0);
        vehicles[1] = new Bike("B456", "Sport", 20.0);
        vehicles[2] = new InsurableCar("T789", "Truck", 100.0, "INS12345"); 

        for (Vehicle vehicle : vehicles) {
            int rentalDays = 5;
            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            double insuranceCost = 0.0;

            if (vehicle instanceof Insurable) {
                Insurable insurableVehicle = (Insurable) vehicle;
                insuranceCost = insurableVehicle.calculateInsurance(rentalDays);
                System.out.println(insurableVehicle.getInsuranceDetails());
            }

            System.out.println("Vehicle Type: " + vehicle.getType());
            System.out.println("Rental Cost: $" + rentalCost);
            System.out.println("Insurance Cost: $" + insuranceCost);
            System.out.println("Total Cost: $" + (rentalCost + insuranceCost));
            System.out.println("");
        }
    }
}
