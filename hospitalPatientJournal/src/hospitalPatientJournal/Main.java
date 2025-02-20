package hospitalPatientJournal;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static Hospital hospital = new Hospital();
	static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        // User actions
        defaultPatients(hospital);
        printMenu();
        boolean running = true;
		int answer;
		while(running) {
			answer = scanner.nextInt();
			switch(answer) {
                case 1:
                	// Add a patient
                	addNewPatient(scanner);
                	break;
                case 2:
                	// Delete a patient
                	deletePatient(scanner);
                    break;
                case 3:
                	// Search for a patient
                    searchPatient(scanner);
                    break;
                case 4:
                	// Print all the patient of the chosen department
                	printPatientsByDepartment(scanner);
                    break;
                case 0:
                    // Exit the program
                	System.out.println("Exiting program...");
                	running = false;
					break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
			printMenu();
        }
        scanner.close();
        }
    
     // The menu
     private static void printMenu() {
		System.out.println("Welcome to the patients journal!\n"
			+ "Please choose an option:\n"
			+ "1- Add a New Patient\n"
			+ "2- Delete a Patient\n"
			+ "3- Search for a Patient\n"
			+ "4- Print all the Patients of the Department\n"
			+ "0 - Exit"
			);		
	 }
         
     // Method adding a new patient
     private static void addNewPatient(Scanner scanner) {
        System.out.println("Enter patient's last name:");
        String familyName = scanner.next();
        scanner.nextLine();
        System.out.println("Enter patient's birth year:");
        int birthYear = scanner.nextInt();
        System.out.println("Enter patient's diagnosis:");
        String diagnosis = scanner.next();
        System.out.println("Choose department (1 - Cardiology, 2 - Neurology, 3 - Urology):");
        int departmentChoice = scanner.nextInt();
       
        Department department = null;
            switch (departmentChoice) {
               case 1:
                  department = Department.CARDIOLOGY;
                  break;
               case 2:
                  department = Department.NEUROLOGY;
                  break;
               case 3:
                  department = Department.UROLOGY;
                  break;
               default:
                  System.out.println("Invalid department choice.");
                  return;
         }

         Patient newPatient = new Patient(familyName, birthYear, diagnosis, department);
         department.addPatient(newPatient);
         hospital.addPatient(newPatient);
         System.out.println("New patient is added!");
      }

      // Method deleting a patient
      private static void deletePatient(Scanner scanner) {
         System.out.println("Enter patient ID to delete:");
         int patientId = scanner.nextInt();
         hospital.deletePatient(patientId);
      }
 
      // Method searching for a patient
      private static void searchPatient(Scanner scanner) {
    	 int parameterChoice = 0;
    	 while (true) {
    		 try {
                 System.out.println("Choose the parameter (1 - last name, 2 - year of birth, 3 - diagnosis):");
                 parameterChoice = scanner.nextInt();
                 scanner.nextLine();
                 break;
    		 } catch (InputMismatchException e) {
    			   System.out.println("Invalid input. Please enter a valid number (1, 2, or 3).");
    	            scanner.nextLine();
    		 }
    	 }
    	 
         switch (parameterChoice) {
            case 1:
            	// Searching by the last name
            	System.out.println("Enter patient's last name");
            	String familyName = scanner.nextLine();
            	// Asking for the year of birth to filter the result
            	System.out.println("Enter the year of birth (if unknown, enter 0):");
            	int birthYear = 0;
            	while (true) {
            		try {
            	        birthYear = scanner.nextInt();
                        scanner.nextLine();
                        break;
            		 } catch (InputMismatchException e) {
                         System.out.println("Invalid input. Please enter a valid year.");
                         scanner.nextLine();
                     }
                 }
                 if (birthYear == 0) {
                     // If the year of birth is unknown, searching by the last name
            	     List<Patient> foundPatients = hospital.searchByFamilyName(familyName);
                         if (foundPatients.isEmpty()) {
                             System.out.println("No patients found with the last name " + familyName);
                         } else {
                             for (Patient patient : foundPatients) {
                                  patient.displayPatientInfo();
                }
             }
                    } else {
                        // If the year of birth is entered, searching by the last name and the year of birth 
                        List<Patient> foundPatients = hospital.searchByFamilyNameAndBirthYear(familyName, birthYear);
                        if (foundPatients.isEmpty()) {
                            System.out.println("Patients with the last name " + familyName + " born in year " + birthYear + " are not found.");
                        } else {
                            for (Patient patient : foundPatients) {
                                patient.displayPatientInfo();
                            }  
                        }
                    }
                    break;   
              case 2:
            	  // Searching by the year of birth
                  System.out.println("Enter patient's year of birth");
                  int birthYear1 = scanner.nextInt();
                  scanner.nextLine();
            	  List<Patient> foundPatientsByBirthYear = hospital.searchByBirthYear(birthYear1);
            	  if (foundPatientsByBirthYear.isEmpty()) {
                      System.out.println("No patients were born in year " + birthYear1);
                  } else {
                      for (Patient patient : foundPatientsByBirthYear) {
                          patient.displayPatientInfo();
               }
              }
              break;
        	  case 3:
        		// Searching by diagnosis
                  System.out.println("Enter diagnosis");
              	  String diagnosis = scanner.nextLine();
            	  List<Patient> foundPatientsByDiagnosis = hospital.searchByDiagnosis(diagnosis);
            	  if (foundPatientsByDiagnosis.isEmpty()) {
                      System.out.println("No patients found having this diagnosis " + diagnosis);
                  } else {
                      for (Patient patient : foundPatientsByDiagnosis) {
                        patient.displayPatientInfo();
                
                      }
                  }
                  break;    
             default:
                  System.out.println("Invalid option.");
                  break;
             }
       }
      
       // Method printing all the patients of the chosen department
       private static void printPatientsByDepartment(Scanner scanner) {
                System.out.println("Choose department (1 - Urology, 2 - Cardiology, 3 - Neurology):");
                int departmentChoice = scanner.nextInt();
                Department department = null;

                switch (departmentChoice) {
                     case 1:
                         department = Department.UROLOGY;
                         break;
                     case 2:
                         department = Department.CARDIOLOGY;
                         break;
                     case 3:
                         department = Department.NEUROLOGY;
                         break;
                     default:
                         System.out.println("Invalid department choice.");
                         return;
                }

                department.printPatients();
        }
       
        private static void defaultPatients(Hospital hospital) {
   

            // Adds patients to the department and to the journal of the hospital 
            Patient patient1 = new Patient("Ivanov", 1999, "Kidney Stones",  Department.UROLOGY);
            Department.UROLOGY.addPatient(patient1);
            hospital.addPatient(patient1);
            
            Patient patient2 = new Patient("Petrov", 1984, "Prostate Enlargement", Department.UROLOGY);
            Department.UROLOGY.addPatient(patient2);
            hospital.addPatient(patient2);
            
            Patient patient3 = new Patient("Sidorov", 2001, "Urinary Tract Infection", Department.UROLOGY);
            Department.UROLOGY.addPatient(patient3);
            hospital.addPatient(patient3);
            
            Patient patient4 = new Patient("Kuznetsova", 1976, "Bladder Infection", Department.UROLOGY);
            Department.UROLOGY.addPatient(patient4);
            hospital.addPatient(patient4);
            
            Patient patient5 = new Patient("Turner", 1999, "Myocarditis",  Department.CARDIOLOGY);
            Department.CARDIOLOGY.addPatient(patient5);
            hospital.addPatient(patient5);
            
          
            Patient patient6 = new Patient("Turner", 1986, "Heart Attack", Department.CARDIOLOGY);
            Department.CARDIOLOGY.addPatient(patient6);
            hospital.addPatient(patient6);
            
            Patient patient7 = new Patient("Davis", 2001, "Arrhythmia", Department.CARDIOLOGY);
            Department.CARDIOLOGY.addPatient(patient7);
            hospital.addPatient(patient7);
            
            Patient patient8 = new Patient("Cohan", 1983, "Concussion", Department.NEUROLOGY);
            Department.NEUROLOGY.addPatient(patient8);
            hospital.addPatient(patient8);
            
            Patient patient9 = new Patient("Davis", 2003, "Spinal Cord Injury", Department.NEUROLOGY);
            Department.NEUROLOGY.addPatient(patient9);
            hospital.addPatient(patient9);
            
            Patient patient10 = new Patient("Polansky", 1972, "Epilepsy", Department.NEUROLOGY);
            Department.NEUROLOGY.addPatient(patient10);
            hospital.addPatient(patient10);
            
            Patient patient11 = new Patient("Steiman", 1998, "Concussion", Department.NEUROLOGY);
            Department.NEUROLOGY.addPatient(patient11);
            hospital.addPatient(patient11);	
        }      
 }            	
            	
            	
            	
