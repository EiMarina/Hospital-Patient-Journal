package hospitalPatientJournal;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for archiving recovered patients using File I/O and Serialization.
 */
public class PatientArchive {

    private static final String ARCHIVE_FILE = "archived_patients.dat";

    /**
     * Archives a recovered patient by saving them to the archive file.
     */
    public static void archivePatient(Patient patient) {
        List<Patient> archivedPatients = loadArchivedPatients();
        archivedPatients.add(patient);
        saveArchivedPatients(archivedPatients);
        System.out.println("Patient " + patient.getFamilyName() + " has been archived.");
    }

    /**
     * Loads the archived patients from the file.
     */
    public static List<Patient> loadArchivedPatients() {
        File file = new File(ARCHIVE_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Patient>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading archived patients: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * Saves the list of archived patients to the file.
     */
    private static void saveArchivedPatients(List<Patient> patients) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVE_FILE))) {
            oos.writeObject(patients);
        } catch (IOException e) {
            System.out.println("Error saving archived patients: " + e.getMessage());
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
                patient.displayPatientInfo();
            }
        }
    }
}
