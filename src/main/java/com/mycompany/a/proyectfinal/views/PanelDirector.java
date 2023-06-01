package com.mycompany.a.proyectfinal.views;

import com.mycompany.a.proyectfinal.models.Director;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Manuel Silva
 */
public class PanelDirector extends JPanel {

    private JTable table;
    private DefaultTableModel model;
    private final ActionListener actionListener;

    public PanelDirector(ActionListener actionListener) {
        this.actionListener = actionListener;
        init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.table = new JTable();
        JScrollPane scrollPane = new JScrollPane(this.table);
        this.add(scrollPane, BorderLayout.CENTER);
        createTable();
    }

    private void createTable() {
        this.model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3;
            }
        };
        this.model.addColumn("ID");
        this.model.addColumn("Nombre");
        this.model.addColumn("Acciones");

        this.table.setModel(model);
        this.table.setRowHeight(30);
        this.table.getColumnModel().getColumn(2).setCellRenderer(new TableActionCellRender(this.actionListener));
        this.table.getColumnModel().getColumn(2).setCellEditor(new TableActionCellEditor(this.actionListener));
    }

    public void loadData(ArrayList<Director> list) {
        for (Director director : list) {
            this.model.addRow(new Object[]{director.getIdDirector(), director.getNombreDirector()});
        }
    }

    public int getId() {
        return (int) this.table.getValueAt(this.table.getSelectedRow(), 0);
    }

    public void clean() {
        this.model = (DefaultTableModel) this.table.getModel();
        this.model.setRowCount(0);
        this.table.revalidate();
    }
}
