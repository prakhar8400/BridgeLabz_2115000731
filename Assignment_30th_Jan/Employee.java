public class Patient {
    private final int patientID;
    private String name;
    private int age;
    private String ailment;
    private static int patientCount = 0;
    private static final String hospitalName = "XYZ Hospital";

    public Patient(String name, int age, String ailment) {
        this.patientID = ++patientCount;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
    }

    public static int getTotalPatients() {
        return patientCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age. Age cannot be negative.");
        }
    }

    public String getAilment() {
        return ailment;
    }

    public void setAilment(String ailment) {
        this.ailment = ailment;
    }

    public static void displayPatientDetails(Object patientObj) {
        if (patientObj instanceof Patient) {
            Patient patient = (Patient) patientObj;
            System.out.println("Patient ID: " + patient.patientID);
            System.out.println("Patient Name: " + patient.name);
            System.out.println("Age: " + patient.age);
            System.out.println("Ailment: " + patient.ailment);
            System.out.println("Hospital: " + hospitalName);
        } else {
            System.out.println("Invalid patient object.");
        }
    }
}
