package com.skyreserve.ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    
    private CardLayout cardLayout;
    private JPanel mainContainer;

    public MainFrame() {
        setTitle("SkyReserve - Smart Airline Reservation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 900);
        setMinimumSize(new Dimension(1024, 768));
        setLocationRelativeTo(null); // Center on screen
        
        initUI();
    }
    
    private void initUI() {
        cardLayout = new CardLayout();
        mainContainer = new JPanel(cardLayout);
        
        // Add Login Panel
        LoginPanel loginPanel = new LoginPanel(this::onLoginSuccess);
        mainContainer.add(loginPanel, "LOGIN");
        
        add(mainContainer);
        showLogin();
    }
    
    public void showLogin() {
        cardLayout.show(mainContainer, "LOGIN");
    }
    
    private void onLoginSuccess(String role) {
        // Fetch mock user from repository based on role
        com.skyreserve.repositories.InMemoryUserRepository userRepo = new com.skyreserve.repositories.InMemoryUserRepository();
        String defaultUsername = role.toLowerCase();
        com.skyreserve.models.User user = userRepo.findByUsername(defaultUsername).orElse(
                new com.skyreserve.models.User(defaultUsername, "pass", role, "Default " + role)
        );
        
        AppShell shell = new AppShell(user, this::showLogin);
        
        // Add or replace the APP card
        mainContainer.add(shell, "APP");
        cardLayout.show(mainContainer, "APP");
    }
}
