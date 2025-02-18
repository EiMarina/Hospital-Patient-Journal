package hospitalPatientJournal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an object for the "Urology" department
        Department urologyDepartment = new Department("Urology");
        Department cardiologyDepartment = new Department("Cardiology");
        Department neurologyDepartment = new Department("Neurology");

        // Add patients to the "Urology" department 
        urologyDepartment.addPatient(new Patient("Ivanov", 1999, "Kidney Stones", urologyDepartment, "Active"));
        urologyDepartment.addPatient(new Patient("Petrov", 1984, "Prostate Enlargement", urologyDepartment, "Active"));
        urologyDepartment.addPatient(new Patient("Sidorov", 2001, "Urinary Tract Infection", urologyDepartment, "Active"));
        urologyDepartment.addPatient(new Patient("Kuznetsova", 1976, "Bladder Infection", urologyDepartment, "Active"));
      
        //Add patients to the "Cardiology" department 
        cardiologyDepartment.addPatient(new Patient("Turner", 1999, "Myocarditis", cardiologyDepartment, "Active"));
        cardiologyDepartment.addPatient(new Patient("Turner", 1986, "Heart Attack", cardiologyDepartment, "Active"));
        cardiologyDepartment.addPatient(new Patient("Davis", 2001, "Arrhythmia", cardiologyDepartment, "Active"));
        
        //Add patients to the "Neurology" department
        neurologyDepartment.addPatient(new Patient ("Cohan", 1983, "Concussion", neurologyDepartment, "Active" ));
        neurologyDepartment.addPatient(new Patient("Davis", 2003, "Spinal Cord Injury", neurologyDepartment, "Active"));
        neurologyDepartment.addPatient(new Patient("Polansky", 1972, "Epilepsy", neurologyDepartment, "Active"));
        neurologyDepartment.addPatient(new Patient("Steiman", 1998, "Concussion", neurologyDepartment, "Active"));
        
        // Display patient information
        System.out.println("Patients in Urology Department:");
        urologyDepartment.printPatients();
        
        System.out.println("Patients in Cardiology Department:");
        cardiologyDepartment.printPatients();

        System.out.println("\nPatients in Neurology Department:");
        neurologyDepartment.printPatients();
        
       

        // User actions
        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an action: ");
            System.out.println("1. Update patient status");
            System.out.println("2. Remove patient");
            System.out.println("3. Print patients");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // Update patient status
                    System.out.println("Enter patient ID to update status:");
                    int patientId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    urologyDepartment.updatePatientStatus(patientId, "Recovered");
                    break;
                case 2:
                    // Remove patient
                    System.out.println("Enter patient ID to remove:");
                    int idToRemove = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    urologyDepartment.removePatient(idToRemove);
                    break;
                case 3:
                    // Print the list of patients
                    urologyDepartment.printPatients();
                    break;
                case 4:
                    // Exit the program
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
        scanner.close();
    }
}

