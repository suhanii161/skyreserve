package com.skyreserve.ui.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

public class DesignToken {
    
    // Colors
    public static final Color COLOR_PRIMARY = Color.decode("#0d47a1"); // Deep blue
    public static final Color COLOR_SECONDARY = Color.decode("#64b5f6"); // Light blue
    public static final Color COLOR_BACKGROUND = Color.decode("#f4f7f9");
    public static final Color COLOR_SURFACE = Color.decode("#ffffff");
    public static final Color COLOR_BORDER = Color.decode("#e0e0e0");
    public static final Color COLOR_TEXT_PRIMARY = Color.decode("#212121");
    public static final Color COLOR_TEXT_SECONDARY = Color.decode("#757575");
    
    // Status Colors
    public static final Color COLOR_SUCCESS = Color.decode("#4caf50");
    public static final Color COLOR_WARNING = Color.decode("#ff9800");
    public static final Color COLOR_ERROR = Color.decode("#f44336");
    public static final Color COLOR_INFO = Color.decode("#2196f3");
    
    // Typography
    public static final Font FONT_H1 = new Font("Segoe UI", Font.BOLD, 28);
    public static final Font FONT_H2 = new Font("Segoe UI", Font.BOLD, 22);
    public static final Font FONT_H3 = new Font("Segoe UI", Font.BOLD, 18);
    public static final Font FONT_BODY = new Font("Segoe UI", Font.PLAIN, 14);
    public static final Font FONT_BODY_BOLD = new Font("Segoe UI", Font.BOLD, 14);
    public static final Font FONT_SMALL = new Font("Segoe UI", Font.PLAIN, 12);
    
    // Spacing
    public static final int SPACING_SMALL = 8;
    public static final int SPACING_MEDIUM = 16;
    public static final int SPACING_LARGE = 24;
    
    // Borders & Margins
    public static final int CORNER_RADIUS = 8;
    public static final Insets PADDING_STANDARD = new Insets(16, 16, 16, 16);
    public static final Insets PADDING_SMALL = new Insets(8, 8, 8, 8);
}
