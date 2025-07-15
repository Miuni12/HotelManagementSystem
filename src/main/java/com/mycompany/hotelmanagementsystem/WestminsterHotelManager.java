// WestminsterHotelManager.java
package com.mycompany.hotelmanagementsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Implementation of HotelManager interface for Westminster Hotel
 * Manages hotel staff and guest operations
 */
public class WestminsterHotelManager implements HotelManager {

    // Instance variables
    private ArrayList<HotelStaff> hotelStaffList;
    private ArrayList<Guest> hotelGuestList;
    private int staffLimit;
    private Scanner scanner;

    /**
     * Constructor for WestminsterHotelManager
     * @param maxMembersNumber Maximum number of staff members allowed
     */
    public WestminsterHotelManager(int maxMembersNumber) {
        this.hotelStaffList = new ArrayList<>();
        this.hotelGuestList = new ArrayList<>();
        this.staffLimit = maxMembersNumber;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu and processes user selection
     * @return true if user chooses to exit, false otherwise
     */
    @Override
    public boolean runMenu() {
        boolean exit = false;

        System.out.println("\n========== HOTEL MANAGEMENT SYSTEM ==========");
        System.out.println("0. Save and Exit");
        System.out.println("1. Add New Staff Member");
        System.out.println("2. Print Staff List");
        System.out.println("3. Add Guest");
        System.out.println("4. Open GUI");
        System.out.println("5. Delete Staff Member");
        System.out.println("============================================");
        System.out.print("Enter your choice: ");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 0:
                    exit = true;
                    System.out.println("Exiting system...");
                    break;
                case 1:
                    addHotelStaff();
                    break;
                case 2:
                    printHotelStaffList();
                    break;
                case 3:
                    addGuest();
                    break;
                case 4:
                    runGUI();
                    break;
                case 5:
                    deleteHotelStaff();
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 0-5.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        }

        return exit;
    }

    /**
     * Adds a new hotel staff member based on user input
     */
    @Override
    public void addHotelStaff() {
        // Check if staff limit is reached
        if (hotelStaffList.size() >= staffLimit) {
            System.out.println("Cannot add more staff. Maximum limit of " + staffLimit + " reached.");
            return;
        }

        System.out.println("\n--- Add New Staff Member ---");
        System.out.println("1. Manager");
        System.out.println("2. Housekeeper");
        System.out.println("3. Chef");
        System.out.print("Select staff type: ");

        try {
            int staffType = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Get common staff information
            String firstName = getValidInput("Enter first name: ");
            String lastName = getValidInput("Enter last name: ");
            String staffID = getValidStaffID();
            LocalDate dateOfBirth = getValidDate();

            // Create staff based on type
            HotelStaff newStaff = null;
            switch (staffType) {
                case 1:
                    newStaff = createManager(firstName, lastName, staffID, dateOfBirth);
                    break;
                case 2:
                    newStaff = createHousekeeper(firstName, lastName, staffID, dateOfBirth);
                    break;
                case 3:
                    newStaff = createChef(firstName, lastName, staffID, dateOfBirth);
                    break;
                default:
                    System.out.println("Invalid staff type!");
                    return;
            }

            if (newStaff != null) {
                addStaffToList(newStaff);
                System.out.println("Staff member added successfully!");
            }
        } catch (Exception e) {
            System.out.println("Error adding staff member: " + e.getMessage());
            scanner.nextLine(); // Clear invalid input
        }
    }

    /**
     * Creates a new Manager object with specific details
     */
    private Manager createManager(String firstName, String lastName, String staffID, LocalDate dob) {
        String licenseNumber = getValidInput("Enter license number: ");

        Manager manager = new Manager(firstName, lastName);
        manager.setStaffID(staffID);
        manager.setDateOfBirth(dob);
        manager.setLicenseNumber(licenseNumber);

        return manager;
    }

    /**
     * Creates a new Housekeeper object with specific details
     */
    private HouseKeeper createHousekeeper(String firstName, String lastName, String staffID, LocalDate dob) {
        int experience = getValidIntInput("Enter years of experience: ");

        HouseKeeper housekeeper = new HouseKeeper(firstName, lastName);
        housekeeper.setStaffID(staffID);
        housekeeper.setDateOfBirth(dob);
        housekeeper.setYearsOfExperience(experience);

        return housekeeper;
    }

    /**
     * Creates a new Chef object with specific details
     */
    private Chef createChef(String firstName, String lastName, String staffID, LocalDate dob) {
        String speciality = getValidInput("Enter speciality (e.g., Italian, Chinese): ");
        int experience = getValidIntInput("Enter years of experience: ");

        Chef chef = new Chef(firstName, lastName);
        chef.setStaffID(staffID);
        chef.setDateOfBirth(dob);
        chef.setSpeciality(speciality);
        chef.setYearsOfExperience(experience);

        return chef;
    }

    /**
     * Adds a staff member to the staff list
     * @param staff The staff member to add
     */
    private void addStaffToList(HotelStaff staff) {
        if (hotelStaffList.size() < staffLimit) {
            hotelStaffList.add(staff);
        } else {
            System.out.println("Cannot add staff. Maximum limit reached.");
        }
    }

