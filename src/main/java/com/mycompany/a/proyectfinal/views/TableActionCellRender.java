package com.mycompany.a.proyectfinal.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Manuel Silva
 */
public class TableActionCellRender extends DefaultTableCellRenderer {

    private final ActionListener actionListener;
    
    public TableActionCellRender(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        PanelAction panelAction = new PanelAction(actionListener);
        if (isSelected) {
            panelAction.setBackground(component.getBackground());
        } else {
            panelAction.setBackground(Color.WHITE);
        }
        return panelAction;
    }
}
