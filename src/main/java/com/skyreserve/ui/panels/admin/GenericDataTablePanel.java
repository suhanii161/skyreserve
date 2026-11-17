package com.skyreserve.ui.panels.admin;

import com.skyreserve.ui.components.DesignToken;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GenericDataTablePanel extends JPanel {
    
    public GenericDataTablePanel(String titleStr, String subtitleStr, String[] columns, Object[][] data) {
        setLayout(new BorderLayout());
        setBackground(DesignToken.COLOR_BACKGROUND);

        JPanel content = new JPanel(new MigLayout("insets 40, wrap 1, fillx", "[grow]", "[]20[]20[grow]"));
        content.setOpaque(false);
        
        // Header
        JPanel header = new JPanel(new MigLayout("insets 0", "[grow][]", "[]10[]"));
        header.setOpaque(false);
        JLabel title = new JLabel(titleStr);
        title.setFont(DesignToken.FONT_H1);
        JLabel subtitle = new JLabel(subtitleStr);
        subtitle.setForeground(DesignToken.COLOR_TEXT_SECONDARY);
        
        JPanel titlePanel = new JPanel(new GridLayout(2, 1));
        titlePanel.setOpaque(false);
        titlePanel.add(title);
        titlePanel.add(subtitle);
        
        header.add(titlePanel, "growx");
        
        // Action Buttons
        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        actions.setOpaque(false);
        JButton addBtn = new JButton("Add New");
        addBtn.setBackground(DesignToken.COLOR_PRIMARY);
        addBtn.setForeground(Color.WHITE);
        JButton editBtn = new JButton("Edit");
        JButton delBtn = new JButton("Delete");
        delBtn.setForeground(DesignToken.COLOR_ERROR);
        
        actions.add(addBtn);
        actions.add(editBtn);
        actions.add(delBtn);
        
        header.add(actions);
        
        content.add(header, "growx");
        
        // Search
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setOpaque(false);
        JTextField searchField = new JTextField(30);
        searchField.putClientProperty("JTextField.placeholderText", "Search records...");
        searchPanel.add(new JLabel("Search: "));
        searchPanel.add(searchField);
        content.add(searchPanel, "growx");
        
        // Table Panel
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(DesignToken.COLOR_SURFACE);
        tablePanel.setBorder(BorderFactory.createLineBorder(DesignToken.COLOR_BORDER));
        tablePanel.putClientProperty("FlatLaf.style", "arc: 12");
        
        DefaultTableModel model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        
        JTable table = new JTable(model);
        table.setRowHeight(35);
        table.setFont(DesignToken.FONT_BODY);
        table.getTableHeader().setFont(DesignToken.FONT_BODY_BOLD);
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tablePanel.add(scroll, BorderLayout.CENTER);
        
        content.add(tablePanel, "grow");
        
        add(content, BorderLayout.CENTER);
    }
}
