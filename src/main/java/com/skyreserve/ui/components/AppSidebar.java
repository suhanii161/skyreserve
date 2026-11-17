package com.skyreserve.ui.components;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class AppSidebar extends JPanel {
    
    private final Consumer<String> onNavigate;
    
    public AppSidebar(String role, Consumer<String> onNavigate) {
        this.onNavigate = onNavigate;
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(DesignToken.COLOR_PRIMARY);
        setPreferredSize(new Dimension(240, 0));
        setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        
        // Logo
        JLabel logo = new JLabel("SkyReserve");
        logo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        logo.setForeground(Color.WHITE);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        add(logo);
        add(Box.createRigidArea(new Dimension(0, 30)));
        
        // Navigation Links
        if (role.equals("CUSTOMER")) {
            buildCustomerNav();
        } else if (role.equals("ADMIN") || role.equals("STAFF")) {
            buildAdminNav();
        }
        
        add(Box.createVerticalGlue());
        addNavButton("Logout");
    }
    
    private void buildCustomerNav() {
        addNavButton("Home");
        addNavButton("Book Flight");
        addNavButton("My Bookings");
        addNavButton("Manage Booking");
        addNavButton("Flight Status");
        addNavButton("Travel Deals");
        addNavButton("Loyalty Program");
        addNavButton("Profile");
        addNavButton("Settings");
    }
    
    private void buildAdminNav() {
        addNavButton("Dashboard");
        addNavButton("Flights");
        addNavButton("Bookings");
        addNavButton("Passengers");
        addNavButton("Revenue");
        addNavButton("Analytics");
        addNavButton("Reports");
        addNavButton("Users");
        addNavButton("Settings");
    }
    
    private void addNavButton(String text) {
        JButton btn = new JButton(text);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setMaximumSize(new Dimension(200, 40));
        btn.setBackground(DesignToken.COLOR_PRIMARY);
        btn.setForeground(Color.WHITE);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setMargin(new Insets(0, 20, 0, 0));
        
        // Simple hover effect
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(DesignToken.COLOR_SECONDARY);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(DesignToken.COLOR_PRIMARY);
            }
        });
        
        btn.addActionListener(e -> onNavigate.accept(text));
        
        add(btn);
        add(Box.createRigidArea(new Dimension(0, 5)));
    }
}
