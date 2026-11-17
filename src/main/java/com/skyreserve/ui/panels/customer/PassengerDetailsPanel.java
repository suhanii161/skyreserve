package com.skyreserve.ui.panels.customer;

import com.skyreserve.models.Passenger;
import com.skyreserve.ui.components.DesignToken;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class PassengerDetailsPanel extends JPanel {

    private final Consumer<Passenger> onSubmit;

    public PassengerDetailsPanel(Consumer<Passenger> onSubmit) {
        this.onSubmit = onSubmit;
        setLayout(new BorderLayout());
        setBackground(DesignToken.COLOR_BACKGROUND);

        JPanel content = new JPanel(new MigLayout("insets 40, wrap 2", "[grow][300!]", "[fill]"));
        content.setOpaque(false);
        
        // Header
        JPanel header = new JPanel(new MigLayout("insets 0", "[]", "[]10[]"));
        header.setOpaque(false);
        JLabel title = new JLabel("Passenger Details & Add-ons");
        title.setFont(DesignToken.FONT_H1);
        header.add(title, "wrap");
        content.add(header, "span 2, wrap");
        
        // Left - Passenger Form
        JPanel formPanel = new JPanel(new MigLayout("wrap 4, insets 20", "[][grow][][grow]", "[]15[]15[]"));
        formPanel.setBackground(DesignToken.COLOR_SURFACE);
        formPanel.setBorder(BorderFactory.createLineBorder(DesignToken.COLOR_BORDER));
        formPanel.putClientProperty("FlatLaf.style", "arc: 12");
        
        JLabel pTitle = new JLabel("Passenger 1 (Adult)");
        pTitle.setFont(DesignToken.FONT_BODY_BOLD);
        formPanel.add(pTitle, "span 4, wrap");
        
        formPanel.add(new JLabel("Title"));
        JComboBox<String> titleCombo = new JComboBox<>(new String[]{"Mr.", "Ms.", "Mrs."});
        formPanel.add(titleCombo, "growx");
        
        formPanel.add(new JLabel("Full Name"));
        JTextField nameField = new JTextField(20);
        formPanel.add(nameField, "growx, wrap");
        
        formPanel.add(new JLabel("Age"));
        JTextField ageField = new JTextField(5);
        formPanel.add(ageField, "growx");
        
        formPanel.add(new JLabel("Gender"));
        JComboBox<String> genderCombo = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        formPanel.add(genderCombo, "growx, wrap");
        
        formPanel.add(new JLabel("ID Type"));
        JComboBox<String> idCombo = new JComboBox<>(new String[]{"Passport", "Aadhar Card", "Driving License"});
        formPanel.add(idCombo, "growx");
        
        formPanel.add(new JLabel("ID Number"));
        JTextField idNumField = new JTextField();
        formPanel.add(idNumField, "growx, wrap");
        
        content.add(formPanel, "grow");
        
        // Right - Addons
        JPanel addonsPanel = new JPanel(new MigLayout("wrap 1, insets 20", "[grow]", "[]15[]10[]"));
        addonsPanel.setBackground(DesignToken.COLOR_SURFACE);
        addonsPanel.setBorder(BorderFactory.createLineBorder(DesignToken.COLOR_BORDER));
        addonsPanel.putClientProperty("FlatLaf.style", "arc: 12");
        
        JLabel aTitle = new JLabel("Add Extras");
        aTitle.setFont(DesignToken.FONT_BODY_BOLD);
        addonsPanel.add(aTitle);
        
        addonsPanel.add(new JLabel("Baggage"));
        JCheckBox baggage1 = new JCheckBox("Extra 5 kg (+₹800)");
        JCheckBox baggage2 = new JCheckBox("Extra 10 kg (+₹1,400)");
        addonsPanel.add(baggage1);
        addonsPanel.add(baggage2);
        
        addonsPanel.add(new JSeparator(), "growx, gapy 10 10");
        addonsPanel.add(new JLabel("Meals"));
        JComboBox<String> mealCombo = new JComboBox<>(new String[]{"Standard", "Vegetarian (+₹350)", "Non-Vegetarian (+₹400)"});
        addonsPanel.add(mealCombo, "growx");
        
        addonsPanel.add(new JSeparator(), "growx, gapy 10 10");
        JCheckBox priorityBoarding = new JCheckBox("Priority Boarding (+₹500)");
        addonsPanel.add(priorityBoarding);
        
        JButton continueBtn = new JButton("Continue to Payment");
        continueBtn.setBackground(DesignToken.COLOR_PRIMARY);
        continueBtn.setForeground(Color.WHITE);
        continueBtn.setFont(DesignToken.FONT_BODY_BOLD);
        continueBtn.addActionListener(e -> {
            if (nameField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter passenger name.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int age = 0;
            try { age = Integer.parseInt(ageField.getText()); } catch(Exception ex) {}
            
            Passenger p = new Passenger(
                    (String)titleCombo.getSelectedItem(),
                    nameField.getText(),
                    age,
                    (String)genderCombo.getSelectedItem()
            );
            p.setIdType((String)idCombo.getSelectedItem());
            p.setIdNumber(idNumField.getText());
            p.setExtraBaggage(baggage1.isSelected() || baggage2.isSelected());
            p.setMealPreference((String)mealCombo.getSelectedItem());
            
            onSubmit.accept(p);
        });
        
        addonsPanel.add(Box.createVerticalStrut(20));
        addonsPanel.add(continueBtn, "growx, h 45!");
        
        content.add(addonsPanel, "aligny top");
        
        add(content, BorderLayout.CENTER);
    }
}
