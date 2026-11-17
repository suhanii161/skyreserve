package com.skyreserve.ui.panels.customer;

import com.github.lgooddatepicker.components.DatePicker;
import com.skyreserve.ui.components.DesignToken;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class FlightSearchForm extends JPanel {
    
    public FlightSearchForm(Consumer<String> onSearch) {
        setLayout(new BorderLayout());
        setOpaque(false);
        
        JPanel card = new JPanel(new MigLayout("wrap 4, insets 20", "[grow][grow][grow][grow]", "[]10[]10[]20[]"));
        card.setBackground(DesignToken.COLOR_SURFACE);
        card.setBorder(BorderFactory.createLineBorder(DesignToken.COLOR_BORDER, 1));
        card.putClientProperty("FlatLaf.style", "arc: 12");
        
        // Tabs simulation
        JPanel tabs = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        tabs.setOpaque(false);
        JLabel tab1 = new JLabel("One Way");
        tab1.setFont(DesignToken.FONT_BODY_BOLD);
        tab1.setForeground(DesignToken.COLOR_PRIMARY);
        
        JLabel tab2 = new JLabel("Round Trip");
        tab2.setForeground(DesignToken.COLOR_TEXT_SECONDARY);
        
        JLabel tab3 = new JLabel("Multi City");
        tab3.setForeground(DesignToken.COLOR_TEXT_SECONDARY);
        
        tabs.add(tab1);
        tabs.add(tab2);
        tabs.add(tab3);
        
        card.add(tabs, "span 4, growx, wrap");
        
        // Fields
        card.add(new JLabel("From"), "span 2");
        card.add(new JLabel("To"), "span 2");
        
        JComboBox<String> fromCombo = new JComboBox<>(new String[]{"Delhi (DEL)", "Mumbai (BOM)", "Bengaluru (BLR)", "Goa (GOA)", "Hyderabad (HYD)"});
        JComboBox<String> toCombo = new JComboBox<>(new String[]{"Mumbai (BOM)", "Delhi (DEL)", "Bengaluru (BLR)", "Goa (GOA)", "Hyderabad (HYD)"});
        card.add(fromCombo, "span 2, growx, h 35!");
        card.add(toCombo, "span 2, growx, h 35!");
        
        card.add(new JLabel("Departure"), "span 2");
        card.add(new JLabel("Return"), "span 2");
        
        DatePicker departurePicker = new DatePicker();
        DatePicker returnPicker = new DatePicker();
        card.add(departurePicker, "span 2, growx, h 35!");
        card.add(returnPicker, "span 2, growx, h 35!");
        
        card.add(new JLabel("Passengers"), "span 2");
        card.add(new JLabel("Class"), "span 2");
        
        JComboBox<String> paxCombo = new JComboBox<>(new String[]{"1 Adult", "2 Adults", "2 Adults, 1 Child"});
        JComboBox<String> classCombo = new JComboBox<>(new String[]{"Economy", "Premium Economy", "Business", "First"});
        
        card.add(paxCombo, "span 2, growx, h 35!");
        card.add(classCombo, "span 2, growx, h 35!");
        
        JButton searchBtn = new JButton("Search Flights");
        searchBtn.setBackground(DesignToken.COLOR_PRIMARY);
        searchBtn.setForeground(Color.WHITE);
        searchBtn.setFont(DesignToken.FONT_BODY_BOLD);
        searchBtn.addActionListener(e -> {
            // Mock validation
            if (departurePicker.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Please select a departure date.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            onSearch.accept(fromCombo.getSelectedItem() + "|" + toCombo.getSelectedItem());
        });
        
        card.add(searchBtn, "span 4, growx, h 40!");
        
        add(card, BorderLayout.CENTER);
    }
}
