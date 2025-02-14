package hospitalPatientJournal;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an object for the "Urology" department
        Department urologyDepartment = new Department("Urology Department");

        // Add patients to the department
        urologyDepartment.addPatient(new Patient("Ivanov", "Kidney Stones", new Date(), urologyDepartment, "Active"));
        urologyDepartment.addPatient(new Patient("Petrov", "Prostate Enlargement", new Date(), urologyDepartment, "Active"));
        urologyDepartment.addPatient(new Patient("Sidorov", "Urinary Tract Infection", new Date(), urologyDepartment, "Active"));
        urologyDepartment.addPatient(new Patient("Kuznetsova", "Bladder Infection", new Date(), urologyDepartment, "Active"));
        
        // Print the list of patients in the urology department
        urologyDepartment.printPatients();

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

