package com.skyreserve.main;

import com.formdev.flatlaf.FlatLightLaf;
import com.skyreserve.ui.MainFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Font;

public class SkyReserveApplication {

    public static void main(String[] args) {
        setupDesignSystem();

        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }

    private static void setupDesignSystem() {
        try {
            // Use FlatLaf Light as the base theme
            UIManager.setLookAndFeel(new FlatLightLaf());

            // Global UI overrides to match Premium Airline theme
            // Typography (Inter, Roboto, Segoe UI based)
            Font baseFont = new Font("Segoe UI", Font.PLAIN, 14);
            UIManager.put("defaultFont", baseFont);
            
            // Colors
            UIManager.put("Component.accentColor", "#0d47a1"); // Deep blue
            UIManager.put("Component.focusColor", "#64b5f6");  // Light blue focus
            UIManager.put("Button.arc", 8);
            UIManager.put("Component.arc", 8);
            UIManager.put("ProgressBar.arc", 8);
            UIManager.put("TextComponent.arc", 8);

            // Button specific
            UIManager.put("Button.background", "#ffffff");
            UIManager.put("Button.foreground", "#0d47a1");
            UIManager.put("Button.focusedBorderColor", "#0d47a1");
            UIManager.put("Button.hoverBackground", "#f5f5f5");

            // Panel
            UIManager.put("Panel.background", "#f4f7f9"); // Very light blue/grey workspace
            
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
    }
}
