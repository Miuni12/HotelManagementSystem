// HotelManager.java
package com.mycompany.hotelmanagementsystem;

public interface HotelManager {

    /**
     * Displays the main menu and handles user input
     * @return true if user chooses to exit, false otherwise
     */
    boolean runMenu();

    /**
     * Adds a new hotel staff member to the system
     */
    void addHotelStaff();

    /**
     * Prints the list of all hotel staff members
     */
    void printHotelStaffList();

    /**
     * Adds a new guest to the hotel system
     */
    void addGuest();

    /**
     * Launches the graphical user interface
     */
    void runGUI();

    /**
     * Deletes a hotel staff member from the system
     */
    void deleteHotelStaff();
}