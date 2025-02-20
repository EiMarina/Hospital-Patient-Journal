package hospitalPatientJournal;

import java.util.ArrayList;
import java.util.List;

// Class representing a hospital that manages departments and patients.
public class Hospital {
    private List<Patient> patients; // List of all patients in the hospital
    
    // Constructor to initialize the hospital
    public Hospital() {
        this.patients = new ArrayList<>();
        new ArrayList<>();
    }
    
    // Adds a new patient to the corresponding department.
    public void addPatient(Patient patient) {
        this.patients.add(patient);
    } 
   
    //Deletes a patient by their ID from the corresponding department.
    public void deletePatient(int patientId) {
        Patient patientToDelete = null;
        for (Patient patient : patients) {
            if (patient.getId() == patientId) {
                patientToDelete = patient;
                break;
            }
        }
        if (patientToDelete != null) {
        	String familyName = patientToDelete.getFamilyName();
            patientToDelete.getDepartment().removePatient(patientId); // Deletes a patient from the department
            patients.remove(patientToDelete); // Deletes a patient from the journal
            System.out.println("Patient with ID " + patientId + " and last name " + familyName + " is deleted!");
        } else {
            System.out.println("Patient with ID " + patientId + " is not found.");
        }
    }

    // Searches for patients by family name.
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

    // Searches for patients by the year of birth.
     public List<Patient> searchByBirthYear(int birthYear) {
         List<Patient> filteredPatients = new ArrayList<>();
    	 for (Patient patient : patients) {
    	     if (patient.getBirthYear() == birthYear) {
    	         filteredPatients.add(patient);
    	     }
    	     }
    	 return filteredPatients;
    }

    // Searches for patients by family name and year of birth.
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
    
    // Searches for patients by diagnosis.
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
}
