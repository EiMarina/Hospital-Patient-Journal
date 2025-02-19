package hospitalPatientJournal;

/**
 * Class representing a patient in a hospital.
 */
public class Patient {
    private int id; // Unique patient ID
    private String familyName; // Patient's last name
    private int birthYear; // Patient's birth year
    private String diagnosis; // Patient's diagnosis
    private Department department; // Department where the patient is treated
    private String status; // Current status of the patient (e.g., "Active", "Recovered")
    private static int COUNTER = 0; // Counter to generate unique patient IDs

    // Constructor to initialize a new patient
    public Patient(String familyName, int birthYear, String diagnosis, Department department, String status) {
        this.id = ++COUNTER; // Automatically generate a unique ID
        this.familyName = familyName;
        this.birthYear = birthYear;
        this.diagnosis = diagnosis;
        this.department = department;
        this.status = status;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public Department getDepartment() {
        return department;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns a formatted string representation of the patient's information.
     */
    @Override
    public String toString() {
        return "Patient's ID: " + id + "\n" +
               "Family Name: " + familyName + "\n" +
               "Year of Birth: " + birthYear + "\n" +
               "Diagnosis: " + diagnosis + "\n" +
               "Department: " + department.getName() + "\n" +
               "Status: " + status + "\n" +
               "---------------------------";
    }

    /**
     * Prints detailed information about the patient.
     */
    public void displayPatientInfo() {
        System.out.println(this.toString());
    }
}

