package com.skyreserve.ui.panels.customer;

import com.skyreserve.models.Flight;
import com.skyreserve.repositories.InMemoryFlightRepository;
import com.skyreserve.ui.components.DesignToken;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class FlightStatusBoard extends JPanel {

    public FlightStatusBoard() {
        setLayout(new BorderLayout());
        setBackground(DesignToken.COLOR_BACKGROUND);

        JPanel content = new JPanel(new MigLayout("insets 40, wrap 1, fillx", "[grow]", "[]20[]20[grow]"));
        content.setOpaque(false);
        
        // Header
        JPanel header = new JPanel(new MigLayout("insets 0", "[]", "[]10[]"));
        header.setOpaque(false);
        JLabel title = new JLabel("Flight Status Board");
        title.setFont(DesignToken.FONT_H1);
        header.add(title, "wrap");
        content.add(header, "growx");
        
        // Filters
        JPanel filters = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        filters.setOpaque(false);
        
        JButton depBtn = new JButton("Departures");
        depBtn.setBackground(DesignToken.COLOR_PRIMARY);
        depBtn.setForeground(Color.WHITE);
        JButton arrBtn = new JButton("Arrivals");
        
        JComboBox<String> airportCombo = new JComboBox<>(new String[]{"Delhi (DEL)", "Mumbai (BOM)"});
        JComboBox<String> dateCombo = new JComboBox<>(new String[]{"Today", "Tomorrow"});
        
        filters.add(depBtn);
        filters.add(arrBtn);
        filters.add(new JLabel("Airport: "));
        filters.add(airportCombo);
        filters.add(new JLabel("Date: "));
        filters.add(dateCombo);
        
        content.add(filters, "growx");
        
        // Table Panel
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(DesignToken.COLOR_SURFACE);
        tablePanel.setBorder(BorderFactory.createLineBorder(DesignToken.COLOR_BORDER));
        tablePanel.putClientProperty("FlatLaf.style", "arc: 12");
        
        String[] columns = {"Flight", "Destination", "Scheduled", "Status", "Gate"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        
        InMemoryFlightRepository repo = new InMemoryFlightRepository();
        List<Flight> flights = repo.getAllFlights();
        
        for (Flight f : flights) {
            String status = "On Time";
            if (f.getFlightNumber().contains("UK")) status = "Delayed";
            if (f.getFlightNumber().contains("502")) status = "Departed";
            if (f.getFlightNumber().contains("467")) status = "Check-in Open";
            
            Object[] row = {
                f.getFlightNumber(),
                f.getDestination().getCity(),
                String.format("%02d:%02d", f.getDepartureTime().getHour(), f.getDepartureTime().getMinute()),
                status,
                (int)(Math.random() * 10) + 1
            };
            model.addRow(row);
        }
        
        JTable table = new JTable(model);
        table.setRowHeight(40);
        table.setFont(DesignToken.FONT_BODY);
        table.getTableHeader().setFont(DesignToken.FONT_BODY_BOLD);
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tablePanel.add(scroll, BorderLayout.CENTER);
        
        content.add(tablePanel, "grow");
        
        add(content, BorderLayout.CENTER);
    }
}
