package com.skyreserve.ui;

import com.skyreserve.models.User;
import com.skyreserve.ui.components.AppHeader;
import com.skyreserve.ui.components.AppSidebar;
import com.skyreserve.ui.components.DesignToken;
import com.skyreserve.ui.panels.customer.CustomerBookingFlow;
import com.skyreserve.ui.panels.customer.CustomerDashboard;

import javax.swing.*;
import java.awt.*;

public class AppShell extends JPanel {

    private final JPanel contentArea;
    private final CardLayout cardLayout;
    private final User currentUser;

    public AppShell(User currentUser, Runnable onLogout) {
        this.currentUser = currentUser;
        setLayout(new BorderLayout());
        setBackground(DesignToken.COLOR_BACKGROUND);

        // Sidebar
        AppSidebar sidebar = new AppSidebar(currentUser.getRole(), this::navigate);
        add(sidebar, BorderLayout.WEST);

        // Right side container (Header + Content)
        JPanel rightContainer = new JPanel(new BorderLayout());
        
        // Header
        AppHeader header = new AppHeader(currentUser.getRole(), currentUser.getFullName());
        rightContainer.add(header, BorderLayout.NORTH);

        // Content Area with CardLayout
        cardLayout = new CardLayout();
        contentArea = new JPanel(cardLayout);
        contentArea.setBackground(DesignToken.COLOR_BACKGROUND);
        
        // Add placeholder panels for all navigation items
        initPlaceholders();
        
        rightContainer.add(contentArea, BorderLayout.CENTER);
        add(rightContainer, BorderLayout.CENTER);
        
        // Navigate to default view
        if (currentUser.getRole().equals("CUSTOMER")) {
            navigate("Home");
        } else {
            navigate("Dashboard");
        }
    }
    
    private void initPlaceholders() {
        if (currentUser.getRole().equals("CUSTOMER")) {
            contentArea.add(new CustomerDashboard(this::navigate), "Home");
            contentArea.add(new CustomerBookingFlow(currentUser), "Book Flight");
            contentArea.add(new com.skyreserve.ui.panels.customer.MyBookingsPanel(currentUser), "My Bookings");
            contentArea.add(createPlaceholder("Manage/Modify Booking"), "Manage Booking");
            contentArea.add(new com.skyreserve.ui.panels.customer.FlightStatusBoard(), "Flight Status");
            contentArea.add(createPlaceholder("Travel Deals & Offers"), "Travel Deals");
            contentArea.add(createPlaceholder("Loyalty Program Details"), "Loyalty Program");
            contentArea.add(createPlaceholder("User Profile"), "Profile");
            contentArea.add(createPlaceholder("Application Settings"), "Settings");
        } else {
            contentArea.add(new com.skyreserve.ui.panels.admin.AdminDashboard(), "Dashboard");
            
            // Flights mock data
            String[] fCols = {"Flight No", "Airline", "Origin", "Dest", "Dep Time", "Status", "Seats"};
            Object[][] fData = {
                {"6E-204", "IndiGo", "DEL", "BOM", "06:30", "On Time", "180/180"},
                {"UK-811", "Vistara", "BOM", "DEL", "08:15", "Delayed", "145/160"},
                {"AI-302", "Air India", "DEL", "BLR", "09:45", "On Time", "120/180"}
            };
            contentArea.add(new com.skyreserve.ui.panels.admin.GenericDataTablePanel("Flight Management", "Manage schedules, routes, and capacities.", fCols, fData), "Flights");
            
            // Bookings mock data
            String[] bCols = {"PNR", "Date", "Customer", "Flight", "Amount", "Status"};
            Object[][] bData = {
                {"AX7K92", "20 Sep", "Sarthak Sharma", "6E-204", "₹11,980", "Confirmed"},
                {"BW8M11", "20 Sep", "John Doe", "UK-811", "₹8,450", "Pending"},
                {"CZ4N55", "21 Sep", "Jane Smith", "AI-302", "₹12,200", "Cancelled"}
            };
            contentArea.add(new com.skyreserve.ui.panels.admin.GenericDataTablePanel("Booking Management", "View and manage all customer bookings.", bCols, bData), "Bookings");
            
            // Passengers mock data
            String[] pCols = {"ID", "Name", "Age", "Gender", "ID Type", "Flight PNR"};
            Object[][] pData = {
                {"P1001", "Sarthak Sharma", "28", "Male", "Passport", "AX7K92"},
                {"P1002", "John Doe", "34", "Male", "Aadhar", "BW8M11"},
                {"P1003", "Jane Smith", "25", "Female", "Passport", "CZ4N55"}
            };
            contentArea.add(new com.skyreserve.ui.panels.admin.GenericDataTablePanel("Passenger Directory", "Master list of all traveling passengers.", pCols, pData), "Passengers");
            
            contentArea.add(createPlaceholder("Revenue Overview"), "Revenue");
            contentArea.add(createPlaceholder("Analytics Charts"), "Analytics");
            contentArea.add(createPlaceholder("Generated Reports"), "Reports");
            contentArea.add(createPlaceholder("User Management"), "Users");
            contentArea.add(createPlaceholder("System Settings"), "Settings");
        }
    }
    
    private JPanel createPlaceholder(String title) {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(DesignToken.COLOR_BACKGROUND);
        JLabel l = new JLabel(title);
        l.setFont(DesignToken.FONT_H1);
        l.setForeground(DesignToken.COLOR_TEXT_SECONDARY);
        p.add(l);
        return p;
    }

    private void navigate(String destination) {
        if (destination.equals("Logout")) {
            // Handle logout by requesting the parent MainFrame to switch to Login
            Container parent = getParent();
            while (parent != null && !(parent instanceof MainFrame)) {
                parent = parent.getParent();
            }
            if (parent != null) {
                ((MainFrame) parent).showLogin();
            }
        } else {
            cardLayout.show(contentArea, destination);
        }
    }
}
