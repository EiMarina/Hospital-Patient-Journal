package hospitalPatientJournal;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a hospital department that contains a list of patients.
 */
public class Department {
    private String departmentName; // Name of the department
    private List<Patient> patients; // List of patients in the department
    private static List<Department> departments = new ArrayList<>(); // List of all departments

    // Predefined departments
    public static final Department CARDIOLOGY = new Department("Cardiology");
    public static final Department NEUROLOGY = new Department("Neurology");
    public static final Department UROLOGY = new Department("Urology");

    // Constructor to initialize a new department
    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.patients = new ArrayList<>();
        departments.add(this);
    }

    /**
     * Returns the name of the department.
     */
    public String getName() {
        return departmentName;
    }

    /**
     * Adds a new patient to the department and prints their details.
     */
    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient added to department " + departmentName + ":\n" + patient);
    }

    /**
     * Removes a patient from the department by their ID.
     * If the patient is found, their details are printed before removal.
     */
    public void removePatient(int patientId) {
        Patient patientToRemove = findPatientById(patientId);
        if (patientToRemove != null) {
            patients.remove(patientToRemove);
            System.out.println("Patient removed from department " + departmentName + ":\n" + patientToRemove);
        } else {
            System.out.println("Patient with ID " + patientId + " not found.");
        }
    }

    /**
     * Returns the list of patients in the department.
     */
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * Prints all patients in the department.
     */
    public void printPatients() {
        if (patients.isEmpty()) {
            System.out.println("There are no patients in the department " + departmentName + ".");
        } else {
            System.out.println("List of patients in the department " + departmentName + ":");
            for (Patient patient : patients) {
                System.out.println(patient); // Uses the overridden toString() method
            }
        }
    }

    /**
     * Updates the status of a patient based on their ID.
     * If the patient is found, the updated information is printed.
     */
    public void updatePatientStatus(int patientId, String newStatus) {
        Patient patient = findPatientById(patientId);
        if (patient != null) {
            patient.setStatus(newStatus);
            System.out.println("Updated patient status:\n" + patient);
        } else {
            System.out.println("Patient with ID " + patientId + " not found.");
        }
    }

    /**
     * Finds a patient by their ID and returns the Patient object.
     * If not found, returns null.
     */
    private Patient findPatientById(int patientId) {
        for (Patient patient : patients) {
            if (patient.getId() == patientId) {
                return patient;
            }
        }
        return null;
    }

    /**
     * Returns the list of all departments.
     */
    public static List<Department> getAllDepartments() {
        return departments;
    }
}
