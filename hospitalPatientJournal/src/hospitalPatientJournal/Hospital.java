package hospitalPatientJournal;

import java.util.ArrayList;

public class Hospital {
	private ArrayList<Patient> patients = new ArrayList<Patient>();
	private ArrayList<Department> departments = new ArrayList<Department>();
	
	 // Creating a new department
    public void addDepartment(Department department) {
		this.departments.add(department);
    }
    
	// Creating a new patient
	public void addPatient(Patient patient) {
		this.patients.add(patient);
		System.out.println("Patient is added!");
	}
	
	// Deleting a patient by deleting his id
	public void deletePatient(int id) {
	    patients.removeIf(patient -> patient.getId() == id);
	    System.out.println("Patient is deleted!");
	}
	
		// Searching patients by family name       
	 public ArrayList<Patient> searchByFamilyName(String familyName) {
	    ArrayList<Patient> filteredPatients = new ArrayList<>();
	       for (Patient patient : patients) {
	           if (patient.getFamilyName().equalsIgnoreCase(familyName)) {
	              filteredPatients.add(patient);
	              }
	           }
	           return filteredPatients;
	  }

	  // Searching patients by diagnosis
	  public ArrayList<Patient> searchByDiagnosis(String diagnosis) {
	     ArrayList<Patient> filteredPatients = new ArrayList<>();
	       for (Patient patient : patients) {
	           if (patient.getDiagnosis().equalsIgnoreCase(diagnosis)) {
	              filteredPatients.add(patient);
	              }
	           }
	           return filteredPatients;
	  }
	    
	  // Searching patients by department
	  public ArrayList<Patient> searchByDepartment(Department department) {
	     ArrayList<Patient> filteredPatients = new ArrayList<>();
	       for (Patient patient : patients) {
	           if (patient.getDepartment().equals(department)) {
	               filteredPatients.add(patient);
	               }
	           }
	           return filteredPatients;
	   }
}