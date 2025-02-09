package hospitalPatientJournal;

import java.util.Date;

public class Patient {
	private String id;
	private String familyName;
	private String diagnosis;
	private Date admissionDate;
	private String status;
	private static int COUNTER = 0;
	
	public Patient(String id, String familyName, String diagnosis, Date admissionDate, String status) {
		this.familyName = familyName;
		this.id = " "+(++COUNTER);
		this.diagnosis = diagnosis;
		this.admissionDate = admissionDate;
		this.status = status;
}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String status() {
		return status;
	}

	public void status(String status) {
		this.status = status;
	}
	
	public void displayPatientInfo() {
	      System.out.println("Patient ID: " + id);
	      System.out.println("Family Name: " + familyName);
	      System.out.println("Diagnosis: " + diagnosis);
	      System.out.println("Admission Date: " + admissionDate);
	      System.out.println("Status: " + status);
	    }
	}