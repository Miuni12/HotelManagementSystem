// Guest.java
package com.mycompany.hotelmanagementsystem;

/**
 * Guest class representing a hotel guest
 * Contains guest information and room details
 */
public class Guest {

    private String name;
    private String surname;
    private int roomNumber;
    private int nightsStayed;

    /**
     * Constructor for Guest
     * @param name First name
     * @param surname Last name
     */
    public Guest(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.roomNumber = 0;
        this.nightsStayed = 0;
    }

    /**
     * Sets the room number
     * @param roomNumber The room number
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Sets the number of nights stayed
     * @param nightsStayed Number of nights stayed
     */
    public void setNightsStayed(int nightsStayed) {
        this.nightsStayed = nightsStayed;
    }

    /**
     * Gets the room number
     * @return The room number
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Gets the number of nights stayed
     * @return Number of nights stayed
     */
    public int getNightsStayed() {
        return nightsStayed;
    }

    /**
     * Gets the guest's first name
     * @return The first name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the guest's surname
     * @return The surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Returns a string representation of the guest
     * @return String representation
     */
    @Override
    public String toString() {
        return name + " " + surname + " - Room number: " + roomNumber +
                ", Nights stayed: " + nightsStayed;
    }
}