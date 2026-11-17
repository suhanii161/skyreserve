package com.skyreserve.ui.panels.customer;

import com.skyreserve.models.Flight;
import com.skyreserve.ui.components.DesignToken;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class FareOptimizerPanel extends JPanel {
    
    public FareOptimizerPanel(Flight currentSelection, Consumer<Flight> onContinue) {
        setLayout(new BorderLayout());
        setBackground(DesignToken.COLOR_BACKGROUND);

        JPanel content = new JPanel(new MigLayout("insets 40, wrap 2", "[grow][grow]", "[fill]"));
        content.setOpaque(false);
        
        // Header
        JPanel header = new JPanel(new MigLayout("insets 0", "[]", "[]10[]"));
        header.setOpaque(false);
        JLabel title = new JLabel("Smart Fare & Travel Optimizer");
        title.setFont(DesignToken.FONT_H1);
        title.setIcon(UIManager.getIcon("OptionPane.informationIcon")); // simple mock icon
        JLabel subtitle = new JLabel("Find better options and save more on your travel.");
        subtitle.setForeground(DesignToken.COLOR_TEXT_SECONDARY);
        header.add(title, "wrap");
        header.add(subtitle);
        content.add(header, "span 2, wrap");
        
        // Left - Current Selection
        JPanel currentPanel = new JPanel(new MigLayout("wrap 1, insets 30", "[grow]", "[]10[]10[]"));
        currentPanel.setBackground(DesignToken.COLOR_SURFACE);
        currentPanel.setBorder(BorderFactory.createLineBorder(DesignToken.COLOR_ERROR, 2));
        currentPanel.putClientProperty("FlatLaf.style", "arc: 12");
        
        JLabel cTitle = new JLabel("Your selected flight");
        cTitle.setFont(DesignToken.FONT_BODY_BOLD);
        currentPanel.add(cTitle);
        
        currentPanel.add(new JLabel(currentSelection.getAirline().getName() + " " + currentSelection.getFlightNumber()));
        
        JLabel cPrice = new JLabel("₹" + (int)currentSelection.getBasePrice());
        cPrice.setFont(DesignToken.FONT_H1);
        cPrice.setForeground(DesignToken.COLOR_ERROR);
        currentPanel.add(cPrice);
        
        JLabel warning = new JLabel("There are smarter options available!");
        warning.setForeground(DesignToken.COLOR_ERROR);
        currentPanel.add(warning);
        
        // Potential savings
        currentPanel.add(new JSeparator(), "growx, gapy 20 20");
        JLabel sTitle = new JLabel("Potential Savings");
        currentPanel.add(sTitle);
        JLabel sValue = new JLabel("Up to ₹1,480");
        sValue.setFont(DesignToken.FONT_H1);
        sValue.setForeground(DesignToken.COLOR_SUCCESS);
        currentPanel.add(sValue);
        
        JButton keepBtn = new JButton("Keep Current Selection");
        keepBtn.addActionListener(e -> onContinue.accept(currentSelection));
        currentPanel.add(keepBtn, "growx, h 40!, gapy 20");
        
        content.add(currentPanel, "grow, w 400!");
        
        // Right - Alternatives
        JPanel altPanel = new JPanel(new MigLayout("wrap 1, insets 0", "[grow]", "[]15[]15[]"));
        altPanel.setOpaque(false);
        
        // Tabs
        JPanel tabs = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        tabs.setOpaque(false);
        JButton t1 = new JButton("Cheaper Options");
        t1.setBackground(DesignToken.COLOR_PRIMARY);
        t1.setForeground(Color.WHITE);
        JButton t2 = new JButton("Flexible Dates");
        JButton t3 = new JButton("Round Trip Savings");
        tabs.add(t1); tabs.add(t2); tabs.add(t3);
        altPanel.add(tabs, "growx");
        
        // Mock Alternatives
        altPanel.add(createAltCard("Alternative Flight", "SpiceJet SG-312", "Similar timing • Non-stop", 4980, (int)currentSelection.getBasePrice() - 4980, currentSelection, onContinue), "growx");
        altPanel.add(createAltCard("Different Departure (2 hours later)", "IndiGo 6E-502", "Same airline • Same duration", 4200, (int)currentSelection.getBasePrice() - 4200, currentSelection, onContinue), "growx");
        
        content.add(altPanel, "grow");
        
        add(content, BorderLayout.CENTER);
    }
    
    private JPanel createAltCard(String type, String details, String sub, int price, int savings, Flight original, Consumer<Flight> onContinue) {
        JPanel card = new JPanel(new MigLayout("fillx", "[][grow][][]", "[]5[]"));
        card.setBackground(DesignToken.COLOR_SURFACE);
        card.setBorder(BorderFactory.createLineBorder(DesignToken.COLOR_BORDER, 1));
        card.putClientProperty("FlatLaf.style", "arc: 12");
        
        JLabel t = new JLabel(type);
        t.setFont(DesignToken.FONT_BODY_BOLD);
        JLabel d = new JLabel(details);
        JLabel s = new JLabel(sub);
        s.setForeground(DesignToken.COLOR_TEXT_SECONDARY);
        
        JPanel info = new JPanel(new GridLayout(3, 1));
        info.setOpaque(false);
        info.add(t); info.add(d); info.add(s);
        
        JLabel p = new JLabel("₹" + price);
        p.setFont(DesignToken.FONT_H2);
        
        JLabel save = new JLabel("Save ₹" + savings);
        save.setForeground(DesignToken.COLOR_SUCCESS);
        save.setFont(DesignToken.FONT_BODY_BOLD);
        save.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(DesignToken.COLOR_SUCCESS),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        
        JButton select = new JButton("Select");
        select.addActionListener(e -> {
            // For mock, we just reuse the original flight but pretend it was updated
            original.setBasePrice(price);
            onContinue.accept(original);
        });
        
        card.add(info, "growx");
        card.add(p);
        card.add(save);
        card.add(select);
        
        return card;
    }
}