    /**
     * Prints the sorted list of all hotel staff members
     */
    @Override
    public void printHotelStaffList() {
        if (hotelStaffList.isEmpty()) {
            System.out.println("No staff members in the system.");
            return;
        }

        System.out.println("\n--- Hotel Staff List (Sorted by Date of Birth) ---");
        Collections.sort(hotelStaffList);

        for (int i = 0; i < hotelStaffList.size(); i++) {
            System.out.println((i + 1) + ". " + hotelStaffList.get(i).toString());
        }
        System.out.println("Total staff members: " + hotelStaffList.size());
    }

    /**
     * Deletes a hotel staff member based on staff ID
     */
    @Override
    public void deleteHotelStaff() {
        if (hotelStaffList.isEmpty()) {
            System.out.println("No staff members to delete.");
            return;
        }

        System.out.print("Enter staff ID to delete: ");
        String staffID = scanner.nextLine().trim();

        HotelStaff foundStaff = findStaffById(staffID);

        if (foundStaff != null) {
            System.out.println("\nStaff member found:");
            System.out.println("Name: " + foundStaff.getName() + " " + foundStaff.getSurname());
            System.out.println("Type: " + getStaffType(foundStaff));

            System.out.print("Are you sure you want to delete this staff member? (y/n): ");
            String confirmation = scanner.nextLine().trim().toLowerCase();

            if (confirmation.equals("y") || confirmation.equals("yes")) {
                hotelStaffList.remove(foundStaff);
                System.out.println("Staff member deleted successfully!");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Staff member with ID '" + staffID + "' not found.");
        }
    }

    /**
     * Finds a staff member by their ID
     * @param staffID The ID to search for
     * @return The found staff member or null if not found
     */
    private HotelStaff findStaffById(String staffID) {
        for (HotelStaff staff : hotelStaffList) {
            if (staff.getStaffID().equals(staffID)) {
                return staff;
            }
        }
        return null;
    }

    /**
     * Gets the type of staff member as a string
     * @param staff The staff member
     * @return The staff type as a string
     */
    private String getStaffType(HotelStaff staff) {
        if (staff instanceof Manager) {
            return "Manager";
        } else if (staff instanceof HouseKeeper) {
            return "Housekeeper";
        } else if (staff instanceof Chef) {
            return "Chef";
        }
        return "Unknown";
    }

    /**
     * Adds a new guest to the hotel system
     */
    @Override
    public void addGuest() {
        System.out.println("\n--- Add New Guest ---");

        String firstName = getValidInput("Enter guest first name: ");
        String lastName = getValidInput("Enter guest last name: ");
        int roomNumber = getValidIntInput("Enter room number: ");
        int nightsStayed = getValidIntInput("Enter number of nights stayed: ");

        Guest guest = new Guest(firstName, lastName);
        guest.setRoomNumber(roomNumber);
        guest.setNightsStayed(nightsStayed);

        hotelGuestList.add(guest);
        System.out.println("Guest added successfully!");
    }

    /**
     * Launches the graphical user interface
     */
    @Override
    public void runGUI() {
        try {
            HotelTableGUI gui = new HotelTableGUI(hotelStaffList);
            gui.setVisible(true);
            System.out.println("GUI launched successfully!");
        } catch (Exception e) {
            System.out.println("Error launching GUI: " + e.getMessage());
        }
    }

    // Helper methods for input validation

    /**
     * Gets valid non-empty string input from user
     * @param prompt The prompt message
     * @return Valid string input
     */
    private String getValidInput(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
            }
        } while (input.isEmpty());
        return input;
    }

    /**
     * Gets valid integer input from user
     * @param prompt The prompt message
     * @return Valid integer input
     */
    private int getValidIntInput(String prompt) {
        int input;
        while (true) {
            try {
                System.out.print(prompt);
                input = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (input < 0) {
                    System.out.println("Please enter a non-negative number.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        return input;
    }

    /**
     * Gets valid staff ID (checks for uniqueness)
     * @return Valid unique staff ID
     */
    private String getValidStaffID() {
        String staffID;
        do {
            staffID = getValidInput("Enter staff ID: ");
            if (findStaffById(staffID) != null) {
                System.out.println("Staff ID already exists. Please enter a unique ID.");
            }
        } while (findStaffById(staffID) != null);
        return staffID;
    }

    /**
     * Gets valid date input from user
     * @return Valid LocalDate object
     */
    private LocalDate getValidDate() {
        LocalDate date = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (date == null) {
            System.out.print("Enter date of birth (dd/MM/yyyy): ");
            String dateString = scanner.nextLine().trim();

            try {
                date = LocalDate.parse(dateString, formatter);

                // Check if date is not in the future
                if (date.isAfter(LocalDate.now())) {
                    System.out.println("Date cannot be in the future. Please enter a valid date.");
                    date = null;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use dd/MM/yyyy format.");
            }
        }

        return date;
    }
}