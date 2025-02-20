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
     * Adds a new patient.
     */
    public void addPatient(Patient patient) {
        patients.add(patient);
    }
    
    /**
     * Deletes a patient.
     */
	public void removePatient(int patientId) {
		  patients.removeIf(patient -> patient.getId() == patientId);	
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

	public String getDepartmentName() {
		return departmentName;
	}
}
