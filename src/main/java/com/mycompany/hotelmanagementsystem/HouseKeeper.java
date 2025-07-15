// HouseKeeper.java
package com.mycompany.hotelmanagementsystem;


public class HouseKeeper extends HotelStaff {

    private int yearsOfExperience;

    /**
     * Constructor for HouseKeeper
     * @param name First name
     * @param surname Last name
     */
    public HouseKeeper(String name, String surname) {
        super(name, surname);
    }

    /**
     * Sets the years of experience
     * @param yearsOfExperience Years of experience
     */
    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    /**
     * Gets the years of experience
     * @return Years of experience
     */
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    /**
     * Returns a string representation of the housekeeper
     * @return String representation
     */
    @Override
    public String toString() {
        return super.toString() + "Housekeeper - Years of Experience: " + yearsOfExperience;
    }
}