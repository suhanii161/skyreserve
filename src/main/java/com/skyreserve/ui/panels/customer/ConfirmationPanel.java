package com.skyreserve.ui.panels.customer;

import com.skyreserve.models.Booking;
import com.skyreserve.ui.components.DesignToken;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;

public class ConfirmationPanel extends JPanel {
    
    public ConfirmationPanel(Booking booking, Runnable onBackToHome) {
        setLayout(new BorderLayout());
        setBackground(DesignToken.COLOR_BACKGROUND);

        JPanel content = new JPanel(new MigLayout("insets 50, wrap 1, align center", "[800!]", "[]30[]"));
        content.setOpaque(false);
        
        // Success Banner
        JPanel banner = new JPanel(new MigLayout("insets 20", "[][grow][]", "[]"));
        banner.setBackground(DesignToken.COLOR_SURFACE);
        banner.setBorder(BorderFactory.createLineBorder(DesignToken.COLOR_SUCCESS, 2));
        banner.putClientProperty("FlatLaf.style", "arc: 12");
        
        JLabel icon = new JLabel("✓");
        icon.setFont(new Font("Segoe UI", Font.BOLD, 48));
        icon.setForeground(DesignToken.COLOR_SUCCESS);
        
        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        textPanel.setOpaque(false);
        JLabel title = new JLabel("Booking Confirmed!");
        title.setFont(DesignToken.FONT_H1);
        title.setForeground(DesignToken.COLOR_SUCCESS);
        JLabel subtitle = new JLabel("Your e-ticket has been generated successfully.");
        textPanel.add(title);
        textPanel.add(subtitle);
        
        JPanel pnrPanel = new JPanel(new GridLayout(2, 1));
        pnrPanel.setOpaque(false);
        JLabel pnrLabel = new JLabel("PNR", SwingConstants.RIGHT);
        JLabel pnrValue = new JLabel(booking.getPnr(), SwingConstants.RIGHT);
        pnrValue.setFont(DesignToken.FONT_H1);
        pnrValue.setForeground(DesignToken.COLOR_PRIMARY);
        pnrPanel.add(pnrLabel);
        pnrPanel.add(pnrValue);
        
        banner.add(icon);
        banner.add(textPanel, "growx");
        banner.add(pnrPanel);
        
        content.add(banner, "growx");
        
        // E-Ticket Card
        JPanel ticket = new JPanel(new MigLayout("insets 30, wrap 2", "[grow][grow]", "[]10[]"));
        ticket.setBackground(DesignToken.COLOR_SURFACE);
        ticket.setBorder(BorderFactory.createLineBorder(DesignToken.COLOR_BORDER));
        ticket.putClientProperty("FlatLaf.style", "arc: 12");
        
        JLabel tHeader = new JLabel("Booking Details");
        tHeader.setFont(DesignToken.FONT_BODY_BOLD);
        ticket.add(tHeader, "span 2, wrap");
        
        DateTimeFormatter timeFmt = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("dd MMM yyyy");
        
        String depTime = booking.getFlight().getDepartureTime().format(timeFmt);
        String arrTime = booking.getFlight().getArrivalTime().format(timeFmt);
        String date = booking.getFlight().getDepartureTime().format(dateFmt);
        
        ticket.add(new JLabel("Flight: " + booking.getFlight().getAirline().getName() + " " + booking.getFlight().getFlightNumber()));
        ticket.add(new JLabel("Date: " + date));
        
        ticket.add(new JLabel("Departure: " + booking.getFlight().getOrigin().getCode() + " at " + depTime));
        ticket.add(new JLabel("Arrival: " + booking.getFlight().getDestination().getCode() + " at " + arrTime));
        
        if (!booking.getPassengers().isEmpty()) {
            ticket.add(new JLabel("Passenger: " + booking.getPassengers().get(0).getFullName()));
            if(booking.getPassengers().get(0).getSelectedSeat() != null) {
                ticket.add(new JLabel("Seat: " + booking.getPassengers().get(0).getSelectedSeat().getSeatNumber()));
            }
        }
        
        ticket.add(new JSeparator(), "span 2, growx, gapy 20 20");
        
        JLabel totalLabel = new JLabel(String.format("Total Amount: ₹%.2f", booking.getTotalAmount()));
        totalLabel.setFont(DesignToken.FONT_H3);
        ticket.add(totalLabel, "span 2");
        
        content.add(ticket, "growx");
        
        // Actions
        JPanel actions = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        actions.setOpaque(false);
        
        JButton dlBtn = new JButton("Download Ticket");
        dlBtn.setBackground(DesignToken.COLOR_PRIMARY);
        dlBtn.setForeground(Color.WHITE);
        
        JButton homeBtn = new JButton("Back to Home");
        homeBtn.addActionListener(e -> onBackToHome.run());
        
        actions.add(dlBtn);
        actions.add(homeBtn);
        
        content.add(actions, "growx");
        
        add(content, BorderLayout.CENTER);
    }
}
