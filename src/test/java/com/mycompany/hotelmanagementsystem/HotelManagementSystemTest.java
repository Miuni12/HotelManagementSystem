package com.mycompany.hotelmanagementsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * JUnit test class for the Hotel Management System
 * Tests core functionality of staff management, guest management, and data validation
 *
 * @author Miuni Weerasinghe
 * @version 1.0
 */
public class HotelManagementSystemTest {

    private WestminsterHotelManager hotelManager;
    private Manager testManager;
    private HouseKeeper testHousekeeper;
    private Chef testChef;
    private Guest testGuest;

    /**
     * Set up test fixtures before each test
     */
    @BeforeEach
    public void setUp() {
        hotelManager = new WestminsterHotelManager(5); // Small limit for testing

        // Create test staff members
        testManager = new Manager("John", "Smith");
        testManager.setStaffID("M001");
        testManager.setDateOfBirth(LocalDate.of(1980, 5, 15));
        testManager.setLicenseNumber("LIC123456");

        testHousekeeper = new HouseKeeper("Jane", "Doe");
        testHousekeeper.setStaffID("H001");
        testHousekeeper.setDateOfBirth(LocalDate.of(1985, 8, 20));
        testHousekeeper.setYearsOfExperience(5);

        testChef = new Chef("Mario", "Rossi");
        testChef.setStaffID("C001");
        testChef.setDateOfBirth(LocalDate.of(1975, 12, 10));
        testChef.setSpeciality("Italian");
        testChef.setYearsOfExperience(15);

        testGuest = new Guest("Alice", "Johnson");
        testGuest.setRoomNumber(101);
        testGuest.setNightsStayed(3);
    }

    // ============ Manager Tests ============

    @Test
    @DisplayName("Test Manager Creation and Getters")
    public void testManagerCreation() {
        assertNotNull(testManager);
        assertEquals("John", testManager.getName());
        assertEquals("Smith", testManager.getSurname());
        assertEquals("M001", testManager.getStaffID());
        assertEquals("LIC123456", testManager.getLicenseNumber());
        assertEquals(LocalDate.of(1980, 5, 15), testManager.getDateOfBirth());
    }

    @Test
    @DisplayName("Test Manager License Number Setter")
    public void testManagerLicenseNumberSetter() {
        testManager.setLicenseNumber("NEW_LICENSE_789");
        assertEquals("NEW_LICENSE_789", testManager.getLicenseNumber());
    }

    @Test
    @DisplayName("Test Manager toString Method")
    public void testManagerToString() {
        String expected = "John Smith, ID: M001, DOB: 15/05/1980 - Manager - License number: LIC123456";
        assertEquals(expected, testManager.toString());
    }

    // ============ HouseKeeper Tests ============

    @Test
    @DisplayName("Test HouseKeeper Creation and Getters")
    public void testHousekeeperCreation() {
        assertNotNull(testHousekeeper);
        assertEquals("Jane", testHousekeeper.getName());
        assertEquals("Doe", testHousekeeper.getSurname());
        assertEquals("H001", testHousekeeper.getStaffID());
        assertEquals(5, testHousekeeper.getYearsOfExperience());
        assertEquals(LocalDate.of(1985, 8, 20), testHousekeeper.getDateOfBirth());
    }

    @Test
    @DisplayName("Test HouseKeeper Experience Setter")
    public void testHousekeeperExperienceSetter() {
        testHousekeeper.setYearsOfExperience(10);
        assertEquals(10, testHousekeeper.getYearsOfExperience());
    }

    @Test
    @DisplayName("Test HouseKeeper toString Method")
    public void testHousekeeperToString() {
        String expected = "Jane Doe, ID: H001, DOB: 20/08/1985 - Housekeeper - Years of Experience: 5";
        assertEquals(expected, testHousekeeper.toString());
    }

    // ============ Chef Tests ============

    @Test
    @DisplayName("Test Chef Creation and Getters")
    public void testChefCreation() {
        assertNotNull(testChef);
        assertEquals("Mario", testChef.getName());
        assertEquals("Rossi", testChef.getSurname());
        assertEquals("C001", testChef.getStaffID());
        assertEquals("Italian", testChef.getSpeciality());
        assertEquals(15, testChef.getYearsOfExperience());
        assertEquals(LocalDate.of(1975, 12, 10), testChef.getDateOfBirth());
    }

    @Test
    @DisplayName("Test Chef Speciality and Experience Setters")
    public void testChefSetters() {
        testChef.setSpeciality("French");
        testChef.setYearsOfExperience(20);

        assertEquals("French", testChef.getSpeciality());
        assertEquals(20, testChef.getYearsOfExperience());
    }

