import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String hospitalName;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public String getHospitalName() {
        return hospitalName;
    }
}

class Doctor {
    private String doctorName;
    private List<Patient> patients;

    public Doctor(String doctorName) {
        this.doctorName = doctorName;
        this.patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void consult(Patient patient) {
        System.out.println(doctorName + " is consulting with " + patient.getPatientName());
    }
}

class Patient {
    private String patientName;
    private List<Doctor> doctors;

    public Patient(String patientName) {
        this.patientName = patientName;
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public String getPatientName() {
        return patientName;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a Hospital
        Hospital hospital = new Hospital("XYZ Hospital");

        // Create Doctors
        Doctor doctor1 = new Doctor("Dr. Smith");
        Doctor doctor2 = new Doctor("Dr. Jones");
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);

        // Create Patients
        Patient patient1 = new Patient("John Doe");
        Patient patient2 = new Patient("Jane Doe");
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        // Establish doctor-patient relationships
        doctor1.addPatient(patient1);
        doctor1.addPatient(patient2);
        doctor2.addPatient(patient1);

        // Demonstrate consultation
        doctor1.consult(patient1); 
    }
}
