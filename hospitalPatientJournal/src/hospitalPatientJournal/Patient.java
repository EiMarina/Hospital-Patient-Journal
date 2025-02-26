package hospitalPatientJournal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for representing a patient.
 */
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L; // Recommended to add serialVersionUID

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
     * Converts the patient to a CSV-formatted string.
     * This will be used for saving the patient's data to a CSV file.
     */
    public String toCSV() {
        return id + "," + familyName + "," + birthYear + "," + diagnosis + "," + department.getName() + "," + status;
    }

    /**
     * Creates a patient from a CSV-formatted string.
     * This will be used to read a patient's data from a CSV file.
     */
    public static Patient fromCSV(String csvLine) {
        String[] fields = csvLine.split(",");
        int id = Integer.parseInt(fields[0]);
        String familyName = fields[1];
        int birthYear = Integer.parseInt(fields[2]);
        String diagnosis = fields[3];
        Department department = new Department(fields[4]); // Assuming department has a constructor taking a name
        String status = fields[5];
        return new Patient(familyName, birthYear, diagnosis, department, status);
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

    // Method for saving the patient to a file
    public void saveToFile(PrintWriter writer) {
        writer.println(toCSV());
    }

    /**
     * Loads a list of patients from a CSV file.
     */
    public static List<Patient> loadPatientsFromFile(String filePath) {
        List<Patient> patients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Parse the CSV line and create a Patient object
                Patient patient = Patient.fromCSV(line);
                patients.add(patient);
            }
        } catch (IOException e) {
            System.out.println("Error loading patients from file: " + e.getMessage());
        }
        return patients;
    }

    /**
     * Saves a list of patients to a CSV file.
     */
    public static void savePatientsToFile(List<Patient> patients, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Patient patient : patients) {
                patient.saveToFile(writer); // Saving each patient as a CSV line
            }
        } catch (IOException e) {
            System.out.println("Error saving patients to file: " + e.getMessage());
        }
    }
}
