package hospitalPatientJournal;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String departmentName; // Department name
	private List<Patient> patients; // list of patients in the department

	// Constructor
	public Department(String departmentName) {
		this.departmentName = departmentName;
		this.patients = new ArrayList<>();
	}

	// Method adds patients to department
	public void addPatient(Patient patient) {
		patients.add(patient);
		System.out.println("Patient " + patient.getFamilyName() + " added to the department " + departmentName);
	}

	// Method for deleting patients by ID
	public void removePatient(int patientId) {
		Patient patientToRemove = findPatientById(patientId);
		if (patientToRemove != null) {
			patients.remove(patientToRemove);
			System.out.println("Patient with ID " + patientId + " removed from the department " + departmentName);
		} else {
			System.out.println("Patient with ID " + patientId + " not found.");
		}
	}

	// Method to get patients from the department
	public List<Patient> getPatients() {
		return patients;
	}

	// Method to print information about all patients in the department
	public void printPatients() {
		if (patients.isEmpty()) {
			System.out.println("There are no patients in the department " + departmentName + ".");
		} else {
			System.out.println("List of patients in the department " + departmentName + ":");
			for (Patient patient : patients) {
				System.out.println(patient);
			}
		}
	}

	// Method to update patient status
	public void updatePatientStatus(int patientId, String newStatus) {
		Patient patient = findPatientById(patientId);
		if (patient != null) {
			patient.setStatus(newStatus);
			System.out.println("Patient " + patient.getFamilyName() + "'s status updated to " + newStatus);
		} else {
			System.out.println("Patient with ID " + patientId + " not found.");
		}
	}

	// Method to find a patient by ID
	private Patient findPatientById(int patientId) {
		for (Patient patient : patients) {
			if (patient.getId() == patientId) {
				return patient;
			}
		}
		return null;
	}
}
