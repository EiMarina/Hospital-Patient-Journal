package hospitalPatientJournal;

public class Patient {
	private int id;
	private String familyName;
	private int birthYear;
	private String diagnosis;
	private Department department;
	private String status;
	private static int COUNTER = 0;
	
	// Constructor for the patient class
	public Patient(String familyName, int birthYear, String diagnosis, Department department, String status) {
		this.id = ++COUNTER;		
		this.familyName = familyName;
		this.birthYear = birthYear;	
		this.diagnosis = diagnosis;
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
	
	public int getBirthYear() {
		return birthYear;
	}

	public void setbirthYear(int birthYear) {
		this.birthYear = birthYear;
		
	}
	public String getDiagnosis() {
		return diagnosis;
		
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
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
	      System.out.println("Patient's ID: " + id);
	      System.out.println("Family Name: " + familyName);
	      System.out.println("Year of Birth: " + birthYear);
	      System.out.println("Diagnosis: " + diagnosis);
	      System.out.println("Department: " + department);
	      System.out.println("Status: " + status);
	}
}

