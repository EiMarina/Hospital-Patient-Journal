# Hospital-Patient-Journal
This is a hospital patient journal management system. It allows users to manage and track patients in different hospital departments (such as Cardiology, Neurology, and Urology). The system supports adding, deleting, updating patient information, and searching for patients based on various criteria.
## Features
* Add a new patient: Users can add new patients to the system, including their details (name, birth year, diagnosis, department and status).
* Delete a patient: Users can remove patients from the system using their unique patient ID.
* Update patient status: Allows changing the patient's status (e.g., Active, Recovered).
* Search for a patient: Users can search for a patient by their last name (filtering if there are patients with the same last name), year of birth, or diagnosis.
* Print patients by department: Users can print a list of patients in a specific department (Cardiology, Neurology, or Urology).
## Install dependencies
* Java 11+
## How to Install the Programm
1. Clone the repository:
git clone  [(https://github.com/EiMarina/hospital-patient-journal.git)]
2. Navigate to the project directory:
cd [hospital-patient-journal]
3. Compile and run the project:
[javac Main.java
java Main]
## How to Run the Programm
Once the program starts, you'll see a menu with the following options:
* 1. Add a new patient
* 2. Delete a patient
* 3. Update a patient's status
* 4. Search for a patient
* 5. Print all patients in a department
* 0. Exit the program
### Adding a New Patient
When you select option 1, you'll be asked to provide the following information:
  * Last Name: Enter the patient's last name.
  * Birth Year: Enter the patient's year of birth.
  * Diagnosis: Provide a diagnosis for the patient.
  * Department: Choose a department (Cardiology, Neurology, or Urology).
  * Status: Enter the patient's current status (e.g., Active, Recovered, etc.).
### Deleting a Patient
Option 2 allows you to delete a patient by entering their unique patient ID.
### Updating Patient Status
With option 3, you can update the patient's status (e.g., from Active to Recovered).
### Searching for Patients
Option 4 allows you to search for a patient by their:
  * Last name (with option filtering by year of birth)
  * Year of birth
  * Diagnosis
### Printing all the Patients of the Chosen Department
With option 5, you can print the list of all patients from one of the following departments:
  * Cardiology
  * Neurology
  * Urology
## Acknowledgements
  * Developers: Marina Eidelman, Katerina Fedorenko
