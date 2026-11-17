package com.skyreserve.ui.components;

import javax.swing.*;
import java.awt.*;

public class AppHeader extends JPanel {
    
    public AppHeader(String userRole, String userName) {
        setLayout(new BorderLayout());
        setBackground(DesignToken.COLOR_SURFACE);
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, DesignToken.COLOR_BORDER));
        setPreferredSize(new Dimension(0, 60));
        
        // Left side: Global Search
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, DesignToken.SPACING_MEDIUM, 15));
        searchPanel.setOpaque(false);
        JTextField searchField = new JTextField(30);
        searchField.putClientProperty("JTextField.placeholderText", "Search flights, destinations, or bookings...");
        searchField.putClientProperty("JComponent.roundRect", true);
        searchPanel.add(searchField);
        
        // Right side: Profile and Notifications
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, DesignToken.SPACING_MEDIUM, 15));
        rightPanel.setOpaque(false);
        
        JLabel notifications = new JLabel("Notifications");
        notifications.setFont(DesignToken.FONT_SMALL);
        
        JPanel profilePanel = new JPanel(new GridLayout(2, 1));
        profilePanel.setOpaque(false);
        JLabel nameLabel = new JLabel(userName);
        nameLabel.setFont(DesignToken.FONT_BODY_BOLD);
        JLabel roleLabel = new JLabel(userRole);
        roleLabel.setFont(DesignToken.FONT_SMALL);
        roleLabel.setForeground(DesignToken.COLOR_TEXT_SECONDARY);
        
        profilePanel.add(nameLabel);
        profilePanel.add(roleLabel);
        
        rightPanel.add(notifications);
        rightPanel.add(profilePanel);
        
        add(searchPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
    }
}
