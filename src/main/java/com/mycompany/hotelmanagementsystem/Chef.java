// Chef.java
package com.mycompany.hotelmanagementsystem;

public class Chef extends HotelStaff {

    private String speciality;
    private int yearsOfExperience;

    /**
     * Constructor for Chef
     * @param name First name
     * @param surname Last name
     */
    public Chef(String name, String surname) {
        super(name, surname);
    }

    /**
     * Sets the speciality
     * @param speciality The chef's speciality
     */
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    /**
     * Sets the years of experience
     * @param yearsOfExperience Years of experience
     */
    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    /**
     * Gets the speciality
     * @return The chef's speciality
     */
    public String getSpeciality() {
        return speciality;
    }

    /**
     * Gets the years of experience
     * @return Years of experience
     */
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    /**
     * Returns a string representation of the chef
     * @return String representation
     */
    @Override
    public String toString() {
        return super.toString() + "Chef - Speciality: " + speciality +
                ", Years of Experience: " + yearsOfExperience;
    }
}