    @Test
    @DisplayName("Test Chef toString Method")
    public void testChefToString() {
        String expected = "Mario Rossi, ID: C001, DOB: 10/12/1975 - Chef - Speciality: Italian, Years of Experience: 15";
        assertEquals(expected, testChef.toString());
    }

    // ============ Guest Tests ============

    @Test
    @DisplayName("Test Guest Creation and Getters")
    public void testGuestCreation() {
        assertNotNull(testGuest);
        assertEquals("Alice", testGuest.getName());
        assertEquals("Johnson", testGuest.getSurname());
        assertEquals(101, testGuest.getRoomNumber());
        assertEquals(3, testGuest.getNightsStayed());
    }

    @Test
    @DisplayName("Test Guest Setters")
    public void testGuestSetters() {
        testGuest.setRoomNumber(205);
        testGuest.setNightsStayed(7);

        assertEquals(205, testGuest.getRoomNumber());
        assertEquals(7, testGuest.getNightsStayed());
    }

    @Test
    @DisplayName("Test Guest toString Method")
    public void testGuestToString() {
        String expected = "Alice Johnson - Room number: 101, Nights stayed: 3";
        assertEquals(expected, testGuest.toString());
    }

    // ============ HotelStaff Comparison Tests ============

    @Test
    @DisplayName("Test Staff Comparison by Date of Birth")
    public void testStaffComparison() {
        // testChef (1975) should come before testManager (1980)
        assertTrue(testChef.compareTo(testManager) < 0);

        // testManager (1980) should come before testHousekeeper (1985)
        assertTrue(testManager.compareTo(testHousekeeper) < 0);

        // testHousekeeper (1985) should come after testChef (1975)
        assertTrue(testHousekeeper.compareTo(testChef) > 0);
    }

    @Test
    @DisplayName("Test Staff Comparison with Null Dates")
    public void testStaffComparisonWithNullDates() {
        Manager managerWithNullDate = new Manager("Test", "User");
        managerWithNullDate.setStaffID("TEST");
        // dateOfBirth is null by default

        // Staff with null date should come after staff with valid date
        assertTrue(managerWithNullDate.compareTo(testManager) > 0);

        // Staff with valid date should come before staff with null date
        assertTrue(testManager.compareTo(managerWithNullDate) < 0);
    }

    // ============ Date Formatting Tests ============

    @Test
    @DisplayName("Test Date String Formatting")
    public void testDateStringFormatting() {
        assertEquals("15/05/1980", testManager.getStringDate());
        assertEquals("20/08/1985", testHousekeeper.getStringDate());
        assertEquals("10/12/1975", testChef.getStringDate());
    }

    @Test
    @DisplayName("Test Date String with Null Date")
    public void testDateStringWithNullDate() {
        Manager managerWithNullDate = new Manager("Test", "User");
        assertEquals("N/A", managerWithNullDate.getStringDate());
    }

    // ============ HotelTableModel Tests ============

    @Test
    @DisplayName("Test HotelTableModel Creation and Basic Operations")
    public void testHotelTableModel() {
        ArrayList<HotelStaff> staffList = new ArrayList<>();
        staffList.add(testManager);
        staffList.add(testHousekeeper);
        staffList.add(testChef);

        HotelTableModel tableModel = new HotelTableModel(staffList);

        // Test basic table properties
        assertEquals(3, tableModel.getRowCount());
        assertEquals(6, tableModel.getColumnCount());

        // Test column names
        assertEquals("Staff ID", tableModel.getColumnName(0));
        assertEquals("First Name", tableModel.getColumnName(1));
        assertEquals("Last Name", tableModel.getColumnName(2));
        assertEquals("Date of Birth", tableModel.getColumnName(3));
        assertEquals("Role", tableModel.getColumnName(4));
        assertEquals("Details", tableModel.getColumnName(5));
    }

    @Test
    @DisplayName("Test HotelTableModel Cell Values")
    public void testHotelTableModelCellValues() {
        ArrayList<HotelStaff> staffList = new ArrayList<>();
        staffList.add(testManager);

        HotelTableModel tableModel = new HotelTableModel(staffList);

        // Test manager row values
        assertEquals("M001", tableModel.getValueAt(0, 0)); // Staff ID
        assertEquals("John", tableModel.getValueAt(0, 1)); // First Name
        assertEquals("Smith", tableModel.getValueAt(0, 2)); // Last Name
        assertEquals("15/05/1980", tableModel.getValueAt(0, 3)); // Date of Birth
        assertEquals("Manager", tableModel.getValueAt(0, 4)); // Role
        assertEquals("License: LIC123456", tableModel.getValueAt(0, 5)); // Details
    }

