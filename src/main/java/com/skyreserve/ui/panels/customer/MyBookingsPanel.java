package com.skyreserve.ui.panels.customer;

import com.skyreserve.models.Booking;
import com.skyreserve.models.User;
import com.skyreserve.repositories.InMemoryBookingRepository;
import com.skyreserve.ui.components.DesignToken;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MyBookingsPanel extends JPanel {
    
    private final User currentUser;
    private final InMemoryBookingRepository bookingRepo;

    public MyBookingsPanel(User currentUser) {
        this.currentUser = currentUser;
        // In a real app we'd use a singleton/DI for the repo
        this.bookingRepo = new InMemoryBookingRepository();
        
        setLayout(new BorderLayout());
        setBackground(DesignToken.COLOR_BACKGROUND);

        JPanel content = new JPanel(new MigLayout("insets 40, wrap 1, fillx", "[grow]", "[]20[grow]"));
        content.setOpaque(false);
        
        // Header
        JPanel header = new JPanel(new MigLayout("insets 0", "[]", "[]10[]"));
        header.setOpaque(false);
        JLabel title = new JLabel("My Bookings");
        title.setFont(DesignToken.FONT_H1);
        JLabel subtitle = new JLabel("View and manage your upcoming and past trips.");
        subtitle.setForeground(DesignToken.COLOR_TEXT_SECONDARY);
        header.add(title, "wrap");
        header.add(subtitle);
        content.add(header, "growx");
        
        // Table Panel
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(DesignToken.COLOR_SURFACE);
        tablePanel.setBorder(BorderFactory.createLineBorder(DesignToken.COLOR_BORDER));
        tablePanel.putClientProperty("FlatLaf.style", "arc: 12");
        
        String[] columns = {"PNR", "Date", "Route", "Flight", "Amount", "Status"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        
        List<Booking> bookings = bookingRepo.findByUsername(currentUser.getUsername());
        DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("dd MMM yyyy");
        
        if (bookings.isEmpty()) {
            // Add a mock booking for demo purposes if empty
            Object[] row = {"AX7K92", "20 Sep 2026", "DEL -> BOM", "6E-204", "₹11,980", "Confirmed"};
            model.addRow(row);
        } else {
            for (Booking b : bookings) {
                Object[] row = {
                    b.getPnr(),
                    b.getFlight().getDepartureTime().format(dateFmt),
                    b.getFlight().getOrigin().getCode() + " -> " + b.getFlight().getDestination().getCode(),
                    b.getFlight().getFlightNumber(),
                    "₹" + b.getTotalAmount(),
                    b.getStatus()
                };
                model.addRow(row);
            }
        }
        
        JTable table = new JTable(model);
        table.setRowHeight(40);
        table.setFont(DesignToken.FONT_BODY);
        table.getTableHeader().setFont(DesignToken.FONT_BODY_BOLD);
        table.getTableHeader().setBackground(DesignToken.COLOR_BACKGROUND);
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tablePanel.add(scroll, BorderLayout.CENTER);
        
        // Actions
        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        actions.setOpaque(false);
        JButton viewBtn = new JButton("View Details");
        JButton cancelBtn = new JButton("Cancel Booking");
        cancelBtn.setForeground(DesignToken.COLOR_ERROR);
        
        cancelBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                int res = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel this booking? A cancellation fee of ₹500 will apply.", "Cancel Booking", JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    model.setValueAt("Cancelled", row, 5);
                    JOptionPane.showMessageDialog(this, "Booking cancelled. Refund initiated.");
                }
            }
        });
        
        actions.add(viewBtn);
        actions.add(cancelBtn);
        tablePanel.add(actions, BorderLayout.SOUTH);
        
        content.add(tablePanel, "grow");
        
        add(content, BorderLayout.CENTER);
    }
}
