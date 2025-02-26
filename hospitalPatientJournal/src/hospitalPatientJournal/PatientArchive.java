package hospitalPatientJournal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for managing the archiving of recovered patients.
 */
public class PatientArchive {

    // Path to the archive CSV file on the user's system
    private static final String ARCHIVE_CSV_FILE = System.getProperty("user.home") + "/Documents/hospital/archived_patients.csv";

    // Ensure the archive folder and file exist
    static {
        File directory = new File(System.getProperty("user.home") + "/Documents/hospital");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File archiveFile = new File(ARCHIVE_CSV_FILE);
        if (!archiveFile.exists()) {
            try {
                archiveFile.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating archive CSV file: " + e.getMessage());
            }
        }
    }

    /**
     * Archives a single patient if their status is "Recovered".
     */
    public static void archivePatient(Patient patient) {
        System.out.println("Attempting to archive patient: " + patient.getFamilyName());
        // Call archivePatients to add the patient to the archive
        archivePatients(List.of(patient));
    }

    /**
     * Archives a list of patients if their status is "Recovered".
     */
    public static void archivePatients(List<Patient> patients) {
        // Load the existing archived patients from the file
        List<Patient> archivedPatients = loadArchivedPatients();
        boolean isUpdated = false;

        // Iterate over the patients and archive only those with status "Recovered"
        for (Patient patient : patients) {
            System.out.println("Checking patient for archiving: " + patient.getFamilyName() + " (ID: " + patient.getId() + ")");
            if ("Recovered".equalsIgnoreCase(patient.getStatus()) &&
                    archivedPatients.stream().noneMatch(p -> p.getId() == patient.getId())) {
                archivedPatients.add(patient);
                System.out.println("Patient " + patient.getFamilyName() + " (ID: " + patient.getId() + ") has been archived.");
                isUpdated = true;
            }
        }

        // Save the updated list of archived patients to the CSV file
        if (isUpdated) {
            System.out.println("Saving updated list of archived patients...");
            saveArchivedPatientsToCSV(archivedPatients);
        } else {
            System.out.println("No new patients were archived.");
        }
    }

    /**
     * Loads the list of archived patients from the CSV file.
     */
    public static List<Patient> loadArchivedPatients() {
        System.out.println("Loading archived patients from file...");
        List<Patient> archivedPatients = new ArrayList<>();
        File file = new File(ARCHIVE_CSV_FILE);

        // If the archived patients file doesn't exist, return an empty list
        if (!file.exists()) {
            System.out.println("Archive file not found, returning empty list.");
            return archivedPatients;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            // Read each line and convert it to a Patient object
            while ((line = reader.readLine()) != null) {
                archivedPatients.add(Patient.fromCSV(line));  // Parse the CSV line into a Patient object
            }
        } catch (IOException e) {
            System.out.println("Error loading archived patients from CSV: " + e.getMessage());
        }

        System.out.println("Loaded " + archivedPatients.size() + " archived patients.");
        return archivedPatients;
    }

    /**
     * Saves the list of archived patients to the CSV file.
     */
    private static void saveArchivedPatientsToCSV(List<Patient> patients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVE_CSV_FILE))) {
            for (Patient patient : patients) {
                writer.write(patient.toCSV() + "\n");  // Assuming you have a toCSV method in the Patient class
            }
            System.out.println("Archived patients saved to CSV.");
        } catch (IOException e) {
            System.out.println("Error saving archived patients to CSV: " + e.getMessage());
        }
    }

    /**
     * Displays all archived patients.
     */
    public static void displayArchivedPatients() {
        List<Patient> archivedPatients = loadArchivedPatients();
        if (archivedPatients.isEmpty()) {
            System.out.println("No archived patients.");
        } else {
            System.out.println("Archived patients:");
            for (Patient patient : archivedPatients) {
                patient.displayPatientInfo(); // Assuming displayPatientInfo is defined in Patient class
            }
        }
    }

    /**
     * Deletes a patient from the archive.
     */
    public static void deletePatientFromArchive(Patient patient) {
        List<Patient> archivedPatients = loadArchivedPatients();
        archivedPatients.removeIf(p -> p.getId() == patient.getId());

        // Save the updated list of archived patients after deletion
        saveArchivedPatientsToCSV(archivedPatients);
        System.out.println("Patient " + patient.getFamilyName() + " has been removed from the archive.");
    }

    /**
     * Checks if a patient is already archived.
     */
    public static boolean isPatientArchived(Patient patient) {
        List<Patient> archivedPatients = loadArchivedPatients();
        return archivedPatients.stream().anyMatch(p -> p.getId() == patient.getId());
    }
}
