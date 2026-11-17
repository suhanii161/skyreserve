package com.skyreserve.ui.panels.customer;

import com.skyreserve.models.Seat;
import com.skyreserve.ui.components.DesignToken;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SeatSelectionPanel extends JPanel {
    
    private final Consumer<Seat> onSeatSelected;
    private Seat currentlySelectedSeat = null;
    private JLabel selectedSeatLabel;
    private JLabel selectedSeatPrice;
    private final List<SeatButton> seatButtons = new ArrayList<>();

    public SeatSelectionPanel(Consumer<Seat> onSeatSelected) {
        this.onSeatSelected = onSeatSelected;
        
        setLayout(new BorderLayout());
        setBackground(DesignToken.COLOR_BACKGROUND);
        
        JPanel content = new JPanel(new MigLayout("insets 40, wrap 2", "[grow][300!]", "[fill]"));
        content.setOpaque(false);
        
        // Header
        JPanel header = new JPanel(new MigLayout("insets 0", "[]", "[]10[]"));
        header.setOpaque(false);
        JLabel title = new JLabel("Select Your Seats");
        title.setFont(DesignToken.FONT_H1);
        JLabel subtitle = new JLabel("IndiGo 6E-204 | Delhi -> Mumbai | 20 Sep 2026");
        subtitle.setForeground(DesignToken.COLOR_TEXT_SECONDARY);
        header.add(title, "wrap");
        header.add(subtitle);
        content.add(header, "span 2, wrap");
        
        // Seat Map Area (Left)
        JPanel seatMapContainer = new JPanel(new MigLayout("insets 20, align center", "[center]", "[]20[]"));
        seatMapContainer.setBackground(DesignToken.COLOR_SURFACE);
        seatMapContainer.setBorder(BorderFactory.createLineBorder(DesignToken.COLOR_BORDER));
        seatMapContainer.putClientProperty("FlatLaf.style", "arc: 12");
        
        // Legend
        JPanel legend = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        legend.setOpaque(false);
        legend.add(createLegendItem(DesignToken.COLOR_BORDER, "Available"));
        legend.add(createLegendItem(DesignToken.COLOR_PRIMARY, "Selected"));
        legend.add(createLegendItem(DesignToken.COLOR_ERROR, "Occupied"));
        legend.add(createLegendItem(DesignToken.COLOR_INFO, "Extra Legroom"));
        seatMapContainer.add(legend, "wrap");
        
        // Grid Map
        JPanel grid = new JPanel(new GridLayout(10, 7, 10, 10)); // 10 rows, A B C [aisle] D E F
        grid.setOpaque(false);
        
        for (int row = 1; row <= 10; row++) {
            for (char col = 'A'; col <= 'G'; col++) {
                if (col == 'D') {
                    // Aisle
                    grid.add(new JLabel(String.valueOf(row), SwingConstants.CENTER));
                } else {
                    String seatNum = row + "" + (col > 'D' ? (char)(col - 1) : col);
                    // Mock data
                    boolean isOccupied = (row == 3 && col == 'B') || (row == 6 && col == 'A') || (row == 8 && col == 'E');
                    boolean isExtraLegroom = (row <= 2 || row == 5 || row == 6);
                    double price = isExtraLegroom ? 1200 : 500;
                    
                    Seat seat = new Seat(seatNum, !isOccupied, isExtraLegroom, price);
                    SeatButton btn = new SeatButton(seat);
                    seatButtons.add(btn);
                    grid.add(btn);
                }
            }
        }
        
        seatMapContainer.add(grid);
        content.add(seatMapContainer, "grow");
        
        // Summary Area (Right)
        JPanel summaryPanel = new JPanel(new MigLayout("insets 30, wrap 1", "[grow]", "[]10[]10[]10[]20[]"));
        summaryPanel.setBackground(DesignToken.COLOR_SURFACE);
        summaryPanel.setBorder(BorderFactory.createLineBorder(DesignToken.COLOR_BORDER));
        summaryPanel.putClientProperty("FlatLaf.style", "arc: 12");
        
        JLabel sTitle = new JLabel("Selected Seat");
        sTitle.setFont(DesignToken.FONT_BODY_BOLD);
        summaryPanel.add(sTitle);
        
        selectedSeatLabel = new JLabel("-");
        selectedSeatLabel.setFont(DesignToken.FONT_H1);
        selectedSeatLabel.setForeground(DesignToken.COLOR_PRIMARY);
        summaryPanel.add(selectedSeatLabel);
        
        selectedSeatPrice = new JLabel("₹0");
        selectedSeatPrice.setFont(DesignToken.FONT_H2);
        summaryPanel.add(selectedSeatPrice);
        
        JButton confirmBtn = new JButton("Confirm Seat");
        confirmBtn.setBackground(DesignToken.COLOR_PRIMARY);
        confirmBtn.setForeground(Color.WHITE);
        confirmBtn.setFont(DesignToken.FONT_BODY_BOLD);
        confirmBtn.addActionListener(e -> {
            if (currentlySelectedSeat == null) {
                JOptionPane.showMessageDialog(this, "Please select a seat to continue.", "No Seat Selected", JOptionPane.WARNING_MESSAGE);
                return;
            }
            this.onSeatSelected.accept(currentlySelectedSeat);
        });
        summaryPanel.add(confirmBtn, "growx, h 45!");
        
        content.add(summaryPanel, "aligny top");
        
        add(content, BorderLayout.CENTER);
    }
    
    private JPanel createLegendItem(Color color, String label) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        p.setOpaque(false);
        JPanel box = new JPanel();
        box.setPreferredSize(new Dimension(16, 16));
        box.setBackground(color);
        if(color == DesignToken.COLOR_BORDER) {
             box.setBackground(DesignToken.COLOR_SURFACE);
             box.setBorder(BorderFactory.createLineBorder(DesignToken.COLOR_BORDER));
        }
        p.add(box);
        p.add(new JLabel(label));
        return p;
    }
    
    private class SeatButton extends JPanel {
        private final Seat seat;
        
        public SeatButton(Seat seat) {
            this.seat = seat;
            setPreferredSize(new Dimension(35, 35));
            putClientProperty("FlatLaf.style", "arc: 8");
            
            updateVisuals();
            
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (!seat.isAvailable()) return;
                    
                    if (currentlySelectedSeat != null) {
                        for (SeatButton btn : seatButtons) {
                            if (btn.seat == currentlySelectedSeat) {
                                btn.updateVisuals();
                                break;
                            }
                        }
                    }
                    
                    currentlySelectedSeat = seat;
                    updateVisuals();
                    
                    selectedSeatLabel.setText(seat.getSeatNumber());
                    selectedSeatPrice.setText("₹" + (int)seat.getPrice());
                }
            });
            
            setCursor(seat.isAvailable() ? Cursor.getPredefinedCursor(Cursor.HAND_CURSOR) : Cursor.getDefaultCursor());
        }
        
        public void updateVisuals() {
            if (!seat.isAvailable()) {
                setBackground(DesignToken.COLOR_ERROR);
                setBorder(null);
            } else if (currentlySelectedSeat == seat) {
                setBackground(DesignToken.COLOR_PRIMARY);
                setBorder(null);
            } else if (seat.isExtraLegroom()) {
                setBackground(DesignToken.COLOR_INFO);
                setBorder(null);
            } else {
                setBackground(DesignToken.COLOR_SURFACE);
                setBorder(BorderFactory.createLineBorder(DesignToken.COLOR_BORDER, 2));
            }
            repaint();
        }
    }
}
