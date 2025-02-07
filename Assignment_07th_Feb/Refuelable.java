interface Refuelable {
    void refuel();
}

public class Vehicle {
    protected int maxSpeed;
    protected String model;

    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getModel() {
        return model;
    }
}

public class ElectricVehicle extends Vehicle {
    public ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    public void charge() {
        System.out.println("Electric Vehicle is charging.");
    }
}

public class PetrolVehicle extends Vehicle implements Refuelable {
    public PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    @Override
    public void refuel() {
        System.out.println("Refueling Petrol Vehicle.");
    }
}

public class Main {
    public static void main(String[] args) {
        ElectricVehicle electricCar = new ElectricVehicle(180, "Tesla Model S");
        electricCar.charge();

        PetrolVehicle petrolCar = new PetrolVehicle(220, "BMW M3");
        petrolCar.refuel();
    }
}
