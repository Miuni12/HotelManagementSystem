// Manager.java
package com.mycompany.hotelmanagementsystem;

public class Manager extends HotelStaff {

    private String licenseNumber;

    /**
     * Constructor for Manager
     * @param name First name
     * @param surname Last name
     */
    public Manager(String name, String surname) {
        super(name, surname);
    }

    /**
     * Sets the license number
     * @param licenseNumber The license number
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    /**
     * Gets the license number
     * @return The license number
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * Returns a string representation of the manager
     * @return String representation
     */
    @Override
    public String toString() {
        return super.toString() + "Manager - License number: " + licenseNumber;
    }
}