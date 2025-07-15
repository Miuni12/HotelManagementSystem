// HotelTableModel.java
package com.mycompany.hotelmanagementsystem;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * Custom table model for displaying hotel staff data in JTable
 * Extends AbstractTableModel to provide data to JTable
 */
public class HotelTableModel extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {
            "Staff ID", "First Name", "Last Name", "Date of Birth", "Role", "Details"
    };

    private ArrayList<HotelStaff> staffList;

    /**
     * Constructor for HotelTableModel
     * @param staffList List of hotel staff to display
     */
    public HotelTableModel(ArrayList<HotelStaff> staffList) {
        this.staffList = staffList;
    }

    /**
     * Gets the number of rows in the table
     * @return Number of rows
     */
    @Override
    public int getRowCount() {
        return staffList.size();
    }

    /**
     * Gets the number of columns in the table
     * @return Number of columns
     */
    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    /**
     * Gets the value at a specific cell
     * @param rowIndex Row index
     * @param columnIndex Column index
     * @return Value at the specified cell
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        HotelStaff staff = staffList.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return staff.getStaffID();
            case 1:
                return staff.getName();
            case 2:
                return staff.getSurname();
            case 3:
                return staff.getStringDate();
            case 4:
                return getStaffRole(staff);
            case 5:
                return getStaffDetails(staff);
            default:
                return null;
        }
    }

    /**
     * Gets the column name for display
     * @param column Column index
     * @return Column name
     */
    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    /**
     * Gets the staff role as a string
     * @param staff Staff member
     * @return Role string
     */
    private String getStaffRole(HotelStaff staff) {
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
     * Gets specific details for each staff type
     * @param staff Staff member
     * @return Details string
     */
    private String getStaffDetails(HotelStaff staff) {
        if (staff instanceof Manager) {
            Manager manager = (Manager) staff;
            return "License: " + manager.getLicenseNumber();
        } else if (staff instanceof HouseKeeper) {
            HouseKeeper housekeeper = (HouseKeeper) staff;
            return "Experience: " + housekeeper.getYearsOfExperience() + " years";
        } else if (staff instanceof Chef) {
            Chef chef = (Chef) staff;
            return "Speciality: " + chef.getSpeciality() +
                    ", Experience: " + chef.getYearsOfExperience() + " years";
        }
        return "N/A";
    }

    /**
     * Determines if a cell is editable
     * @param row Row index
     * @param column Column index
     * @return false - all cells are non-editable
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    /**
     * Updates the table model with new data
     * @param newStaffList Updated staff list
     */
    public void updateData(ArrayList<HotelStaff> newStaffList) {
        this.staffList = newStaffList;
        fireTableDataChanged();
    }
}