// HotelManagementSystem.java
package com.mycompany.hotelmanagementsystem;

/**
 * Main class for the Hotel Management System
 *
 * STUDENT DETAILS:
 * FIRST NAME: Miuni
 * LAST NAME: Weerasinghe
 * STUDENT ID: 20233015
 *
 * @author Miuni Weerasinghe
 */
public class HotelManagementSystem {

    public static void main(String[] args) {
        // Initialize hotel manager with capacity for 100 staff members
        HotelManager hotelManager = new WestminsterHotelManager(100);
        boolean exit = false;

        // Main program loop
        while (!exit) {
            exit = hotelManager.runMenu();
        }

        System.out.println("Thank you for using the Hotel Management System!");
    }
}