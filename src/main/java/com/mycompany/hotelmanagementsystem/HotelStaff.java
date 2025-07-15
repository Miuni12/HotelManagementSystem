// HotelStaff.java
package com.mycompany.hotelmanagementsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Abstract base class for all hotel staff members
 * Implements Comparable for sorting by date of birth
 */
public abstract class HotelStaff implements Comparable<HotelStaff> {

    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String staffID;

    /**
     * Constructor for HotelStaff
     * @param name First name of the staff member
     * @param surname Last name of the staff member
     */
    public HotelStaff(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    // Setter methods

    /**
     * Sets the first name of the staff member
     * @param name The first name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the surname of the staff member
     * @param surname The surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Sets the date of birth of the staff member
     * @param dateOfBirth The date of birth
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Sets the staff ID
     * @param staffID The staff ID
     */
    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    // Getter methods

    /**
     * Gets the first name of the staff member
     * @return The first name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the surname of the staff member
     * @return The surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Gets the date of birth of the staff member
     * @return The date of birth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Gets the staff ID
     * @return The staff ID
     */
    public String getStaffID() {
        return staffID;
    }

    /**
     * Gets the date of birth as a formatted string
     * @return The date of birth in dd/MM/yyyy format
     */
    public String getStringDate() {
        if (dateOfBirth != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return dateOfBirth.format(formatter);
        }
        return "N/A";
    }

    /**
     * Returns a string representation of the staff member
     * @return String representation
     */
    @Override
    public String toString() {
        return name + " " + surname + ", ID: " + staffID + ", DOB: " + getStringDate() + " - ";
    }

    /**
     * Compares staff members by date of birth for sorting
     * @param other The other staff member to compare with
     * @return Comparison result
     */
    @Override
    public int compareTo(HotelStaff other) {
        if (this.dateOfBirth == null && other.dateOfBirth == null) {
            return 0;
        }
        if (this.dateOfBirth == null) {
            return 1;
        }
        if (other.dateOfBirth == null) {
            return -1;
        }
        return this.dateOfBirth.compareTo(other.dateOfBirth);
    }
}