package com.skyreserve.ui.panels.customer;

import com.skyreserve.models.Flight;
import com.skyreserve.repositories.InMemoryFlightRepository;
import com.skyreserve.ui.components.DesignToken;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Consumer;

public class FlightResultsPanel extends JPanel {
    
    private final Consumer<Flight> onFlightSelected;
    private final InMemoryFlightRepository flightRepo;
    private JPanel resultsContainer;

    public FlightResultsPanel(Consumer<Flight> onFlightSelected) {
        this.onFlightSelected = onFlightSelected;
        this.flightRepo = new InMemoryFlightRepository();
        
        setLayout(new BorderLayout());
        setBackground(DesignToken.COLOR_BACKGROUND);
        
        // Header (Search Summary)
        JPanel header = new JPanel(new MigLayout("insets 20", "[grow]", "[]"));
        header.setBackground(DesignToken.COLOR_SURFACE);
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, DesignToken.COLOR_BORDER));
        
        JLabel routeLabel = new JLabel("Delhi (DEL) -> Mumbai (BOM) | 20 Sep 2026 | 2 Adults | Economy");
        routeLabel.setFont(DesignToken.FONT_H3);
        header.add(routeLabel, "wrap");
        
        add(header, BorderLayout.NORTH);
        
        // Main Content (Sidebar filters + Results list)
        JPanel mainContent = new JPanel(new BorderLayout(20, 0));
        mainContent.setOpaque(false);
        mainContent.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Filters Sidebar
        JPanel filtersPanel = createFiltersPanel();
        mainContent.add(filtersPanel, BorderLayout.WEST);
        
        // Results Area
        resultsContainer = new JPanel(new MigLayout("wrap 1, fillx, insets 0", "[grow]", "[]20[]"));
        resultsContainer.setOpaque(false);
        
        // Mock Smart Recommendation Header
        JPanel smartHeader = new JPanel(new MigLayout("fillx", "[grow][]", "[]"));
        smartHeader.setBackground(DesignToken.COLOR_SURFACE);
        smartHeader.setBorder(BorderFactory.createLineBorder(DesignToken.COLOR_SUCCESS, 1));
        smartHeader.putClientProperty("FlatLaf.style", "arc: 8");
        
        JLabel smartLabel = new JLabel("Smart Recommendation");
        smartLabel.setForeground(DesignToken.COLOR_SUCCESS);
        smartLabel.setFont(DesignToken.FONT_BODY_BOLD);
        smartHeader.add(smartLabel);
        
        resultsContainer.add(smartHeader, "growx");
        
        // Load mock flights
        loadFlights();
        
        JScrollPane scrollPane = new JScrollPane(resultsContainer);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        mainContent.add(scrollPane, BorderLayout.CENTER);
        add(mainContent, BorderLayout.CENTER);
    }
    
    private JPanel createFiltersPanel() {
        JPanel p = new JPanel(new MigLayout("wrap 1", "[250!]", "[]10[]"));
        p.setBackground(DesignToken.COLOR_SURFACE);
        p.setBorder(BorderFactory.createLineBorder(DesignToken.COLOR_BORDER, 1));
        p.putClientProperty("FlatLaf.style", "arc: 8");
        
        JLabel title = new JLabel("Sort By");
        title.setFont(DesignToken.FONT_BODY_BOLD);
        p.add(title);
        
        JComboBox<String> sortCombo = new JComboBox<>(new String[]{"Recommended", "Cheapest", "Fastest"});
        p.add(sortCombo, "growx, wrap");
        
        p.add(new JSeparator(), "growx, gapy 10 10");
        
        JLabel stopsTitle = new JLabel("Stops");
        stopsTitle.setFont(DesignToken.FONT_BODY_BOLD);
        p.add(stopsTitle);
        
        p.add(new JCheckBox("Non-stop", true));
        p.add(new JCheckBox("1 Stop"));
        p.add(new JCheckBox("2+ Stops"));
        
        p.add(new JSeparator(), "growx, gapy 10 10");
        
        JLabel airlinesTitle = new JLabel("Airlines");
        airlinesTitle.setFont(DesignToken.FONT_BODY_BOLD);
        p.add(airlinesTitle);
        
        p.add(new JCheckBox("IndiGo", true));
        p.add(new JCheckBox("Air India", true));
        p.add(new JCheckBox("Vistara", true));
        
        return p;
    }
    
    private void loadFlights() {
        // Just load DEL -> BOM for 20th Sep for mock
        LocalDateTime date = LocalDateTime.of(2026, 9, 20, 0, 0);
        List<Flight> flights = flightRepo.searchFlights("DEL", "BOM", date);
        
        for (Flight f : flights) {
            resultsContainer.add(createFlightCard(f), "growx");
        }
    }
    
    private JPanel createFlightCard(Flight f) {
        JPanel card = new JPanel(new MigLayout("fillx", "[100!][grow][100!][150!]", "[]10[]"));
        card.setBackground(DesignToken.COLOR_SURFACE);
        card.setBorder(BorderFactory.createLineBorder(DesignToken.COLOR_BORDER, 1));
        card.putClientProperty("FlatLaf.style", "arc: 8");
        
        // Airline info
        JPanel airlineInfo = new JPanel(new GridLayout(2, 1));
        airlineInfo.setOpaque(false);
        JLabel name = new JLabel(f.getAirline().getName());
        name.setFont(DesignToken.FONT_BODY_BOLD);
        JLabel num = new JLabel(f.getFlightNumber());
        num.setForeground(DesignToken.COLOR_TEXT_SECONDARY);
        airlineInfo.add(name);
        airlineInfo.add(num);
        
        // Timing info
        JPanel timingInfo = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        timingInfo.setOpaque(false);
        
        JLabel dep = new JLabel("<html><center><b>" + String.format("%02d:%02d", f.getDepartureTime().getHour(), f.getDepartureTime().getMinute()) + "</b><br>" + f.getOrigin().getCode() + "</center></html>");
        JLabel arr = new JLabel("<html><center><b>" + String.format("%02d:%02d", f.getArrivalTime().getHour(), f.getArrivalTime().getMinute()) + "</b><br>" + f.getDestination().getCode() + "</center></html>");
        
        // Calculate duration simply for mock
        long hours = java.time.Duration.between(f.getDepartureTime(), f.getArrivalTime()).toHours();
        long mins = java.time.Duration.between(f.getDepartureTime(), f.getArrivalTime()).toMinutesPart();
        JLabel dur = new JLabel(hours + "h " + mins + "m");
        dur.setForeground(DesignToken.COLOR_TEXT_SECONDARY);
        
        timingInfo.add(dep);
        timingInfo.add(dur);
        timingInfo.add(arr);
        
        // Price and Action
        JPanel actionInfo = new JPanel(new MigLayout("wrap 1, align right", "[]", "[]5[]"));
        actionInfo.setOpaque(false);
        JLabel price = new JLabel("₹" + (int)f.getBasePrice());
        price.setFont(DesignToken.FONT_H2);
        
        JButton bookBtn = new JButton("Book");
        bookBtn.setBackground(DesignToken.COLOR_PRIMARY);
        bookBtn.setForeground(Color.WHITE);
        bookBtn.setFont(DesignToken.FONT_BODY_BOLD);
        bookBtn.addActionListener(e -> onFlightSelected.accept(f));
        
        actionInfo.add(price);
        actionInfo.add(bookBtn, "growx");
        
        card.add(airlineInfo);
        card.add(timingInfo, "growx");
        card.add(new JPanel(), "grow"); // spacer
        card.add(actionInfo);
        
        return card;
    }
}
