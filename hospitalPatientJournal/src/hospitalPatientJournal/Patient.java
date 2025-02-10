package hospitalPatientJournal;

import java.util.Date;

public class Patient {
	private int id;
	private String familyName;
	private String diagnosis;
	private Date admissionDate;
	private Department department;
	private String status;
	private static int COUNTER = 0;
	
	// Constructor for the patient class
	public Patient(String familyName, String diagnosis, Date admissionDate, Department department, String status) {
		this.familyName = familyName;
		this.id = ++COUNTER;
		this.diagnosis = diagnosis;
		this.admissionDate = admissionDate;
		this.department = department;
		this.status = status;
    }
	
	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	// Method of displaying all the information about the patient
	public void displayPatientInfo() {
	      System.out.println("Patient ID: " + id);
	      System.out.println("Family Name: " + familyName);
	      System.out.println("Diagnosis: " + diagnosis);
	      System.out.println("Admission Date: " + admissionDate);
	      System.out.println("Department: " + department);
	      System.out.println("Status: " + status);
	}
}

