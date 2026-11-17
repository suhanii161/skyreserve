package com.skyreserve.ui.panels.customer;

import com.skyreserve.models.Booking;
import com.skyreserve.ui.components.DesignToken;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class PaymentPanel extends JPanel {
    
    private final Consumer<Booking> onPaymentSuccess;
    private final Booking booking;

    public PaymentPanel(Booking booking, Consumer<Booking> onPaymentSuccess) {
        this.booking = booking;
        this.onPaymentSuccess = onPaymentSuccess;
        
        setLayout(new BorderLayout());
        setBackground(DesignToken.COLOR_BACKGROUND);

        JPanel content = new JPanel(new MigLayout("insets 40, wrap 2", "[grow][400!]", "[fill]"));
        content.setOpaque(false);
        
        // Header
        JPanel header = new JPanel(new MigLayout("insets 0", "[]", "[]10[]"));
        header.setOpaque(false);
        JLabel title = new JLabel("Payment");
        title.setFont(DesignToken.FONT_H1);
        header.add(title, "wrap");
        content.add(header, "span 2, wrap");
        
        // Left - Summary
        JPanel summaryPanel = new JPanel(new MigLayout("wrap 1, insets 30", "[grow]", "[]10[]"));
        summaryPanel.setBackground(DesignToken.COLOR_SURFACE);
        summaryPanel.setBorder(BorderFactory.createLineBorder(DesignToken.COLOR_BORDER));
        summaryPanel.putClientProperty("FlatLaf.style", "arc: 12");
        
        JLabel sTitle = new JLabel("Booking Summary");
        sTitle.setFont(DesignToken.FONT_BODY_BOLD);
        summaryPanel.add(sTitle);
        
        summaryPanel.add(new JLabel("Flight: " + booking.getFlight().getFlightNumber()));
        summaryPanel.add(new JLabel("Route: " + booking.getFlight().getOrigin().getCode() + " -> " + booking.getFlight().getDestination().getCode()));
        
        if (!booking.getPassengers().isEmpty()) {
            summaryPanel.add(new JLabel("Passenger: " + booking.getPassengers().get(0).getFullName()));
            if(booking.getPassengers().get(0).getSelectedSeat() != null) {
                summaryPanel.add(new JLabel("Seat: " + booking.getPassengers().get(0).getSelectedSeat().getSeatNumber()));
            }
        }
        
        summaryPanel.add(new JSeparator(), "growx, gapy 10 10");
        
        // Base fare calculation logic is mocked here
        double base = booking.getFlight().getBasePrice();
        double seatPrice = booking.getPassengers().isEmpty() || booking.getPassengers().get(0).getSelectedSeat() == null ? 0 : booking.getPassengers().get(0).getSelectedSeat().getPrice();
        double extras = 0;
        if (!booking.getPassengers().isEmpty() && booking.getPassengers().get(0).isExtraBaggage()) extras += 800;
        if (!booking.getPassengers().isEmpty() && booking.getPassengers().get(0).getMealPreference().contains("+")) extras += 350;
        
        double total = base + seatPrice + extras;
        booking.setTotalAmount(total); // Set the calculated total
        
        summaryPanel.add(new JLabel(String.format("Base Fare: ₹%.2f", base)));
        summaryPanel.add(new JLabel(String.format("Seat Selection: ₹%.2f", seatPrice)));
        summaryPanel.add(new JLabel(String.format("Extras: ₹%.2f", extras)));
        
        summaryPanel.add(new JSeparator(), "growx, gapy 10 10");
        
        JLabel totalLabel = new JLabel(String.format("Total Amount: ₹%.2f", total));
        totalLabel.setFont(DesignToken.FONT_H2);
        totalLabel.setForeground(DesignToken.COLOR_PRIMARY);
        summaryPanel.add(totalLabel);
        
        content.add(summaryPanel, "grow");
        
        // Right - Payment Mock
        JPanel payPanel = new JPanel(new MigLayout("wrap 1, insets 30", "[grow]", "[]15[]10[]"));
        payPanel.setBackground(DesignToken.COLOR_SURFACE);
        payPanel.setBorder(BorderFactory.createLineBorder(DesignToken.COLOR_BORDER));
        payPanel.putClientProperty("FlatLaf.style", "arc: 12");
        
        JLabel pTitle = new JLabel("Payment Method");
        pTitle.setFont(DesignToken.FONT_BODY_BOLD);
        payPanel.add(pTitle);
        
        JComboBox<String> methodCombo = new JComboBox<>(new String[]{"Credit/Debit Card", "UPI", "Net Banking"});
        payPanel.add(methodCombo, "growx");
        
        payPanel.add(new JLabel("Card Number"));
        payPanel.add(new JTextField("**** **** **** 1234"), "growx");
        
        JPanel expiryCvv = new JPanel(new GridLayout(1, 4, 10, 0));
        expiryCvv.setOpaque(false);
        expiryCvv.add(new JLabel("Expiry"));
        expiryCvv.add(new JTextField("12/28"));
        expiryCvv.add(new JLabel("CVV"));
        expiryCvv.add(new JTextField("***"));
        payPanel.add(expiryCvv, "growx");
        
        payPanel.add(new JSeparator(), "growx, gapy 20 20");
        
        JButton payBtn = new JButton(String.format("Pay ₹%.2f", total));
        payBtn.setBackground(DesignToken.COLOR_SUCCESS);
        payBtn.setForeground(Color.WHITE);
        payBtn.setFont(DesignToken.FONT_BODY_BOLD);
        payBtn.addActionListener(e -> {
            booking.setStatus("Confirmed");
            booking.setPnr("AX7K" + (int)(Math.random() * 100)); // Generate mock PNR
            
            // In a real app we'd save to booking repository here.
            com.skyreserve.repositories.InMemoryBookingRepository repo = new com.skyreserve.repositories.InMemoryBookingRepository();
            repo.save(booking); // Save mock booking
            
            onPaymentSuccess.accept(booking);
        });
        payPanel.add(payBtn, "growx, h 50!");
        
        content.add(payPanel, "aligny top");
        
        add(content, BorderLayout.CENTER);
    }
}
