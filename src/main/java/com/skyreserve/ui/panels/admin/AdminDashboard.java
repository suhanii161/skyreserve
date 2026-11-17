package com.skyreserve.ui.panels.admin;

import com.skyreserve.ui.components.DesignToken;
import net.miginfocom.swing.MigLayout;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.style.Styler;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class AdminDashboard extends JPanel {

    public AdminDashboard() {
        setLayout(new BorderLayout());
        setBackground(DesignToken.COLOR_BACKGROUND);

        JPanel content = new JPanel(new MigLayout("insets 30, wrap 1, fillx", "[grow]", "[]20[]20[]"));
        content.setOpaque(false);
        
        // Header
        JPanel header = new JPanel(new MigLayout("insets 0", "[grow][]", "[]"));
        header.setOpaque(false);
        JLabel title = new JLabel("Admin Analytics Dashboard");
        title.setFont(DesignToken.FONT_H1);
        header.add(title);
        
        JComboBox<String> dateFilter = new JComboBox<>(new String[]{"01 Oct 2026 - 31 Oct 2026", "This Month", "Last 30 Days"});
        header.add(dateFilter);
        
        content.add(header, "growx");
        
        // KPIs Row
        JPanel kpiRow = new JPanel(new GridLayout(1, 4, 20, 0));
        kpiRow.setOpaque(false);
        kpiRow.add(createKpiCard("Today's Flights", "86"));
        kpiRow.add(createKpiCard("Bookings", "1,842"));
        kpiRow.add(createKpiCard("Passengers", "3,217"));
        kpiRow.add(createKpiCard("Revenue", "₹42.8L"));
        content.add(kpiRow, "growx");
        
        // Charts Row
        JPanel chartsRow = new JPanel(new MigLayout("insets 0, gap 20", "[grow][grow]", "[300!]"));
        chartsRow.setOpaque(false);
        
        chartsRow.add(createChartPanel("Bookings Trend", createBookingsChart()), "grow");
        chartsRow.add(createChartPanel("Revenue Trend", createRevenueChart()), "grow");
        
        content.add(chartsRow, "growx");
        
        // Bottom Row
        JPanel bottomRow = new JPanel(new MigLayout("insets 0, gap 20", "[grow][grow][grow]", "[250!]"));
        bottomRow.setOpaque(false);
        
        bottomRow.add(createListCard("Route Popularity", new String[]{"DEL -> BOM (1,248)", "DEL -> BLR (982)", "BOM -> BLR (841)", "DEL -> HYD (718)", "BOM -> GOA (612)"}), "grow");
        bottomRow.add(createStatCard("Flight Occupancy", "82%", "Average"), "grow");
        bottomRow.add(createStatCard("Vehicle/Passenger Type", "Business: 28%", "Leisure: 62%"), "grow");
        
        content.add(bottomRow, "growx");
        
        JScrollPane scroll = new JScrollPane(content);
        scroll.setBorder(null);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll, BorderLayout.CENTER);
    }
    
    private JPanel createKpiCard(String label, String value) {
        JPanel card = new JPanel(new MigLayout("wrap 1", "[grow]", "[]5[]"));
        card.setBackground(DesignToken.COLOR_SURFACE);
        card.setBorder(BorderFactory.createLineBorder(DesignToken.COLOR_BORDER));
        card.putClientProperty("FlatLaf.style", "arc: 12");
        
        JLabel l = new JLabel(label);
        l.setForeground(DesignToken.COLOR_TEXT_SECONDARY);
        JLabel v = new JLabel(value);
        v.setFont(DesignToken.FONT_H1);
        v.setForeground(DesignToken.COLOR_PRIMARY);
        if(label.equals("Revenue")) v.setForeground(DesignToken.COLOR_SUCCESS);
        
        card.add(l);
        card.add(v);
        return card;
    }
    
    private JPanel createChartPanel(String title, CategoryChart chart) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(DesignToken.COLOR_SURFACE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(DesignToken.COLOR_BORDER),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        card.putClientProperty("FlatLaf.style", "arc: 12");
        
        JLabel l = new JLabel(title);
        l.setFont(DesignToken.FONT_BODY_BOLD);
        card.add(l, BorderLayout.NORTH);
        
        XChartPanel<CategoryChart> chartPanel = new XChartPanel<>(chart);
        chartPanel.setOpaque(false);
        card.add(chartPanel, BorderLayout.CENTER);
        
        return card;
    }
    
    private CategoryChart createBookingsChart() {
        CategoryChart chart = new CategoryChartBuilder().width(400).height(200).build();
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setChartBackgroundColor(DesignToken.COLOR_SURFACE);
        chart.getStyler().setPlotBackgroundColor(DesignToken.COLOR_SURFACE);
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setAxisTitlesVisible(false);
        
        chart.addSeries("Bookings", Arrays.asList("Oct 1", "Oct 8", "Oct 15", "Oct 22", "Oct 31"), Arrays.asList(200, 250, 220, 280, 260));
        return chart;
    }
    
    private CategoryChart createRevenueChart() {
        CategoryChart chart = new CategoryChartBuilder().width(400).height(200).build();
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setChartBackgroundColor(DesignToken.COLOR_SURFACE);
        chart.getStyler().setPlotBackgroundColor(DesignToken.COLOR_SURFACE);
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setAxisTitlesVisible(false);
        
        chart.addSeries("Revenue", Arrays.asList("Oct 1", "Oct 8", "Oct 15", "Oct 22", "Oct 31"), Arrays.asList(4.2, 5.1, 4.8, 6.0, 5.5));
        return chart;
    }
    
    private JPanel createListCard(String title, String[] items) {
        JPanel card = new JPanel(new MigLayout("wrap 1, fillx", "[grow]", "[]10[]"));
        card.setBackground(DesignToken.COLOR_SURFACE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(DesignToken.COLOR_BORDER),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        card.putClientProperty("FlatLaf.style", "arc: 12");
        
        JLabel l = new JLabel(title);
        l.setFont(DesignToken.FONT_BODY_BOLD);
        card.add(l);
        
        for (String item : items) {
            card.add(new JLabel(item));
        }
        
        return card;
    }
    
    private JPanel createStatCard(String title, String mainStat, String sub) {
        JPanel card = new JPanel(new MigLayout("wrap 1, align center", "[center]", "[]10[]5[]"));
        card.setBackground(DesignToken.COLOR_SURFACE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(DesignToken.COLOR_BORDER),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        card.putClientProperty("FlatLaf.style", "arc: 12");
        
        JLabel l = new JLabel(title);
        l.setFont(DesignToken.FONT_BODY_BOLD);
        
        JLabel s = new JLabel(mainStat);
        s.setFont(new Font("Segoe UI", Font.BOLD, 48));
        s.setForeground(DesignToken.COLOR_PRIMARY);
        
        JLabel sb = new JLabel(sub);
        
        card.add(l);
        card.add(s);
        card.add(sb);
        
        return card;
    }
}
