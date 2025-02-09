package hospitalPatientJournal;

import java.util.ArrayList;

public class Hospital {
	private ArrayList<Patient> patients = new ArrayList<Patient>();
	private ArrayList<Department> departments = new ArrayList<Department>();
	
	public void addPatient(Patient patient) {
		this.patients.add(patient);
		System.out.println("Patient is added!");
	}
	
	    // Search patients by family name       
	    public ArrayList<Patient> searchByFamilyName(String familyName) {
	         ArrayList<Patient> filteredPatients = new ArrayList<>();
	            for (Patient patient : patients) {
	               if (patient.getFamilyName().contains(familyName)) {
	            	   filteredPatients.add(patient);
	               }
	             }
	             return filteredPatients;
	             }

	    // Search patients by diagnosis
	    public ArrayList<Patient> searchByDiagnosis(String diagnosis) {
	    	ArrayList<Patient> filteredPatients = new ArrayList<>();
	             for (Patient patient : patients) {
	            	 if (patient.getDiagnosis().contains(diagnosis)) {
	            	   filteredPatients.add(patient);
	               }
	             }
	             return filteredPatients;
	            }
	    
	    // Search patients by department
	   
	}