    @Test
    @DisplayName("Test HotelTableModel Cell Editability")
    public void testHotelTableModelCellEditability() {
        ArrayList<HotelStaff> staffList = new ArrayList<>();
        staffList.add(testManager);

        HotelTableModel tableModel = new HotelTableModel(staffList);

        // All cells should be non-editable
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            for (int col = 0; col < tableModel.getColumnCount(); col++) {
                assertFalse(tableModel.isCellEditable(row, col));
            }
        }
    }

    // ============ Edge Case Tests ============

    @Test
    @DisplayName("Test Empty Staff List")
    public void testEmptyStaffList() {
        ArrayList<HotelStaff> emptyList = new ArrayList<>();
        HotelTableModel tableModel = new HotelTableModel(emptyList);

        assertEquals(0, tableModel.getRowCount());
        assertEquals(6, tableModel.getColumnCount());
    }

    @Test
    @DisplayName("Test Staff ID Uniqueness Validation")
    public void testStaffIDUniqueness() {
        // This would typically be tested through the WestminsterHotelManager
        // but we can test the basic concept
        Manager manager1 = new Manager("John", "Doe");
        Manager manager2 = new Manager("Jane", "Smith");

        manager1.setStaffID("SAME_ID");
        manager2.setStaffID("SAME_ID");

        assertEquals(manager1.getStaffID(), manager2.getStaffID());
        // In real implementation, the hotel manager should prevent duplicate IDs
    }

    @Test
    @DisplayName("Test Zero Experience Values")
    public void testZeroExperienceValues() {
        HouseKeeper newHousekeeper = new HouseKeeper("New", "Employee");
        newHousekeeper.setYearsOfExperience(0);

        Chef newChef = new Chef("New", "Chef");
        newChef.setYearsOfExperience(0);

        assertEquals(0, newHousekeeper.getYearsOfExperience());
        assertEquals(0, newChef.getYearsOfExperience());
    }

    @Test
    @DisplayName("Test Negative Room Numbers")
    public void testNegativeRoomNumbers() {
        Guest guest = new Guest("Test", "Guest");
        guest.setRoomNumber(-1);

        assertEquals(-1, guest.getRoomNumber());
        // Note: In a real application, validation should prevent negative room numbers
    }

    // ============ Staff Hierarchy Tests ============

    @Test
    @DisplayName("Test Staff Inheritance Hierarchy")
    public void testStaffInheritanceHierarchy() {
        assertTrue(testManager instanceof HotelStaff);
        assertTrue(testHousekeeper instanceof HotelStaff);
        assertTrue(testChef instanceof HotelStaff);

        assertTrue(testManager instanceof Manager);
        assertTrue(testHousekeeper instanceof HouseKeeper);
        assertTrue(testChef instanceof Chef);

        // Test polymorphism
        HotelStaff staffAsManager = testManager;
        HotelStaff staffAsHousekeeper = testHousekeeper;
        HotelStaff staffAsChef = testChef;

        assertEquals("John", staffAsManager.getName());
        assertEquals("Jane", staffAsHousekeeper.getName());
        assertEquals("Mario", staffAsChef.getName());
    }

    // ============ Integration Tests ============

    @Test
    @DisplayName("Test Staff List Sorting")
    public void testStaffListSorting() {
        ArrayList<HotelStaff> staffList = new ArrayList<>();
        staffList.add(testHousekeeper); // 1985
        staffList.add(testManager);     // 1980
        staffList.add(testChef);        // 1975

        // Sort by date of birth
        java.util.Collections.sort(staffList);

        // Should be sorted: Chef (1975), Manager (1980), Housekeeper (1985)
        assertEquals(testChef, staffList.get(0));
        assertEquals(testManager, staffList.get(1));
        assertEquals(testHousekeeper, staffList.get(2));
    }

    @Test
    @DisplayName("Test Table Model Update")
    public void testTableModelUpdate() {
        ArrayList<HotelStaff> initialList = new ArrayList<>();
        initialList.add(testManager);

        HotelTableModel tableModel = new HotelTableModel(initialList);
        assertEquals(1, tableModel.getRowCount());

        // Add more staff
        ArrayList<HotelStaff> updatedList = new ArrayList<>();
        updatedList.add(testManager);
        updatedList.add(testHousekeeper);
        updatedList.add(testChef);

        tableModel.updateData(updatedList);
        assertEquals(3, tableModel.getRowCount());
    }
}