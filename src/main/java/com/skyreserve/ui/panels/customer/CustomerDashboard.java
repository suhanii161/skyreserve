package com.skyreserve.ui.panels.customer;

import com.skyreserve.ui.components.DesignToken;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class CustomerDashboard extends JPanel {
    
    private final Consumer<String> onNavigate;

    public CustomerDashboard(Consumer<String> onNavigate) {
        this.onNavigate = onNavigate;
        setLayout(new BorderLayout());
        setBackground(DesignToken.COLOR_BACKGROUND);
        
        // Scroll pane for the entire dashboard
        JPanel scrollContent = new JPanel(new MigLayout("wrap 1, insets 30, fillx", "[grow]", "[]20[]20[]"));
        scrollContent.setBackground(DesignToken.COLOR_BACKGROUND);

        // 1. Hero Section
        JPanel heroPanel = new JPanel(new BorderLayout());
        heroPanel.setBackground(DesignToken.COLOR_PRIMARY);
        heroPanel.putClientProperty("FlatLaf.style", "arc: 16");
        heroPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        
        JLabel heroTitle = new JLabel("Explore the World");
        heroTitle.setFont(new Font("Segoe UI", Font.BOLD, 36));
        heroTitle.setForeground(Color.WHITE);
        
        JLabel heroSub = new JLabel("Discover Amazing Destinations");
        heroSub.setFont(DesignToken.FONT_H3);
        heroSub.setForeground(DesignToken.COLOR_SECONDARY);
        
        JPanel titlePanel = new JPanel(new GridLayout(2, 1));
        titlePanel.setOpaque(false);
        titlePanel.add(heroTitle);
        titlePanel.add(heroSub);
        
        heroPanel.add(titlePanel, BorderLayout.WEST);
        // We'd add an image to the East here normally
        
        scrollContent.add(heroPanel, "growx, h 180!");
        
        // 2. Flight Search Form (overlays hero slightly in design, but we place it below for simplicity or MigLayout offset)
        FlightSearchForm searchForm = new FlightSearchForm(query -> {
            // Trigger navigation to Book Flight tab
            onNavigate.accept("Book Flight"); 
        });
        
        scrollContent.add(searchForm, "growx");
        
        // 3. Stats / Info Cards Row
        JPanel cardsRow = new JPanel(new MigLayout("insets 0, gap 20", "[grow][grow][grow]", "[fill]"));
        cardsRow.setOpaque(false);
        
        cardsRow.add(createUpcomingTripCard(), "grow");
        cardsRow.add(createSkyPointsCard(), "grow");
        cardsRow.add(createSmartDealsCard(), "grow");
        
        scrollContent.add(cardsRow, "growx");
        
        JScrollPane scrollPane = new JScrollPane(scrollContent);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private JPanel createUpcomingTripCard() {
        JPanel card = createBaseCard();
        card.setLayout(new MigLayout("wrap 1", "[grow]", "[]10[]5[]10[]"));
        
        JLabel title = new JLabel("Upcoming Trip");
        title.setFont(DesignToken.FONT_BODY_BOLD);
        
        JLabel route = new JLabel("DEL -> BOM");
        route.setFont(DesignToken.FONT_H3);
        
        JLabel details = new JLabel("20 Sep 2026 | 6E-204 | 06:30 AM");
        details.setForeground(DesignToken.COLOR_TEXT_SECONDARY);
        
        JButton viewBtn = new JButton("View Booking");
        viewBtn.setBackground(DesignToken.COLOR_PRIMARY);
        viewBtn.setForeground(Color.WHITE);
        
        card.add(title);
        card.add(route);
        card.add(details);
        card.add(viewBtn, "growx");
        
        return card;
    }
    
    private JPanel createSkyPointsCard() {
        JPanel card = createBaseCard();
        card.setLayout(new MigLayout("wrap 1, align center", "[center]", "[]10[]10[]"));
        
        JLabel title = new JLabel("SkyPoints");
        title.setFont(DesignToken.FONT_BODY_BOLD);
        
        JLabel pts = new JLabel("8,420");
        pts.setFont(new Font("Segoe UI", Font.BOLD, 36));
        pts.setForeground(DesignToken.COLOR_PRIMARY);
        
        JLabel status = new JLabel("Gold Member");
        status.setForeground(DesignToken.COLOR_WARNING);
        
        card.add(title);
        card.add(pts);
        card.add(status);
        
        return card;
    }
    
    private JPanel createSmartDealsCard() {
        JPanel card = createBaseCard();
        card.setLayout(new MigLayout("wrap 1", "[grow]", "[]10[]10[]"));
        
        JLabel title = new JLabel("Smart Deals");
        title.setFont(DesignToken.FONT_BODY_BOLD);
        
        JLabel offer = new JLabel("Up to 30% Off");
        offer.setFont(DesignToken.FONT_H2);
        
        JButton viewBtn = new JButton("Explore Deals");
        
        card.add(title);
        card.add(offer);
        card.add(Box.createVerticalStrut(10));
        card.add(viewBtn, "growx");
        
        return card;
    }
    
    private JPanel createBaseCard() {
        JPanel p = new JPanel();
        p.setBackground(DesignToken.COLOR_SURFACE);
        p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(DesignToken.COLOR_BORDER, 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        p.putClientProperty("FlatLaf.style", "arc: 12");
        return p;
    }
}
