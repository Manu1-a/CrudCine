package com.mycompany.a.proyectfinal.views;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Manuel Silva
 */
public class PanelAction extends JPanel {

    private MyButton buttonDelete;
    private MyButton buttonUpdate;
    private final ActionListener actionListener;
    
    public PanelAction(ActionListener actionListener) {
        this.actionListener = actionListener;
        init();
    }

    private void init() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        this.buttonDelete = new MyButton("Eliminar");
        this.buttonDelete.setActionCommand("delete");
        this.buttonDelete.addActionListener(this.actionListener);
        
        this.buttonUpdate = new MyButton("Actualizar");
        this.buttonUpdate.setActionCommand("update");
        this.buttonUpdate.addActionListener(this.actionListener);
        
        this.add(this.buttonDelete);
        this.add(this.buttonUpdate);
    }
}
