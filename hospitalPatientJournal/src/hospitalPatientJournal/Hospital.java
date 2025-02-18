package hospitalPatientJournal;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a hospital that manages departments and patients.
 */
public class Hospital {
    private List<Patient> patients; // List of all patients in the hospital
    private List<Department> departments; // List of all hospital departments

    // Constructor to initialize the hospital
    public Hospital() {
        this.patients = new ArrayList<>();
        this.departments = new ArrayList<>();
    }

    /**
     * Adds a new department to the hospital.
     */
    public void addDepartment(Department department) {
        this.departments.add(department);
    }

    /**
     * Adds a new patient to the hospital.
     */
    public void addPatient(Patient patient) {
        this.patients.add(patient);
        System.out.println("Patient is added!");
    }

    /**
     * Deletes a patient by their ID.
     */
    public void deletePatient(int id) {
        patients.removeIf(patient -> patient.getId() == id);
        System.out.println("Patient is deleted!");
    }

    /**
     * Searches for patients by family name.
     */
    public List<Patient> searchByFamilyName(String familyName) {
        List<Patient> filteredPatients = new ArrayList<>();
        if (familyName == null) return filteredPatients;
        for (Patient patient : patients) {
            if (patient.getFamilyName().equalsIgnoreCase(familyName)) {
                filteredPatients.add(patient);
            }
        }
        return filteredPatients;
    }

    /**
     * Searches for patients by diagnosis.
     */
    public List<Patient> searchByDiagnosis(String diagnosis) {
        List<Patient> filteredPatients = new ArrayList<>();
        if (diagnosis == null) return filteredPatients;
        for (Patient patient : patients) {
            if (patient.getDiagnosis().equalsIgnoreCase(diagnosis)) {
                filteredPatients.add(patient);
            }
        }
        return filteredPatients;
    }

    /**
     * Searches for patients by department.
     */
    public List<Patient> searchByDepartment(Department department) {
        List<Patient> filteredPatients = new ArrayList<>();
        if (department == null) return filteredPatients;
        for (Patient patient : patients) {
            if (patient.getDepartment().equals(department)) {
                filteredPatients.add(patient);
            }
        }
        return filteredPatients;
    }

    /**
     * Searches for patients by family name and year of birth.
     */
    public List<Patient> searchByFamilyNameAndBirthYear(String familyName, int birthYear) {
        List<Patient> filteredPatients = new ArrayList<>();
        if (familyName == null) return filteredPatients;
        for (Patient patient : patients) {
            if (patient.getFamilyName().equalsIgnoreCase(familyName) && patient.getBirthYear() == birthYear) {
                filteredPatients.add(patient);
            }
        }
        return filteredPatients;
    }
}
