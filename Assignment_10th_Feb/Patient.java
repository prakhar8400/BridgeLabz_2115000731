abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class InPatient extends Patient {
    private int daysOfStay;

    public InPatient(String patientId, String name, int age, int daysOfStay) {
        super(patientId, name, age);
        this.daysOfStay = daysOfStay;
    }

    @Override
    public double calculateBill() {
        // Example: Calculate bill based on daily rate (adjust as needed)
        return daysOfStay * 1000.0; 
    }
}

class OutPatient extends Patient {
    private String consultationType;

    public OutPatient(String patientId, String name, int age, String consultationType) {
        super(patientId, name, age);
        this.consultationType = consultationType;
    }

    @Override
    public double calculateBill() {
        // Example: Calculate bill based on consultation type
        if (consultationType.equals("General")) {
            return 500.0;
        } else if (consultationType.equals("Specialist")) {
            return 1000.0;
        } else {
            return 0.0; // Default or invalid type
        }
    }
}

interface MedicalRecord {
    void addRecord(String record);
    String viewRecords();
}

class PatientWithRecord extends InPatient implements MedicalRecord {
    private String medicalHistory = "";

    public PatientWithRecord(String patientId, String name, int age, int daysOfStay) {
        super(patientId, name, age, daysOfStay);
    }

    @Override
    public void addRecord(String record) {
        medicalHistory += record + "\n";
    }

    @Override
    public String viewRecords() {
        return medicalHistory;
    }
}

public class Main {
    public static void main(String[] args) {
        InPatient inPatient = new InPatient("IP123", "John Doe", 30, 5);
        OutPatient outPatient = new OutPatient("OP456", "Jane Smith", 25, "General");
        PatientWithRecord patientWithRecord = new PatientWithRecord("IPR789", "David Lee", 40, 3);

        patientWithRecord.addRecord("Diagnosis: Fever");
        patientWithRecord.addRecord("Medication: Paracetamol");

        Patient[] patients = {inPatient, outPatient, patientWithRecord};

        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Bill Amount: $" + patient.calculateBill());
            if (patient instanceof MedicalRecord) {
                MedicalRecord patientRecord = (MedicalRecord) patient;
                System.out.println("Medical Records:\n" + patientRecord.viewRecords());
            }
            System.out.println("");
        }
    }
}
