package hospitalPatientJournal;

import java.util.List;
import java.util.Scanner;

public class Main {

    static Hospital hospital = new Hospital();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Creating default patients
        defaultPatients(hospital);

        // Display main menu
        printMenu();
        
        boolean running = true;
        while (running) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                int answer = scanner.nextInt();
                scanner.nextLine(); // Clear \n after nextInt()
                switch (answer) {
                    case 1 -> addNewPatient(scanner);
                    case 2 -> deletePatient(scanner);
                    case 3 -> updatePatientStatus(scanner);
                    case 4 -> searchPatient(scanner);
                    case 5 -> printPatientsByDepartment(scanner);
                    case 6 -> PatientArchive.displayArchivedPatients();
                    case 0 -> {
                        System.out.println("Exiting program...");
                        running = false;
                    }
                    default -> System.out.println("Invalid choice! Try again.");
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Clear invalid input
            }
            if (running) {
                printMenu();
            }
        }
        scanner.close();
    }
    private static void updatePatientStatus(Scanner scanner) {
        System.out.println("Enter patient ID to update status:");
        
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid patient ID:");
            scanner.next();
        }
        int patientId = scanner.nextInt();
        scanner.nextLine(); // Clear \n after nextInt()
        
        Patient patient = hospital.getPatientById(patientId);
        
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.println("Enter new status for patient " + patient.getFamilyName() + ":");
        String newStatus = scanner.nextLine();
        patient.setStatus(newStatus);
        System.out.println("Patient status updated to " + newStatus);

        if (newStatus.equalsIgnoreCase("Recovered")) {
            PatientArchive.archivePatients(hospital.getPatients());
            System.out.println("Patient " + patient.getFamilyName() + " has been archived.");
        }
    }


    private static void printMenu() {
        System.out.println("\nWelcome to the patients journal!\n" +
                "Please choose an option:\n" +
                "1- Add a New Patient\n" +
                "2- Delete a Patient\n" +
                "3- Update the Patient's Status\n" +
                "4- Search for a Patient\n" +
                "5- Print all the Patients of the Department\n" +
                "6 - View Archived Patients\n" +
                "0 - Exit");
    }

    private static void addNewPatient(Scanner scanner) {
        System.out.println("Enter patient's last name:");
        String familyName = scanner.nextLine();

        System.out.println("Enter patient's birth year:");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid year:");
            scanner.next();
        }
        int birthYear = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter patient's diagnosis:");
        String diagnosis = scanner.nextLine();

        System.out.println("Choose department (1 - Cardiology, 2 - Neurology, 3 - Urology):");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter 1, 2, or 3:");
            scanner.next();
        }
        int departmentChoice = scanner.nextInt();
        scanner.nextLine();

        Department department = switch (departmentChoice) {
            case 1 -> Department.CARDIOLOGY;
            case 2 -> Department.NEUROLOGY;
            case 3 -> Department.UROLOGY;
            default -> null;
        };

        if (department == null) {
            System.out.println("Invalid department choice.");
            return;
        }

        System.out.println("Enter patient's status (Active, Recovered, etc.):");
        String status = scanner.nextLine();

        Patient newPatient = new Patient(familyName, birthYear, diagnosis, department, status);
        department.addPatient(newPatient);
        hospital.addPatient(newPatient);
        System.out.println("Patient " + familyName + " added successfully!");
    }

    private static void deletePatient(Scanner scanner) {
        System.out.println("Enter the patient ID to delete:");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid patient ID:");
            scanner.next();
        }
        int patientId = scanner.nextInt();
        scanner.nextLine();
        
        if (hospital.deletePatient(patientId)) {
            System.out.println("Patient has been successfully deleted.");
        } else {
            System.out.println("No patient found with the given ID.");
        }
    }

    private static void searchPatient(Scanner scanner) {
        System.out.println("Enter patient's last name:");
        String familyName = scanner.nextLine();
        List<Patient> foundPatients = hospital.searchByFamilyName(familyName);
        
        if (foundPatients.isEmpty()) {
            System.out.println("No patients found with the last name " + familyName);
        } else {
            for (Patient patient : foundPatients) {
                patient.displayPatientInfo();
            }
        }
    }

    private static void printPatientsByDepartment(Scanner scanner) {
        System.out.println("Choose department (1 - Urology, 2 - Cardiology, 3 - Neurology):");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter 1, 2, or 3:");
            scanner.next();
        }
        int departmentChoice = scanner.nextInt();
        scanner.nextLine();

        Department department = switch (departmentChoice) {
            case 1 -> Department.UROLOGY;
            case 2 -> Department.CARDIOLOGY;
            case 3 -> Department.NEUROLOGY;
            default -> null;
        };

        if (department == null) {
            System.out.println("Invalid department choice.");
            return;
        }
        department.printPatients();
    }
    private static void defaultPatients(Hospital hospital) {
    	Patient patient1 = new Patient("Ivanov", 1999, "Kidney Stones", Department.UROLOGY, "Active");
    	hospital.addPatient(patient1);
    	Department.UROLOGY.addPatient(patient1);

    	Patient patient2 = new Patient("Petrov", 1984, "Prostate Enlargement", Department.UROLOGY, "Active");
    	hospital.addPatient(patient2);
    	Department.UROLOGY.addPatient(patient2);

    	Patient patient3 = new Patient("Sidorov", 2001, "Urinary Tract Infection", Department.UROLOGY, "Active");
    	hospital.addPatient(patient3);
    	Department.UROLOGY.addPatient(patient3);

    	Patient patient4 = new Patient("Kuznetsova", 1976, "Bladder Infection", Department.UROLOGY, "Active");
    	hospital.addPatient(patient4);
    	Department.UROLOGY.addPatient(patient4);

    	Patient patient5 = new Patient("Turner", 1999, "Myocarditis", Department.CARDIOLOGY, "Active");
    	hospital.addPatient(patient5);
    	Department.CARDIOLOGY.addPatient(patient5);

    	Patient patient6 = new Patient("Turner", 1986, "Heart Attack", Department.CARDIOLOGY, "Active");
    	hospital.addPatient(patient6);
    	Department.CARDIOLOGY.addPatient(patient6);

    	Patient patient7 = new Patient("Davis", 2001, "Arrhythmia", Department.CARDIOLOGY, "Active");
    	hospital.addPatient(patient7);
    	Department.CARDIOLOGY.addPatient(patient7);

    	Patient patient8 = new Patient("Cohan", 1983, "Concussion", Department.NEUROLOGY, "Active");
    	hospital.addPatient(patient8);
    	Department.NEUROLOGY.addPatient(patient8);

    	Patient patient9 = new Patient("Davis", 2003, "Spinal Cord Injury", Department.NEUROLOGY, "Active");
    	hospital.addPatient(patient9);
    	Department.NEUROLOGY.addPatient(patient9);

    	Patient patient10 = new Patient("Polansky", 1972, "Epilepsy", Department.NEUROLOGY, "Active");
    	hospital.addPatient(patient10);
    	Department.NEUROLOGY.addPatient(patient10);

    	Patient patient11 = new Patient("Steiman", 1998, "Concussion", Department.NEUROLOGY, "Active");
    	hospital.addPatient(patient11);
    	Department.NEUROLOGY.addPatient(patient11);
    }
}
