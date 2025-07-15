// HotelTableGUI.java
package com.mycompany.hotelmanagementsystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * GUI class for displaying hotel staff in a table format
 * Provides functionality to save staff data to file
 */
public class HotelTableGUI extends JFrame {

    private JTable staffTable;
    private HotelTableModel tableModel;
    private ArrayList<HotelStaff> staffList;

    /**
     * Constructor for HotelTableGUI
     * @param staffList List of hotel staff to display
     */
    public HotelTableGUI(ArrayList<HotelStaff> staffList) {
        this.staffList = staffList;
        initializeGUI();
    }

    /**
     * Initializes the GUI components
     */
    private void initializeGUI() {
        setTitle("Hotel Staff Management System");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);

        // Create table model and table
        tableModel = new HotelTableModel(staffList);
        staffTable = new JTable(tableModel);

        // Enable sorting
        staffTable.setAutoCreateRowSorter(true);

        // Set table properties
        staffTable.setFillsViewportHeight(true);
        staffTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        // Create scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(staffTable);
        scrollPane.setPreferredSize(new Dimension(750, 500));

        // Create save button
        JButton saveButton = new JButton("Save Staff Data to File");
        saveButton.addActionListener(new SaveButtonListener());

        // Add components to frame
        add(scrollPane, BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);

        // Center the frame on screen
        setLocationRelativeTo(null);
    }

    /**
     * Saves staff data to a file using serialization
     */
    private void saveStaffToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("staff_data.ser"))) {
            oos.writeObject(staffList);
            JOptionPane.showMessageDialog(this,
                    "Staff data saved successfully to staff_data.ser",
                    "Save Successful",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error saving staff data: " + e.getMessage(),
                    "Save Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Inner class for handling save button events
     */
    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            saveStaffToFile();
        }
    }
}