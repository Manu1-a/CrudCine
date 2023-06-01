
package com.mycompany.a.proyectfinal.views;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author Manuel Silva
 */
public class TableActionCellEditor extends DefaultCellEditor {

    private final ActionListener actionListener;
    
    public TableActionCellEditor(ActionListener actionListener) {
        super(new JCheckBox());
        this.actionListener = actionListener;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PanelAction panelAction = new PanelAction(actionListener);
        return panelAction;
    }

    
}
