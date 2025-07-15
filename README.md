🏨 Hotel Management System
📌 Overview
The Hotel Management System is a Java-based application that helps manage hotel staff and guest records efficiently using both console and Swing GUI interfaces. It is built with OOP principles, tested using JUnit, and follows a clean modular structure.

👤 Author Information
Name: Miuni Weerasinghe

Student ID: 20233015

Institution: University of Westminster

Coursework: Object-Oriented Programming (OOP-LAB)

🗂️ Project Structure
pgsql
Copy code
HotelManagementSystem/
├── .idea/                        ← IntelliJ config
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com.mycompany.hotelmanagementsystem/
│   │           ├── HotelManagementSystem.java
│   │           ├── WestminsterHotelManager.java
│   │           ├── HotelManager.java
│   │           ├── HotelStaff.java
│   │           ├── Manager.java
│   │           ├── HouseKeeper.java
│   │           ├── Chef.java
│   │           ├── Guest.java
│   │           ├── HotelTableGUI.java
│   │           └── HotelTableModel.java
│
│   └── test/
│       └── java/
│           └── com.mycompany.hotelmanagementsystem/
│               └── HotelManagementSystemTest.java   ← ✅ JUnit test class
│
├── target/                       ← Compiled classes & build outputs
├── pom.xml                       ← Maven configuration
⚙️ Features
✅ Core Functionality
Add / Delete / View Staff (Manager, Housekeeper, Chef)

Guest registration and room assignment

Staff sorting by date of birth

Graphical Staff Table GUI

Staff data persistence to .ser files

JUnit-based unit tests

👥 Staff Types
Type	Additional Attributes
Manager	License Number
Housekeeper	Years of Experience
Chef	Speciality, Years of Experience

🧪 Running & Testing
✅ Run App in IntelliJ
Right-click HotelManagementSystem.java

Choose Run 'HotelManagementSystem.main()'

✅ Run Tests in IntelliJ
Right-click on HotelManagementSystemTest.java (under src/test)

Select Run 'HotelManagementSystemTest'

✅ Make sure src/test/java is marked as Test Sources Root

🧪 Running Tests via Maven (CLI)
Make sure you have Maven installed and run:

bash
Copy code
# Run all tests
mvn test
🧠 Note: JUnit 5 (Jupiter) is used. See pom.xml for dependencies.

🖥️ Console Menu
text
Copy code
========== HOTEL MANAGEMENT SYSTEM ==========
0. Save and Exit
1. Add New Staff Member
2. Print Staff List
3. Add Guest
4. Open GUI
5. Delete Staff Member
   ============================================
   💾 Data Persistence
   Data is stored via Java Serialization to a .ser file

Stored in the project root as staff_data.ser

Can be triggered from the GUI Save button

📊 GUI Features
Java Swing-based staff table view

Columns: Staff ID, First Name, Last Name, DOB, Role, Details

Table is non-editable and auto-sorted

🔐 Input Validation & Error Handling
Validation Type	Description
Non-empty input	Names, IDs, Specialities, etc.
Unique Staff ID	No duplicate staff entries
Date validation	Valid format dd/MM/yyyy, no future dates
Non-negative numbers	Room numbers, Experience years
Robust exception handling	Covers file I/O, invalid input, GUI failures

🧪 Test Coverage (JUnit 5)
✅ Staff object creation and properties

✅ Guest attributes and room assignment

✅ toString methods and polymorphism

✅ Sorting logic via Comparable interface

✅ HotelTableModel data and GUI representation

✅ Edge cases (null dates, invalid room numbers, duplicates)

🔧 System Requirements
Requirement	Minimum
Java	JDK 8+
IDE	IntelliJ / Eclipse
RAM	512MB
Display	1024x768 (for GUI)

🔮 Future Improvements
Add a Database for persistent storage

Implement room booking & availability

Add billing and invoicing

Introduce admin login system

Export reports (PDF/CSV)

Build REST API or web version (Spring Boot)

📃 License & Notice
This project is developed for educational purposes as part of coursework under the University of Westminster.
Do not redistribute without permission from the author.

Last Updated: July 2025
Version: 1.0
Author: Miuni Weerasinghe