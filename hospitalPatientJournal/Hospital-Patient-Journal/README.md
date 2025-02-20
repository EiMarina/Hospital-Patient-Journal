# Hospital-Patient-Journal
This is a hospital patient journal management system. It allows users to manage and track patients in different hospital departments (such as Cardiology, Neurology, and Urology). The system supports adding, deleting and searching for patients based on various criteria.

## Features
* Add a new patient: Users can add new patients to the system, including their details (name, birth year, diagnosis and department).
* Delete a patient: Users can remove patients from the system using their unique patient ID.
* Search for a patient: Users can search for a patient by their last name (filtering if there are patients with the same last name), year of birth, or diagnosis.
* Print patients by department: Users can print a list of patients in a specific department (Cardiology, Neurology, or Urology).

## Install dependencies
* Java 11+

## How to Install the Programm
1. Clone the repository:
```
git clone https://github.com/EiMarina/hospital-patient-journal.git
```
2. Navigate to the project directory:
```
cd hospital-patient-journal
```
3. Compile and run the project:
```
javac Main.java
java Main
```
## How to Run the Programm
Once the program starts, you'll see a menu with the following options:
1. Add a new patient
2. Delete a patient
3. Search for a patient
4. Print all patients in a department
5. Exit the program
   
### Adding a New Patient
When you select option 1, you'll be asked to provide the following information:
  * Last Name: Enter the patient's last name.
  * Birth Year: Enter the patient's year of birth.
  * Diagnosis: Provide a diagnosis for the patient.
  * Department: Choose a department (Cardiology, Neurology, or Urology).

```ruby
Enter the patient's last name: Ivanov
Enter the patient's birth year: 1999
Enter the patient's diagnosis: Kidney Stones
Choose the department (1 - Cardiology, 2 - Neurology, 3 - Urology): 3
The new patient will be added to the system and to the Urology department.
```

### Deleting a Patient
Option 2 allows you to delete a patient by entering their unique patient ID.

### Searching for Patients
Option 3 allows you to search for a patient by their:
  * Last name (with option filtering by year of birth)
  * Year of birth
  * Diagnosis
    
### Printing all the Patients of the Chosen Department
With option 4, you can print the list of all patients from one of the following departments:
  * Cardiology
  * Neurology
  * Urology
    
## Code Structure
### Main Class
The Main class contains the main menu logic and methods for interacting with the system, such as adding, deleting and searching for patients.

### Department Class
The Department class represents a hospital department, such as Cardiology, Neurology, and Urology. It contains a list of patients and methods for adding/removing patients and printing the list of patients in the department.

### Patient Class
The Patient class holds information about an individual patient, such as their name, birth year, diagnosis, and department.
## Acknowledgements
  * Developers: Marina Eidelman, Katerina Fedorenko
