package hospitalPatientJournal;

import java.util.ArrayList;
import java.util.List;

/**
 * The Hospital class represents a hospital that manages a list of patients.
 */
public class Hospital {
    private List<Patient> patients;

    /**
     * Constructor initializes an empty list of patients.
     */
    public Hospital() {
        this.patients = new ArrayList<>();
    }

    /**
     * Adds a new patient to the hospital's list.
     * 
     * @param patient The patient to be added.
     */
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    /**
     * Deletes a patient from the hospital by their ID.
     * 
     * @param patientId The ID of the patient to be removed.
     * @return true if the patient was removed successfully, false otherwise.
     */
    public boolean deletePatient(int patientId) {
        return patients.removeIf(patient -> patient.getId() == patientId);
    }

    /**
     * Retrieves a patient by their ID.
     * 
     * @param patientId The ID of the patient to find.
     * @return The patient object if found, otherwise null.
     */
    public Patient getPatientById(int patientId) {
        for (Patient patient : patients) {
            if (patient.getId() == patientId) {
                return patient;
            }
        }
        return null;
    }

    /**
     * Retrieves a list of all patients in the hospital.
     * 
     * @return A copy of the patient list to prevent external modification.
     */
    public List<Patient> getPatients() {
        return new ArrayList<>(patients);
    }

    /**
     * Searches for patients by their last name.
     * 
     * @param familyName The last name of the patient(s) to search for.
     * @return A list of patients with the matching last name.
     */
    public List<Patient> searchByFamilyName(String familyName) {
        List<Patient> result = new ArrayList<>();
        for (Patient patient : patients) {
            if (patient.getFamilyName().equalsIgnoreCase(familyName)) {
                result.add(patient);
            }
        }
        return result;
    }
}
