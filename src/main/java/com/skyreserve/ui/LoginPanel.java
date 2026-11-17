package com.skyreserve.ui;

import com.skyreserve.ui.components.DesignToken;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class LoginPanel extends JPanel {
    
    private final Consumer<String> onLoginSuccess;

    public LoginPanel(Consumer<String> onLoginSuccess) {
        this.onLoginSuccess = onLoginSuccess;
        setLayout(new BorderLayout());
        setBackground(DesignToken.COLOR_BACKGROUND);

        // Center card
        JPanel card = new JPanel(new MigLayout("wrap 1, insets 40, align center", "[grow, fill]", "[]20[]20[]10[]20[]"));
        card.setBackground(DesignToken.COLOR_SURFACE);
        card.setBorder(BorderFactory.createLineBorder(DesignToken.COLOR_BORDER, 1));
        card.putClientProperty("FlatLaf.style", "arc: 16");

        JLabel title = new JLabel("Welcome Back!");
        title.setFont(DesignToken.FONT_H1);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel subtitle = new JLabel("Sign in to continue");
        subtitle.setFont(DesignToken.FONT_BODY);
        subtitle.setForeground(DesignToken.COLOR_TEXT_SECONDARY);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);

        JTextField usernameField = new JTextField(20);
        usernameField.putClientProperty("JTextField.placeholderText", "Username");
        
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.putClientProperty("JTextField.placeholderText", "Password");

        JButton loginBtn = new JButton("Login");
        loginBtn.setBackground(DesignToken.COLOR_PRIMARY);
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFont(DesignToken.FONT_BODY_BOLD);
        
        // Mock authentication action
        loginBtn.addActionListener(e -> {
            String uname = usernameField.getText();
            String pwd = new String(passwordField.getPassword());
            
            // Very simple mock check
            if (uname.equals("admin") || uname.equals("staff") || uname.equals("customer")) {
                onLoginSuccess.accept(uname.toUpperCase()); // returning role directly for mock
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials. Use 'customer', 'staff', or 'admin'.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        // Quick login buttons for demo
        JPanel demoPanel = new JPanel(new MigLayout("wrap 1, insets 0", "[fill]", "[]10[]"));
        demoPanel.setOpaque(false);
        demoPanel.setBorder(BorderFactory.createTitledBorder("Demo Login"));
        
        JButton btnCust = new JButton("Login as Customer");
        btnCust.addActionListener(e -> onLoginSuccess.accept("CUSTOMER"));
        
        JButton btnStaff = new JButton("Login as Staff");
        btnStaff.addActionListener(e -> onLoginSuccess.accept("STAFF"));
        
        JButton btnAdmin = new JButton("Login as Admin");
        btnAdmin.addActionListener(e -> onLoginSuccess.accept("ADMIN"));
        
        demoPanel.add(btnCust);
        demoPanel.add(btnStaff);
        demoPanel.add(btnAdmin);

        card.add(title);
        card.add(subtitle);
        card.add(new JLabel("Username"));
        card.add(usernameField);
        card.add(new JLabel("Password"));
        card.add(passwordField);
        card.add(loginBtn, "h 40!");
        card.add(new JSeparator(), "growx, gapy 10 10");
        card.add(demoPanel);

        // Wrapping to center it in BorderLayout
        JPanel centerWrapper = new JPanel(new GridBagLayout());
        centerWrapper.setOpaque(false);
        centerWrapper.add(card);

        add(centerWrapper, BorderLayout.CENTER);
    }
}
