public class Device {
    private String deviceId;
    private boolean status; // true for ON, false for OFF

    public Device(String deviceId) {
        this.deviceId = deviceId;
        this.status = false; // Default to OFF
    }

    public String getDeviceId() {
        return deviceId;
    }

    public boolean getStatus() {
        return status;
    }

    public void turnOn() {
        status = true;
    }

    public void turnOff() {
        status = false;
    }

    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + (status ? "ON" : "OFF"));
    }
}

public class Thermostat extends Device {
    private double temperatureSetting;

    public Thermostat(String deviceId, double temperatureSetting) {
        super(deviceId);
        this.temperatureSetting = temperatureSetting;
    }

    public double getTemperatureSetting() {
        return temperatureSetting;
    }

    public void setTemperatureSetting(double temperatureSetting) {
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

public class Main {
    public static void main(String[] args) {
        Device device1 = new Device("D1");
        device1.turnOn();
        device1.displayStatus(); // Output: Device ID: D1, Status: ON

        Thermostat thermostat = new Thermostat("T1", 22.0);
        thermostat.turnOn();
        thermostat.displayStatus(); // Output: Device ID: T1, Status: ON, Temperature Setting: 22.0°C
    }
}
