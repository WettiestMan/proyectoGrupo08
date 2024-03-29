package com.grupo06.View.CustomTable;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTable extends JTable {

    private CustomTableModel customModel = new CustomTableModel();

    public CustomTableModel getCustomModel() {
        return customModel;
    }

    public void setCustomModel(CustomTableModel customModel) {
        this.customModel = customModel;
    }

    
    
    public CustomTable() {
        
        setShowHorizontalLines(true);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setResizingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                CustomTableHeader header = new CustomTableHeader(o + "");
                header.setHorizontalAlignment(JLabel.CENTER);
                
                return header;
            }
        });
        
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        setRowHeight(32);
        setModel(customModel);
        
        // Set the custom renderer for the first column
                
        getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                return (Component) value;
            }
        });
     
        getColumnModel().getColumn(0).setPreferredWidth(32);
        getColumnModel().getColumn(1).setPreferredWidth(323);
        getColumnModel().getColumn(2).setPreferredWidth(160);
        getColumnModel().getColumn(3).setPreferredWidth(160);
        
    }
}